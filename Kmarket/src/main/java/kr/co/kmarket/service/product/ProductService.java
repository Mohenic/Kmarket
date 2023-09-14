package kr.co.kmarket.service.product;

import java.util.List;

import kr.co.kmarket.dao.product.ProductDAO;
import kr.co.kmarket.dto.product.ProductDTO;


public enum ProductService {
	
	INSTANCE;
	
	// productDAO
	private ProductDAO dao = ProductDAO.getInstance();
	
	// service
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	public ProductDTO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<ProductDTO> selectProducts(String prodCate1, int start) {
		return dao.selectProducts(prodCate1,start);
	}
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}
}