package kr.co.kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_cs;
import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.cs.ArticleDTO;

public class ArticleDAO extends DBHelper{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private static ArticleDAO instance = new ArticleDAO();
	
	public static ArticleDAO getInstance() {
		return instance;
	};
	
	private ArticleDAO() {
		
	}
	
	public void insertArticle(ArticleDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.INSERT_ARTICLE);
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
			logger.debug("insertQnaArticle()..." + e.getMessage());
		}	
		
	}
	
	public ArticleDTO selectArticle(String qnaNo) {
			
		ArticleDTO dto = null;
			
			try {
				
				conn = getConnection();
				psmt = conn.prepareStatement(SQL_cs.SELECT_ARTICLE);
				psmt.setString(1, qnaNo);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					dto = new ArticleDTO();
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
					dto.setTypeName(rs.getString(13));
				}
				close();
			} catch (Exception e) {
				logger.debug("selectQnaArticle()" + e.getMessage());
			}
			return dto;
		}
	
	
	
	public List<ArticleDTO> selectArticles(String group, String cate, int start){
		
		List<ArticleDTO> qnaArticles = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_ARTICLES);
			psmt.setString(1, group);
			psmt.setString(2, cate);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
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
				dto.setTypeName(rs.getString(13));
				
				qnaArticles.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.debug("selectArticles()..." + e.getMessage());
		}
		return qnaArticles;
	}
	
	
	public int selectCountTotal(String group,String cate) {
			
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_COUNT_TOTAL);
			psmt.setString(1, group);
			psmt.setString(2, cate);
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
	
	
	//최신글 조회
	public List<ArticleDTO> selectArticleLatest(String group, int end) {
		
		List<ArticleDTO> latest = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_ARTICLE_LATEST);
			psmt.setString(1, group);
			psmt.setInt(2, end);
			rs = psmt.executeQuery();
	
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setNo(rs.getInt(1));
				dto.setTypeName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setMaskWriter(rs.getString(4));
				dto.setRdateYYMMDD(rs.getString(5));
				latest.add(dto);
			}
			
			close();
			
		} catch (Exception e) {
			logger.error("selectArteicleLateste() error : " + e.getMessage());
		}
		return latest;
	}


}
