package kr.co.kmarket.dao.member;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_MEMBER;
import kr.co.kmarket.dto.member.Member_termsDTO;

public class MemberTermsDAO extends DBHelper{

	public static MemberTermsDAO instance =new MemberTermsDAO();
	public static MemberTermsDAO getInstance() {
		return instance;
	};
	
	public Member_termsDTO  termsUser(String type) {
		Member_termsDTO dto =new Member_termsDTO();
		int type1 = Integer.parseInt(type);
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			
			if(type1==1) {
				rs=stmt.executeQuery(SQL_MEMBER.SELECT_TEMRS);
			
					if(rs.next()) {
						dto.setTerms(rs.getString(1));
						dto.setPrivacy(rs.getString(2));
						dto.setLocation(rs.getString(3));
						dto.setFinance(rs.getString(4));
					}
			
			}else if (type1==2) {
				rs=stmt.executeQuery(SQL_MEMBER.SELECT_TAX);
				
				if(rs.next()) {
					dto.setTax(rs.getString(1));
					dto.setPrivacy(rs.getString(2));
					dto.setFinance(rs.getString(3));
				}
			}
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
		
		
	}

	
	
	
}
