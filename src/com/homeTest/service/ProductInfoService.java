package com.homeTest.service;

import java.util.List;

import com.homeTest.pojo.Product;
import com.homeTest.util.PageUtil;

public interface ProductInfoService {
	
	/**
	 * 分页获得所有商品信息
	 * @param pageUtil
	 * @return
	 */
	List<Product> getProducts(PageUtil pageUtil);
	
	/**
	 * 查询一共多少条记录
	 * @return
	 */
	int count();
}
