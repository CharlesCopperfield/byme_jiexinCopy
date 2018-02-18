package cn.itcast.jk.domain;

import java.util.Date;

/** 
 * 装箱单
 * 选择多个报运建立一个装箱
 * @author  Charles Copperfield 
 * @date 2017年12月28日 - 下午9:35:33    
 */
public class PackingList {
	
	private String id;
	/**卖方*/
	private String seller;
	/**买方*/
	private String buyer;
	/**发票号*/
	private String invoiceNo;
	/**发票日期*/
	private Date invoiceDate;
	/**唛头*/
	private String marks;
	/**描述*/
	private String descriptions;
	private String  exportIds;
	private String  exportNos;
	/**状态*/
	private int state;
	/**创建人*/
	private String  createBy;
	/**创建部门*/
	private String  createDept;
	/**创建日期*/
	private String  createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getExportIds() {
		return exportIds;
	}
	public void setExportIds(String exportIds) {
		this.exportIds = exportIds;
	}
	public String getExportNos() {
		return exportNos;
	}
	public void setExportNos(String exportNos) {
		this.exportNos = exportNos;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public PackingList(String id, String seller, String buyer, String invoiceNo, Date invoiceDate, String marks,
			String descriptions, String exportIds, String exportNos, int state, String createBy, String createDept,
			String createTime) {
		super();
		this.id = id;
		this.seller = seller;
		this.buyer = buyer;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.marks = marks;
		this.descriptions = descriptions;
		this.exportIds = exportIds;
		this.exportNos = exportNos;
		this.state = state;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
	}
	public PackingList() {
		super();
	}
	@Override
	public String toString() {
		return "PackingList [id=" + id + ", seller=" + seller + ", buyer=" + buyer + ", invoiceNo=" + invoiceNo
				+ ", invoiceDate=" + invoiceDate + ", marks=" + marks + ", descriptions=" + descriptions
				+ ", exportIds=" + exportIds + ", exportNos=" + exportNos + ", state=" + state + ", createBy="
				+ createBy + ", createDept=" + createDept + ", createTime=" + createTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceNo == null) ? 0 : invoiceNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackingList other = (PackingList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoiceNo == null) {
			if (other.invoiceNo != null)
				return false;
		} else if (!invoiceNo.equals(other.invoiceNo))
			return false;
		return true;
	}
	
	
	
	

}
