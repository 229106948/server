package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.NoticeDao;
import com.bus.model.Notice;

public class NoticeDaoImpl implements NoticeDao {

	public List<Notice> seekNoticeByDriverId(int parentId) {
		List<Notice> noticeList = new ArrayList<Notice>();
		Notice notice;
		String sql = "select notice.id,notice.title,notice.time,notice.content,notice.driverId from student,line,notice where student.parentId=? and student.lineId=line.id and line.driverId=notice.driverId";
		List<Object> params = new ArrayList<Object>();
		params.add(parentId);
		List<Map<String, Object>> res = DBFactory.getRs(sql, params);
		Map<String, Object> map;
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++) {
				map = res.get(i);
				int id = (Integer) map.get("id");
				String title = (String) map.get("title");
				String time = (String) map.get("time");
				String content = (String) map.get("content");
				int mDriverId = (Integer) map.get("driverId");
				notice = new Notice(id, title, time, content, mDriverId);
				if(!noticeList.contains(notice)){
					noticeList.add(notice);
				}
			}
		}
		return noticeList;
	}

	public boolean addNotice(Notice notice) {

		String sql = "insert into notice(driverId,title,time,content) values(?,?,?,?)";

		List<Object> params = new ArrayList<Object>();
		params.add(notice.getDriverId());
		params.add(notice.getTitle());
		params.add(notice.getTime());
		params.add(notice.getContent());

		return DBFactory.getExec(sql, params);
	}

}
