package kr.co.kmarket.dto.cs;

public class QnaDTO {
	
	private int qnaNo;
	private int parent;
	private int comment;
	private String cate;
	private String type;
	private String title;
	private String content;
	private String writer;
	private String regip;
	private String rdate;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	
	public void setQnaNo(String qnaNo) {
		this.qnaNo = Integer.parseInt(qnaNo);
	}
	
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public void setRdateYYMMDD(String rdate) {
		this.rdate = rdate.substring(2, 10);
	}
	
	public String maskWriter(String writer) {
        if (writer!= null && writer.length() > 2) {
            String maskedUserId = writer.substring(0, 2) + "**";
            return maskedUserId;
        }
        return writer;
    }
	
	
	@Override
	public String toString() {
		return "QnaDTO [qnaNo=" + qnaNo + ", parent=" + parent + ", comment=" + comment + ", cate=" + cate + ", type="
				+ type + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regip=" + regip
				+ ", rdate=" + rdate + "]";
	}
	
	
	
	

}
