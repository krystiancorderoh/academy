<%@page import="com.softtek.academy.jstl.domain.model.Cart"%>
<%@page import="com.softtek.academy.jstl.service.CartService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%!
	CartService cartService = new CartService();
%>
<%
	request.setAttribute("carts", cartService.getCarts());
%>

<html>
<head>
	<title>Carts</title>
	<meta charset="UTF-8">
</head>
<body>
	<h3>Cart List:</h3>
	
	<a href="<c:url value="/jsp/cart/add.jsp"/>">Add Cart</a> --- 
	<a href="<c:url value="/index.jsp"/>">Return to Index</a>
	<br/><br/>
	
	<table style="width: 100%;" border="1">
		<tr>
			<th width="5%">Cart Id</th>
			<th width="10%">Lines Amount</th>
			<th width="10%">Shipping Amount</th>
			<th width="10%">Cart Amount</th>
			<th width="14%">Ship To</th>
			<th width="7%">Status</th>
			<th width="11%">Create User</th>
			<th width="13%">Create Date</th>
			<th width="13%">Modify Date</th>
			<th width="7%">Delete</th>
		</tr>
		<c:forEach var="cart" items="${carts}">
			<tr>
				<td align="center">
				    <a href="<c:url value="/jsp/cart/edit.jsp?cartId=${cart.id}"/>">
				        <fmt:formatNumber pattern="000" value="${cart.id}"/>
				    </a>
			     </td>
				<td align="right"><fmt:formatNumber pattern="$ #,##0.00" value="${cart.linesAmount}" /></td>
				<td align="right"><fmt:formatNumber pattern="$ #,##0.00" value="${cart.shippingAmount}" /></td>
				<td align="right"><fmt:formatNumber pattern="$ #,##0.00" value="${cart.cartAmount}" /></td>
				<td>${cart.shipTo.name}</td>
				<td>${cart.status.description}</td>
				<td>${cart.createUser}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cart.createDate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${cart.updateDate}" /></td>
				<td align="center"><c:if test="${cart.status.id != 1300}">[ X ]</c:if></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>