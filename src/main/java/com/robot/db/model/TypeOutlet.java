package com.robot.db.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="\"SP_TYPE_OUTLET\"")
public class TypeOutlet  implements Serializable{
	
private static final long serialVersionUID = 1L;
	@Id
	@Column(name="\"TYPE_ID\"")
	private int id;
	
	@Column(name = "\"TYPE_NAME\"")
	private String name;

	@Column(name = "\"TYPE_PERCENTAGE\"")
	private String percen;

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

	public String getPercen() {
		return percen;
	}

	public void setPercen(String percen) {
		this.percen = percen;
	}

	@Override
	public String toString() {
		return "TypeOutlet [id=" + id + ", name=" + name + ", percen=" + percen + "]";
	}
	
	
}
