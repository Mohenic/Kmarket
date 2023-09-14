package kr.co.kmarket.service.cs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.cs.QnaDAO;
import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.cs.QnaDTO;

public enum QnaService {

	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private QnaDAO dao = QnaDAO.getInstance();
	
	public void insertQnarticle(QnaDTO dto) {
		dao.insertQnaArticle(dto);
	}
	
	public void selectQnaArticle() {
		
	}
	
	public List<QnaDTO> selectQnaArticles(String cate){
		return dao.selectQnaArticles(cate);
	}
	
	public void selectCountTotal() {
	
	}
	
}
