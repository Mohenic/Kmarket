package kr.co.kmarket.controller.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.controller.DAO.OrderDAO;

public enum OrderService {
	
	INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	OrderDAO dao = OrderDAO.getInstance();
	
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
