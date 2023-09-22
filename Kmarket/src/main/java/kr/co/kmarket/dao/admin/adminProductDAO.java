package kr.co.kmarket.dao.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_admin;
import kr.co.kmarket.dto.product.ProductDTO;

public class adminProductDAO extends DBHelper {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProductDTO selectProduct(String prodNo) {
		ProductDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_admin.SELECT_ARTICLE);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setProdNo(rs.getString(1));
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
				dto.setReview(rs.getString(16));
				dto.setThumb1ForRename(rs.getString(17));
				dto.setThumb2ForRename(rs.getString(18));
				dto.setThumb3ForRename(rs.getString(19));
				dto.setDetailForRename(rs.getString(20));
				dto.setStatus(rs.getString(21));
				dto.setDuty(rs.getString(22));
				dto.setReceipt(rs.getString(23));
				dto.setBizType(rs.getString(24));
				dto.setOrigin(rs.getString(25));
				dto.setIp(rs.getString(26));
				dto.setRdate(rs.getString(27));
				dto.setEtc1(rs.getString(28));
				dto.setEtc2(rs.getString(29));
				dto.setEtc3(rs.getString(30));
				dto.setEtc4(rs.getString(31));
				dto.setEtc5(rs.getString(32));
			}
			
		} catch (Exception e) {
			logger.debug("selectArticle()..." + e.getMessage());
		}
		
		return dto;
	}

}
