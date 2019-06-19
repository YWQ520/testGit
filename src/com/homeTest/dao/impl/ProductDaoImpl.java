package com.homeTest.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.homeTest.dao.BaseDao;
import com.homeTest.dao.ProductDao;
import com.homeTest.pojo.Product;
import com.homeTest.util.PageUtil;

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao {

	@Resource
	private BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selProducts(PageUtil pageUtil) {
		String hql = "from Product"; 
		return (List<Product>) baseDao.pagination(hql,pageUtil.getNowPage(),pageUtil.getSizePage());
	}

	@Override
	public int count() {
		String hql = "select count(product_id) from Product"; 
		long count =(Long) baseDao.uniqueQuery(hql);
		return (int) count;
	}
	
}
