package cn.itcast.jk.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

/** 
 * 购销合同
 * @author  Charles Copperfield 
 * @date 2017年12月28日 - 下午7:51:32    
 */
@Repository
public class Contract {
	/**草稿状态*/
	public static final int STATE_DRAFT = 0;
	/**已上报状态*/
	public static final int STATE_REPORTED = 1;
	
	/**打印版式:一款*/
	public static final int PRINTSTYLE_ONE = 1;
	/**打印版式:二款*/
	public static final int PRINTSTYLE_TWO = 2;
	
	private String id;
	/**收购方*/
	private String offeror;
	/**合同号*/
	private String contractNo;
	/**签单日期*/
	private Date signingDate;
	/**制单人*/
	private String inputBy;
	/**审单人*/
	private String checkBy;
	/**验货员*/
	private String inspector;
	/**总金额*/
	private double totalAmount;
	/**重要程度*/
	private int importNum;
	/**要求*/
	private String crequest;
	/**客户名称*/
	private String customName;
	/**交货期限*/
	private Date deliveryPeriod;
	/**船期*/
	private Date shipTime;
	/**贸易条款*/
	private String tradeTerms;
	/**说明*/
	private String remark;
	/**打印版式*/
	private String printStyle;
	/**归档前状态*/
	private int oldState;
	/**状态*/
	private int state;
	/**走货状态*/
	private int outState;
	/**创建人*/
	private String createBy;
	/**创建部门*/
	private String createDept;
	/**创建日期*/
	private Date createTime;
	
	/**货物数,表中无此字段,业务需要*/
	private int contractProductNum;
	/**附件数,表中无此字段,业务需要*/
	private int extCproductNum;
	
	
	public int getContractProductNum() {
		return contractProductNum;
	}
	public void setContractProductNum(int contractProductNum) {
		this.contractProductNum = contractProductNum;
	}
	public int getExtCproductNum() {
		return extCproductNum;
	}
	public void setExtCproductNum(int extCproductNum) {
		this.extCproductNum = extCproductNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOfferor() {
		return offeror;
	}
	public void setOfferor(String offeror) {
		this.offeror = offeror;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getSigningDate() {
		return signingDate;
	}
	public void setSigningDate(Date signingDate) {
		this.signingDate = signingDate;
	}
	public String getInputBy() {
		return inputBy;
	}
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}
	public String getCheckBy() {
		return checkBy;
	}
	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getImportNum() {
		return importNum;
	}
	public void setImportNum(int importNum) {
		this.importNum = importNum;
	}
	public String getCrequest() {
		return crequest;
	}
	public void setCrequest(String crequest) {
		this.crequest = crequest;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public Date getDeliveryPeriod() {
		return deliveryPeriod;
	}
	public void setDeliveryPeriod(Date deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}
	public Date getShipTime() {
		return shipTime;
	}
	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}
	public String getTradeTerms() {
		return tradeTerms;
	}
	public void setTradeTerms(String tradeTerms) {
		this.tradeTerms = tradeTerms;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPrintStyle() {
		return printStyle;
	}
	public void setPrintStyle(String printStyle) {
		this.printStyle = printStyle;
	}
	public int getOldState() {
		return oldState;
	}
	public void setOldState(int oldState) {
		this.oldState = oldState;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOutState() {
		return outState;
	}
	public void setOutState(int outState) {
		this.outState = outState;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Contract [id=" + id + ", offeror=" + offeror + ", contractNo=" + contractNo + ", signingDate="
				+ signingDate + ", inputBy=" + inputBy + ", checkBy=" + checkBy + ", inspector=" + inspector
				+ ", totalAmount=" + totalAmount + ", importNum=" + importNum + ", crequest=" + crequest
				+ ", customName=" + customName + ", deliveryPeriod=" + deliveryPeriod + ", shipTime=" + shipTime
				+ ", tradeTerms=" + tradeTerms + ", remark=" + remark + ", printStyle=" + printStyle + ", oldState="
				+ oldState + ", state=" + state + ", outState=" + outState + ", createBy=" + createBy + ", createDept="
				+ createDept + ", createTime=" + createTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contractNo == null) ? 0 : contractNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Contract other = (Contract) obj;
		if (contractNo == null) {
			if (other.contractNo != null)
				return false;
		} else if (!contractNo.equals(other.contractNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Contract(String id, String offeror, String contractNo, Date signingDate, String inputBy, String checkBy,
			String inspector, double totalAmount, int importNum, String crequest, String customName,
			Date deliveryPeriod, Date shipTime, String tradeTerms, String remark, String printStyle, int oldState,
			int state, int outState, String createBy, String createDept, Date createTime) {
		super();
		this.id = id;
		this.offeror = offeror;
		this.contractNo = contractNo;
		this.signingDate = signingDate;
		this.inputBy = inputBy;
		this.checkBy = checkBy;
		this.inspector = inspector;
		this.totalAmount = totalAmount;
		this.importNum = importNum;
		this.crequest = crequest;
		this.customName = customName;
		this.deliveryPeriod = deliveryPeriod;
		this.shipTime = shipTime;
		this.tradeTerms = tradeTerms;
		this.remark = remark;
		this.printStyle = printStyle;
		this.oldState = oldState;
		this.state = state;
		this.outState = outState;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
	}
	public Contract() {
		super();
	}
	
	
	
	
	
	

}
