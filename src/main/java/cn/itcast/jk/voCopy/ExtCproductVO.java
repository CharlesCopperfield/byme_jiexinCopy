package cn.itcast.jk.voCopy;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;

/** 
 * 合同附件.
 * 附件和货物的不同：多了附件类型和要求；同时货物从属合同，附件从属货物。
 * @author  Charles Copperfield 
 * @date 2017年12月28日 - 下午8:45:29    
 */
@Repository
public class ExtCproductVO {
	
	private ContractProduct contractProduct;
	private Factory factory;//和厂家一对多关系
	
	
	
	
	
	
	
	
	
	
	public ContractProduct getContractProduct() {
		return contractProduct;
	}
	public void setContractProduct(ContractProduct contractProduct) {
		this.contractProduct = contractProduct;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	private String id;
	private String contractProductId;
	private String factoryId;
	private String factoryName;
	/**类型*/
	private int ctype;
	/**货号*/
	private String productNo;
	private String productImage;
	private String productDesc;
	/**数量*/
	private int cnumber;
	/**包装单位*/
	private String packingUnit;
	/**单价*/
	private double price;
	
	/**总金额*/
	private double amount;
	/**要求*/
	private String productRequest;
	/**排序号*/
	private int orderNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContractProductId() {
		return contractProductId;
	}
	public void setContractProductId(String contractProductId) {
		this.contractProductId = contractProductId;
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
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
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
	public String getProductRequest() {
		return productRequest;
	}
	public void setProductRequest(String productRequest) {
		this.productRequest = productRequest;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "ExtCproduct [id=" + id + ", contractProductId=" + contractProductId + ", factoryId=" + factoryId
				+ ", factoryName=" + factoryName + ", ctype=" + ctype + ", productNo=" + productNo + ", productImage="
				+ productImage + ", productDesc=" + productDesc + ", cnumber=" + cnumber + ", packingUnit="
				+ packingUnit + ", price=" + price + ", amount=" + amount + ", productRequest=" + productRequest
				+ ", orderNo=" + orderNo + "]";
	}
	public ExtCproductVO(String id, String contractProductId, String factoryId, String factoryName, int ctype,
			String productNo, String productImage, String productDesc, int cnumber, String packingUnit, double price,
			double amount, String productRequest, int orderNo) {
		super();
		this.id = id;
		this.contractProductId = contractProductId;
		this.factoryId = factoryId;
		this.factoryName = factoryName;
		this.ctype = ctype;
		this.productNo = productNo;
		this.productImage = productImage;
		this.productDesc = productDesc;
		this.cnumber = cnumber;
		this.packingUnit = packingUnit;
		this.price = price;
		this.amount = amount;
		this.productRequest = productRequest;
		this.orderNo = orderNo;
	}
	public ExtCproductVO() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
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
		ExtCproductVO other = (ExtCproductVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productNo == null) {
			if (other.productNo != null)
				return false;
		} else if (!productNo.equals(other.productNo))
			return false;
		return true;
	}
	
	

}
