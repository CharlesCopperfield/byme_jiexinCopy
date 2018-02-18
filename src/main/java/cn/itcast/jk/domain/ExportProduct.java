package cn.itcast.jk.domain;
/** 
 * 报运货物
 * @author  Charles Copperfield 
 * @date 2017年12月28日 - 下午9:12:04    
 */
public class ExportProduct {
	private String  id;
	private String  exportId;
	private String  factoryId;
	private String  factoryName;
	/**货号*/
	private String  productNo;
	/**包装单位*/
	private String  packingUnit;
	/**数量*/
	private int cnumber;
	/**件数*/
	private int boxNum;
	/**毛重*/
	private double grossWeight;
	/**净重*/
	private double  netWeight;
	/**尺寸长*/
	private double  sizeLength;
	/**尺寸宽*/
	private double  sizeWidth;
	/**尺寸高*/
	private double  sizeHeight;
	/**出口单价*/
	private double  exPrice;
	/**单价*/
	private double  price;
	/**含税*/
	private double  tax;
	/**排序号*/
	private int orderNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExportId() {
		return exportId;
	}
	public void setExportId(String exportId) {
		this.exportId = exportId;
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
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public int getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(int boxNum) {
		this.boxNum = boxNum;
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
	public double getSizeLength() {
		return sizeLength;
	}
	public void setSizeLength(double sizeLength) {
		this.sizeLength = sizeLength;
	}
	public double getSizeWidth() {
		return sizeWidth;
	}
	public void setSizeWidth(double sizeWidth) {
		this.sizeWidth = sizeWidth;
	}
	public double getSizeHeight() {
		return sizeHeight;
	}
	public void setSizeHeight(double sizeHeight) {
		this.sizeHeight = sizeHeight;
	}
	public double getExPrice() {
		return exPrice;
	}
	public void setExPrice(double exPrice) {
		this.exPrice = exPrice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public ExportProduct(String id, String exportId, String factoryId, String factoryName, String productNo,
			String packingUnit, int cnumber, int boxNum, double grossWeight, double netWeight, double sizeLength,
			double sizeWidth, double sizeHeight, double exPrice, double price, double tax, int orderNo) {
		super();
		this.id = id;
		this.exportId = exportId;
		this.factoryId = factoryId;
		this.factoryName = factoryName;
		this.productNo = productNo;
		this.packingUnit = packingUnit;
		this.cnumber = cnumber;
		this.boxNum = boxNum;
		this.grossWeight = grossWeight;
		this.netWeight = netWeight;
		this.sizeLength = sizeLength;
		this.sizeWidth = sizeWidth;
		this.sizeHeight = sizeHeight;
		this.exPrice = exPrice;
		this.price = price;
		this.tax = tax;
		this.orderNo = orderNo;
	}
	public ExportProduct() {
		super();
	}
	@Override
	public String toString() {
		return "ExportProduct [id=" + id + ", exportId=" + exportId + ", factoryId=" + factoryId + ", factoryName="
				+ factoryName + ", productNo=" + productNo + ", packingUnit=" + packingUnit + ", cnumber=" + cnumber
				+ ", boxNum=" + boxNum + ", grossWeight=" + grossWeight + ", netWeight=" + netWeight + ", sizeLength="
				+ sizeLength + ", sizeWidth=" + sizeWidth + ", sizeHeight=" + sizeHeight + ", exPrice=" + exPrice
				+ ", price=" + price + ", tax=" + tax + ", orderNo=" + orderNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exportId == null) ? 0 : exportId.hashCode());
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
		ExportProduct other = (ExportProduct) obj;
		if (exportId == null) {
			if (other.exportId != null)
				return false;
		} else if (!exportId.equals(other.exportId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
