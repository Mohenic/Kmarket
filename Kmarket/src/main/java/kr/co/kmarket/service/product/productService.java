package kr.co.kmarket.service.product;

import java.util.List;

import kr.co.kmarket.dto.product.productDTO;


public enum productService {
	
	INSTANCE;
	
	// productDAO
	private productDAO dao = productDAO.getInstance();
	
	// service
	public void insertProduct(productDTO dto) {
		dao.insertProduct(dto);
	}
	public productDTO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
	}
	public List<productDTO> selectProducts() {
		return dao.selectProducts();
	}
	public void updateProduct(productDTO dto) {
		dao.updateProduct(dto);
	}
	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}
}