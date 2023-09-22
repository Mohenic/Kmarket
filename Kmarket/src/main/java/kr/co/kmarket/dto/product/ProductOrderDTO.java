package kr.co.kmarket.dto.product;

import java.io.File;
import java.text.DecimalFormat;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductOrderDTO {


	private int ordNo;
	private String ordUid;
	private int ordCount;
	private int ordPrice;
	private int ordDiscount;
	private int ordDelivery;
	private int savePoint;
	private int usedPoint;
	private int ordTotPrice;
	private String recipName;
	private String recipHp;
	private String recipZip;
	private String recipAddr1;
	private String recipAddr2;
	private int ordPayment;
	private int ordComplete;
	private String ordDate;

	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	
	public void setOrdNo(String ordNo) {
		this.ordNo = Integer.parseInt(ordNo);
	}
	
	public String getOrdUid() {
		return ordUid;
	}
	public void setOrdUid(String ordUid) {
		this.ordUid = ordUid;
	}
	public int getOrdCount() {
		return ordCount;
	}
	public void setOrdCount(int ordCount) {
		this.ordCount = ordCount;
	}
	
	public void setOrdCount(String ordCount) {
		this.ordCount = Integer.parseInt(ordCount);
	}
	
	public int getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}
	public void setOrdPrice(String ordPrice) {
		this.ordPrice = Integer.parseInt(ordPrice);
	}
	public int getOrdDelivery() {
		return ordDelivery;
	}
	public void setOrdDelivery(int ordDelivery) {
		this.ordDelivery = ordDelivery;
	}
	public void setOrdDelivery(String ordDelivery) {
		this.ordDelivery = Integer.parseInt(ordDelivery);
	}
	
	public int getSavePoint() {
		return savePoint;
	}
	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
	}
	public void setSavePoint(String savePoint) {
		this.savePoint = Integer.parseInt(savePoint);
	}
	
	public int getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}
	
	public void setUsedPoint(String usedPoint) {
		this.usedPoint = Integer.parseInt(usedPoint);
	}
	public int getOrdTotPrice() {
		return ordTotPrice;
	}
	public void setOrdTotPrice(int ordTotPrice) {
		this.ordTotPrice = ordTotPrice;
	}
	
	public void setOrdTotPrice(String ordTotPrice) {
		this.ordTotPrice = Integer.parseInt(ordTotPrice);
	}
	
	public String getRecipName() {
		return recipName;
	}
	public void setRecipName(String recipName) {
		this.recipName = recipName;
	}
	public String getRecipHp() {
		return recipHp;
	}
	public void setRecipHp(String recipHp) {
		this.recipHp = recipHp;
	}
	public String getRecipZip() {
		return recipZip;
	}
	public void setRecipZip(String recipZip) {
		this.recipZip = recipZip;
	}
	public String getRecipAddr1() {
		return recipAddr1;
	}
	public void setRecipAddr1(String recipAddr1) {
		this.recipAddr1 = recipAddr1;
	}
	public String getRecipAddr2() {
		return recipAddr2;
	}
	public void setRecipAddr2(String recipAddr2) {
		this.recipAddr2 = recipAddr2;
	}
	public int getOrdPayment() {
		return ordPayment;
	}
	public void setOrdPayment(int ordPayment) {
		this.ordPayment = ordPayment;
	}
	
	public void setOrdPayment(String ordPayment) {
		this.ordPayment = Integer.parseInt(ordPayment);
	}
	
	public int getOrdComplete() {
		return ordComplete;
	}
	public void setOrdComplete(int ordComplete) {
		this.ordComplete = ordComplete;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	
	public int getOrdDiscount() {
		return ordDiscount;
	}
	public void setOrdDiscount(int ordDiscount) {
		this.ordDiscount = ordDiscount;
	}
	
	public void setOrdDiscount(String ordDiscount) {
		this.ordDiscount = Integer.parseInt(ordDiscount);
	}

	public String getPriceWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(ordPrice);
	}
	
	public String getDeliveryWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(ordDelivery);
	}
	
	public String getUsedPointWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(usedPoint);
	}
	
	public String getOrdTotPriceWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(ordTotPrice);
	}
	
	public String getOrdDiscountWithComma() {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(ordDiscount);
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
	
	public int getTotalprice(int price, int discount, int delivery) {
		int Totalprice=0;
		
		return Totalprice=(int)(price-(price*(discount*0.01))+delivery);
	}
	
	public String getTotal(int price, int discount, int delivery) {
		
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(getTotalprice(price, discount,delivery));
	}
	
	public int getDiscountPrice2(int price, int discount) {
		int discountPrice=0;
		
		discountPrice=(int)(price*(discount*0.01));
		
		return discountPrice;
	}
	
	
	
}
