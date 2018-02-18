package cn.itcast.jk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.ExtCproduct;

/** 
 * 合同货物附件业务层接口.
 * @author  Charles Copperfield 
 * @date 2018年1月2日 - 下午8:05:47    
 */
@Service
public interface ExtCproductService extends BaseService<ExtCproduct>{
	
	/**查询指定合同货物下的所有附件*/
	List<ExtCproduct> findAllByContractProductId(String contractProductId);

}
