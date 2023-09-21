package kr.co.kmarket.dao.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_Cart;
import kr.co.kmarket.db.SQL_ORDER;
import kr.co.kmarket.db.SQL_product;
import kr.co.kmarket.dto.product.ProductCartDTO;
import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.dto.product.ProductItemDTO;
import kr.co.kmarket.dto.product.ProductOrderDTO;

public class ProductOrderDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ProductDTO dto = null;
	// 싱글톤
	private static ProductOrderDAO instance = new ProductOrderDAO();
	
	public static ProductOrderDAO getInstance() {
		return instance;
	}
	private ProductOrderDAO() {}
	
	public void insertOrder(ProductOrderDTO dto) {
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_ORDER.INSERT_ORDER);
			psmt.setString(1, dto.getOrdUid());
			psmt.setInt(2, dto.getOrdCount());
			psmt.setInt(3, dto.getOrdPrice());
			psmt.setInt(4, dto.getOrdDiscount());
			psmt.setInt(5, dto.getOrdDelivery());
			psmt.setInt(6, dto.getSavePoint());
			psmt.setInt(7, dto.getUsedPoint());
			psmt.setInt(8, dto.getOrdTotPrice());
			psmt.setString(9, dto.getRecipName());
			psmt.setString(10, dto.getRecipHp());
			psmt.setString(11, dto.getRecipZip());
			psmt.setString(12, dto.getRecipAddr1());
			psmt.setString(13, dto.getRecipAddr2());
			psmt.setInt(14, dto.getOrdPayment());
			
			psmt.executeUpdate();
			
			close();
			
			
		} catch (Exception e) {
			logger.error("insert error : "+e.getMessage());
		}
		
	}
	
	public void insertItem(ProductItemDTO dto) {
		
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_ORDER.INSERT_ITEM);
			psmt.setInt(1, dto.getOrdNo());
			psmt.setInt(2, dto.getProdNo());
			psmt.setInt(3, dto.getCount());
			psmt.setInt(4, dto.getPrice());
			psmt.setInt(5, dto.getDiscount());
			psmt.setInt(6, dto.getPoint());
			psmt.setInt(7, dto.getDelivery());
			psmt.setInt(8, dto.getTotal());
			
			psmt.executeUpdate();
			
			close();
			
			
		} catch (Exception e) {
			logger.error("insert error : "+e.getMessage());
		}
		
	}
	
	public int selectOrderLastNum() {
		int ordno=0;
		try {
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_ORDER.SELECT_ORDERS);
			
			rs=psmt.executeQuery();
			if(rs.next()) {
				ordno=rs.getInt(1);
			}
			
			
		}catch (Exception e) {

		}
		return ordno;
	}
	
	public List<ProductItemDTO> selectOrderItems(int ordNo2){
		List<ProductItemDTO> list = new ArrayList<>();
		ProductItemDTO dto =null;
		
		try {
			
			conn=getConnection();
			psmt=conn.prepareStatement(SQL_ORDER.SELECT_ORDER);
			psmt.setInt(1, ordNo2);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				dto=new ProductItemDTO();
				dto.setOrdNo(rs.getInt(1));
				dto.setProdNo(rs.getInt(2));
				dto.setCount(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setDiscount(rs.getInt(5));
				dto.setPoint(rs.getInt(6));
				dto.setDelivery(rs.getInt(7));
				dto.setTotal(rs.getInt(8));
				dto.setProdCate1(rs.getInt(10));
				dto.setProdCate2(rs.getInt(11));
				dto.setProdName(rs.getString(12));
				dto.setDescript(rs.getString(13));
				list.add(dto);
			}
			
		} catch (Exception e) {
			logger.error("select error1 : " +e.getMessage());
		}
		
		
		return list;
	}
	
}