package com.homeTest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.homeTest.dao.ProductDao;
import com.homeTest.pojo.Product;
import com.homeTest.service.ProductInfoService;
import com.homeTest.util.PageUtil;

@Service("productInfoServiceImpl")
public class ProductInfoServiceImpl implements ProductInfoService {

	@Resource(name = "productDaoImpl")
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts(PageUtil pageUtil) {
		return productDao.selProducts(pageUtil);
	}

	@Override
	public int count() {
		return productDao.count();
	}

}
