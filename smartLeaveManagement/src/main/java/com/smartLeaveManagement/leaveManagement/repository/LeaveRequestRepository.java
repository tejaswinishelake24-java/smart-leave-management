package com.smartLeaveManagement.leaveManagement.repository;

import com.smartLeaveManagement.leaveManagement.entity.LeaveRequest;
import com.smartLeaveManagement.leaveManagement.entity.LeaveStatus;
import com.smartLeaveManagement.leaveManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployee(User employee);

    List<LeaveRequest> findByStatus(LeaveStatus status);

    List<LeaveRequest> findByEmployeeAndStatus(User employee, LeaveStatus status);
}