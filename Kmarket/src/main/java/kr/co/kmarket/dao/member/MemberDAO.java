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
	

	
	
}