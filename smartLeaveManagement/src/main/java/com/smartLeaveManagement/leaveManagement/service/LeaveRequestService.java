package com.smartLeaveManagement.leaveManagement.service;

import com.smartLeaveManagement.leaveManagement.entity.*;
import com.smartLeaveManagement.leaveManagement.repository.LeaveRequestRepository;
import com.smartLeaveManagement.leaveManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private UserRepository userRepository;

    public LeaveRequest applyLeave(LeaveRequest request) {

        User employee = userRepository.findById(request.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Business rule
        if (request.getStartDate().isAfter(request.getEndDate())) {
            throw new RuntimeException("Start date cannot be after end date");
        }

        request.setStatus(LeaveStatus.PENDING);
        request.setEmployee(employee);

        return leaveRequestRepository.save(request);
    }

    public List<LeaveRequest> getLeavesByEmployee(Long empId) {

        User employee = userRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return leaveRequestRepository.findByEmployee(employee);
    }
}