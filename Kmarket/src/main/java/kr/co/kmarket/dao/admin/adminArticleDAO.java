package kr.co.kmarket.dao.admin;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_admin;
import kr.co.kmarket.dto.admin.adminArticleDTO;

public class adminArticleDAO extends DBHelper {

	public List<adminArticleDTO> selectArticles(String group, int start){
		
		List<adminArticleDTO> article = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_ALL);
			psmt.setString(1, group);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				adminArticleDTO dto = new adminArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComment(rs.getInt(3));
				dto.setGroup(rs.getString(4));
				dto.setCate(rs.getString(5));
				dto.setType(rs.getInt(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setWriter(rs.getString(9));
				dto.setHit(rs.getInt(10));
				dto.setRegip(rs.getString(11));
				dto.setRdate(rs.getString(12));
				dto.setCateName(rs.getString(13));
				article.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public List<adminArticleDTO> selectArticles(String group,String cate, int start){
		
		List<adminArticleDTO> article = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			if(cate.equals("0")) {
				psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_ALL);
				psmt.setString(1, group);
				psmt.setInt(2, start);
			}else {
				psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_CATE);
				psmt.setString(1, group);
				psmt.setString(2, cate);
				psmt.setInt(3, start);
			}
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				adminArticleDTO dto = new adminArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setParent(rs.getInt(2));
				dto.setComment(rs.getInt(3));
				dto.setGroup(rs.getString(4));
				dto.setCate(rs.getString(5));
				dto.setType(rs.getInt(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setWriter(rs.getString(9));
				dto.setHit(rs.getInt(10));
				dto.setRegip(rs.getString(11));
				dto.setRdate(rs.getString(12));
				dto.setCateName(rs.getString(13));
				article.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public int selectCountArticleTotal(String group) {
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_COUNT_ARTICLE_ALL);
			psmt.setString(1, group);
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
	
	public int selectCountArticleTotal(String group,String cate) {
		int total = 0;
		
		try {
			conn = getConnection();
			
			if(cate.equals("0")) {
				psmt = conn.prepareStatement(SQL_admin.SELECT_COUNT_ARTICLE_ALL);
				psmt.setString(1, group);
			}else {
				psmt = conn.prepareStatement(SQL_admin.SELECT_COUNT_ARTICLE_CATE);
				psmt.setString(1, group);
				psmt.setString(2, cate);
			}
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
