package kr.co.kmarket.dao.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_admin;
import kr.co.kmarket.dto.admin.adminArticleDTO;
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
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
  
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
	
	public ProductDTO selectArticle(String prodNo) {
		ProductDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLE);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setProdNo(rs.getString(1));
				dto.setProdCate1(rs.getInt(2));
				dto.setProdCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setSeller(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getString(16));
				dto.setThumb1ForRename(rs.getString(17));
				dto.setThumb2ForRename(rs.getString(18));
				dto.setThumb3ForRename(rs.getString(19));
				dto.setDetailForRename(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				dto.setEtc1(rs.getString(28));
				dto.setEtc2(rs.getString(29));
				dto.setEtc3(rs.getString(30));
				dto.setEtc4(rs.getString(31));
				dto.setEtc5(rs.getString(32));
			}
			
		} catch (Exception e) {
			logger.debug("selectArticle()..." + e.getMessage());
		}
		
		return dto;
	}
	
	
	
}
