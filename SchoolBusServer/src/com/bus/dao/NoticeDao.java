package com.bus.dao;

import java.util.List;

import com.bus.model.Notice;

public interface NoticeDao {
	public List<Notice> seekNoticeByDriverId(int driverId);
	public boolean addNotice(Notice notice);
}
