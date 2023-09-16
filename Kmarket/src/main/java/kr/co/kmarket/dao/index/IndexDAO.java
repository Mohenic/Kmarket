package kr.co.kmarket.dao.index;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_INDEX;
import kr.co.kmarket.dto.product.ProductDTO;

public class IndexDAO extends DBHelper {
	
	public static IndexDAO instance =new IndexDAO();
	public static IndexDAO getInstance() {
		return instance;
	}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<ProductDTO> selectProductsSold(){
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_INDEX.SELECT_PRODUCTS_SOLD);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto =new ProductDTO();
				dto.setProdName(rs.getString(1));
				dto.setDescript(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDiscount(rs.getInt(4));
				dto.setThumb1(rs.getString(5));
				products.add(dto);
			}
			
			close();
			
			
		} catch (Exception e) {
			logger.error("selectproduct error1 : " +e.getMessage());
		}
		
		return products;
		
	}
	
	public List<ProductDTO> selectProductsScore(){
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_INDEX.SELECT_PRODUCTS_SCORE);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto =new ProductDTO();
				dto.setProdName(rs.getString(1));
				dto.setDescript(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDiscount(rs.getInt(4));
				dto.setThumb1(rs.getString(5));
				dto.setDelivery(rs.getString(6));
				products.add(dto);
			}
			
			close();
			
			
		} catch (Exception e) {
			logger.error("selectproduct2 error : " +e.getMessage());
		}
		
		return products;
		
	}
	
	public List<ProductDTO> selectProductsNew(){
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_INDEX.SELECT_PRODUCTS_NEW);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto =new ProductDTO();
				dto.setProdName(rs.getString(1));
				dto.setDescript(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDiscount(rs.getInt(4));
				dto.setThumb1(rs.getString(5));
				dto.setDelivery(rs.getString(6));
				products.add(dto);
			}
			
			close();
			
			
		} catch (Exception e) {
			logger.error("selectproduct3 error : " +e.getMessage());
		}
		
		return products;
		
	}
	
	public List<ProductDTO> selectProductsDiscount(){
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_INDEX.SELECT_PRODUCTS_DISCOUNT);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto =new ProductDTO();
				dto.setProdName(rs.getString(1));
				dto.setDescript(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setDiscount(rs.getInt(4));
				dto.setThumb1(rs.getString(5));
				dto.setDelivery(rs.getString(6));
				products.add(dto);
			}
			
			close();
			
			
		} catch (Exception e) {
			logger.error("selectproduct4 error : " +e.getMessage());
		}
		
		return products;
		
	}
}
