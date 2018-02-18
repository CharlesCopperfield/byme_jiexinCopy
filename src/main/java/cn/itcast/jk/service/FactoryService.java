package cn.itcast.jk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.Factory;

/** 
 * 工厂业务层
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 上午10:20:28    
 */
@Service
public interface FactoryService extends BaseService<Factory>{


	/**停用*/
	int stopStateByIds(String[] ids);

	/**启用*/
	int startStateByIds(String[] ids);
	
	/**查询所有厂家名称*/
	List<String> findAllName();
	

}
