package cn.itcast.jk.domain;

/**
 * 报运附件
 * 直接复制合同附件表，整表冗余；
 * 加速后续业务读取数据 设计简单，方便适应需求变化
 * @author Charles Copperfield
 * @date 2017年12月28日 - 下午9:22:02
 */
public class ExtEproduct {
	private String id;
	private String exportProductId;
	private String factoryId;
	private String factoryName;
	/**类型*/
	private int ctype;
	/**货号*/
	private String productNo;
	/**货物照片*/
	private String productImage;
	/**货物描述*/
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
	public String getExportProductId() {
		return exportProductId;
	}
	public void setExportProductId(String exportProductId) {
		this.exportProductId = exportProductId;
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
	public ExtEproduct(String id, String exportProductId, String factoryId, String factoryName, int ctype,
			String productNo, String productImage, String productDesc, int cnumber, String packingUnit, double price,
			double amount, String productRequest, int orderNo) {
		super();
		this.id = id;
		this.exportProductId = exportProductId;
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
	public ExtEproduct() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exportProductId == null) ? 0 : exportProductId.hashCode());
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
		ExtEproduct other = (ExtEproduct) obj;
		if (exportProductId == null) {
			if (other.exportProductId != null)
				return false;
		} else if (!exportProductId.equals(other.exportProductId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExtEproduct [id=" + id + ", exportProductId=" + exportProductId + ", factoryId=" + factoryId
				+ ", factoryName=" + factoryName + ", ctype=" + ctype + ", productNo=" + productNo + ", productImage="
				+ productImage + ", productDesc=" + productDesc + ", cnumber=" + cnumber + ", packingUnit="
				+ packingUnit + ", price=" + price + ", amount=" + amount + ", productRequest=" + productRequest
				+ ", orderNo=" + orderNo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
