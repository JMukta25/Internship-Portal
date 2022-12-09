<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>CCOEW Internship Portal</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> 
					CCOEW Internship Portal </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Companies</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div-
		 class="container">
			<h3 class="text-center">List of Companies</h3>*/
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Company</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Year</th>
						<th>Position</th>
						<th>Stipend</th>
						<th>Number of Students selected</th>
						<th>Number of students who received PPO</th>
						<th>Selected Student's Branch</th>
						<th>Duration</th>
						<th>Location</th>
						<th>Branches Eligible</th>
						<th>CTC</th>
						<th>Qualifying CGPA</th>
						<th>Company website link</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.companyid}" /></td>
							<td><c:out value="${user.companyname}" /></td>
							<td><c:out value="${user.year}" /></td>
							<td><c:out value="${user.position}" /></td>
							<td><c:out value="${user.stipend}" /></td>
							<td><c:out value="${user.students_selected}" /></td>
							<td><c:out value="${user.ppo}" /></td>
							<td><c:out value="${user.branch}" /></td>
							<td><c:out value="${user.duration}" /></td>
							<td><c:out value="${user.location}" /></td>
							<td><c:out value="${user.branches_eligible}" /></td>
							<td><c:out value="${user.ctc}" /></td>
							<td><c:out value="${user.cgpa}" /></td>
							<td><c:out value="${user.link}" /></td>
							<td><a href="edit?companyid=<c:out value="${user.companyid}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?companyid=<c:out value="${user.companyid}" />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>