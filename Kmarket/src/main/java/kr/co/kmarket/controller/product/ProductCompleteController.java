package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.product.ProductItemDTO;
import kr.co.kmarket.dto.product.ProductOrderDTO;
import kr.co.kmarket.service.product.ProductCartService;
import kr.co.kmarket.service.product.ProductOrderService;
import kr.co.kmarket.service.product.ProductService;

@WebServlet("/product/complete.do")
public class ProductCompleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5772880320109292475L;
	ProductOrderService service1 = ProductOrderService.INSTANCE;
	ProductCartService service2 = ProductCartService.INSTANCE;

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				int ordNo3=service1.selectOrderLastNum();
				List<ProductItemDTO> list = service1.selectOrderItems(ordNo3);
				ProductOrderDTO order =service1.selectOrder(ordNo3);
				
				req.setAttribute("list", list);
				req.setAttribute("order", order);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/product/complete.jsp");
				dispatcher.forward(req, resp);
			}
	
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				String uid = req.getParameter("uid");
				String count=req.getParameter("count");
				String price=req.getParameter("price");
				String discount =req.getParameter("discount");
				String delivery = req.getParameter("delivery");
				String savepoint = req.getParameter("addpoint");
				String usedpoint = req.getParameter("losepoint");
				String totprice = req.getParameter("total");
				String recipname = req.getParameter("orderer");
				String reciphp =req.getParameter("hp");
				String recipzip =req.getParameter("zip");
				String recipaddr1 =req.getParameter("addr1");
				String recipaddr2 =req.getParameter("addr2");
				String payment =req.getParameter("payment");
				String type =req.getParameter("type");
				String cartNo[]=req.getParameterValues("cartNo");
				
				
				ProductOrderDTO dto = new ProductOrderDTO();
				dto.setOrdUid(uid);
				dto.setOrdCount(count);
				dto.setOrdPrice(price);
				dto.setOrdDiscount(discount);
				dto.setOrdDelivery(delivery);
				dto.setSavePoint(savepoint);
				dto.setUsedPoint(usedpoint);
				dto.setOrdTotPrice(totprice);
				dto.setRecipName(recipname);
				dto.setRecipHp(reciphp);
				dto.setRecipZip(recipzip);
				dto.setRecipAddr1(recipaddr1);
				dto.setRecipAddr2(recipaddr2);
				dto.setOrdPayment(payment);
				
				service1.insertOrder(dto);
				
				if(type.equals("cart")) {
					for(String cartNos : cartNo) {
						service2.deleteCart(cartNos);
					}
				}
				
				
				int ordNo2=service1.selectOrderLastNum();
				
				String[] itemprodNo =req.getParameterValues("itemprodNo");
				String[] itemcount =req.getParameterValues("itemcount");
				String[] itemprice =req.getParameterValues("itemprice");
				String[] itemdiscount =req.getParameterValues("itemdiscount");
				String[] itempoint =req.getParameterValues("itempoint");
				String[] itemdelivery =req.getParameterValues("itemdelivery");
				String[] itemtotal =req.getParameterValues("itemtotal");
				
				
				for(int i=0; i<itemprodNo.length;i++) {
					ProductItemDTO dto2 =new ProductItemDTO();
					dto2.setOrdNo(ordNo2);
					dto2.setProdNo(itemprodNo[i]);
					dto2.setCount(itemcount[i]);
					dto2.setPrice(itemprice[i]);
					dto2.setDiscount(itemdiscount[i]);
					dto2.setPoint(itempoint[i]);
					dto2.setDelivery(itemdelivery[i]);
					dto2.setTotal(itemtotal[i]);
					service1.insertItem(dto2);
				}
				
				resp.sendRedirect("/Kmarket/product/complete.do");
			}


	}