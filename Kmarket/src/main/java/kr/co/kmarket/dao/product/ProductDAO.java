package kr.co.kmarket.dao.product;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_product;
import kr.co.kmarket.dto.product.ProductDTO;


public class ProductDAO extends DBHelper{
	private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);
	private static ProductDAO instace = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instace;
	}
	
	private ProductDAO() {
	
	}
	
	public void insertProduct(ProductDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.INSERT_PRODUCT);
			
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
	            psmt.setInt(11, dto.getSold());
	            psmt.setInt(12, dto.getDelivery());
	            psmt.setInt(13, dto.getHit());
	            psmt.setInt(14, dto.getScore());
	            psmt.setInt(15, dto.getReview());
	            psmt.setString(16, dto.getThumb1());
	            psmt.setString(17, dto.getThumb2());
	            psmt.setString(18, dto.getThumb3());
	            psmt.setString(19, dto.getDetail());
	            psmt.setString(20, dto.getStatus());
	            psmt.setString(21, dto.getDuty());
	            psmt.setString(22, dto.getReceipt());
	            psmt.setString(23, dto.getBizType());
	            psmt.setString(24, dto.getOrigin());
	            psmt.setString(25, dto.getIp());
	            psmt.setInt(26, dto.getEtc1());
	            psmt.setInt(27, dto.getEtc2());
	            psmt.setString(28, dto.getEtc3());
	            psmt.setString(29, dto.getEtc4());
	            psmt.setString(30, dto.getEtc5());
	            psmt.executeUpdate();
	            close();
	            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ProductDTO selectProduct(int prodNo) {
		ProductDTO dto = new ProductDTO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.SELECT_PRODUCT);
			psmt.setInt(1, prodNo);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
	            dto = new ProductDTO();
	            dto.setProdNo(rs.getInt("prodNo"));
	            dto.setProdCate1(rs.getInt("prodCate1"));
	            dto.setProdCate2(rs.getInt("prodCate2"));
	            dto.setProdName(rs.getString("prodName"));
	            dto.setDescript(rs.getString("descript"));
	            dto.setSeller(rs.getString("seller"));
	            dto.setCompany(rs.getString("company"));
	            dto.setPrice(rs.getInt("price"));
	            dto.setDiscount(rs.getInt("discount"));
	            dto.setPoint(rs.getInt("point"));
	            dto.setStock(rs.getInt("stock"));
	            dto.setSold(rs.getInt("sold"));
	            dto.setDelivery(rs.getInt("delivery"));
	            dto.setHit(rs.getInt("hit"));
	            dto.setScore(rs.getInt("score"));
	            dto.setReview(rs.getInt("review"));
	            dto.setThumb1(rs.getString("thumb1"));
	            dto.setThumb2(rs.getString("thumb2"));
	            dto.setThumb3(rs.getString("thumb3"));
	            dto.setDetail(rs.getString("detail"));
	            dto.setStatus(rs.getString("status"));
	            dto.setDuty(rs.getString("duty"));
	            dto.setReceipt(rs.getString("receipt"));
	            dto.setBizType(rs.getString("bizType"));
	            dto.setOrigin(rs.getString("origin"));
	            dto.setIp(rs.getString("ip"));
	            dto.setRdate(rs.getString("rdate"));
	            dto.setEtc1(rs.getInt("etc1"));
	            dto.setEtc2(rs.getInt("etc2"));
	            dto.setEtc3(rs.getString("etc3"));
	            dto.setEtc4(rs.getString("etc4"));
	            dto.setEtc5(rs.getString("etc5"));
	        }
			close();
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dto;
	}
	

	public List<ProductDTO> selectProducts(int start) {
		List<ProductDTO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.SELECT_PRODUCTS);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
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
				dto.setEtc1(rs.getInt(28));
				dto.setEtc2(rs.getInt(29));
				dto.setEtc3(rs.getString(30));
				dto.setEtc4(rs.getString(31));
				dto.setEtc5(rs.getString(32));
				products.add(dto);
				
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public void updateProduct(ProductDTO dto) {
		
	}
	public void deleteProduct(int prodNo) {
		
	}
	
	public int selectCountProductTotal() {
		
		int total = 0;
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.SELECT_COUNT_PRODUCT_TOTAL);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	//상품 분류 (판매량,리뷰수 등)
	public List<ProductDTO> selectProductsByOption(String sqlQuery, int start) {
	    List<ProductDTO> products = new ArrayList<>();
	    
	    try {
	        conn = getConnection();
	        psmt = conn.prepareStatement(sqlQuery);
	        psmt.setInt(1, start);
	        rs = psmt.executeQuery();
	        
	        while (rs.next()) {
	            ProductDTO dto = new ProductDTO();
	            dto.setProdNo(rs.getInt(1));
	            dto.setProdCate1(rs.getInt(2));
	            dto.setProdCate2(rs.getInt(3));
	            dto.setProdName(rs.getString(4));
	            dto.setDescript(rs.getString(5));
	            dto.setSeller(rs.getString(6));
	            dto.setCompany(rs.getString(7));
	            dto.setPrice(rs.getInt(8));
	            dto.setDiscount(rs.getInt(9));
	            dto.setSold(rs.getInt(10));
	            dto.setHit(rs.getInt(11));
	            dto.setScore(rs.getInt(12));
	            dto.setReview(rs.getInt(13));
	            dto.setThumb1(rs.getString(14));
	            dto.setDetail(rs.getString(15));
	            dto.setReceipt(rs.getString(16));
	            dto.setRdate(rs.getString(17));
	            products.add(dto);
	        }
	        close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return products;
	}
	public List<ProductDTO> selectProductsSelling(int start) {
	    String sqlQuery = SQL_product.SELECT_PRODUCTS_SELLING;
	    return selectProductsByOption(sqlQuery, start);
	}

	public List<ProductDTO> selectProductsLowprice(int start) {
	    String sqlQuery = SQL_product.SELECT_PRODUCTS_LOWPRICE;
	    return selectProductsByOption(sqlQuery, start);
	}

	public List<ProductDTO> selectProductsHighprice(int start) {
	    String sqlQuery = SQL_product.SELECT_PRODUCTS_HIGHPRICE;
	    return selectProductsByOption(sqlQuery, start);
	}

	public List<ProductDTO> selectProductsHighrating(int start) {
	    String sqlQuery = SQL_product.SELECT_PRODUCTS_HIGHRATING;
	    return selectProductsByOption(sqlQuery, start);
	}

	public List<ProductDTO> selectProductsManyreviews(int start) {
	    String sqlQuery = SQL_product.SELECT_PRODUCTS_MANYREVIEWS;
	    return selectProductsByOption(sqlQuery, start);
	}

	public List<ProductDTO> selectProductsRecent(int start) {
	    String sqlQuery = SQL_product.SELECT_PRODUCTS_RECENT;
	    return selectProductsByOption(sqlQuery, start);
	}
	
}