package com.robot.db.model;

import java.io.Serializable;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="\"SP_OUTLET\"")
public class Outlet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="\"OUTLET_ID\"")
	private String id;
	
	@Column(name="\"OUTLET_NAME\"")
	private String name;

	@Column(name="\"OUTLET_EMAIL\"")
	private String email;

	@Column(name="\"OUTLET_PHONE\"")
	private String phone;
	
//	@JoinColumn(name ="\"ID_STATUS\"")
	@Column(name="\"OUTLET_STATUS\"")
	private int status;
//	@JoinTable(name = "\"SP_STATUS\"",
//			joinColumns = {@JoinColumn(name ="\"OUTLET_STATUS\"")},
//			inverseJoinColumns = {@JoinColumn(name="\"ID_STATUS\"")})
//	@OneToMany(targetEntity = StatusOutlet.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "os", referencedColumnName = "")
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "")
//	private StatusOutlet OUTLET_STATUS;
	
	@Column(name = "\"OUTLET_TYPE\"")
	private int type;
	
	@Column(name="\"OUTLET_PLAFON\"")
	private String plafon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPlafon() {
		return plafon;
	}

	public void setPlafon(String plafon) {
		this.plafon = plafon;
	}

	@Override
	public String toString() {
		return "Outlet [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", status=" + status
				+ ", type=" + type + ", plafon=" + plafon + "]";
	}

	

	
	
	

}
