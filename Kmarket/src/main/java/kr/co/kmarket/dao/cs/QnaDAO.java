package kr.co.kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_cs;
import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.cs.QnaDTO;

public class QnaDAO extends DBHelper{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private static QnaDAO instance = new QnaDAO();
	
	public static QnaDAO getInstance() {
		return instance;
	};
	
	private QnaDAO() {
		
	}
	
	public void insertQnaArticle(QnaDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.INSERT_QNA_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getType());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.debug("insertQnaArticle()..." + e.getMessage());
		}	
		
	}
	
	public QnaDTO selectQnaArticle(String qnaNo) {
			
		QnaDTO dto = null;
			
			try {
				
				conn = getConnection();
				psmt = conn.prepareStatement(SQL_cs.SELECT_QNA_ARTICLE);
				psmt.setString(1, qnaNo);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					dto = new QnaDTO();
					dto.setQnaNo(rs.getInt(1));
					dto.setParent(rs.getInt(2));
					dto.setComment(rs.getInt(3));
					dto.setCate(rs.getString(4));
					dto.setType(rs.getString(5));
					dto.setTitle(rs.getString(6));
					dto.setContent(rs.getString(7));
					dto.setWriter(rs.getString(8));
					dto.setRegip(rs.getString(9));
					dto.setRdate(rs.getString(10));
				}
				close();
			} catch (Exception e) {
				logger.debug("selectQnaArticle()" + e.getMessage());
			}
			return dto;
		}
	
	
	
	public List<QnaDTO> selectQnaArticles(String cate, int start){
		
		List<QnaDTO> qnaArticles = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_QNA_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				QnaDTO dto = new QnaDTO();
				dto.setQnaNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComment(rs.getInt(3));
				dto.setCate(rs.getString(4));
				dto.setType(rs.getString(5));
				dto.setTitle(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setWriter(rs.getString(8));
				dto.setRegip(rs.getString(9));
				dto.setRdateYYMMDD(rs.getString(10));
				
				qnaArticles.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.debug("selectFaqArticles()..." + e.getMessage());
		}
		return qnaArticles;
	}
	
	
	public int selectCountTotal(String cate) {
			
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.debug("selectCountTotal()..." + e.getMessage());
		}
		return total;
	}


}
