package kr.co.kmarket.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.member.MemberTermsDAO;
import kr.co.kmarket.dto.member.Km_member_termsDTO;

public enum MemberTermsService {
	INSTANCE;
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	private MemberTermsDAO dao =MemberTermsDAO.getInstance();
	
	public Km_member_termsDTO selectTerms(String type) {
		return dao.termsUser(type);
	}


}
