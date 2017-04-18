package com.bus.model;

public class Leave {
	private int id;
	private int parentId;
	private int studentId;
	private String startTime;
	private String applyTime;
	private String leaveType;
	private String endTime;
	private String telephone;
	public Leave(int id, int parentId, int studentId,
			String startTime, String applyTime, String leaveType,
			String endTime, String leaveReason,String telephone) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.studentId = studentId;
		this.startTime = startTime;
		this.applyTime = applyTime;
		this.leaveType = leaveType;
		this.endTime = endTime;
		this.leaveReason = leaveReason;
		this.telephone=telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String leaveReason;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	

}
