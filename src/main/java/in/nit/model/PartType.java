package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parttab")

public class PartType {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer partId;
	@Column(name="pcode")
	private String partCode;
	@Column(name="pwidth")
	private Double partWidth;
	@Column(name="plength")
	private Double partLength;
	@Column(name="pheight")
	private Double partHeight;
	@Column(name="pbcost")
	private Double partBaseCost;
	@Column(name="pbcurrency")
	private Double partBaseCurrency;

	@ManyToOne
	@JoinColumn(name="uomIdFk")
	private UomType uomOb;

	@ManyToOne
	@JoinColumn(name="orderIdFk")
	private OrderMethod omOb;

	@ManyToOne
	@JoinColumn(name="orderPurchaseIdFk")
	private OrderMethod omPurchaseOb;

	@Column(name="description")
	private String description;

	public PartType() {
		super();
	}

	public UomType getUomOb() {
		return uomOb;
	}

	public void setUomOb(UomType uomOb) {
		this.uomOb = uomOb;
	}

	public OrderMethod getOmOb() {
		return omOb;
	}

	public void setOmOb(OrderMethod omOb) {
		this.omOb = omOb;
	}

	public PartType(Integer partId) {
		super();
		this.partId = partId;
	}

	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public Double getPartWidth() {
		return partWidth;
	}

	public void setPartWidth(Double partWidth) {
		this.partWidth = partWidth;
	}

	public Double getPartLength() {
		return partLength;
	}

	public void setPartLength(Double partLength) {
		this.partLength = partLength;
	}

	public Double getPartHeight() {
		return partHeight;
	}

	public void setPartHeight(Double partHeight) {
		this.partHeight = partHeight;
	}

	public Double getPartBaseCost() {
		return partBaseCost;
	}

	public void setPartBaseCost(Double partBaseCost) {
		this.partBaseCost = partBaseCost;
	}

	public Double getPartBaseCurrency() {
		return partBaseCurrency;
	}

	public void setPartBaseCurrency(Double partBaseCurrency) {
		this.partBaseCurrency = partBaseCurrency;
	}


	public OrderMethod getOmPurchaseOb() {
		return omPurchaseOb;
	}

	public void setOmPurchaseOb(OrderMethod omPurchaseOb) {
		this.omPurchaseOb = omPurchaseOb;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PartType [partId=" + partId + ", partCode=" + partCode + ", partWidth=" + partWidth + ", partLength="
				+ partLength + ", partHeight=" + partHeight + ", partBaseCost=" + partBaseCost + ", partBaseCurrency="
				+ partBaseCurrency + ", uomOb=" + uomOb + ", omOb=" + omOb + ", omPurchaseOb=" + omPurchaseOb
				+ ", description=" + description + "]";
	}
}//class
