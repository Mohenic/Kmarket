package kr.co.kmarket.service.cs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.cs.FaqDAO;
import kr.co.kmarket.dto.cs.FaqDTO;

public enum FaqService {

	instance;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private FaqDAO dao = FaqDAO.instance;
	
	public FaqDTO selectFaqArticle(String faqNo) {
		return dao.selectFaqArticle(faqNo);
	}
	
	public List<FaqDTO> selectFaqArticles(String cate, int start){
		return dao.selectFaqArticles(cate, start);
	}
	
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	
}
