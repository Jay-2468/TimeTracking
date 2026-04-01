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

									<td class="text-dark-emphasis">${member.user.firstName}${member.user.lastName}</td>

									<td class="text-dark-emphasis">${member.user.email}</td>

									<td class="text-dark-emphasis">${member.user.role}</td>

									<td class="text-dark-emphasis">${member.project.projectName}</td>

									<td class=><span class="badge bg-success">
											${member.status} </span></td>

									<td class="text-center"><a href="view-user?userId=${member.user.userId}"
										class="btn btn-sm btn-info text-white"> <i
											class="mdi mdi-eye"></i> View
									</a></td>

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