package cn.itcast.jk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.domain.Factory;

/** 
 * 生产厂家的dao层.
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午8:01:05    
 */
@Repository
public interface FactoryDao extends BaseDao<Factory>{

	/**修改工厂的state(状态:0停用;1启用)*/
	int changeState(Map<String, Object> changeStateMap);

	/**查询所有厂家名称*/
	List<String> findAllName();
	

}
