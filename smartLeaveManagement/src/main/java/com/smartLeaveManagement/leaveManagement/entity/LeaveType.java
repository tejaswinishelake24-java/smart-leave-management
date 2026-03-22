package com.smartLeaveManagement.leaveManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_type")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int maxDays;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMaxDays() { return maxDays; }
    public void setMaxDays(int maxDays) { this.maxDays = maxDays; }
}