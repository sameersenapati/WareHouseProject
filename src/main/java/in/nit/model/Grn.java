package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grntab")
public class Grn {
	@Id
	@Column(name = "gid")
	@GeneratedValue
	private Integer grnId; 
	@Column(name = "gcode")
	private String grnCode;
	@Column(name = "gtype")
	private String grnType;
	@Column(name = "gdescr")
	private String description;
    //Integrations
	@ManyToOne
	@JoinColumn(name = "poIdFk",unique = true)
	private PurchaseOrderType po;
	
	public Grn() {
		super();
	}

	public Grn(Integer grnId) {
		super();
		this.grnId = grnId;
	}

	public Integer getGrnId() {
		return grnId;
	}

	public void setGrnId(Integer grnId) {
		this.grnId = grnId;
	}

	public String getGrnCode() {
		return grnCode;
	}

	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}

	public String getGrnType() {
		return grnType;
	}

	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PurchaseOrderType getPo() {
		return po;
	}

	public void setPo(PurchaseOrderType po) {
		this.po = po;
	}

	@Override
	public String toString() {
		return "Grn [grnId=" + grnId + ", grnCode=" + grnCode + ", grnType=" + grnType + ", description=" + description
				+ ", po=" + po + "]";
	}
	
}//class
