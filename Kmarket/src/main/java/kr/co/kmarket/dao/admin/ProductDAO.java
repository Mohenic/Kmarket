package kr.co.kmarket.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_Admin;
import kr.co.kmarket.dto.product.ProductDTO;

public class ProductDAO extends DBHelper{

	private static ProductDAO instace = new ProductDAO();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static ProductDAO getInstance() {
		return instace;
	}
	
	private ProductDAO() {
	
	}
	
	public void insertProduct(ProductDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_Admin.INSERT_ORDER);
			psmt.setInt(1, dto.getProdCate1());
			psmt.setInt(2, dto.getProdCate2());
			psmt.setString(3, dto.getProdName());
			psmt.setString(4, dto.getDescript());
			psmt.setString(5, dto.getSeller());
			psmt.setString(6, dto.getCompany());
			psmt.setInt(7, dto.getPrice());
			psmt.setInt(8, dto.getDiscount());
			psmt.setInt(9, dto.getPoint());
			psmt.setInt(10, dto.getStock());
			psmt.setInt(11, dto.getDiscount());
			psmt.setString(12, dto.getThumb1());
			psmt.setString(13, dto.getThumb2());
			psmt.setString(14, dto.getThumb3());
			psmt.setString(15, dto.getDetail());
			psmt.setString(16, dto.getStatus());
			psmt.setString(17, dto.getDuty());
			psmt.setString(18, dto.getReceipt());
			psmt.setString(19, dto.getBizType());
			psmt.setString(20, dto.getOrigin());
			psmt.setString(21, dto.getIp());

			psmt.executeUpdate();
			
			close();
			
		} catch (Exception e) {
			logger.error("insertProduct()" + e.getMessage());
		}
	}
	
	public void selectProduct() {
			
	}
	
	public void selectProducts() {
		
	}
	
	public void updateProduct() {
		
	}
	public void deleteProduct() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
