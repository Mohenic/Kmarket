package kr.co.kmarket.service.cs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.cs.FaqDAO;
import kr.co.kmarket.dao.cs.NoticeDAO;
import kr.co.kmarket.dto.cs.FaqDTO;

public enum NoticeService {

	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private NoticeDAO dao = NoticeDAO.getInstance();
	
	
}
