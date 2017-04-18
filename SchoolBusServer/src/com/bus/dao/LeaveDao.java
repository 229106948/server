package com.bus.dao;

import java.util.List;

import com.bus.model.Leave;

public interface LeaveDao {
	public List<Leave> seekLeaveByStudentId(int studentId);

	public boolean addLeave(Leave leave);
}
