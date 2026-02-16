package com.vishnu.presence.repository;

import com.vishnu.presence.entity.Attendance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByUser_Id(Long userId);
    List<Attendance> findByUser_IdAndTimestampAfter(
        Long userId,
        LocalDateTime time
);
    long countByUser_IdAndStatus(Long userId, String status);

}
