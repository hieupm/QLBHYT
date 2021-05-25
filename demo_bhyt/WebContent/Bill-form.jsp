<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"
	>
<link href="${pageContext.request.contextPath}/source/css/all.css" rel="stylesheet"/>
<link href="all.css" rel="stylesheet"/>
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
			<c:if test="${param.bhyt eq 1}">
				<h3 style="text-align: center; color: green" id="bhyt">Thêm bảo hiểm vào danh sách hóa đơn thành công!</h3>
			</c:if>
			<c:if test="${param.bhyt eq 0}">
				<h3 style="text-align: center; color: red" id="bhyt">Thêm bảo hiểm vào danh sách hóa đơn thất bại!</h3>
			</c:if>
			<c:if test="${param.deletebh eq 1}">
				<h3 style="text-align: center; color: green" id="deletebh">Xóa bảo hiểm thành công!</h3>
			</c:if>
	<div class="container col-md-5">
		<div>
			<div>
				<c:if test="${bill == null}">
					<form action="Bill-insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${bill == null}">
            			Thêm hóa đơn mới
            		</c:if>
					</h2>
				</caption>

				<c:if test="${bill != null}">
					<input type="hidden" name="id" value="<c:out value='${bill.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Loại đối tượng</label> 
					<select value='${bill.type}' id="type" name="type" class="form-control" id="mySelect" onchange="payment()" required="required">
						<option></option>
						<option value="Nhóm do người lao động và người sử dụng lao động đóng">Nhóm do người lao động và người sử dụng lao động đóng</option>
						<option value="Nhóm do cơ quan bảo hiểm xã hội đóng">Nhóm do cơ quan bảo hiểm xã hội đóng</option>
						<option value="Nhóm được ngân sách Nhà nước hỗ trợ mức đóng">Nhóm được ngân sách Nhà nước hỗ trợ mức đóng</option>
						<option value="Nhóm tham gia Bảo hiểm y tế theo hộ gia đình">Nhóm tham gia Bảo hiểm y tế theo hộ gia đình</option>
						<option value="Nhóm do người sử dụng lao động đóng">Nhóm do người sử dụng lao động đóng</option>
					</select>

				</fieldset>
				
				<fieldset class="form-group">
					<label>Ngày trả tiền</label> <input type="date" id="paidDate"
						value="<c:out value='${bill.paidDate}' />" class="form-control"
						name="paidDate" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Số CMT người trả</label> 
						<select id="idCardNum" name="idCardNum" class="form-control" required="required"> 
						<option></option>
                          <c:forEach items="${listCustomer}" var="c">
                                <option value="${c.idCardNum}">${c.idCardNum} (Họ tên: ${c.name}, SĐT: ${c.telephone})</option>
                          </c:forEach>
                     </select>
                     
				</fieldset>

				<fieldset class="form-group">
					<label>Tên tổ chức</label> 
						<select name="tblAssociationid" class="form-control" id="tblAssociationid"> 
						<option value="0"></option>
                          <c:forEach items="${listAssociation}" var="a">
                                <option value="${a.id}">${a.name}</option>
                          </c:forEach>
                          		
                          		
                     </select>
				</fieldset>
				<h2 id="demo">Danh sách thanh toán:</h2> 
				<br>
				<table class="table table-bordered" id="countit">
				<thead>
					<tr>
						<th>STT</th>
						<th>CMT người được trả</th>
						<th>Tên người được trả</th>
						<th>Ngày gia hạn</th>
						<th>Ngày hết hạn</th>	
						<th>Bệnh viện</th>					
						<th>Tiền trả</th>
						<th>Công cụ</th>
					</tr>
				</thead>
				<tbody id="BHYT1">
					<!--   for (Todo todo: todos) {  -->
					<%!  int count=1;  %>
					<c:forEach var="bhyt"  items="${bhytList}" varStatus="loop">
						
						<tr id="salary-${loop.index}">
							
							<td class='index'>${count=count+1}</td>
							<td><c:out value="${bhyt.customer.getIdCardNum()}" /></td>
							<td><c:out value="${bhyt.customer.getName()}" /></td>
							<td><c:out value="${bhyt.startDate}" /></td>
							<td><c:out value="${bhyt.endDate}" /></td>
							<td><c:out value="${bhyt.hospital.getName()}" /></td>	
							
							<td class='count-me' id="pay-${loop.index}">
								<c:out value="${Math.round((bhyt.salary*0.045*(1-bhyt.supportLevel)))*12}" />
							</td>
							<td> <a id="deleteBh?id=<c:out value='${bhyt.id}' />" href="Bhyt-delete?id=<c:out value='${bhyt.id}' />">Delete</a></td>
						</tr>
						
                		
                
					</c:forEach>
					<!-- } -->
				</tbody>
				<tbody><tr><td>Tổng tiền</td><td></td><td></td><td></td><td></td><td></td><td id="sum"></td></tr></tbody>
			</table>
			<script>
		
				var tds = document.getElementById('countit').getElementsByTagName('td');
				var sum=0;
				for(var i=0; i < tds.length; i++){
					if(tds[i].className == 'count-me') {
					sum += isNaN(tds[i].innerHTML) ? 0 : parseInt(tds[i].innerHTML);
					}
				}
				
				function payment(){		
					var selected = document.getElementById("mySelect").value;
						
					if (selected != "Nhóm tham gia Bảo hiểm y tế theo hộ gia đình") {	
						document.getElementById('sum').innerHTML = sum;
						
					} else {										
						var salaries = []
						var salariesCount = document.getElementById("BHYT1").querySelectorAll('tr').length;
						var total = 0;
						var basicSalary = 4600000; 
						var firstSalary = 0;
						
						for (var i = 0; i < salariesCount; i++) {							
							if (i == 0){
								firstSalary = basicSalary * 0.045
								total = firstSalary + total	
								document.getElementById("pay-"+i).innerHTML = firstSalary;
							}
							else if (i == 1){
								total = firstSalary * 0.7 + total		
								document.getElementById("pay-"+i).innerHTML = firstSalary*0.7;
							}
							else if (i == 2) {
								total = firstSalary * 0.6 + total			
								document.getElementById("pay-"+i).innerHTML = firstSalary*0.6;
							}
							else if (i == 3) {
								total = firstSalary * 0.5 + total	
								document.getElementById("pay-"+i).innerHTML = firstSalary*0.5;
							}
							else {
								total = firstSalary * 0.4 + total			
								document.getElementById("pay-"+i).innerHTML = firstSalary*0.4;
							}
								
						}	
						
						sum = total;
						console.log("Total: "+total);
						
					}
					document.getElementById('sum').innerHTML = sum;
				}
				
			</script>

					<button id="saveBill" type="submit" class="btn btn-success">Save</button>
					<a href="<%=request.getContextPath()%>/Bhyt-new" class="btn btn-success">Thêm BHYT mới</a>	
					
						
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
