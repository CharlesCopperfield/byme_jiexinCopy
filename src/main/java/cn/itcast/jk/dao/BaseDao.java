package cn.itcast.jk.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/** 
 * 所有dao层接口的父接口.封装基本的增删改查功能.
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午7:39:52    
 */
@Repository
public interface BaseDao<T> {
	
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
