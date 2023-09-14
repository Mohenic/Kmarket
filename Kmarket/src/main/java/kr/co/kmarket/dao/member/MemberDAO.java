package kr.co.kmarket.dao.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_MEMBER;
import kr.co.kmarket.db.SQL_MEMBER;
import kr.co.kmarket.dto.member.MemberDTO;

public class MemberDAO extends DBHelper {

	public static MemberDAO instance =new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	};
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	public void insertMember(MemberDTO dto) {
		int type =dto.getType();
		try {
			conn=getConnection();
			if(type==1) {
				psmt=conn.prepareStatement(SQL_MEMBER.INSERT_MEMBER);
				psmt.setString(1, dto.getUid());
				psmt.setString(2, dto.getPass());
				psmt.setString(3, dto.getName());
				psmt.setInt(4, dto.getGender());
				psmt.setString(5, dto.getHp());
				psmt.setString(6, dto.getEmail());
				psmt.setInt(7, dto.getType());
				psmt.setString(8, dto.getZip());
				psmt.setString(9, dto.getAddr1());
				psmt.setString(10, dto.getAddr2());
				psmt.setString(11, dto.getRegip());
			}else if(type==2) {
				psmt=conn.prepareStatement(SQL_MEMBER.INSERT_MEMBER_SELLER);
				psmt.setString(1, dto.getUid());
				psmt.setString(2, dto.getPass());
				psmt.setString(3, dto.getEmail());
				psmt.setInt(4, dto.getType());
				psmt.setString(5, dto.getZip());
				psmt.setString(6, dto.getAddr1());
				psmt.setString(7, dto.getAddr2());
				psmt.setString(8, dto.getCompany());
				psmt.setString(9, dto.getCeo());
				psmt.setString(10, dto.getBizRegNum());
				psmt.setString(11, dto.getComRegNum());
				psmt.setString(12, dto.getTel());
				psmt.setString(13, dto.getManager());
				psmt.setString(14, dto.getManagerHp());
				psmt.setString(15, dto.getFax());
				psmt.setString(16, dto.getRegip());
			}
			
			
			psmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			logger.error("insertMember : "+e.getMessage());
		}
		
	}
	
	public int selectCountUid(String uid) {
		int result =0;
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_MEMBER.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectCountUid error : "+ e.getMessage());
		
		}
		
		
		return result;
	}
	
	public int selectCountEmail(String email) {
		int result =0;
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_MEMBER.SELECT_COUNT_EMAIL);
			psmt.setString(1, email);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectCountEmail error : "+ e.getMessage());
		
		}
		
		
		return result;
	}

	public int selectCountHp(String hp) {
		int result =0;
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_MEMBER.SELECT_COUNT_HP);
			psmt.setString(1, hp);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
			close();
		} catch (Exception e) {
			logger.error("selectCountHp error : "+ e.getMessage());
		
		}
		
		
		return result;
	}

	public MemberDTO selectMember(String uid, String pass) {
		MemberDTO dto = null;
		try {
			
			conn=getConnection();
			
			psmt=conn.prepareStatement(SQL_MEMBER.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new MemberDTO();
				dto.setUid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGender(rs.getInt(4));			
				dto.setHp(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setType(rs.getInt(7));;
				dto.setPoint(rs.getInt(8));
				dto.setLevel(rs.getInt(9));
				dto.setZip(rs.getString(10));
				dto.setAddr1(rs.getString(11));
				dto.setAddr2(rs.getString(12));
				dto.setCompany(rs.getString(13));
				dto.setCeo(rs.getString(14));
				dto.setBizRegNum(rs.getString(15));
				dto.setComRegNum(rs.getString(16));
				dto.setTel(rs.getString(17));
				dto.setManager(rs.getString(18));
				dto.setManagerHp(rs.getString(19));
				dto.setFax(rs.getString(20));
				dto.setRegip(rs.getString(21));
				dto.setRdate(rs.getString(23));

			}
			
			close();
				
		} catch (Exception e) {
			logger.error("selecttUser error : "+e.getMessage());
		}
		
		return dto;
	}
	
	
}