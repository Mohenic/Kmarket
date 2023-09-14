package kr.co.kmarket.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.member.MemberTermsDAO;
import kr.co.kmarket.dto.member.MemberDTO;
import kr.co.kmarket.dto.member.Member_termsDTO;

public enum MemberTermsService {
	INSTANCE;
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	private MemberTermsDAO dao =MemberTermsDAO.getInstance();
	
	public Member_termsDTO selectTerms(String type) {
		return dao.termsUser(type);
	}



}
