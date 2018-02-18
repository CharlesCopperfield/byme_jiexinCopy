package cn.itcast.jk.voCopy;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;

/** 
 * 合同货物.装率和箱数报运业务使用，合同业务不使用。
 * @author  Charles Copperfield 
 * @date 2017年12月28日 - 下午8:19:20    
 */
@Repository
public class ContractProductVO {
	
	private Contract contract;//将复杂的关联关系变成单表操作.
	private List<ExtCproductVO> extCproductVOs;//和附件一对多关系
	private Factory factory;//和生产厂家多对一关系
	
	
	
	
	
	
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<ExtCproductVO> getExtCproductVOs() {
		return extCproductVOs;
	}

	public void setExtCproductVOs(List<ExtCproductVO> extCproductVOs) {
		this.extCproductVOs = extCproductVOs;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	private String id;
	private String contractId;
	private String factoryId;
	private String factoryName;
	/**货号*/
	private String productNo;
	private String productImage;
	private String productDesc;
	/**数量*/
	private int cnumber;
	/**实际出货数量*/
	private int outNumber;
	/**装率*/
	private String loadingRate;
	/**箱数*/
	private int boxNum;
	/**包装单位*/
	private String packingUnit;
	/**单价*/
	private double price;
	/**总金额*/
	private double amount;
	/**是否出货完毕*/
	private int finished;
	/**附件*/
	private String exts;
	/**排序号*/
	private int orderNo;
	
	/**该货物合同下所有附件,表中无此字段,只在需要时赋值即可.*/
	private List<ExtCproductVO> extCproductList;
	
	public List<ExtCproductVO> getExtCproductList() {
		return extCproductList;
	}

	public void setExtCproductList(List<ExtCproductVO> extCproductList) {
		this.extCproductList = extCproductList;
	}

	public ContractProductVO() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public int getOutNumber() {
		return outNumber;
	}
	public void setOutNumber(int outNumber) {
		this.outNumber = outNumber;
	}
	public String getLoadingRate() {
		return loadingRate;
	}
	public void setLoadingRate(String loadingRate) {
		this.loadingRate = loadingRate;
	}
	public int getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(int boxNum) {
		this.boxNum = boxNum;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getFinished() {
		return finished;
	}
	public void setFinished(int finished) {
		this.finished = finished;
	}
	public String getExts() {
		return exts;
	}
	public void setExts(String exts) {
		this.exts = exts;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "ContractProduct [id=" + id + ", contractId=" + contractId + ", factoryId=" + factoryId
				+ ", factoryName=" + factoryName + ", productNo=" + productNo + ", productImage=" + productImage
				+ ", productDesc=" + productDesc + ", cnumber=" + cnumber + ", outNumber=" + outNumber
				+ ", loadingRate=" + loadingRate + ", boxNum=" + boxNum + ", packingUnit=" + packingUnit + ", price="
				+ price + ", amount=" + amount + ", finished=" + finished + ", exts=" + exts + ", orderNo=" + orderNo
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contractId == null) ? 0 : contractId.hashCode());
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
		ContractProductVO other = (ContractProductVO) obj;
		if (contractId == null) {
			if (other.contractId != null)
				return false;
		} else if (!contractId.equals(other.contractId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
