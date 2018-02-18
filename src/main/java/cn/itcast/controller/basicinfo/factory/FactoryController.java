package cn.itcast.controller.basicinfo.factory;

import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.controller.BaseController;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;

/** 
 * 
 * @author  Charles Copperfield 
 * @date 2017年12月29日 - 下午7:07:14    
 */
@Controller
@RequestMapping("basicinfo/factory")
public class FactoryController extends BaseController {
	
	@Autowired
	private FactoryService factoryService;
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}
	
	/**显示厂家列表*/
	@RequestMapping("list.action")
	public String listAction(Model model) {
		List<Factory> dataList = factoryService.findAll();
		model.addAttribute("dataList", dataList);
		return "basicinfo/factory/FactoryList.jsp";
	}
	
	/**查看*/
	@RequestMapping("toview.action")
	public String toviewAction(String id, Model model) {
		Factory factory = factoryService.findById(id);
		model.addAttribute("factory", factory);
		return "basicinfo/factory/FactoryView.jsp";
	}
	
	/**跳转到新增页面*/
	@RequestMapping("tocreate.action")
	public String tocreateAction() {
		return "basicinfo/factory/FactoryCreate.jsp";
	}
	
	/**执行新增操作.*/
	@RequestMapping("insert.action")
	public String insertAction(Factory factory) {
		factoryService.insertOne(factory);
		return "redirect:list.action";
	}
	
	/**跳转到修改页面*/
	@RequestMapping("toupdate.action")
	public String toupdateAction(String id,Model model) {
		Factory factory = factoryService.findById(id);
		model.addAttribute("obj", factory);
		return "basicinfo/factory/FactoryUpdate.jsp";
	}
	
	/**执行更新操作*/
	@RequestMapping("update.action")
	public String updateAction(Factory factory) {
		factoryService.updateOne(factory);
		return "redirect:list.action";
	}
	
	/**删除一个*/
	@RequestMapping("deleteById.action")
	public String deleteByIdAction(String id) {
		factoryService.deleteById(id);
		return "redirect:list.action";
	}
	
	/**删除多个*/
	@RequestMapping("delete.action")
	public String deleteAction(String[] id) {
		factoryService.deleteByIds(id);
		return "redirect:list.action";
	}
	
	/**更改厂家启用状态*/
	@RequestMapping("start.action")
	public String startStateAction(@Param("id") String[] id) {
		factoryService.startStateByIds(id);
		return "redirect:list.action";
	}
	
	/**更改厂家启用状态*/
	@RequestMapping("stop.action")
	public String stopStateAction(@Param("id") String[] id) {
		factoryService.stopStateByIds(id);
		return "redirect:list.action";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
