package kr.co.kmarket.dao.index;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_INDEX;
import kr.co.kmarket.dto.product.ProductDTO;

public class IndexDAO extends DBHelper {
	
	public static IndexDAO instance =new IndexDAO();
	public static IndexDAO getInstance() {
		return instance;
	}
	
	public List<ProductDTO> selectProducts(){
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
			
		}
		
		return products;
		
	}
}
