package dto;

import java.sql.Date;

public class USER_DateDto {

	private String userid; //ユーザーID

	private String loginpw; //ログインPW

	private String name; //名前

	private int age; //年齢

	private String streetaddress; //住所

	private Date recordday; //登録日時

	private Date resetday; //更新日時

	public USER_DateDto(String userid, String loginpw, String name, int age, String streetaddress, Date recordday,
			Date resetday) {

		super();

		this.userid = userid;

		this.loginpw = loginpw;

		this.name = name;

		this.age = age;

		this.streetaddress = streetaddress;

		this.recordday = recordday;

		this.resetday = resetday;

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLoginpw() {
		return loginpw;
	}

	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
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



}
