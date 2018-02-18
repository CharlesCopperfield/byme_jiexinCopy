package cn.itcast.jk.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/** 
 * 打印vo
 * @author  Charles Copperfield 
 * @date 2018年1月3日 - 下午4:42:08    
 */
@Repository
public class OutProductVO implements Serializable {
	private static final long serialVersionUID = -856264461523979451L;
	//contract's fields
	private String customName;//客户名称
	private String contractNo;//订单号
	private Date deliveryPeriod;//工厂交期
	private	Date shipTime;//船期
	private String tradeTerms;//贸易条款
	private Date signingDate;//签单日期 
	
	//contractProduct's fields
	private String productNo;//货号
	private int cnumber;//数量
	private String factoryName;//工厂
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	@Override
	public String toString() {
		return "OutProductVO [customName=" + customName + ", contractNo=" + contractNo + ", deliveryPeriod="
				+ deliveryPeriod + ", shipTime=" + shipTime + ", tradeTerms=" + tradeTerms + ", productNo=" + productNo
				+ ", cnumber=" + cnumber + ", factoryName=" + factoryName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contractNo == null) ? 0 : contractNo.hashCode());
		result = prime * result + ((customName == null) ? 0 : customName.hashCode());
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
		OutProductVO other = (OutProductVO) obj;
		if (contractNo == null) {
			if (other.contractNo != null)
				return false;
		} else if (!contractNo.equals(other.contractNo))
			return false;
		if (customName == null) {
			if (other.customName != null)
				return false;
		} else if (!customName.equals(other.customName))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
