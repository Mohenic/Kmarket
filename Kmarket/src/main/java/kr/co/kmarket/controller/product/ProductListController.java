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
        String category1Param = req.getParameter("prodCate1");
        String category2Param = req.getParameter("prodCate2");

        int start = 0;
        List<ProductDTO> list;

        if (category1Param != null && category2Param != null) {
            int category1 = Integer.parseInt(category1Param);
            int category2 = Integer.parseInt(category2Param);

            list = service.getProductsByCategory(category1, category2);
            logger.info("카테고리별로 상품 목록 조회");
        } else if (sortOption != null && !sortOption.isEmpty()) {
            if ("selling".equals(sortOption)) {
                list = service.selectProductsSelling(start);
                logger.info("판매량 높은 순서대로 상품 목록 조회");
            } else if ("lowprice".equals(sortOption)) {
                list = service.selectProductsLowprice(start);
                logger.info("낮은 가격 순서대로 상품 목록 조회");
            } else if ("highprice".equals(sortOption)) {
                list = service.selectProductsHighprice(start);
                logger.info("높은 가격 순서대로 상품 목록 조회");
            } else if ("highrating".equals(sortOption)) {
                list = service.selectProductsHighrating(start);
                logger.info("평점 높은 순서대로 상품 목록 조회");
            } else if ("manyreviews".equals(sortOption)) {
                list = service.selectProductsManyreviews(start);
                logger.info("후기 많은 순서대로 상품 목록 조회");
            } else if ("recent".equals(sortOption)) {
                list = service.selectProductsRecent(start);
                logger.info("최근 등록 순서대로 상품 목록 조회");
            } else {
                list = service.selectProducts(start);
                logger.info("기본 조회");
            }
        } else {
            list = service.selectProducts(start);
            logger.info("기본 조회");
        }

        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
        dispatcher.forward(req, resp);
    }
}
