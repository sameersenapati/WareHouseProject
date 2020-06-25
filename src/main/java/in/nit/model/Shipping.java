package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipingtab")
public class Shipping {
	@Id
	@Column(name="shipngid")
	@GeneratedValue
	private Integer shippingId;
	@Column(name="shipngcode")
	private String shippingCode;
	@Column(name="shipngrnum")
	private String shippingRefNum;
	@Column(name="crefnum")
	private String courierRefNum;
	@Column(name="condet")
	private String contactDetails;
	@Column(name="socode")
	private String saleOrderCode;
	@Column(name="shipngdesc")
	private String description;
	@Column(name="btoadd")
	private String billToAddress;
	@Column(name="shiptoadd")
	private String shipToAddress;

	public Shipping() {
		super();
	}

	public Shipping(Integer shippingId) {
		super();
		this.shippingId = shippingId;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getShippingRefNum() {
		return shippingRefNum;
	}

	public void setShippingRefNum(String shippingRefNum) {
		this.shippingRefNum = shippingRefNum;
	}

	public String getCourierRefNum() {
		return courierRefNum;
	}

	public void setCourierRefNum(String courierRefNum) {
		this.courierRefNum = courierRefNum;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getSaleOrderCode() {
		return saleOrderCode;
	}

	public void setSaleOrderCode(String saleOrderCode) {
		this.saleOrderCode = saleOrderCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBillToAddress() {
		return billToAddress;
	}

	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}

	public String getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", shippingCode=" + shippingCode + ", shippingRefNum="
				+ shippingRefNum + ", courierRefNum=" + courierRefNum + ", contactDetails=" + contactDetails
				+ ", saleOrderCode=" + saleOrderCode + ", description=" + description + ", billToAddress="
				+ billToAddress + ", shipToAddress=" + shipToAddress + "]";
	}

}
