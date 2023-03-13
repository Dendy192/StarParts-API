package com.robot.db.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="\"SP_STATUS\"")
//@IdClass(StatusOutlet.PrimaryKey.class)
public class StatusOutlet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="\"ID_STATUS\"")
	private int id;
	
	@Column(name = "\"STATUS_NAME\"")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StatusOutlet [id=" + id + ", status=" + status + "]";
	}
	
	
}
