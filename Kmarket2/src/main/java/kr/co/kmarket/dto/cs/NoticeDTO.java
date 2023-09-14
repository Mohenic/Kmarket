package kr.co.kmarket.dto.cs;

public class NoticeDTO {
	
	private int noticeNo;
	private String cate;
	private String title;
	private String content;
	private String rdate;
	
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", cate=" + cate + ", title=" + title + ", content=" + content
				+ ", rdate=" + rdate + "]";
	}
	
	

}
