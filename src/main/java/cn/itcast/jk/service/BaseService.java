package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 上午10:21:59    
 */
public interface BaseService<T> {

	/**查找所有T*/
	List<T> findAll();
	
	/**查找指定id的T*/
	T findById(String id);
	
	/**删除指定id的T*/
	int deleteById(String id);
	
	/**批量删除ids*/
	int deleteByIds(Serializable[] ids);
	
	/**增加一个T*/
	int insertOne(T entity);
	
	/**修改指定T*/
	int updateOne(T eneity);
	
}
