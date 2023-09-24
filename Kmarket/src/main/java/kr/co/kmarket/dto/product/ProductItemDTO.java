package kr.co.kmarket.dto.product;

import java.text.DecimalFormat;

public class ProductItemDTO {



	private int ordNo;
	private int prodNo;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String prodName;
	private String descript;
	private String thumb1;
	private int prodCate1;
	private int prodCate2;
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getThumb1() {
		return thumb1;
	}
	public void setThumb1(String thumb1) {
		this.thumb1 = thumb1;
	}
	public int getProdCate1() {
		return prodCate1;
	}
	public void setProdCate1(int prodCate1) {
		this.prodCate1 = prodCate1;
	}
	public int getProdCate2() {
		return prodCate2;
	}
	public void setProdCate2(int prodCate2) {
		this.prodCate2 = prodCate2;
	}

	
	
	
	
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = Integer.parseInt(ordNo);
	}
	
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = Integer.parseInt(prodNo);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setCount(String count) {
		this.count = Integer.parseInt(count);
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setDiscount(String discount) {
		this.discount = Integer.parseInt(discount);
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setPoint(String point) {
		this.point = Integer.parseInt(point);
	}
	
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery =Integer.parseInt(delivery);
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}
	
	public String getPriceWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(price);
	}
	
	public String getDeliveryWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(delivery);
	}
	
	public String getTotalWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(total);
	}
	
	public int getDiscountPrice(int price, int discount) {
		int discountPrice=0;
		
		discountPrice=(int)(price-(price*(discount*0.01)));
		
		return discountPrice;
	}
	public String getDiscount(int price, int discount) {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(getDiscountPrice(price, discount));
	}
	
	public int getDiscountPrice2(int price, int discount) {
		int discountPrice=0;
		
		discountPrice=(int)(price*(discount*0.01));
		
		return discountPrice;
	}
	
	public String getDiscount2(int price, int discount) {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(getDiscountPrice2(price, discount));
	}
	
	
}
