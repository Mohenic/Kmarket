package kr.co.kmarket.service.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.admin.ProductDAO;
import kr.co.kmarket.dto.product.productDTO;



public enum ProductService {
	
	INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ProductDAO dao = ProductDAO.getInstance();
	
	public void insertArticle(productDTO dto) {
		dao.insertProduct(dto);
	}
	
	public void selectArticle() {
			
	}
	
	public void selectArticles() {
		
	}
	
	public void updateArticle() {
		
	}
	public void deleteArticle() {
		
	}
}
