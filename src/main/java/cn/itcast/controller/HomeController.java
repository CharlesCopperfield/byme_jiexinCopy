package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 负责页面整体框架的加载.
 * @author  Charles Copperfield 
 * @date 2017年12月30日 - 上午8:45:22    
 */
@Controller
public class HomeController {
	
	/**跳转至登录首页.*/
	@RequestMapping("home")
	public String homeAction() {
		return "index.jsp";
	}
	
	/**后台主要框架.*/
	@RequestMapping("fmain")
	public String fmainAction() {
		return "home/fmain.jsp";
	}
	
	/**后台左边框*/
	@RequestMapping("left")
	public String leftAction() {
		return "home/left.jsp";
	}
	
	/**后台标题框(上边框)*/
	@RequestMapping("title")
	public String titleAction() {
		return "home/title.jsp";
	}
	
	/**后台主页面(显示数据,进行操作的主页面)*/
	@RequestMapping("main")
	public String mainAction() {
		return "baseinfo/main.jsp";
	}
	
	/**系统管理栏左边框*/
	@RequestMapping("sysadminLeft")
	public String sysadminLeftAction() {
		return "sysadmin/left.jsp";
	}
	
	/**系统管理栏主页面*/
	@RequestMapping("sysadminMain")
	public String sysadminMainAction() {
		return "sysadmin/main.jsp";
	}
	
	/**基础信息左边框*/
	@RequestMapping("baseinfoLeft")
	public String baseinfoLeftAction() {
		return "baseinfo/left.jsp";
	}
	
	/**基础信息主页面*/
	@RequestMapping("baseinfoMain")
	public String baseinfoMainAction() {
		return "baseinfo/main.jsp";
	}
	
	/**货运管理左边框*/
	@RequestMapping("cargoLeft")
	public String cargoLeftAction() {
		return "cargo/left.jsp";
	}
	
	/**货运管理主页面*/
	@RequestMapping("cargoMain")
	public String cargoMainAction() {
		return "cargo/main.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
