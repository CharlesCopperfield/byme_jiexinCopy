package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.itcast.jk.service.BaseService;

/** 
 * 业务层的默认实现,只能保证与数据库的交互结果,
 * 如果子类有业务需求,需要重写相应方法.
 * 另外需要将实际处理对象传入进来.
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 上午10:28:47    
 */

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private BaseService<T> baseService;
	protected BaseServiceImpl(BaseService<T> baseService) {
		this.baseService = baseService;
	}
	public void setBaseService(BaseService<T> baseService) {
		this.baseService = baseService;
	}
	
	
	
	@Override
	public List<T> findAll() {
		return baseService.findAll();
	}

	@Override
	public T findById(String id) {
		return baseService.findById(id);
	}

	@Override
	public int deleteById(String id) {
		return baseService.deleteById(id);
	}

	@Override
	public int deleteByIds(Serializable[] ids) {
		return baseService.deleteByIds(ids);
	}

	@Override
	public int insertOne(T entity) {
		return baseService.insertOne(entity);
	}

	@Override
	public int updateOne(T eneity) {
		return baseService.updateOne(eneity);
	}

}
