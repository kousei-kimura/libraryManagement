package dto;

import java.sql.Date;

public class Book_InformationDto {

	private String bookid; //図書ID

	private String bookname; //図書名

	private String author; //著者

	private String publisher; //出版社

	private int isbnid; //ISBN番号

	private Date recordday; //登録日時

	private Date resetday; //更新日時

	private String loanstate; //貸出フラグ(状況)

	public Book_InformationDto(String bookid, String bookname, String author, String publisher, int isbnid,
			Date recordday, Date resetday, String loanstate) {

		super();

		this.bookid = bookid;

		this.bookname = bookname;

		this.author = author;

		this.publisher = publisher;

		this.isbnid = isbnid;

		this.recordday = recordday;

		this.resetday = resetday;

		this.loanstate = loanstate;

	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIsbnid() {
		return isbnid;
	}

	public void setIsbnid(int isbnid) {
		this.isbnid = isbnid;
	}

	public Date getRecordday() {
		return recordday;
	}

	public void setRecordday(Date recordday) {
		this.recordday = recordday;
	}

	public Date getResetday() {
		return resetday;
	}

	public void setResetday(Date resetday) {
		this.resetday = resetday;
	}

	public String getLoanstate() {
		return loanstate;
	}

	public void setLoanstate(String loanstate) {
		this.loanstate = loanstate;
	}

}
