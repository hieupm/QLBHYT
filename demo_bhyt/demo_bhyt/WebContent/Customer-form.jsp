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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${customer != null}">
					<form action="Customer-update" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form name="formInsert" action="Customer-insert" method="post" onsubmit="required()">
				</c:if>

				<caption>
					<h2>
						<c:if test="${customer != null}">
            			Sửa thông tin
            		</c:if>
						<c:if test="${customer == null}">
            			Thêm khách hàng mới
            		</c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Tên</label> <input type="text"
						value="<c:out value='${customer.name}' />" class="form-control"
						name="name" id="name" required="required">
						
				</fieldset>
				
				<fieldset class="form-group">
					<label>Số CMT/CCCD</label> <input type="text"
						value="<c:out value='${customer.idCardNum}' />" class="form-control"
						name="idCardNum" id="idCardNum" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Ngày sinh</label> <input type="date"
						value="<c:out value='${customer.dob}' />" class="form-control"
						name="dob" id="dob" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Địa chỉ</label> <input type="text"
						value="<c:out value='${customer.address}' />" class="form-control"
						name="address" id="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Điện thoại</label> <input type="text"
						value="<c:out value='${customer.telephone}' />" class="form-control"
						name="telephone" id="telephone">
				</fieldset>

				<button type="submit" class="btn btn-success" id="saveCus">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
