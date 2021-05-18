<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand">
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/Customer-list"
					class="nav-link">QL khách hàng</a></li>
				<li><a href="<%=request.getContextPath()%>/Bill-new"
					class="nav-link">Đóng BHYT</a></li>
				
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Danh sách hóa đơn </h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Bill-new" class="btn btn-success">Thêm mới</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Loại đối tượng</th>
						<th>Ngày trả tiền</th>
						<th>Người trả</th>
						<th>Công ty</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="bill" items="${listBill}">
						<tr>
							<td><c:out value="${bill.id}" /></td>
							<td><c:out value="${bill.type}" /></td>
							<td><c:out value="${bill.paidDate}" /></td>
							<td><c:out value="${bill.tblCustomerid}" /></td>						
							<td><c:out value="${bill.tblAssociationid}" /></td>
					
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
