package kr.co.kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_cs;
import kr.co.kmarket.dto.cs.FaqDTO;

public class FaqDAO extends DBHelper {
	
	public static FaqDAO instance = new FaqDAO();
	public static FaqDAO getInstance() {
		return instance;
	};

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
	
	public List<FaqDTO> selectFaqArticles(String cate){
		
		List<FaqDTO> faqArticles = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_FAQ_ARTICLES);
			psmt.setString(1, cate);
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
	
	public int selectCountFaq(String cate) {
		
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_COUNT_FAQ);
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
