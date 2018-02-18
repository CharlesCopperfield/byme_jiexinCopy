package cn.itcast.jk.print;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.springframework.util.StringUtils;

import cn.itcast.jk.vo.ContractProductVO;
import cn.itcast.jk.vo.ContractVO;

public class ContractPrintTemplateByMe {
	
	/**打印合同*/
	public void print(ContractVO contractVO,String applicationRealPath,HttpServletResponse response) {
		
		//保存每页的数据,一个map是一页数据
		List<Map<String, String>> pageList = new ArrayList<Map<String,String>>();
		//每页数据保存在此map中
		Map<String, String> page = null;
		
		//获得星星图标
		int importNum=contractVO.getImportNum();
		String _stars = "";
		for(int i=0; i<importNum; i++) {
			_stars += "★";
		}
		
		List<ContractProductVO> contractProductVOList=contractVO.getContractProducts();
		ContractProductVO contractProductVO = null;
		//循环遍历将所有数据按每页格式存入到page/pageList中.
		for(int i=0; i<contractProductVOList.size(); i++) {
			page = new HashMap<String,String>();
			contractProductVO = contractProductVOList.get(i);
			
			//首先存储contractVO中应该保存的数据.
			page.put("offeror", "收 购 方："+contractVO.getOfferor());
			page.put("contractNo", "合 同 号："+contractVO.getContractNo());
			page.put("signingDate", "签单日期："+dateFormat(contractVO.getSigningDate(),"yyyy年MM月dd日"));
			page.put("inputBy", "制单："+contractVO.getInputBy());
			page.put("checkBy", "审单："+contractVO.getCheckBy());
			page.put("inspector", "验货员："+contractVO.getInspector());
			page.put("crequest", contractVO.getCrequest());
			
			//然后存储contractProductVO应该保存的数据
			page.put("factory","生产工厂："+insureNotNull(contractProductVO.getFactory().getFullName()));
			page.put("contacts","联 系 人："+insureNotNull(contractProductVO.getFactory().getContacts()));
			page.put("phone", "电    话："+contractProductVO.getFactory().getPhone());
			
			
			page.put("productImage", contractProductVO.getProductImage());
			page.put("productDesc", contractProductVO.getProductDesc());
			page.put("cnumber", contractProductVO.getCnumber()+"");
			page.put("price", contractProductVO.getPrice()+"");
			page.put("productNo", contractProductVO.getProductNo());
			if(contractProductVO.getPackingUnit().equals("PCS")){
				page.put("packingUnit", "只");
			}else if(contractProductVO.getPackingUnit().equals("SETS")){
				page.put("packingUnit", "套");
			}
			
			//其他需要保存的数据			
			page.put("productDescTitle", _stars+" 货物描述");
			
			
			//如果一页需要显示两条产品数据,要保存第二件产品数据
			if(contractVO.getPrintStyle().equals("2")) {
				i++;
				String factoryFullName = contractProductVO.getFactory().getFullName();
				if (i<contractProductVOList.size()) {//必须保证还有产品.
					contractProductVO = contractProductVOList.get(i);
					//必须保证同一厂家的产品才能打印在一页上.
					if (factoryFullName.equals(contractProductVO.getFactory().getFullName())) {
						page.put("productImage2", contractProductVO.getProductImage());
						page.put("productDesc2", contractProductVO.getProductDesc());
						page.put("cnumber2", contractProductVO.getCnumber()+"");
						page.put("price2", contractProductVO.getPrice()+"");
						page.put("productNo2", contractProductVO.getProductNo());
						if(contractProductVO.getPackingUnit().equals("PCS")){
							page.put("packingUnit2", "只");
						}else if(contractProductVO.getPackingUnit().equals("SETS")){
							page.put("packingUnit2", "套");
						}
					}else {//不是同一厂家,新页打印.
						i--;
					}
				}
			}
			
			//每页的数据保存成功,添加到集合中.
			pageList.add(page);
		}
		
		//数据全部准备好,开始模板打印.
		
		//获取模板文件
		String templateFilePath = applicationRealPath + "/make/xlsprint/tCONTRACTVO.xls";
		
		try {
			Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(templateFilePath)));
			Sheet templateSheet=workbook.getSheetAt(0);//获取模板
			//克隆模板
			for(int i=0; i<pageList.size(); i++) {
				workbook.cloneSheet(0);
				workbook.setSheetName(i+1, "C"+i);
			}
			
