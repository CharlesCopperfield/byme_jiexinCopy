package cn.itcast.jk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.domain.ExtCproduct;

/** 
 * 合同附件.
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 上午11:55:52    
 */
@Repository
public interface ExtCproductDao extends BaseDao<ExtCproduct>{

	/**查询指定合同货物下的所有附件*/
	List<ExtCproduct> findAllByContractProductId(String contractProductId);

}
