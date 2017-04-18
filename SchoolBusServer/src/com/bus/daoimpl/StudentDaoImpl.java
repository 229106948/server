package com.bus.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bus.dao.DBFactory;
import com.bus.dao.StudentDao;
import com.bus.model.Student;

public class StudentDaoImpl implements StudentDao {

	public boolean addChild(Student student) {
		String sql = "insert into student (name,grade,classes,lineId,parentId,aboardSite,debusSite,advanceSite) values(?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(student.getName());
		params.add(student.getGrade());
		params.add(student.getClasses());
		params.add(student.getLineId());
		params.add(student.getParentId());
		params.add(student.getAboardSite());
		params.add(student.getDebusSite());
		params.add(student.getAdvanceSite());
		return DBFactory.getExec(sql, params);

	}

	public Student seekStudentById(int id) {
		Student student = null;
		String sql = "select * from student where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		List<Map<String, Object>> res = DBFactory.getRs(sql, params);
		Map<String, Object> map;
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++) {
				map = res.get(i);
				int studentId = (Integer) map.get("id");
				int parentId = (Integer) map.get("parentId");
				int lineId = (Integer) map.get("lineId");
				String name = (String) map.get("name");
				String grade = (String) map.get("grade");
				String classes = (String) map.get("classes");
				String aboardSite = (String) map.get("aboardSite");
				String debusSite = (String) map.get("debusSite");
				int advanceSite = (Integer) map.get("advanceSite");
				student = new Student(studentId, parentId, lineId, name, grade,
						classes, aboardSite, debusSite, advanceSite);
			}
		}
		return student;
	}

	public List<Student> seekStudentByParentId(String function, int functionId) {

		List<Student> students = new ArrayList<Student>();
		String sql = "select * from student where" + " " + function + "=?";
		List<Object> params = new ArrayList<Object>();
		params.add(functionId);
		List<Map<String, Object>> res = DBFactory.getRs(sql, params);
		Map<String, Object> map;
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++) {
				map = res.get(i);
				int studentId = (Integer) map.get("id");
				int mParentId = (Integer) map.get("parentId");
				int lineId = (Integer) map.get("lineId");
				System.out.println("lineId:" + lineId);
				String name = (String) map.get("name");
				System.out.println("name:" + name);
				String grade = (String) map.get("grade");
				System.out.println("grade:" + grade);
				String classes = (String) map.get("classes");
				System.out.println("classes:" + classes);
				String aboardSite = (String) map.get("aboardSite");
				String debusSite = (String) map.get("debusSite");
				int advanceSite = (Integer) map.get("advanceSite");
				Student student = new Student(studentId, mParentId, lineId,
						name, grade, classes, aboardSite, debusSite,
						advanceSite);
				students.add(student);
			}
		}
		return students;
	}
	public boolean updateChild(String function,Object value,int id) {
		String sql = "update student set ? = ? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(function);
		params.add(value);
		params.add(id);
		return DBFactory.getExec(sql, params);

	}
}
