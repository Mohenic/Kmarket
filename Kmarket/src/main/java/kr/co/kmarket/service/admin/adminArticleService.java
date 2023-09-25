package kr.co.kmarket.service.admin;

import java.util.List;

import kr.co.kmarket.dao.admin.adminArticleDAO;
import kr.co.kmarket.dto.admin.adminArticleDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;

public enum adminArticleService {

	instance;
	
	private adminArticleDAO dao = new adminArticleDAO();
	
	
	public void insertArticle(adminArticleDTO dto) {
		dao.insertArticle(dto);
	}
	
	public void insertAnswer(ArticleDTO dto) {
		dao.insertAnswer(dto);
	}
	
	public adminArticleDTO selectArticle(String no) {
		return dao.selectArticle(no);
	}
	public adminArticleDTO selectArticleType(String no) {
		return dao.selectArticleType(no);
	}
	
	public List<adminArticleDTO> selectArticles(String group, String cate, String type, int start){
		return dao.selectArticles(group, cate, type, start);
	}
	
	public List<adminArticleDTO> selectArticles(String group, String cate, int start){
		return dao.selectArticles(group, cate, start);
	}
	
	public int selectCountArticleTotal(String group,String cate) {
		return dao.selectCountArticleTotal(group, cate);
	}
	
	public void updateArticle(adminArticleDTO dto) {
		dao.updateArticle(dto);
	}
	public void updateArticleType(adminArticleDTO dto) {
		dao.updateArticleType(dto);
	}
	
	public void deleteArticle(String no) {
		dao.deleteArticle(no);
	}
}
