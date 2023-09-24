package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = -7715231998323392840L;
    private ProductService service = ProductService.INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortOption = req.getParameter("sort");
        String orderOption = req.getParameter("order");
        String category1Param = req.getParameter("prodCate1");
        String category2Param = req.getParameter("prodCate2");

        int currentPage = 1;
        int itemsPerPage = 5;

        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }

        int start = (currentPage - 1) * itemsPerPage;
        
        List<ProductDTO> list;
        list = service.getProductsByCategory(sortOption, orderOption, Integer.parseInt(category1Param), Integer.parseInt(category2Param), start);

        req.setAttribute("prodCate1", category1Param);
        req.setAttribute("prodCate2", category2Param);
        req.setAttribute("sortOption", sortOption);
        req.setAttribute("orderOption", orderOption);
        req.setAttribute("list", list);

        int totalItems = service.selectCountProductTotal();
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", currentPage);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
        dispatcher.forward(req, resp);
    }
}