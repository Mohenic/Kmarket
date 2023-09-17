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
				dto.setProdNo(rs.getInt(1));
				dto.setProdCate1(rs.getInt(2));
				dto.setProdCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setSeller(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
				products.add(dto);
			}
			
			close();
			
			
		} catch (Exception e) {
			logger.error("selectproduct error1 : " +e.getMessage());
		}
		
		return products;
		
	}
	
	
	public List<ProductDTO> selectProductsHit(){
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_INDEX.SELECT_PRODUCTS_HIT);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto =new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setProdCate1(rs.getInt(2));
				dto.setProdCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setSeller(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				
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
				dto.setProdNo(rs.getInt(1));
				dto.setProdCate1(rs.getInt(2));
				dto.setProdCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setSeller(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
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
				dto.setProdNo(rs.getInt(1));
				dto.setProdCate1(rs.getInt(2));
				dto.setProdCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setSeller(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
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
				dto.setProdNo(rs.getInt(1));
				dto.setProdCate1(rs.getInt(2));
				dto.setProdCate2(rs.getInt(3));
				dto.setProdName(rs.getString(4));
				dto.setDescript(rs.getString(5));
				dto.setSeller(rs.getString(6));
				dto.setCompany(rs.getString(7));
				dto.setPrice(rs.getInt(8));
				dto.setDiscount(rs.getInt(9));
				dto.setPoint(rs.getInt(10));
				dto.setStock(rs.getInt(11));
				dto.setSold(rs.getInt(12));
				dto.setDelivery(rs.getInt(13));
				dto.setHit(rs.getInt(14));
				dto.setScore(rs.getInt(15));
				dto.setReview(rs.getInt(16));
				dto.setThumb1(rs.getString(17));
				dto.setThumb2(rs.getString(18));
				dto.setThumb3(rs.getString(19));
				dto.setDetail(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				products.add(dto);
			}
			
			close();
			
			
		} catch (Exception e) {
			logger.error("selectproduct4 error : " +e.getMessage());
		}
		
		return products;
		
	}
}
