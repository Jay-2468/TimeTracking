<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

<jsp:include page="../../GlobalCSS.jsp"></jsp:include>
</head>
<body>

	<!-- Header -->
	<jsp:include page="../includes/PMHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../includes/PMLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">Developers List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Developers List</h3>
				</div>

				<!-- Empty State -->
				<c:if test="${empty developers}">
					<div class="alert alert-warning">No users found.</div>
				</c:if>

				<!-- User Table -->
				<c:if test="${not empty developers}">
					<div class="table-responsive">
						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark">
								<tr>
									<th>#</th>
									<th>Profile</th>
									<th>Full Name</th>
									<th>Contact</th>
									<th>Email</th>
									<th>Status</th>
									<th>Created At</th>
									<th class="text-center">Actions</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="developer" items="${developers}" varStatus="i">
									<tr>
										<td class="text-dark-emphasis">${i.index + 1}</td>

										<!-- Profile Picture -->
										<td class="text-center"><c:if
												test="${not empty developer.profilePictureURL}">
												<img src="${developer.profilePictureURL}"
													class="rounded-circle" width="40" height="40" alt="Profile">
											</c:if> <c:if test="${empty developer.profilePictureURL}">
												<span class="text-dark-emphasis">N/A</span>
											</c:if></td>

										<!-- Name -->
										<td class="text-dark-emphasis">${developer.firstName}
											${developer.lastName}</td>

										<!-- Contact -->
										<td class="text-dark-emphasis">${developer.contactNumber}</td>

										<!-- Email -->
										<td class="text-dark-emphasis">${developer.email}</td>

										<!-- Status -->
										<td><c:choose>
												<c:when test="${developer.status == 'Active'}">
													<span class="badge bg-success">Active</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-secondary">Inactive</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Created Date -->
										<td class="text-dark-emphasis">${user.createdAt}</td>

										<!-- Actions -->
										<td class="text-center"><a
											href="viewDeveloper?userId=${developer.userId}"
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
				<jsp:include page="../../GlobalFooter.jsp"></jsp:include>
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>

</body>
</html>
