package com.homeTest.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class CategoryThree implements Serializable {
	private static final long serialVersionUID = -1406586416054765486L;
	private int three_id;//int(11) NOT NULL三级分类编号
	private int two_id;//int(11) NULL二级分类编号
	private String three_name;//varchar(20) NOT NULL名称
	private Set<Product> products = new HashSet<Product>();
	
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public int getThree_id() {
		return three_id;
	}
	public void setThree_id(int three_id) {
		this.three_id = three_id;
	}
	public int getTwo_id() {
		return two_id;
	}
	public void setTwo_id(int two_id) {
		this.two_id = two_id;
	}
	public String getThree_name() {
		return three_name;
	}
	public void setThree_name(String three_name) {
		this.three_name = three_name;
	}
}
