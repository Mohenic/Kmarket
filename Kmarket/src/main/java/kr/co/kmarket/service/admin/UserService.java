package kr.co.kmarket.service.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.admin.MemberDAO;


public enum UserService {
	
	INSTANCE;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	MemberDAO dao = MemberDAO.getInstance();
	
	
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
