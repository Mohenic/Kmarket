package kr.co.kmarket.service.cs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.cs.ArticleDAO;
import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;

public enum ArticleService {

	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	public void insertArticle(ArticleDTO dto) {
		dao.insertArticle(dto);
	}
	
	public ArticleDTO selectArticle(String qnaNo) {
		return dao.selectArticle(qnaNo);
	}
	
	public List<ArticleDTO> selectArticles(String group ,String cate, int start){
		return dao.selectArticles(group ,cate, start);
	}
	
	public int selectCountTotal(String group,String cate) {
		return dao.selectCountTotal(group ,cate);
	}
	
	public List<ArticleDTO> selectArticleLatest(String group, int end) {
		return dao.selectArticleLatest(group, end);
	}
	
	public List<ArticleDTO> selectFaqArticles(String group, String cate) {
		return dao.selectFaqArticles(group, cate);
	}
	
	public List<ArticleDTO> selectFaqArticleLists(String cate){
		return dao.selectFaqArticleLists(cate);
	}
	
	public ArticleDTO selectAnswerArticle(String parent) {
		return dao.selectAnswerArticle(parent);
	}
	
	public List<ArticleDTO> selectNoticeArticles(String group, String cate, int start) {
		return dao.selectNoticeArticles(group, cate, start);
	}
}
