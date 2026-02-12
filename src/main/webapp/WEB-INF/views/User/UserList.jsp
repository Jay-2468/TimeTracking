<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">User List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">User List</h3>
					<a href="newUser" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> New User
					</a>
				</div>

				<!-- Empty State -->
				<c:if test="${empty userList}">
					<div class="alert alert-warning">No users found.</div>
				</c:if>

				<!-- User Table -->
				<c:if test="${not empty userList}">
					<div class="table-responsive">
						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark">
								<tr>
									<th>#</th>
									<th>Profile</th>
									<th>Full Name</th>
									<th>Contact</th>
									<th>Email</th>
									<th>Role</th>
									<th>Status</th>
									<th>Created At</th>
									<th class="text-center">Actions</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="user" items="${userList}" varStatus="i">
									<tr>
										<td>${i.index + 1}</td>

										<!-- Profile Picture -->
										<td class="text-center"><c:if
												test="${not empty user.profilePicture}">
												<img src="uploads/${user.profilePicture}"
													class="rounded-circle" width="40" height="40" alt="Profile">
											</c:if> <c:if test="${empty user.profilePicture}">
												<span class="text-muted">N/A</span>
											</c:if></td>

										<!-- Name -->
										<td>${user.firstName}${user.lastName}</td>

										<!-- Contact -->
										<td>${user.contactNumber}</td>

										<!-- Email -->
										<td>${user.email}</td>

										<!-- Role -->
										<td><span class="badge bg-info text-dark">
												${user.role} </span></td>

										<!-- Status -->
										<td><c:choose>
												<c:when test="${user.status == 'Active'}">
													<span class="badge bg-success">Active</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-secondary">Inactive</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Created Date -->
										<td>${user.createdAt}</td>

										<!-- Actions -->
										<td class="text-center"><a
											href="editUser?userId=${user.userId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>
												Edit
										</a> <a href="deleteUser?userId=${user.userId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this user?')">
												<i class="mdi mdi-delete"></i> Delete
										</a> <a href="viewUser?userId=${user.userId}"
											class="btn btn-sm btn-primary"> <i class="mdi mdi-eye"></i>
												View
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
				<!-- partial:partials/_footer.html -->
				<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>

</body>
</html>
