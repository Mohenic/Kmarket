package kr.co.kmarket.service.index;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.index.IndexDAO;
import kr.co.kmarket.dto.product.ProductDTO;

public enum IndexService {
	INSTANCE;
	
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	private IndexDAO dao =IndexDAO.getInstance();

	public List<ProductDTO> selectProductsHit(){
		return dao.selectProductsHit();
	}
	
	public List<ProductDTO> selectProductsScore(){
		return dao.selectProductsScore();
	}
	
	public List<ProductDTO> selectProductsNew(){
		return dao.selectProductsNew();
	}
	
	public List<ProductDTO> selectProductsDiscount(){
		return dao.selectProductsDiscount();
	}
	
	public List<ProductDTO> selectProductsSold(){
		return dao.selectProductsSold();
	}
	
}
