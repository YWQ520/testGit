package com.homeTest.dao;

import java.util.List;

import com.homeTest.pojo.Product;
import com.homeTest.util.PageUtil;

public interface ProductDao {
	
	/**
	 * ��ѯ������Ʒ
	 * @return
	 */
	List<Product> selProducts(PageUtil pageUtil);
	
	
	/**
	 * ��¼һ���ж�������¼
	 * @return
	 */
	int count();
}
