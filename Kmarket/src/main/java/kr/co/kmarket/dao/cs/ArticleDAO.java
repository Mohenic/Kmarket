package kr.co.kmarket.dao.cs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_cs;
import kr.co.kmarket.dto.cs.FaqDTO;
import kr.co.kmarket.dto.member.MemberDTO;
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
	
	public ArticleDTO selectArticle(String no) {
			
		ArticleDTO dto = null;
			
			try {
				
				conn = getConnection();
				psmt = conn.prepareStatement(SQL_cs.SELECT_ARTICLE);
				psmt.setString(1, no);
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
					dto.setRdateYYMMDD2(rs.getString(12));
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
	
	public List<ArticleDTO> selectFaqArticleLists(String cate){
		
		List<ArticleDTO> lists = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.select_Faq_ArticleList);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleDTO dto = new ArticleDTO();
				dto.setCate(rs.getString(1));
				dto.setType(rs.getInt(2));
				dto.setTypeName(rs.getString(3));
				lists.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.debug("selectFaqArticleList..." + e.getMessage());
		}
		return lists;
	}
	
	//Faq게시글 출력
	public List<ArticleDTO> selectFaqArticles(String group, String cate) {
		
		List<ArticleDTO> FaqArticles = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_Faq_ARTICLES);
			psmt.setString(1, group);
			psmt.setString(2, cate);
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
				FaqArticles.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.debug("selectFaqArticles()..." + e.getMessage());
		}
		
		return FaqArticles;
	}
	//notice 종류별로 뽑기
	public List<ArticleDTO> selectNoticeArticles(String group, String cate, int start) {
		
		List<ArticleDTO> articles = new ArrayList<>();
		
		try {
			conn = getConnection();
			if(cate.equals("0")) {
				psmt  = conn.prepareStatement(SQL_cs.SELECT_NOTICE_Article_ALL);				
				psmt.setString(1, group);
				psmt.setInt(2, start);
				
			}else {
				psmt  = conn.prepareStatement(SQL_cs.SELECT_NOTICE_Article_TYPE);
				psmt.setString(1, group);
				psmt.setString(2, cate);
				psmt.setInt(3, start);
			}
			
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
				articles.add(dto);
			}
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articles;
	}
	
	
	public int selectCountTotal(String group,String cate) {
			
		int total = 0;
		
		try {
			conn = getConnection();
			if(cate.equals("0")) {
				psmt = conn.prepareStatement(SQL_cs.SELECT_COUNT_NOTICE_TOTAL);
				psmt.setString(1, group);
				
			}else {
				psmt = conn.prepareStatement(SQL_cs.SELECT_COUNT_TOTAL);
				psmt.setString(1, group);
				psmt.setString(2, cate);
			}
			
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
				dto.setCate(rs.getString(2));
				dto.setTypeName(rs.getString(3));
				dto.setTitle(rs.getString(4));
				dto.setWriter(rs.getString(5));
				dto.setRdateYYMMDD(rs.getString(6));
				latest.add(dto);
			}
			
			close();
			
		} catch (Exception e) {
			logger.error("selectArteicleLateste() error : " + e.getMessage());
		}
		return latest;
	}
	
	
	
	public void updateArticle(ArticleDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.UPDATE_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setInt(2, dto.getType());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setInt(5, dto.getNo());
			psmt.executeUpdate();
			
		} catch (Exception e) {
			logger.debug("updateArticle..." + e.getMessage());
		}
		
	}
	
	
	
	
	//답글 보기
	public ArticleDTO selectAnswerArticle(String parent) {
		ArticleDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_ANSWER_ARTICLE_);
			psmt.setString(1, parent);
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
				dto.setRdateYYMMDD(rs.getString(12));
			}
			
			close();
			
		} catch (Exception e) {
			logger.debug("selectAnswer()..." + e.getMessage());
		}
		return dto;
	}
	
	public void deleteArticle(String no) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			logger.debug("deleteArticle()..." + e.getMessage());
		}
	}
	
	
	
	//관리자가 type = 2 출력하기
	public int selectTypeMember(String uid) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_cs.SELECT_TYPE_MEMBER);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			close();
			
		} catch (Exception e) {
			logger.debug("selectTypeMember" + e.getMessage());
		}
		
		return result;
	}


}
