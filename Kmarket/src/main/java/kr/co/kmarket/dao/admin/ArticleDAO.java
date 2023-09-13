package kr.co.kmarket.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;

public class ArticleDAO extends DBHelper{
	
	//로거
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//싱글톤
	private static ArticleDAO instace = new ArticleDAO();
	
	public static ArticleDAO getInstance() {
		return instace;
	}
	
	
	
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
