package cn.itcast.jk.service;

import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.BaseService;
import cn.itcast.jk.vo.ContractVO;

/** 
 * 合同业务处理接口
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 下午3:03:46    
 */
@Service
public interface ContractService extends BaseService<Contract> {

	/**上报合同*/
	int reportContractById(String id);
	
	/**取消合同上报*/
	int cancelContractReportById(String id);
	
	/**修改合同的总金额,每次执行增加货物合同,附件时都要执行.*/
	int updateTotalAmount(Contract contract);

	/**获取指定合同下的contractVO*/
	ContractVO view(String contractId);

}
