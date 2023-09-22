package kr.co.kmarket.dto.member;

public class MemberPointDTO {
	
	private int pointNo;
	private String uid;
	private int ordNo;
	private int point;
	private String pointDate;
	public int getPointNo() {
		return pointNo;
	}
	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}
	
	public void setPointNo(String pointNo) {
		this.pointNo = Integer.parseInt(pointNo);
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	public void setPoint(String point) {
		this.point = Integer.parseInt(point);
	}
	
	public String getPointDate() {
		return pointDate;
	}
	
	public void setPointDate(String pointDate) {
		this.pointDate = pointDate;
	}
	
	
	
}
