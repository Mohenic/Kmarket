package kr.co.kmarket.service.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.product.ProductDAO;
import kr.co.kmarket.dto.product.ProductDTO;



public enum ProductService {
	
	INSTANCE;
	
	// productDAO
	private ProductDAO dao = ProductDAO.getInstance();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// service
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	public ProductDTO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<ProductDTO> selectProducts() {
		return dao.selectProducts();
	}
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}
}