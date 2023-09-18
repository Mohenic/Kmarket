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
    public void deleteProduct(String prodNo) {
        dao.deleteProduct(prodNo);
    }
    
    public int selectCountProductTotal() {
    	return dao.selectCountProductTotal();
    }
    
    //상품 분류 (판매량,리뷰수 등)
	public List<ProductDTO> selectProductsSelling(int sort) {
		return dao.selectProductsSelling(sort);
	}
	public List<ProductDTO> selectProductsLowprice(int sort) {
		return dao.selectProductsLowprice(sort);
	}
	public List<ProductDTO> selectProductsHighprice(int sort) {
		return dao.selectProductsHighprice(sort);
	}
	public List<ProductDTO> selectProductsHigtrating(int sort) {
		return dao.selectProductsHighrating(sort);
	}
	public List<ProductDTO> selectProductsManyreviews(int sort) {
		return dao.selectProductsManyreviews(sort);
	}
	public List<ProductDTO> selectProductsRecent(int sort) {
		return dao.selectProductsRecent(sort);
	}
	
	//category
	public List<ProductDTO> getProductsByCategory(int category1, int category2) {
	    return dao.selectProductsByCategory(category1, category2);
	}

}