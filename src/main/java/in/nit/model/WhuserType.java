package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhuserType {
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer userId;
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	@Column(name="ufor")
	private String userFor;
	@Column(name="umail")
	private String userMail;
	@Column(name="ucontact")
	private String userContact;
	@Column(name="uidtype")
	private String userIdtype;
	@Column(name="ifoth")
	private String ifOther;
	@Column(name="uidnum")
	private String idNumber;
	@Column(name="note")
	private String note;


	//zero param Constructor
	public WhuserType() {
		super();
	}
	//parameterized constructor
	public WhuserType(Integer userId) {
		super();
		this.userId = userId;
	}
	//set and get methods
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserIdtype() {
		return userIdtype;
	}
	public void setUserIdtype(String userIdtype) {
		this.userIdtype = userIdtype;
	}
	public String getIfOther() {
		return ifOther;
	}
	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "WhuserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userMail=" + userMail + ", userContact=" + userContact + ", userIdtype=" + userIdtype
				+ ", ifOther=" + ifOther + ", idNumber=" + idNumber + ", note=" + note + "]";
	}



}//class
