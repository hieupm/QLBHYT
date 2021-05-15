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
			<h3 class="text-center">Danh sách khách hàng </h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/Customer-new" class="btn btn-success">Thêm mới</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên</th>
						<th>Số CMT</th>
						<th>Ngày sinh</th>
						<th>Địa chỉ</th>
						<th>Điện thoại</th>
						<th>Công cụ</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="customer" items="${listCustomer}">

						<tr>
							<td><c:out value="${customer.id}" /></td>
							<td><c:out value="${customer.name}" /></td>
							<td><c:out value="${customer.idCardNum}" /></td>
							<td><c:out value="${customer.dob}" /></td>
							<td><c:out value="${customer.address}" /></td>						
							<td><c:out value="${customer.telephone}" /></td>
							<td><a href="Customer-edit?id=<c:out value='${customer.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="Customer-delete?id=<c:out value='${customer.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
