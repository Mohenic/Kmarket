package kr.co.kmarket.controller.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.controller.DAO.ProductDAO;


public enum ProductService {
	
	INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ProductDAO dao = ProductDAO.getInstance();
	
	public void insertArticle() {
		
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
