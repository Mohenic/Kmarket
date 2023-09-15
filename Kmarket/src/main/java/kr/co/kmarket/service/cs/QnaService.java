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
	
	public QnaDTO selectQnaArticle(String qnaNo) {
		return dao.selectQnaArticle(qnaNo);
	}
	
	public List<QnaDTO> selectQnaArticles(String cate, int start){
		return dao.selectQnaArticles(cate, start);
	}
	
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	
}
