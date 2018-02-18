package cn.itcast.controller.cargo.outproduct;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.controller.BaseController;
import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.OutProductVO;
import cn.itcast.util.DownloadUtil;

/**
 * 出货表显示及打印
 * 
 * @author Charles Copperfield
 * @date 2018年1月3日 - 下午4:19:19
 */
@Controller
@RequestMapping("cargo/outproduct")
public class OutProductController extends BaseController {
	
	@Autowired
	private OutProductService outProductService;

	/** 转向选择页面. */
	@RequestMapping("toedit.action")
	public String toeditAction() {
		return "cargo/outproduct/OutProduct.jsp";
	}
	
	/**poi模板开发样例.大致步骤就是这样,只是模板,业务会有差别.本样例只能提供思路步骤,并不能拿来就用.因为这个方法的实现与模板,业务耦合性非常强.*/
	@RequestMapping("printByPOI.action")
	public void printByPOIAction(String inputDate, HttpServletRequest request, HttpServletResponse response) 
	throws Exception {//2011-10
		//1.获取模板输入流
		String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
		InputStream in = new FileInputStream(new File(path+"/tOUTPRODUCT.xls"));
		
		//2.获取样表表单,2007以下版本,模板文件名后缀为.xls
		Workbook workbook = new HSSFWorkbook(in);		
		
		//2.获取样表表单,工作簿 2007以上版本,模板文件后缀名为.xlsx
		//InputStream in = new FileInputStream(new File(path+"/tOUTPRODUCT.xlsx"));
		//Workbook workbook = new XSSFWorkbook(in);		
		
		Sheet sheet = workbook.getSheetAt(0);
		workbook.setSheetName(0, inputDate.replace('-', '年')+"月");
		
		//3.获取首行格式
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
			//3.1设置首行格式及内容
		String titleContent = inputDate.replace("-", "年")+"月份出货表";
		cell.setCellValue(titleContent);
		
		//4.获取内容行格式
		row = sheet.getRow(2);
		int contentCol = 1;
			//4.1客户
		cell = row.getCell(contentCol++);
		CellStyle customNameCellSytle =  cell.getCellStyle();
		
			//4.2订单号
		cell = row.getCell(contentCol++);
		CellStyle contractNoCellSytle =  cell.getCellStyle();

			//4.3货号
		cell = row.getCell(contentCol++);
		CellStyle productNoCellSytle =  cell.getCellStyle();
			
			//4.4数量
		cell = row.getCell(contentCol++);
		CellStyle cnumberCellSytle =  cell.getCellStyle();
		
			//4.5工厂
		cell = row.getCell(contentCol++);
		CellStyle factoryNameCellSytle =  cell.getCellStyle();
		
			//4.6工厂交期
		cell = row.getCell(contentCol++);
		CellStyle deliveryPeriodCellSytle =  cell.getCellStyle();
		
			//4.7船期
		cell = row.getCell(contentCol++);
		CellStyle shipTimeCellSytle =  cell.getCellStyle();
		
			//4.8贸易条款
		cell = row.getCell(contentCol++);
		CellStyle tradeTermsCellSytle =  cell.getCellStyle();
		
		//5.获取数据,循环遍历输出
		List<OutProductVO> outProductVOList = outProductService.findAllBySigningDate(inputDate);
		int contentRow = 2;//内容起始行.
		for (OutProductVO outproductVO : outProductVOList) {
			row = sheet.createRow(contentRow++);
			contentCol = 1;//内容起始列.
			
			//客户
			cell = row.createCell(contentCol++);
			cell.setCellValue(outproductVO.getCustomName());
			cell.setCellStyle(customNameCellSytle);
			
			//订单号
			cell = row.createCell(contentCol++);
			cell.setCellValue(outproductVO.getContractNo());
			cell.setCellStyle(contractNoCellSytle);
			
			//货号
			cell = row.createCell(contentCol++);
			cell.setCellValue(outproductVO.getProductNo());
			cell.setCellStyle(productNoCellSytle);
			
			//数量
			cell = row.createCell(contentCol++);
			cell.setCellValue(outproductVO.getCnumber()+"PCS");
			cell.setCellStyle(cnumberCellSytle);
			
			//工厂
			cell = row.createCell(contentCol++);
			cell.setCellValue(outproductVO.getFactoryName());
			cell.setCellStyle(factoryNameCellSytle);
			
			//工厂交期
			cell = row.createCell(contentCol++);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			cell.setCellValue(dateFormat.format(outproductVO.getDeliveryPeriod()));
			cell.setCellStyle(deliveryPeriodCellSytle);
			
			//船期
			cell = row.createCell(contentCol++);
			cell.setCellValue(dateFormat.format(outproductVO.getShipTime()));
			cell.setCellStyle(shipTimeCellSytle);
			
			//贸易条款
			cell = row.createCell(contentCol++);
			cell.setCellValue(outproductVO.getTradeTerms());
			cell.setCellStyle(tradeTermsCellSytle);
		}
		
		//6.将workbook的内容输出到输出流.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		
		//7.下载
		String returnName = titleContent+".xls";
		response.setContentType("application/octet-stream;charset=utf-8");
		returnName = response.encodeURL(new String(returnName.getBytes(),"iso8859-1"));			//保存的文件名,必须和页面编码一致,否则乱码
		response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
		response.setContentLength(out.size());
		
		ServletOutputStream outputstream = response.getOutputStream();	//取得输出流
		out.writeTo(outputstream);					//写到输出流
		out.close();									//关闭
		outputstream.flush();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("print.action")
	public void printAction(String inputDate, HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		// linux下jdk1.8 方法获取时，不会拼接自己写的目录
				String path = request.getSession().getServletContext().getRealPath("/") + "/make/xlsprint/";
				InputStream is = new FileInputStream(new File(path + "tOUTPRODUCT.xls"));

				Workbook wb = new HSSFWorkbook(is); // 打开一个模板文件，工作簿
				Sheet sheet = wb.getSheetAt(0); // 获取到第一个工作表

				Row nRow = null;
				Cell nCell = null;
				int rowNo = 0; // 行号
				int colNo = 1; // 列号

				// 获取模板上的单元格样式
				nRow = sheet.getRow(2);

				// 客户的样式
				nCell = nRow.getCell(1);
				CellStyle customStyle = nCell.getCellStyle();

				// 订单号的样式
				nCell = nRow.getCell(2);
				CellStyle contractNoStyle = nCell.getCellStyle();

				// 货号的样式
				nCell = nRow.getCell(3);
				CellStyle productNoStyle = nCell.getCellStyle();

				// 数量的样式
				nCell = nRow.getCell(4);
				CellStyle numStyle = nCell.getCellStyle();

				// 生产厂家的样式
				nCell = nRow.getCell(5);
				CellStyle factoryStyle = nCell.getCellStyle();

				// 日期的样式
				nCell = nRow.getCell(6);
				CellStyle dateStyle = nCell.getCellStyle();

				// 贸易条款的样式
				nCell = nRow.getCell(8);
				CellStyle tradeStyle = nCell.getCellStyle();

				// 处理大标题
				nRow = sheet.getRow(rowNo++); // 获取一个行对象
				nCell = nRow.getCell(colNo); // 获取一个单元格对象
				nCell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表"); // yyyy-MM

				rowNo++; // 跳过静态表格头

				// 处理内容
				List<OutProductVO> dataList = outProductService.findAllBySigningDate(inputDate);
				for (int j = 0; j < dataList.size(); j++) {
					colNo = 1; // 初始化
					OutProductVO op = dataList.get(j);

					nRow = sheet.createRow(rowNo++);
					nRow.setHeightInPoints(24);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(op.getCustomName());
					nCell.setCellStyle(customStyle);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(op.getContractNo());
					nCell.setCellStyle(contractNoStyle);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(op.getProductNo());
					nCell.setCellStyle(productNoStyle);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(op.getCnumber());
					nCell.setCellStyle(numStyle);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(op.getFactoryName());
					nCell.setCellStyle(factoryStyle);

					nCell = nRow.createCell(colNo++);
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					nCell.setCellValue(format.format(op.getDeliveryPeriod()));
					nCell.setCellStyle(dateStyle);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(format.format(op.getShipTime()));
					nCell.setCellStyle(dateStyle);

					nCell = nRow.createCell(colNo++);
					nCell.setCellValue(op.getTradeTerms());
					nCell.setCellStyle(tradeStyle);
				}

				// OutputStream os = new FileOutputStream("c:\\outproduct.xls");
				// wb.write(os);
				//
				// os.flush();
				// os.close();

				ByteArrayOutputStream os = new ByteArrayOutputStream();
				wb.write(os);

				DownloadUtil downloadUtil = new DownloadUtil(); // 直接弹出下载框，用户可以打开，可以保存
				downloadUtil.download(os, response, "出货表.xls");

				os.flush();
				os.close();
		
		
		
		
		
		
		
		
	}
	
}
