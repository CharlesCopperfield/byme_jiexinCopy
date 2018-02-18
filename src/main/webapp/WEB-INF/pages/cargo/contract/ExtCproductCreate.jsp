<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript">
    	//设置冗余的生产厂家名称
    	function setFactoryName(val){
    		var ele = document.getElementById("factoryName");
    		ele.value = val;
    	}
    </script>
</head>
<body>
<form method="post">
	<input type="text" name="contractProductId" value="${contractProductId}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
<li id="back"><a href="#" onclick="formSubmit('../contractproduct/tocreate.action?contractId=${contractId}','_self');">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		货物附件信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent">
	            	<select name="factoryInfo">
	            		<option>--请选择--</option>
	            		<c:forEach items="${factoryList }" var="factory">
	            			<option value="${factory.id }@${factory.factoryName}">${factory.factoryName }</option>
	            		</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货号: </td>
	            <td class="tableContent"><input type="text" name="productNo"></td>
	          </tr>
	          <tr>
	          	 <td class="columnTitle_mustbe">分类： </td>
	             <td class="tableContent"><input type="text" name="ctype"></td>
	          	 <td class="columnTitle_mustbe">货物照片： </td>
	             <td class="tableContent"><input type="text" name="productImage"></td>
	          </tr>
	          <tr>
	          	 <td class="columnTitle_mustbe">数量： </td>
	             <td class="tableContent"><input type="text" name="cnumber"></td>
	          	 <td class="columnTitle_mustbe">包装单位： </td>
	             <td class="tableContent"><input type="text" name="packingUnit"></td>
	          </tr>
	          <tr>
	          	 <td class="columnTitle_mustbe">单价： </td>
	             <td class="tableContent"><input type="text" name="price"></td>
	          	 <td class="columnTitle_mustbe">排序号： </td>
	             <td class="tableContent"><input type="text" name="orderNo"></td>
	          </tr>
	          <tr>
	          	 <td class="columnTitle_mustbe">货物描述： </td>
	             <td class="tableContent">
	             	<textarea name="productDesc" cols="10" rows="20" style="width: 150px;height: 130px"></textarea>
	             </td>
	          	 <td class="columnTitle_mustbe">要求： </td>
	             <td class="tableContent">
	            	<textarea name="productRequest" rows="20" cols="10" style="width: 150px;height: 130px;"></textarea>
	             </td>
	          </tr>
	          
		</table>
		
	</div>
</div>
 
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    	附件列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家名称</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.factoryName }</td>
		<td>${o.productNo }</td>
		<td>${o.cnumber }</td>
		<td>${o.packingUnit }</td>
		<td>${o.price }</td>
		<td>${o.amount }</td>
		<td>
			<a href="toupdate.action?id=${o.id }&contractId=${contractId}">[修改]</a>
			<a href="delete.action?id=${o.id }&contractProductId=${o.contractProductId}">[删除]</a>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
 
</div>
 
</form>
</body>
</html>

