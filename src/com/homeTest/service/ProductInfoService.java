package com.homeTest.service;

import java.util.List;

import com.homeTest.pojo.Product;
import com.homeTest.util.PageUtil;

public interface ProductInfoService {
	
	/**
	 * ��ҳ���������Ʒ��Ϣ
	 * @param pageUtil
	 * @return
	 */
	List<Product> getProducts(PageUtil pageUtil);
	
	/**
	 * ��ѯһ����������¼
	 * @return
	 */
	int count();
}
