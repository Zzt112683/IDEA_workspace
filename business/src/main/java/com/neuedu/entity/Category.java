package com.neuedu.entity;

import java.io.Serializable;


//��Ʒ���
public class Category implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6497081881229878546L;
	private int id;
	private int parent_id;
	private String name;
	private int status;
	private int sort_order;
	private String creat_time;
	private String update_time;
	
	
	public Category() {
		super();
	}


	public Category(int id, int parent_id, String name, int status, int sort_order, String creat_time, String update_time) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.sort_order = sort_order;
		this.creat_time = creat_time;
		this.update_time = update_time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getParent_id() {
		return parent_id;
	}


	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getSort_order() {
		return sort_order;
	}


	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}


	public String getCreat_time() {
		return creat_time;
	}


	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}


	public String getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	
	
	
	
}
