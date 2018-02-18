package cn.itcast.jk.domain;

import java.util.Date;

import org.springframework.stereotype.Repository;

/** 
 * 生产厂家.
 * @author  Charles Copperfield 
 * @date 2017年12月28日 - 下午6:48:26    
 */
@Repository
public class Factory {
	
	
	
	private String id;
	private String fullName;
	private String factoryName;
	private String contacts;
	private String phone;
	private String mobile;
	private String fax;
	private String cnote;
	private String inspector;
	/**状态*/
	private int state;
	/**停用状态*/
	public static final int STATE_STOP = 0;
	/**启用状态*/
	public static final int STATE_START = 1;
	
	private int orderNo;
	private String createBy;
	private String createDept;
	
	private Date createTime;
	
	public Factory() {
		super();
	}
	
	public Factory(String id, String fullName, String factoryName, String contacts, String phone, String mobile,
			String fax, String cnote, String inspector, int state, int orderNo, String createBy, String createDept,
			Date createTime) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.factoryName = factoryName;
		this.contacts = contacts;
		this.phone = phone;
		this.mobile = mobile;
		this.fax = fax;
		this.cnote = cnote;
		this.inspector = inspector;
		this.state = state;
		this.orderNo = orderNo;
		this.createBy = createBy;
		this.createDept = createDept;
		this.createTime = createTime;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCnote() {
		return cnote;
	}

	public void setCnote(String cnote) {
		this.cnote = cnote;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
		return "Factory [id=" + id + ", fullName=" + fullName + ", factoryName=" + factoryName + ", contacts="
				+ contacts + ", phone=" + phone + ", mobile=" + mobile + ", fax=" + fax + ", cnote=" + cnote
				+ ", inspector=" + inspector + ", state=" + state + ", orderNo=" + orderNo + ", createBy=" + createBy
				+ ", createDept=" + createDept + ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
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
		Factory other = (Factory) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
