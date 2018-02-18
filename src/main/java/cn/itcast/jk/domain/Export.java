package cn.itcast.jk.domain;

import java.util.Date;

/**
 * 报运单
 * 一个报运单由多个合同来 简化设计，不建立直接一对多关联。
 * 利用CONTRACT_IDS记录关联关系。打断设计，实现跳跃查询
 * @author Charles Copperfield
 * @date 2017年12月28日 - 下午8:57:38
 */
public class Export {
	
	private String id;
	/**制单日期*/
	private Date inputDate;
	/**合同编号集合*/
	private String contractIds;
	/**合同或确认书号*/
	private String customerContract;
	/**L/C NO*/
	private String lcno;
	/**收货人及地址*/
	private String consignee;
	/**唛头*/
	private String marks;
	/**备注*/
	private String remark;
	/**装运港*/
	private String shipmentPort;
	/**目的港*/
	private String destinationPort;
	/**运输方式*/
	private String transportMode;
	/**价格条件*/
	private String priceCondition;
	/**状态*/
	private int state;
	/**总毛重*/
	private double grossWeight;
	/**总净重*/
	private double netWeight;
	/**体积M3*/
	private double measurement;
	/**创建人*/
	private String createBy;
	/**创建部门*/
	private String createDept;
	/**创建日期*/
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public String getContractIds() {
		return contractIds;
	}
	public void setContractIds(String contractIds) {
		this.contractIds = contractIds;
	}
	public String getCustomerContract() {
		return customerContract;
	}
	public void setCustomerContract(String customerContract) {
		this.customerContract = customerContract;
	}
	public String getLcno() {
		return lcno;
	}
	public void setLcno(String lcno) {
		this.lcno = lcno;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getShipmentPort() {
		return shipmentPort;
	}
	public void setShipmentPort(String shipmentPort) {
		this.shipmentPort = shipmentPort;
	}
	public String getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getPriceCondition() {
		return priceCondition;
	}
	public void setPriceCondition(String priceCondition) {
		this.priceCondition = priceCondition;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public double getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}
	public double getMeasurement() {
		return measurement;
	}
	public void setMeasurement(double measurement) {
		this.measurement = measurement;
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
		return "Export [id=" + id + ", inputDate=" + inputDate + ", contractIds=" + contractIds + ", customerContract="
				+ customerContract + ", lcno=" + lcno + ", consignee=" + consignee + ", marks=" + marks + ", remark="
				+ remark + ", shipmentPort=" + shipmentPort + ", destinationPort=" + destinationPort
				+ ", transportMode=" + transportMode + ", priceCondition=" + priceCondition + ", state=" + state
				+ ", grossWeight=" + grossWeight + ", netWeight=" + netWeight + ", measurement=" + measurement
				+ ", createBy=" + createBy + ", createDept=" + createDept + ", createTime=" + createTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contractIds == null) ? 0 : contractIds.hashCode());
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
		Export other = (Export) obj;
		if (contractIds == null) {
			if (other.contractIds != null)
				return false;
		} else if (!contractIds.equals(other.contractIds))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Export(String id, Date inputDate, String contractIds, String customerContract, String lcno, String consignee,
			String marks, String remark, String shipmentPort, String destinationPort, String transportMode,
			String priceCondition, int state, double grossWeight, double netWeight, double measurement, String createBy,
			String createDept, Date createTime) {
		super();
		this.id = id;
		this.inputDate = inputDate;
		this.contractIds = contractIds;
		this.customerContract = customerContract;
		this.lcno = lcno;
		this.consignee = consignee;
		this.marks = marks;
		this.remark = remark;
		this.shipmentPort = shipmentPort;
		this.destinationPort = destinationPort;
		this.transportMode = transportMode;
		this.priceCondition = priceCondition;
		this.state = state;
		this.grossWeight = grossWeight;
		this.netWeight = netWeight;
		this.measurement = measurement;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
	}
	public Export() {
		super();
	}
	
	

}
