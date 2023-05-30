<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<div align="center" class="container">
<br>
	<font color="purple"><b><h2>Employee Details</h2></b></font><br>
	<c:choose>
		<c:when test="${!empty employees.getContent() }">
			<table style="color: black"class="table table-bordered">
				<tr class="table-danger">
					<td><h3>
							<b>No</b>
						</h3></td>
					<td><h3>
							<b>Name</b>
						</h3></td>
					<td><h3>
							<b>Job</b>
						</h3></td>
					<td><h3>
							<b>Salary</b>
						</h3></td>
					<td><h3>
							<b>Country</b>
						</h3></td>
					<td><h3>
							<b>Operations</b>
						</h3></td>
				</tr>
				<c:forEach var="eachEmp" items="${employees.getContent() }">
					<tr class="table-info">
						<td>${eachEmp.empno}</td>
						<td>${eachEmp.ename}</td>
						<td>${eachEmp.job}</td>
						<td>${eachEmp.sal}</td>
						<td>${eachEmp.country}</td>
						<td><a href="./edit?empno=${eachEmp.empno }"><img
								alt="Image Not found" width="50" height="50"
								src="images/Edit.png"></a>&nbsp;&nbsp;<a onclick="return confirm('Do you want to delete')"
							href="./delete?id=${eachEmp.empno}"><img
								alt="Image not Found" width="50" height="50"
								src="images/delete.jpg"></a></td>
					</tr>
				</c:forEach>
			</table>
			
			<c:if test="${!employees.isFirst() }">
			<a href="report?page=0">First</a>
			</c:if>
			<c:if test="${employees.hasPrevious() }">
			<a href="report?page=${employees.getPageable().getPageNumber()-1}">Previous</a>
			</c:if>
			<c:forEach var="i" begin="1" end="${employees.getTotalPages()}">
			     [<a href="report?page=${i-1}">${i}</a>]
			</c:forEach>
			<c:if test="${employees.hasNext() }">
			<a href="report?page=${employees.getPageable().getPageNumber()+1}">Next</a>
			</c:if>
			<c:if test="${!employees.isLast() }">
			<a href="report?page=${employees.getTotalPages()-1 }">Last</a>
			</c:if>
			
			
		</c:when>
		<c:otherwise>
			<h2>
				<font color="red"> Sorry no Records found</font>
			</h2>
		</c:otherwise>
	</c:choose>
	<c:if test="${!empty msg }">
		<h3>
			<font color="green">${msg}</font>
		</h3>
	</c:if>
	<c:if test="${!empty message }">
		<h3>
			<font color="green">${message}</font>
		</h3>
	</c:if>
	
	<c:if test="${!empty messageEdit }">
		<h3>
			<font color="green">${messageEdit}</font>
		</h3>
	</c:if>
	<c:if test="${!empty errorMessage }">
		<h3>
			<font color="green">${errorMessage}</font>
		</h3>
	</c:if>
	<h3>
		<a href="./regi"><img src="images/add.png" alt="Image Not found" width="25" height="25">&nbsp;Register Employee</a>
	</h3>
</div>