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
				
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


			<form name="bhytForm" action="Bhyt-fill" method="post" onsubmit="return validateForm()">
					


				<caption>
					<h2>

            			Thêm BHYT mới

            		
					</h2>
				</caption>

				<c:if test="${bhyt != null}">
					<input type="hidden" name="id" value="<c:out value='${bhyt.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>CMT khách</label> 
					<select id="idCardNum" name="idCardNum" class="form-control" required="required"> 
						<option></option>
                          <c:forEach items="${listCustomer}" var="c">
                                <option value="${c.idCardNum}">${c.idCardNum} (Họ tên: ${c.name})</option>
                          </c:forEach>
                     </select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Ngày gia hạn</label> <input id="startDate" type="date" required="required"
						value="<c:out value='${bhyt.startDate}' />" class="form-control"
						name="startDate" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Ngày hết hạn</label> <input id="endDate" type="date" required="required"
						value="<c:out value='${bhyt.endDate}' />" class="form-control"
						name="endDate">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Mức hỗ trợ</label> <input id="supportLevel" type="text" required="required"
						value="<c:out value='${bhyt.supportLevel}' />" class="form-control"
						name="supportLevel">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Lương</label> <input type="text" id="salary" required="required" 
						value="4600000" class="form-control"
						name="salary">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Bệnh viện</label> 
						<select id="hospitalName" name="name" class="form-control" required="required"> 
                          <c:forEach items="${listHospital}" var="c">
                                <option value="${c.name}">${c.name}</option>
                          </c:forEach>
                     </select>
				</fieldset>
				

				<button type="submit" class="btn btn-success" id="addBH">Thêm vào danh sách hóa đơn</button>

				</form>
				
			</div>
			
		</div>
	</div>
</body>
</html>
