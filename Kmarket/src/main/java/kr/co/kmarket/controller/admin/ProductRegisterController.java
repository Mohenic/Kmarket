package kr.co.kmarket.controller.admin;

import java.io.File;
import java.io.IOException;

/*
 * 작업자 : 손영우
 * 작업시작일 : 2023/09/13
 * 작업종료일 : 2023/09/14
 * */

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.kmarket.dto.product.ProductDTO;
import kr.co.kmarket.service.file.FileService;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/admin/product/register.do")
public class ProductRegisterController extends HttpServlet {
	private static final long serialVersionUID = 6138492371144597779L;

	private ProductService pSerivce = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private FileService fService = FileService.instance;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * prodNo, seller 는 list,login 구현 후 정확한 값 가져오기 가능 현재는 register.jsp 파일내 input
		 * text를 이용해서 값 넘겨주는 중
		 */
		
		String prodCate1 = req.getParameter("cate1");
		String prodCate2 = req.getParameter("cate2");
		
		// 업로드 경로설정
		String path = fService.getPath(req, "/thumb/"+prodCate1+"/"+prodCate2);

		// 폴더 생성
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs(); // 디렉터리가 존재하지 않으면 생성
		}

		// 파일업로드
		MultipartRequest mr = fService.uploadFile(req, path);

		String prodName = mr.getParameter("prodName");
		String descript = mr.getParameter("descript");
		String seller = mr.getParameter("seller");
		String company = mr.getParameter("company");
		String price = mr.getParameter("price");
		String discount = mr.getParameter("discount");
		String point = mr.getParameter("point");
		String stock = mr.getParameter("stock");
		String delivery = mr.getParameter("delivery");
		String thumb1 = mr.getOriginalFileName("thumb1");
		String thumb2 = mr.getOriginalFileName("thumb2");
		String thumb3 = mr.getOriginalFileName("thumb3");
		String detail = mr.getOriginalFileName("detail");
		String status = mr.getParameter("status");
		String duty = mr.getParameter("duty");
		String receipt = mr.getParameter("receipt");
		String bizType = mr.getParameter("bizType");
		String origin = mr.getParameter("origin");
		String ip = req.getRemoteAddr();

		logger.debug("prodCate1 : " + prodCate1);
		logger.debug("prodCate2 : " + prodCate2);
		logger.debug("prodName : " + prodName);
		logger.debug("thumb1 : " + thumb1);
		logger.debug("thumb2 : " + thumb2);
		logger.debug("thumb3 : " + thumb3);
		logger.debug("origin : " + origin);
		logger.debug("ip : " + ip);

		ProductDTO dto = new ProductDTO();
		dto.setPath(path);
		dto.setProdCate1(prodCate1);
		dto.setProdCate2(prodCate2);
		dto.setProdName(prodName);
		dto.setDescript(descript);
		dto.setSeller(seller);
		dto.setCompany(company);
		dto.setPrice(price);
		dto.setDiscount(discount);
		dto.setPoint(point);
		dto.setStock(stock);
		dto.setDelivery(delivery);
		dto.setThumb1ForRename(thumb1);
		dto.setThumb2ForRename(thumb2);
		dto.setThumb3ForRename(thumb3);
		dto.setDetailForRename(detail);
		dto.setStatus(status);
		dto.setDuty(duty);
		dto.setReceipt(receipt);
		dto.setBizType(bizType);
		dto.setOrigin(origin);
		dto.setIp(ip);

		pSerivce.insertProduct(dto);

		logger.debug(dto.toString());

		resp.sendRedirect("/Kmarket/admin/product/list.do?success=200");

	}
}
