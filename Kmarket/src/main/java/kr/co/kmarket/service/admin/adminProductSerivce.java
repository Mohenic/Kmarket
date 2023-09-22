package kr.co.kmarket.service.admin;

import kr.co.kmarket.dao.admin.adminProductDAO;
import kr.co.kmarket.dto.product.ProductDTO;

public enum adminProductSerivce {
	
	instance;
	
	private adminProductDAO dao = new adminProductDAO();
	
	public ProductDTO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}

}
