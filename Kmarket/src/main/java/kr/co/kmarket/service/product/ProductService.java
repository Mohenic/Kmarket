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

    public List<ProductDTO> selectProducts(int start) {
        return dao.selectProducts(start);
    }
    public void updateProduct(ProductDTO dto) {
        dao.updateProduct(dto);
    }
    public void deleteProduct(int prodNo) {
        dao.deleteProduct(prodNo);
    }
    
    public int selectCountProductTotal() {
    	return dao.selectCountProductTotal();
    }
}