			//写数据.
			for(int i=0; i<pageList.size(); i++) {
				//获取复制后的表格模板
				Sheet newSheet=workbook.getSheetAt(i+1);
				newSheet.setForceFormulaRecalculation(true);	
				page=pageList.get(i);
				
				Row nRow = null;
				Cell nCell = null;
				
				int rownum = 6;//从第7行开始.
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				nCell.setCellValue(page.get("offeror"));
				nCell = nRow.getCell(5);
				nCell.setCellValue(page.get("factory"));
				
				//新起一行
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				nCell.setCellValue(page.get("contractNo"));
				nCell = nRow.getCell(5);
				nCell.setCellValue(page.get("contacts"));
				
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				nCell.setCellValue(page.get("signingDate"));
				nCell = nRow.getCell(5);
				nCell.setCellValue(page.get("phone"));
				
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(4);
				nCell.setCellValue(page.get("productDescTitle"));
				
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				//设置图片,图片会将文字覆盖,拿走图片下面就会显示出文字.
				nCell.setCellValue(page.get("productImage"));
				if (!StringUtils.isEmpty(page.get("productImage"))) {
					String imagePath = applicationRealPath+"/ufiles/jquery/"+page.get("productImage");
					this.setPicture(imagePath, newSheet, rownum-1, 1, rownum, 3);
				}
				nCell = nRow.getCell(4);
				nCell.setCellValue(page.get("productDesc"));
				nCell = nRow.getCell(5);
				nCell.setCellValue(page.get("cnumber"));
				nCell = nRow.getCell(6);
				nCell.setCellValue(page.get("packingUnit"));
				nCell = nRow.getCell(7);
				nCell.setCellValue(page.get("price"));
				//设置公式
				nCell = nRow.getCell(8);
				nCell.setCellFormula("F11*H11");
				
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				nCell.setCellValue(page.get("productNo"));
				
				
				
				//如果有第二件产品打印
				if (page.get("productImage2")!=null) {
					nRow = newSheet.getRow(rownum++);
					nCell = nRow.getCell(1);
					//设置图片,图片会将文字覆盖,拿走图片下面就会显示出文字.
					nCell.setCellValue(page.get("productImage2"));
					if (!StringUtils.isEmpty(page.get("productImage2"))) {
						String imagePath = applicationRealPath+"/ufiles/jquery/"+page.get("productImage2");
						this.setPicture(imagePath, newSheet, rownum-1, 1, rownum, 3);
					}
					nCell = nRow.getCell(4);
					nCell.setCellValue(page.get("productDesc2"));
					nCell = nRow.getCell(5);
					nCell.setCellValue(page.get("cnumber2"));
					nCell = nRow.getCell(6);
					nCell.setCellValue(page.get("packingUnit2"));
					nCell = nRow.getCell(7);
					nCell.setCellValue(page.get("price2"));
					//设置公式
					nCell = nRow.getCell(8);
					//nCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
					nCell.setCellFormula("F13*H13");
					
					nRow = newSheet.getRow(rownum++);
					nCell = nRow.getCell(1);
					nCell.setCellValue(page.get("productNo2"));
				} else {//否则跳过空白行.
					rownum += 2;
				}
				
				//制单
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				nCell.setCellValue(page.get("inputBy"));
				nCell = nRow.getCell(4);
				nCell.setCellValue(fixSpaceStr(page.get("checkBy"),26)+page.get("inspector"));
				//设置公式
				nCell = nRow.getCell(8);
				nCell.setCellFormula("I11+I13");
				
				rownum++;//空掉一行
				
				nRow = newSheet.getRow(rownum++);
				nCell = nRow.getCell(1);
				nCell.setCellValue(page.get("crequest"));
				
				
			}
			
			workbook.removeSheetAt(0);//删除模板表
			
			//6.将workbook的内容输出到输出流.
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			workbook.write(out);
			
			String returnName = contractVO.getContractNo()+"购销合同.xls";
			response.setContentType("application/octet-stream;charset=utf-8");
			returnName = response.encodeURL(new String(returnName.getBytes(),"iso8859-1"));			//保存的文件名,必须和页面编码一致,否则乱码
			response.addHeader("Content-Disposition",   "attachment;filename=" + returnName);  
			response.setContentLength(out.size());
			
			ServletOutputStream outputstream = response.getOutputStream();	//取得输出流
			out.writeTo(outputstream);					//写到输出流
			out.close();									//关闭
			outputstream.flush();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//处理图片，excel中图片是单独对象存放
	public void setPicture(String pic, Sheet sheet, int startRow, int startCol, int stopRow, int stopCol) throws IOException{
		File imageFile = new File(pic);
		if(imageFile.exists()){
			InputStream is = new FileInputStream(new File(pic));
			byte[] bytes = IOUtils.toByteArray(is);
			int pictureIdx = sheet.getWorkbook().addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);		//扩展名可为.jpg/.jpeg/.png
			is.close();
			
			Drawing drawing = sheet.createDrawingPatriarch();	// Create the drawing patriarch.  This is the top level container for all shapes.
			//前面四个参数是图片偏移量
			ClientAnchor anchor = new HSSFClientAnchor(20, 1, 1020, 0, (short)startCol, startRow, (short)stopCol, stopRow);	//add a picture shape
			anchor.setRow1(startRow);							//set position corner of the picture		
			anchor.setCol1(startCol);
			anchor.setRow2(stopRow);
			anchor.setCol2(stopCol);
			
			drawing.createPicture(anchor, pictureIdx);
		}
	}
	
	
	public String dateFormat(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	
	public String insureNotNull(String src) {
		return src==null?"":src;
	}
	
	 //返回固定长度串，空白地方用空格填充
	  public String fixSpaceStr(String str,int len){
		  StringBuffer sBuf = new StringBuffer();
		  try{
			  if(str.length()>len){
				  return str;
			  }else{
				  sBuf.append(str);
				  for(int i=0;i<(len-str.length());i++){
					  sBuf.append(" ");
				  }
				  return sBuf.toString();
			  }
		  }catch(Exception e){
			  return str;
		  }
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
