package cn.itcast.controller.cargo.contract;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.controller.BaseController;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.print.ContractPrint;
import cn.itcast.jk.print.ContractPrintTemplate;
import cn.itcast.jk.print.ContractPrintTemplateByMe;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.vo.ContractVO;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 下午2:44:29    
 */
@Controller
@RequestMapping("cargo/contract")
public class ContractController extends BaseController {
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private ContractProductService contractProductService;
	@Autowired
	private ExtCproductService extCproductService;

	
	/**合同列表*/
	@RequestMapping("list.action")
	public String listAction(Model model) {
		List<Contract> dataList = contractService.findAll();
		
		//每次展示页面时,都更新一下数据库表中的totalAmount.暂时就这样处理.
		//虽然真实业务逻辑并非如此.按真实逻辑会比较麻烦,只要附件和货物合同有变动,就要更新contract表.
		//但是显然这样处理会有大问题,随着合同越来越多,每次都全部更新数据库,访问量大的时候可能会较慢.
		for (Contract contract : dataList) {
			contractService.updateTotalAmount(contract);
		}
		
		model.addAttribute("dataList", dataList);
		
		return "cargo/contract/ContractList.jsp";
	}
	
	/**查看*/
	@RequestMapping("toview.action")
	public String toviewAction(String id, Model model) {
		Contract contract = contractService.findById(id);
		model.addAttribute("obj", contract);
		
		//查找此合同下的所有货物合同
		List<ContractProduct> contractProductList = contractProductService.findAllByContractId(id);
		model.addAttribute("contractProductList", contractProductList);
		//查找货物合同下的所有附件,并放入contractProduct.extCproductList属性中
		for (ContractProduct contractProduct : contractProductList) {
			String contractProductId = contractProduct.getId();
			List<ExtCproduct> extCproductList = extCproductService.findAllByContractProductId(contractProductId);
			contractProduct.setExtCproductList(extCproductList);//ContractView.jsp中需要
		}
		return "cargo/contract/ContractView.jsp";
	}
	
	/**进入新增合同页面*/
	@RequestMapping("tocreate.action")
	public String tocreateAction() {
		return "cargo/contract/ContractCreate.jsp";
	}
	
	/**新增合同*/
	@RequestMapping("insert.action")
	public String insertAction(Contract contract) {
		contractService.insertOne(contract);		
		return "redirect:list.action";
	}
	
	/**前往修改页面*/
	@RequestMapping("toupdate.action")
	public String toupdateAction(String id, Model model) {
		Contract contract = contractService.findById(id);
		model.addAttribute("obj", contract);
		return "cargo/contract/ContractUpdate.jsp";
	}
	
	/**修改合同信息.*/
	@RequestMapping("update.action")
	public String updateAction(Contract contract) {
		contractService.updateOne(contract);
		return "redirect:list.action";
	}
	
	/**删除合同*/
	@RequestMapping("delete.action")
	public String deleteAction(String id) {
		contractService.deleteById(id);
		return "redirect:list.action";
	}
	
	/**上报*/
	@RequestMapping("submit.action")
	public String submitAction(String id) {
		contractService.reportContractById(id);
		return "redirect:list.action";
	}
	
	/**取消上报*/
	@RequestMapping("cancel.action")
	public String cancelAction(String id) {
		contractService.cancelContractReportById(id);
		return "redirect:list.action";
	}
	
	
	//打印
	@RequestMapping("print.action")
	public void print(String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//ContractPrint cp = new ContractPrint();
//		ContractPrintTemplate cp = new ContractPrintTemplate();
		
		ContractPrintTemplateByMe cp = new ContractPrintTemplateByMe();
		ContractVO obj = contractService.view(id);
		cp.print(obj, request.getSession().getServletContext().getRealPath("/"), response);
	}
	
	
	
	
	
	
}
