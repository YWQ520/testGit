package com.homeTest.pojo;

import java.io.Serializable;


public class Product implements Serializable{
	
	private static final long serialVersionUID = 4466435726309737877L;
	
	private int product_id;		//int(11) NOT NULL��Ʒ���
	private CategoryThree categoryThree;		// NULL��������
	private int brand_id;		//int(11) NULLƷ�Ʊ��
	private String product_name;		//varchar(20) NOT NULL��Ʒ����
	private String DESCRIPTION;		//varchar(500) NULL��Ʒ����
	private double price;		//double NOT NULL��Ʒ�۸�
	private int stock;		//int(11) NULL  ״̬
	private int browse;		//int(11) NULL  �������
	private int sales;		//int(11) NULL��Ʒ����
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public CategoryThree getCategoryThree() {
		return categoryThree;
	}
	public void setCategoryThree(CategoryThree categoryThree) {
		this.categoryThree = categoryThree;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getBrowse() {
		return browse;
	}
	public void setBrowse(int browse) {
		this.browse = browse;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
}
