package kr.co.kmarket.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_admin;
import kr.co.kmarket.dto.admin.adminArticleDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;
import kr.co.kmarket.dto.product.ProductDTO;

public class adminArticleDAO extends DBHelper {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertArticle(adminArticleDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.INSERT_ARTICLE);
			psmt.setString(1, dto.getGroup());
			psmt.setString(2, dto.getCate());
			psmt.setInt(3, dto.getType());
			psmt.setString(4, dto.getTitle());
			psmt.setString(5, dto.getContent());
			psmt.setString(6, dto.getWriter());
			psmt.setString(7, dto.getRegip());
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//qna 답변
	public void insertAnswer(ArticleDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.INSERT_ANSWER);
			psmt.setInt(1, dto.getParent());
			psmt.setString(2, dto.getGroup());
			psmt.setString(3, dto.getCate());
			psmt.setInt(4, dto.getType());
			psmt.setString(5, dto.getTitle());
			psmt.setString(6, dto.getContent());
			psmt.setString(7, dto.getWriter());
			psmt.setString(8, dto.getRegip());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.debug("insertAnswer..." + e.getMessage());
		}
		
	}
	
	//qna답 출력
	public ArticleDTO selectAnswer(String no) {
		ArticleDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_ANSWER);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ArticleDTO();
				dto.setNo(rs.getString(1));
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
			}
			close();
		} catch (Exception e) {
			logger.debug("selectAnswer" + e.getMessage());
		}
		return dto;
	}
	
	
	
	public adminArticleDTO selectArticle(String no) {
		
		adminArticleDTO dto = new adminArticleDTO();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
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
				dto.setTypeName(rs.getString(14));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public adminArticleDTO selectArticleType(String no) {
		
		adminArticleDTO dto = new adminArticleDTO();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLE_TYPE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
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
				dto.setTypeName(rs.getString(14));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
  
	public List<adminArticleDTO> selectArticles(String group, String cate, int start){
		
		List<adminArticleDTO> article = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			if(cate.equals("0")){
				psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_ALL);
				psmt.setString(1, group);
				psmt.setInt(2, start);
			} else {
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
				dto.setTypeName(rs.getString(14));
				article.add(dto);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public List<adminArticleDTO> selectArticles(String group,String cate, String type, int start){
		
		List<adminArticleDTO> article = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			if(cate.equals("0") && type.equals("0")) {
				psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_TYPE_ALL);
				psmt.setString(1, group);
				psmt.setInt(2, start);
				
			} else if (type.equals("0")) {
				psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_GROUP_ALL);
				psmt.setString(1, group);
				psmt.setString(2, cate);
				psmt.setInt(3, start);
			} else {
				psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLES_TYPE);
				psmt.setString(1, group);
				psmt.setString(2, cate);
				psmt.setString(3, type);
				psmt.setInt(4, start);
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
				dto.setRdateYYMMDD(rs.getString(12));
				dto.setCateName(rs.getString(13));
				dto.setTypeName(rs.getString(14));
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
	
	public void updateArticle(adminArticleDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.UPDATE_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setInt(4, dto.getNo());
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticleType(adminArticleDTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.UPDATE_ARTICLE_TYPE);
			psmt.setString(1, dto.getCate());
			psmt.setInt(2, dto.getType());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getNo());
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteArticle(String no) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
