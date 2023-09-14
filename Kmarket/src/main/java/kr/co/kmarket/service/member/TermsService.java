package kr.co.kmarket.service.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.member.TermsDAO;
import kr.co.kmarket.dto.member.TermsDTO;

public enum TermsService {
	INSTANCE;
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	private TermsDAO dao =TermsDAO.getInstance();
	
	public TermsDTO selectTerms(String type) {
		return dao.termsUser(type);
	}


	
}
