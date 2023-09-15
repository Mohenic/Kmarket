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

	public List<ProductDTO> selectProducts(){
		return dao.selectProducts();
	}
}
