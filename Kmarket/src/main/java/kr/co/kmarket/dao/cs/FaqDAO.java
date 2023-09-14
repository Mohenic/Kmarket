package kr.co.kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_cs;
import kr.co.kmarket.dto.cs.FaqDTO;

public class FaqDAO extends DBHelper {
	
	private static FaqDAO instance = new FaqDAO();
	public static FaqDAO getInstance() {
		return instance;
	};
	private FaqDAO() {
		
	}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	

	public void insertFaqArticle(FaqDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.INSERT_ARTICLE);
			psmt.setString(1, dto.getCate1());
			psmt.setString(2, dto.getCate2());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getWriter());
			psmt.setString(6, dto.getRegip());
			psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.debug("insertFaqArticle()..." + e.getMessage());
		}
		
		
	}
	
	
	public FaqDTO selectFaqArticle(String faqNo) {
		
		FaqDTO dto = null;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_FAQ_ARTICLE);
			psmt.setString(1, faqNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new FaqDTO();
				dto.setFaqNo(rs.getInt("faqNo"));
				dto.setCate1(rs.getString("cate1"));
				dto.setCate2(rs.getString("cate2"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<FaqDTO> selectFaqArticles(String cate, int start){
		
		List<FaqDTO> faqArticles = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_FAQ_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				FaqDTO dto = new FaqDTO();
				dto.setFaqNo(rs.getInt(1));
				dto.setCate1(rs.getString(2));
				dto.setCate2(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setContent(rs.getString(5));
				faqArticles.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faqArticles;
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
			e.printStackTrace();
		}
		
		return total;
	}
}
