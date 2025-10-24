package com.model;

import java.sql.Timestamp;

public class Complaints {
	private int complaint_id;
	private int user_id;
	private String title;
	private String description;
	private String status;
	private Timestamp created_at;
	private Timestamp updated_at;

	public Complaints() {
		
	}

	public Complaints(int complaint_id, int user_id, String title, String description, String status,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.complaint_id = complaint_id;
		this.user_id = user_id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complain_id) {
		this.complaint_id = complain_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Complaints [complaint_id=" + complaint_id + ", user_id=" + user_id + ", title=" + title + ", description="
				+ description + ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}
	

}
