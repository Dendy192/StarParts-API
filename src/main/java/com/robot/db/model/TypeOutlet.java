package com.robot.db.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="\"SP_TYPE_CUSTOMER\"")
public class TypeOutlet  implements Serializable{
	
private static final long serialVersionUID = 1L;
	@Id
	@Column(name="\"ID_TYPE_CUSTOMER\"")
	private int id;
	
	@Column(name = "\"TYPE_NAME\"")
	private String name;

	@Column(name = "\"TYPE_PERCENTAGE\"")
	private int percen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercen() {
		return percen;
	}

	public void setPercen(int percen) {
		this.percen = percen;
	}

	@Override
	public String toString() {
		return "TypeOutlet [id=" + id + ", name=" + name + ", percen=" + percen + "]";
	}
	
	
}
