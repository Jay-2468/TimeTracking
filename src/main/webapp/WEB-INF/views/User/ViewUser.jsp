<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View User</title>

<jsp:include page="../Admin/AdminCSS.jsp"></jsp:include>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../Admin/AdminHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../Admin/AdminLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">User Details</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">User Details</h3>
					<a href="usersList" class="btn btn-secondary btn-sm"> Back to
						List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<div class="row">

							<!-- Profile Picture -->
							<div class="col-md-3 text-center mb-3">
								<c:if test="${not empty user.profilePicture}">
									<img src="uploads/${user.profilePicture}"
										class="rounded-circle mb-2" width="120" height="120"
										alt="Profile Picture">
								</c:if>

								<c:if test="${empty user.profilePicture}">
									<div class="text-muted">No Image</div>
								</c:if>

								<div class="mt-2">
									<span class="badge bg-info text-dark"> ${user.role} </span>
								</div>
							</div>

							<!-- User Info -->
							<div class="col-md-9">

								<table class="table table-borderless">
									<tr>
										<th width="30%">First Name</th>
										<td>${user.firstName}</td>
									</tr>

									<tr>
										<th>Last Name</th>
										<td>${user.lastName}</td>
									</tr>

									<tr>
										<th>Email</th>
										<td>${user.email}</td>
									</tr>

									<tr>
										<th>Contact Number</th>
										<td>${user.contactNumber}</td>
									</tr>

									<tr>
										<th>Role</th>
										<td><span class="badge bg-primary"> ${user.role} </span>
										</td>
									</tr>

									<tr>
										<th>Status</th>
										<td><c:choose>
												<c:when test="${user.status == 'Active'}">
													<span class="badge bg-success">Active</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-secondary">Inactive</span>
												</c:otherwise>
											</c:choose></td>
									</tr>

									<tr>
										<th>Created At</th>
										<td>${user.createdAt}</td>
									</tr>
								</table>

							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- partial:partials/_footer.html -->
			<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->

</body>
</html>
