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
				<a href="https://www.javaguides.net" class="navbar-brand">CCOEW Internship Portal</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Companies</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Company details
            		</c:if>
						<c:if test="${user == null}">
            			Add New Company details
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="companyid" value="<c:out value='${user.companyid}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Company Name</label> <input type="text"
						value="<c:out value='${user.companyname}' />" class="form-control"
						name="companyname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Year</label> <input type="int"
						value="<c:out value='${user.year}' />" class="form-control"
						name="year">
				</fieldset>

				<fieldset class="form-group">
					<label>Position</label> <input type="text"
						value="<c:out value='${user.position}' />" class="form-control"
						name="position">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Stipend</label> <input type="int"
						value="<c:out value='${user.stipend}' />" class="form-control"
						name="stipend">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Students Selected</label> <input type="int"
						value="<c:out value='${user.students_selected}' />" class="form-control"
						name="students_selected">
				</fieldset>
				
				<fieldset class="form-group">
					<label>PPO</label> <input type="int"
						value="<c:out value='${user.ppo}' />" class="form-control"
						name="ppo">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Branch</label> <input type="text"
						value="<c:out value='${user.branch}' />" class="form-control"
						name="branch">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Duration</label> <input type="text"
						value="<c:out value='${user.duration}' />" class="form-control"
						name="duration">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Location</label> <input type="text"
						value="<c:out value='${user.location}' />" class="form-control"
						name="location">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Branches Eligible</label> <input type="text"
						value="<c:out value='${user.branches_eligible}' />" class="form-control"
						name="branches_eligible">
				</fieldset>
				
				<fieldset class="form-group">
					<label>CTC</label> <input type="int"
						value="<c:out value='${user.ctc}' />" class="form-control"
						name="ctc">
				</fieldset>
				
				<fieldset class="form-group">
					<label>CGPA</label> <input type="int"
						value="<c:out value='${user.cgpa}' />" class="form-control"
						name="cgpa">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Link</label> <input type="text"
						value="<c:out value='${user.link}' />" class="form-control"
						name="link">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>