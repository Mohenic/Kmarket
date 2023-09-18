package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/category.do")
public class ProductCateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService service = ProductService.INSTANCE;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category1Param = req.getParameter("prodCate1");
        String category2Param = req.getParameter("prodCate2");

        int category1 = Integer.parseInt(category1Param);
        int category2 = Integer.parseInt(category2Param);

        List<ProductDTO> productList = service.getProductsByCategory(category1, category2);

        req.setAttribute("productList", productList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
        dispatcher.forward(req, resp);
    }
}

