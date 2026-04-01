package com.smartLeaveManagement.leaveManagement.controller;

import com.smartLeaveManagement.leaveManagement.entity.LeaveRequest;
import com.smartLeaveManagement.leaveManagement.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveRequestService leaveService;

    @PostMapping
    public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(leaveService.applyLeave(request));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<LeaveRequest>> getLeaves(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.getLeavesByEmployee(id));
    }
}