package com.homeTest.action;

import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.homeTest.pojo.Product;
import com.homeTest.service.ProductInfoService;
import com.homeTest.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ProductInfoAction extends ActionSupport {

	private static final long serialVersionUID = 2913409761995264259L;

	
	private ProductInfoService productInfoService;
	 
	private List<Product> products;

	private PageUtil pageUtil;

	private WebApplicationContext wc = ContextLoader.getCurrentWebApplicationContext();
	
	public ProductInfoService getProductInfoService() {
		return productInfoService;
	}

	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String execute() throws Exception {
		setProductInfoService(wc.getBean("productInfoServiceImpl",ProductInfoService.class));

		int count = productInfoService.count();

		setPageUtil(pageUtil == null ? new PageUtil(6, 1, count) : new PageUtil(6,pageUtil.getNowPage(),count));

		setProducts(productInfoService.getProducts(pageUtil));
		return super.execute();
	}
}
