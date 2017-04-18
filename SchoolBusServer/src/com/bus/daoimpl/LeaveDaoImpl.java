package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.LeaveDao;
import com.bus.model.Leave;

public class LeaveDaoImpl implements LeaveDao {

	public List<Leave> seekLeaveByStudentId(int parentId) {
		String sql = "select * from leavedata where parentId=?";
		List<Object> params = new ArrayList<Object>();
		params.add(parentId);
		List<Leave> leaves = new ArrayList<Leave>();
		List<Map<String, Object>> leaveList = DBFactory.getRs(sql, params);
		Leave leave;
		if (leaveList != null && leaveList.size() > 0) {
			for (int i = 0; i < leaveList.size(); i++) {
				Map<String, Object> map = leaveList.get(i);
				if (map != null) {
					int id = (Integer) map.get("id");
					int mParentId = (Integer) map.get("parentId");
					int studentId = (Integer) map.get("studentId");
					String startTime = (String) map.get("startTime");
					String applyTime = (String) map.get("applyTime");
					String endTime = (String) map.get("endTime");
					String leaveType=(String) map.get("leaveType");
					String leaveReason = (String) map.get("leaveReason");
					String telephone = (String) map.get("telephone");
					leave = new Leave(id, mParentId, studentId, startTime,
							applyTime, leaveType,endTime, leaveReason, telephone);
					leaves.add(leave);

				}
			}
		}
		return leaves;
	}

	public boolean addLeave(Leave leave) {
		String sql = "insert into leavedata(parentId,studentId,startTime,applyTime,leaveType,endTime,leaveReason,telephone) values (?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(leave.getParentId());
		params.add(leave.getStudentId());
		params.add(leave.getStartTime());
		params.add(leave.getApplyTime());
		params.add(leave.getLeaveType());
		params.add(leave.getEndTime());
		params.add(leave.getLeaveReason());
		params.add(leave.getTelephone());
		return DBFactory.getExec(sql, params);
	}
}
