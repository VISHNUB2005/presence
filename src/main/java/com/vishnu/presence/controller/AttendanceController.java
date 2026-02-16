package com.vishnu.presence.controller;
import com.vishnu.presence.dto.SuspectSummaryDTO;
import com.vishnu.presence.entity.Attendance;
import com.vishnu.presence.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Mark attendance (activity)
    @GetMapping("/mark/{userId}")
    public Attendance markAttendance(@PathVariable Long userId) {
        return attendanceService.markAttendance(userId);
    }

    // Get all attendance
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }
    @GetMapping("/user/{userId}")
public List<Attendance> getAttendanceByUser(@PathVariable Long userId) {
    return attendanceService.getAttendanceByUser(userId);
}
@GetMapping("/suspects")
public List<SuspectSummaryDTO> getSuspectSummary() {
    return attendanceService.getSuspectSummary();
}

}
