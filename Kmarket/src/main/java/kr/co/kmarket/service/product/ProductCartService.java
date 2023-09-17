package kr.co.kmarket.service.product;

import java.util.List;

import kr.co.kmarket.dao.product.ProductCartDAO;
import kr.co.kmarket.dto.product.ProductCartDTO;

	public enum ProductCartService {
		INSTANCE;
		
	private ProductCartDAO dao = ProductCartDAO.getInstance();
	
	
	public void insertCart(ProductCartDTO dto) {
		dao.insertCart(dto);
	}
	
	public ProductCartDTO selectCart(String cartNo) {
		return dao.selectCart(cartNo);
	}
	
	public List<ProductCartDTO> selectCarts() {
		return dao.selectCarts();
	}
	
	public void updateCart(ProductCartDTO dto) {
		dao.updateCart(dto);
	}
	
	public void deleteCart(String cartNo) {
		dao.deleteCart(cartNo);
	}
}
