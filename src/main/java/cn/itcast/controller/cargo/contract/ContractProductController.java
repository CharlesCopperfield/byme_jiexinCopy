package cn.itcast.controller.cargo.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;
import com.sun.org.apache.xpath.internal.operations.Mod;

import cn.itcast.controller.BaseController;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.FactoryService;

/** 
 * 合同货物控制器
 * @author  Charles Copperfield 
 * @date 2018年1月2日 - 上午8:09:04    
 */
@Controller
@RequestMapping("cargo/contractproduct")
public class ContractProductController extends BaseController {
	
	@Autowired
	private ContractProductService contractProductService;
	@Autowired
	private FactoryService factoryService;
	
	/**合同货物新增页面.*/
	@RequestMapping("tocreate.action")
	public String tocreateAction(String contractId, Model model) {
		model.addAttribute("contractId",contractId);
		List<ContractProduct> dataList = contractProductService.findAllByContractId(contractId);
		model.addAttribute("dataList", dataList);
		List<Factory> factoryList = factoryService.findAll();
		model.addAttribute("factoryList", factoryList);
		return "cargo/contract/ContractProductCreate.jsp";
	}
	
	/**新增合同货物操作*/
	@RequestMapping("insert.action")
	public String insertAction(ContractProduct contractProduct,String factoryInfo) {
		String[] factoryIdAndName = factoryInfo.split("@");//在jsp页面传递过来的是${factory.id }@${factory.factoryName}
		contractProduct.setFactoryId(factoryIdAndName[0]);//设置factoryId属性
		contractProduct.setFactoryName(factoryIdAndName[1]);//设置factoryName属性.做这些都是为了避免访问数据库.
		contractProductService.insertOne(contractProduct);
		return "redirect:tocreate.action?contractId="+contractProduct.getContractId();//重定向并传入contractId参数.
	}
	
	
	/**前往修改合同货物页面*/
	@RequestMapping("toupdate.action")
	public String toupdateAction(String id,Model model) {
		ContractProduct contractProduct = contractProductService.findById(id);
		model.addAttribute("obj", contractProduct);
		List<Factory> factoryList = factoryService.findAll();
		model.addAttribute("factoryList", factoryList);
		return "cargo/contract/ContractProductUpdate.jsp";
	}
	
	
	/**修改合同信息*/
	@RequestMapping("update.action")
	public String updateAction(ContractProduct contractProduct, String factoryInfo) {
		String[] factoryIdAndName = factoryInfo.split("@");//在jsp页面传递过来的是${factory.id }@${factory.factoryName}
		contractProduct.setFactoryId(factoryIdAndName[0]);//设置factoryId属性
		contractProduct.setFactoryName(factoryIdAndName[1]);//设置factoryName属性.做这些都是为了避免访问数据库.
		contractProductService.updateOne(contractProduct);
		return "redirect:tocreate.action?contractId="+contractProduct.getContractId();//重定向并传入contractId参数.
	}
	
	/**删除货物合同*/
	@RequestMapping("delete.action")
	public String deleteAction(String id, String contractId) {
		contractProductService.deleteById(id);
		
		return "redirect:tocreate.action?contractId="+contractId;
	}
	
	
	
	
	
	
	
	
	
	

}
