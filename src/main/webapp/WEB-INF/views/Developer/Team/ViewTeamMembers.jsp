<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Team Members</title>

<style>
body {
	background: #f4f6f9;
}

.table-container {
	background: white;
	padding: 25px;
	border-radius: 8px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}
</style>

<jsp:include page="../../GlobalCSS.jsp"></jsp:include>

</head>
<body>
	<!-- Header -->
	<jsp:include page="../includes/DeveloperHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../includes/DeveloperLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">My Team Members</h2>


				<div class="table-container">

					<table class="table table-bordered table-hover">

						<thead class="table-dark">
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Role</th>
								<th>Project</th>
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${teamMembers}" var="member">

								<tr>

									<td>${member.userId}</td>

									<td>${member.firstName}${member.lastName}</td>

									<td>${member.email}</td>

									<td>${member.role}</td>

									<td>${member.projectName}</td>

									<td><span class="badge bg-success">
											${member.status} </span></td>

									<td><a href="view-user?userId=${member.userId}"
										class="btn btn-sm btn-primary"> View </a></td>

								</tr>

							</c:forEach>

						</tbody>

					</table>

				</div>

			</div>
			<!-- partial:partials/_footer.html -->
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
</body>
</html>