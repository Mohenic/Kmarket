package kr.co.kmarket.dao.member;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_MEMBER;
import kr.co.kmarket.dto.member.TermsDTO;


public class TermsDAO extends DBHelper {
	public static TermsDAO instance =new TermsDAO();
	public static TermsDAO getInstance() {
		return instance;
	};
	
	public TermsDTO  termsUser(String type) {
		TermsDTO dto =new TermsDTO();
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
