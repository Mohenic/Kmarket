package kr.co.kmarket.dao.member;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_member;
import kr.co.kmarket.dto.member.Km_member_termsDTO;

public class MemberTermsDAO extends DBHelper{

	public static MemberTermsDAO instance =new MemberTermsDAO();
	public static MemberTermsDAO getInstance() {
		return instance;
	};
	
	public Km_member_termsDTO  termsUser(String type) {
		Km_member_termsDTO dto =new Km_member_termsDTO();
		int type1 = Integer.parseInt(type);
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			
			if(type1==1) {
				rs=stmt.executeQuery(SQL_member.SELECT_TEMRS);
			
					if(rs.next()) {
						dto.setTerms(rs.getString(1));
						dto.setPrivacy(rs.getString(2));
						dto.setLocation(rs.getString(3));
						dto.setFinance(rs.getString(4));
					}
			
			}else if (type1==2) {
				rs=stmt.executeQuery(SQL_member.SELECT_TAX);
				
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
