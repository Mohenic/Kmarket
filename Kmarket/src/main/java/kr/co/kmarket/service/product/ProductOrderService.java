package kr.co.kmarket.service.product;


import java.util.List;

import kr.co.kmarket.dao.product.ProductOrderDAO;
import kr.co.kmarket.dto.product.ProductItemDTO;
import kr.co.kmarket.dto.product.ProductOrderDTO;


public enum ProductOrderService {

    INSTANCE;

    // productDAO
    private ProductOrderDAO dao = ProductOrderDAO.getInstance();

    // service
    public void insertOrder(ProductOrderDTO dto) {
        dao.insertOrder(dto);
    }
    
    public void insertItem(ProductItemDTO dto) {
        dao.insertItem(dto);
    }
    
    public int selectOrderLastNum() {
    	return dao.selectOrderLastNum();
    }
    
    public List<ProductItemDTO> selectOrderItems(int ordNo2) {
    	return dao.selectOrderItems(ordNo2);
    }
 
    public ProductOrderDTO selectOrder(int ordNo2) {
    	return dao.selectOrder(ordNo2);
    }
}