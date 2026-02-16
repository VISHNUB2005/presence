package com.vishnu.presence.service;

import com.vishnu.presence.entity.Attendance;
import com.vishnu.presence.entity.User;
import com.vishnu.presence.repository.AttendanceRepository;
import com.vishnu.presence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.vishnu.presence.dto.SuspectSummaryDTO;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.userRepository = userRepository;
    }

    // Create new attendance (activity log)
public Attendance markAttendance(Long userId) {

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    // ? Block inactive users immediately
    if (!user.isActive()) {
        throw new RuntimeException("User is blocked due to suspicious activity");
    }

    // ?? bot detection window (last 1 minute)
    LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1);

    List<Attendance> recentAttendances =
            attendanceRepository.findByUser_IdAndTimestampAfter(
                    userId, oneMinuteAgo
            );

    Attendance attendance = new Attendance();
    attendance.setUser(user);
    attendance.setTimestamp(LocalDateTime.now());

    // ? rate-based detection
    if (recentAttendances.size() >= 3) {
        attendance.setStatus("SUSPECT");
    } else {
        attendance.setStatus("REAL");
    }

    Attendance savedAttendance = attendanceRepository.save(attendance);

    // ? AUTO-BLOCK LOGIC
    long suspectCount =
            attendanceRepository.countByUser_IdAndStatus(userId, "SUSPECT");

    if (suspectCount >= 3) {
        user.setActive(false);     // auto-block user
        userRepository.save(user);
    }

    return savedAttendance;
}


    // Get all attendance
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
    public List<Attendance> getAttendanceByUser(Long userId) {
    return attendanceRepository.findByUser_Id(userId);
    
}
    public List<SuspectSummaryDTO> getSuspectSummary() {

    List<User> users = userRepository.findAll();
    List<SuspectSummaryDTO> summary = new ArrayList<>();

    for (User user : users) {
        long suspectCount =
                attendanceRepository.countByUser_IdAndStatus(
                        user.getId(), "SUSPECT"
                );

        if (suspectCount > 0) {
            summary.add(new SuspectSummaryDTO(user.getId(), suspectCount));
        }
    }

    return summary;
}

}
