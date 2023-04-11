<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

</head>
<body>
	<h3 align="center" class="mt-3 text-danger">Insurance Report
		search</h3>
	<div class="container mt-4 " align="center">
		<form:form method="post" action="/search" modelAttribute="search">
			<section>
				<label for="planName">Plan Name:</label>
				<form:select path="planName">
					<form:option value="">Select</form:option>
					<form:options items="${planNames}" />
				</form:select>
				&nbsp;&nbsp;&nbsp; <label for="planStatus">Plan Status:</label>
				<form:select path="planStatus">
					<form:option value="">Select</form:option>
					<form:options items="${planStatus}" />
				</form:select>
				&nbsp;&nbsp;&nbsp; <label for="gender">Gender:</label>
				<form:select path="gender">
					<form:option value="">Select</form:option>
					<form:option value="male">Male</form:option>
					<form:option value="female">Female</form:option>
				</form:select>
			</section>
			<br>
			<label for="planStartDate">Plan Start Date:</label>
			<form:input type="date" path="startDate"/>
			&nbsp;&nbsp;&nbsp; <label for="planEndDate">Plan End Date:</label>
			<form:input type="date" path="endDate"/>
			<br>
			<button class="mt-4 btn btn-primary btn-lg p-6" type="submit">Search</button>
		</form:form>
		<hr>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Gender</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
			</thead>
			<tbody>
			

				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.gender }</td>
						<td>${plan.planStartDate }</td>
						<td>${plan.planEndDate}</td>

					</tr>
				</c:forEach>
				
					<c:if test="${empty plans}">
					<tr>
						<td colspan="7" style="text-align: center">No
								Records Found</td></tr>
					</c:if>
			</tbody>
		</table>



		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>