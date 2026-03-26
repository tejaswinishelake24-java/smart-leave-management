package com.smartLeaveManagement.leaveManagement.service;

import com.smartLeaveManagement.leaveManagement.entity.LeaveRequest;
import com.smartLeaveManagement.leaveManagement.entity.LeaveStatus;
import com.smartLeaveManagement.leaveManagement.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveApprovalService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest approveLeave(Long leaveId) {

        LeaveRequest request = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        if (request.getStatus() != LeaveStatus.PENDING) {
            throw new RuntimeException("Only pending requests can be approved");
        }

        request.setStatus(LeaveStatus.APPROVED);
        return leaveRequestRepository.save(request);
    }

    public LeaveRequest rejectLeave(Long leaveId) {

        LeaveRequest request = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));

        if (request.getStatus() != LeaveStatus.PENDING) {
            throw new RuntimeException("Only pending requests can be rejected");
        }

        request.setStatus(LeaveStatus.REJECTED);
        return leaveRequestRepository.save(request);
    }
}