package com.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	String name;
	@Column
	String address;
	@Column
	String department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee( String name, String address, String department) {
		super();
		this.name = name;
		this.address = address;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", department=" + department + "]";
	}

}
