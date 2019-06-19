<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$("#t1 tr:gt(0)").hover(function(){
			$(this).addClass("bgColor");
		},function(){
			$(this).removeClass("bgColor");
		}).css("height","25px");
	});
</script>
</head>
<body>
	<table border="1" id="t1">
		<tr>
			<th>商品编号</th><th>所属分类</th><th>所属品牌</th><th>商品名称</th><th>商品描述</th>
			<th>商品价格</th><th>商品库存</th><th>浏览次数</th><th>商品销量</th>
		</tr>
		<s:iterator value="products" var="product">
			<tr>
				<td><s:property value="#product.product_id"/></td>
				<td><s:property value="#product.categoryThree.three_name"/></td>
				<td><s:property value="#product.brand_id"/></td>
				<td><s:property value="#product.product_name"/></td>
				<td><s:property value="#product.DESCRIPTION"/></td>
				<td><s:property value="#product.price"/></td>
				<td><s:property value="#product.stock"/></td>
				<td><s:property value="#product.browse"/></td>
				<td><s:property value="#product.sales"/></td>
			</tr>
		</s:iterator>
	</table>
	<a href="ShowProduct?pageUtil.nowPage=1">首页</a>
	<a href="ShowProduct?pageUtil.nowPage=<s:property value="pageUtil.upPage"/>">上一页</a>
	<s:iterator begin="1" end="pageUtil.pageCount" status="i">
		<a href="ShowProduct?pageUtil.nowPage=<s:property value="#i.index+1"/>"><s:property value="#i.index+1"/></a>
	</s:iterator>
	<a href="ShowProduct?pageUtil.nowPage=<s:property value="pageUtil.downPage"/>">下一页</a>
	<a href="ShowProduct?pageUtil.nowPage=<s:property value="pageUtil.lastPage"/>">尾页</a>
</body>
</html>