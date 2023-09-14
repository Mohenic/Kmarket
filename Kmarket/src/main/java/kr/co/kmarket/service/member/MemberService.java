package kr.co.kmarket.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.member.MemberDAO;
import kr.co.kmarket.dto.member.MemberDTO;


public enum MemberService {
	INSTANCE;
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	private MemberDAO dao =MemberDAO.getInstance();
	
	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	}
	
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}

	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	
	public MemberDTO selectMember(String uid, String pass) {
		return dao.selectMember(uid,pass);
	}
	
}