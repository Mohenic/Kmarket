package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.product.ProductCartDTO;
import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.product.ProductCartService;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/view.do")
public class ProductViewController extends HttpServlet {

    private static final long serialVersionUID = 2687468093010817571L;
    private ProductService productService = ProductService.INSTANCE;
    private ProductCartService productCartService = ProductCartService.INSTANCE;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	
    	String prodNo = req.getParameter("prodNo");
    	String prodCate1 = req.getParameter("prodCate1");
    	String prodCate2 = req.getParameter("prodCate2");
        int parseNo = Integer.parseInt(prodNo);
       
        productService.updateProductHit(prodNo);
        ProductDTO dto = productService.selectProduct(parseNo);
        req.setAttribute("view", dto);
        req.setAttribute("prodCate1", prodCate1);
        req.setAttribute("prodCate2", prodCate2);
        logger.debug("Product View = " + dto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
        dispatcher.forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uid = req.getParameter("uid");
        String prodNo = req.getParameter("prodNo");
        String prodName = req.getParameter("prodName");
        String descript = req.getParameter("descript");
        String priceStr = req.getParameter("price");
        String pointStr = req.getParameter("point");
        String discountStr = req.getParameter("discount");
        String deliveryStr = req.getParameter("delivery");
        String totalStr = req.getParameter("total");
        String countStr = req.getParameter("num");

        int price = parseInt(priceStr);
        int point = parseInt(pointStr);
        int discount = parseInt(discountStr);
        int delivery = parseInt(deliveryStr);
        int total = parseInt(totalStr);
        int count = parseInt(countStr);

        ProductCartDTO dto = new ProductCartDTO();
        dto.setUid(uid);
        dto.setProdNo(prodNo);
        dto.setProdName(prodName);
        dto.setDescript(descript);
        dto.setPrice(price);
        dto.setPoint(point);
        dto.setDiscount(discount);
        dto.setDelivery(delivery);
        dto.setTotal(total);
        dto.setCount(count);

        productCartService.insertCart(dto);
        resp.sendRedirect("/product/cart.do");
    }

    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
