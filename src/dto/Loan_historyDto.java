package dto;

import java.sql.Date;

public class Loan_historyDto {

	private int loanhistoryid; //貸出履歴ID

	private String loanbookid; //貸出図書ID

	private String loanuserid; //貸出ユーザーID

	private Date loanday; //貸出日時

	private Date returnday; //返却日時

	public Loan_historyDto(int loanhistoryid, String loanbookid, String loanuserid, Date loanday, Date returnday) {

		super();

		this.loanhistoryid = loanhistoryid;

		this.loanbookid = loanbookid;

		this.loanuserid = loanuserid;

		this.loanday = loanday;

		this.returnday = returnday;

	}

	public int getLoanhistoryid() {
		return loanhistoryid;
	}

	public void setLoanhistoryid(int loanhistoryid) {
		this.loanhistoryid = loanhistoryid;
	}

	public String getLoanbookid() {
		return loanbookid;
	}

	public void setLoanbookid(String loanbookid) {
		this.loanbookid = loanbookid;
	}

	public String getLoanuserid() {
		return loanuserid;
	}

	public void setLoanuserid(String loanuserid) {
		this.loanuserid = loanuserid;
	}

	public Date getLoanday() {
		return loanday;
	}

	public void setLoanday(Date loanday) {
		this.loanday = loanday;
	}

	public Date getReturnday() {
		return returnday;
	}

	public void setReturnday(Date returnday) {
		this.returnday = returnday;
	}



}
