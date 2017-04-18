package com.bus.model;

public class Notice {
	private int id;
	private String title;
	private String time;
	private String content;
	private int driverId;

	public Notice(int id, String title, String time, String content,
			int driverId) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.content = content;
		this.driverId = driverId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	/**
	 * 重写 equals方法
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Notice) {
			Notice otherUser = (Notice) object;
			if (this.id == otherUser.getId()
					&& this.driverId == otherUser.getDriverId()
					&& this.title.equals(otherUser.getTitle())
					&& this.time.equals(otherUser.getTime())
					&& this.content.equals(otherUser.getContent())) {
				return true;
			}
		}
		return false;
	}

}
