package kr.co.kmarket.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;

public class MemberDAO extends DBHelper{
	
	//로거
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//싱글톤
	private static MemberDAO instace = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instace;
	}
	
	private MemberDAO() {
	
	}
	
	
	public void inserMember() {
		
	}
	
	public void selectMember() {
			
	}
	
	public void selectMembers() {
		
	}
	
	public void updateMember() {
		
	}
	public void deleteMember() {
		
	}
}
