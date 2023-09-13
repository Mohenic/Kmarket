package kr.co.kmarket.controller.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.controller.DAO.ArticleDAO;

public enum ArticleService {
	INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	ArticleDAO dao = ArticleDAO.getInstance();
	
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
