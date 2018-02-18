package cn.itcast.controller.cargo.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.controller.BaseController;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.service.FactoryService;

/** 
 * 合同货物附件
 * @author  Charles Copperfield 
 * @date 2018年1月2日 - 下午8:00:39    
 */
@Controller
@RequestMapping("cargo/extCproduct")
public class ExtCproductController extends BaseController {
	
	@Autowired
	private ExtCproductService extCproductService;
	@Autowired
	private FactoryService factoryService;
	@Autowired
	private ContractProductService contractProductService;
	
	/**合同货物附件清单页*/
	@RequestMapping("tocreate.action")
	public String tocreateAction(String contractProductId,String contractId, Model model) {
		model.addAttribute("contractProductId", contractProductId);
		if (contractId==null) {
			contractId = contractProductService.findById(contractProductId).getContractId();
		}
		model.addAttribute("contractId", contractId);//返回时用.
		List<ExtCproduct> dataList = extCproductService.findAllByContractProductId(contractProductId);
		model.addAttribute("dataList", dataList);//展示附件列表用
		
		List<Factory> factoryList = factoryService.findAll();
		model.addAttribute("factoryList", factoryList);//展示厂家名称下拉框用
		
		return "cargo/contract/ExtCproductCreate.jsp";
	}
	
	/**新增附件*/
	@RequestMapping("insert.action")
	public String insertAction(ExtCproduct extCproduct, String factoryInfo) {
		String[] factoryIdAndName = factoryInfo.split("@");
		extCproduct.setFactoryId(factoryIdAndName[0]);
		extCproduct.setFactoryName(factoryIdAndName[1]);//设置factoryId和factoryName
		
		extCproductService.insertOne(extCproduct);
		
		return "redirect:tocreate.action?contractProductId="+extCproduct.getContractProductId();


	}
	
	/**前往修改页面*/
	@RequestMapping("toupdate.action")
	public String toupdateAction(String id, String contractId, Model model) {
		model.addAttribute("contractId", contractId);
		ExtCproduct extCproduct = extCproductService.findById(id);
		model.addAttribute("obj", extCproduct);//展示选中的附件数据
		
		List<Factory> factoryList = factoryService.findAll();
		model.addAttribute("factoryList", factoryList);//展示厂家名称下拉框用
		
		return "cargo/contract/ExtCproductUpdate.jsp";
	}
	
	/**修改附件信息*/
	@RequestMapping("update.action")
	public String updateAction(ExtCproduct extCproduct) {
		extCproductService.updateOne(extCproduct);
		return "redirect:tocreate.action?contractProductId="+extCproduct.getContractProductId();
	}
	
	/**删除附件*/
	@RequestMapping("delete.action")
	public String deleteAction(String id, String contractProductId) {
		extCproductService.deleteById(id);
		return "redirect:tocreate.action?contractProductId="+contractProductId;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
