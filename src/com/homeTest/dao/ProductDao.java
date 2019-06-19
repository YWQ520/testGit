package com.homeTest.dao;

import java.util.List;

import com.homeTest.pojo.Product;
import com.homeTest.util.PageUtil;

public interface ProductDao {
	
	/**
	 * 查询所有商品
	 * @return
	 */
	List<Product> selProducts(PageUtil pageUtil);
	
	
	/**
	 * 记录一共有多少条记录
	 * @return
	 */
	int count();
}
