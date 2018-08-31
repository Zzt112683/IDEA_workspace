package com.neuedu.entity;

import java.io.Serializable;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3340604346152912765L;
	private int id;
	private Product product;
	private int productid;
	private int productnum;

	public Cart(int id, Product product, int productid, int productnum) {
		super();
		this.id = id;
		this.product = product;
		this.productid = productid;
		this.productnum = productnum;
	}
	
	public Cart() {
		super();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getProductnum() {
		return productnum;
	}

	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", productnum=" + productnum + "]";
	}

	

	

}
