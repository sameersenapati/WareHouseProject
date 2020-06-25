package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saletab")
public class SaleOrder {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer id;
	@Column(name="ocode")
	private String orderCode;
	@Column(name="refnum")
	private Double refNumber;
	@Column(name="smode")
	private String stockMode;
	@Column(name="ssource")
	private String stockSource;
	@Column(name="ostatus")
	private String status;
	@Column(name="sdescrip")
	private String description;
	public SaleOrder() {
		super();
	}
	public SaleOrder(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Double getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(Double refNumber) {
		this.refNumber = refNumber;
	}
	public String getStockMode() {
		return stockMode;
	}
	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}

	public String getStockSource() {
		return stockSource;
	}
	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SaleOrder [id=" + id + ", orderCode=" + orderCode + ", refNumber=" + refNumber + ", stockMode="
				+ stockMode + ", stockSource=" + stockSource + ", status=" + status + ", description=" + description
				+ "]";
	}
}
