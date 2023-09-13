package kr.co.kmarket.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;

public class OrderDAO extends DBHelper{
	
	
	
	//로거
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//싱글톤
	private static OrderDAO instace = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return instace;
	}
	
	private OrderDAO() {
	
	}
	
	public void insertOrder() {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(null);
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			logger.error("insertOrder()" + e.getMessage());
		}
		
	}
	
	public void selectOrder() {
			
	}
	
	public void selectOrders() {
		
	}
	
	public void updateOrder() {
		
	}
	public void deleteOrder() {
		
	}
	
}
