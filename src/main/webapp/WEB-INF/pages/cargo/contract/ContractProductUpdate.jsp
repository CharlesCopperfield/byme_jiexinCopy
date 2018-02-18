<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<input type="text" name="contractId" value="${obj.contractId}"/>
	<input type="text" name="id" value="${obj.id}" style="display: none"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
<li id="back"><a href="#" onclick="formSubmit('tocreate.action','_self');">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改货物信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent">
	            	<select name="factoryInfo" style="width: 150px; height: 30px;">
	            		<option value="--请选择--">--请选择--</option>
	            		<c:forEach items="${factoryList}" var="factory" varStatus="status">
	            			<option value="${factory.id }@${factory.factoryName}" 
	            			<c:if test="${factory.factoryName==obj.factoryName }">selected="selected"</c:if>
	            			 >${factory.factoryName }</option>
		           		</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="productNo" value="${obj.productNo }"/></td>
	        </tr>
	       <tr>
	      		<td class="columnTitle_mustbe">货物照片：</td>
	            <td class="tableContent"><input type="text" name="productImage" value="${obj.productImage }"/></td>
	       </tr>
	       <tr>
	      		<td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${obj.cnumber }"/></td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packingUnit" value="${obj.packingUnit }"/></td>
	       </tr>
	       <tr>
	      		<td class="columnTitle_mustbe">装率：</td>
	            <td class="tableContent"><input type="text" name="loadingRate" value="${obj.loadingRate }"/></td>
	            <td class="columnTitle_mustbe">箱数：</td>
	            <td class="tableContent"><input type="text" name="boxNum" value="${obj.boxNum }"/></td>
	       </tr>
	       <tr>
	      		<td class="columnTitle_mustbe">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value="${obj.price }"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value="${obj.orderNo }"/></td>
	       </tr>
	       <tr>
	      		<td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContent"><textarea name="productDesc" rows="20" cols="10" style="width: 150px;height: 130px;">${obj.productDesc }</textarea></td>
	       </tr>
		</table>
	</div>
</div>
 

 
</form>
</body>
</html>

