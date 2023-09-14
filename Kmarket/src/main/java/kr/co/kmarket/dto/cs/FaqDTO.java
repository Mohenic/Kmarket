package kr.co.kmarket.dto.cs;

public class FaqDTO {
	
	private int faqNo;
	private String cate1;
	private String cate2;
	private String title;
	private String content;
	private String writer;
	private String regip;
	private String rdate;
	
	public FaqDTO() {

	}

	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = Integer.parseInt(faqNo);
	}
	public String getCate1() {
		return cate1;
	}
	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}
	public String getCate2() {
		return cate2;
	}
	public void setCate2(String cate2) {
		this.cate2 = cate2;
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
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}


	@Override
	public String toString() {
		return "FaqDTO [faqNo=" + faqNo + ", cate1=" + cate1 + ", cate2=" + cate2 + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", regip=" + regip + ", rdate=" + rdate + "]";
	}
	

	
	

}
