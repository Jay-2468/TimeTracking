<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Details</title>
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
				<h2 class="text-dark font-weight-bold mb-2">Project Details</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Project Details</h3>
					<a href="projectsList" class="btn btn-secondary btn-sm"> Back
						to List</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<div class="row">
							<!-- Project Info -->
							<div class="col-md-12">

								<table class="table table-borderless">
									<tr>
										<th width="30%">Project Name</th>
										<td>${project.projectName}</td>
									</tr>

									<tr>
										<th>Description</th>
										<td>${project.description}</td>
									</tr>

									<tr>
										<th>Priority</th>
										<td><c:choose>
												<c:when test="${project.priority == 'LOW'}">
													<span class="badge bg-success">LOW</span>
												</c:when>
												<c:when test="${project.priority == 'MEDIUM'}">
													<span class="badge bg-warning">MEDIUM</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-danger">HIGH</span>
												</c:otherwise>
											</c:choose></td>
									</tr>

									<tr>
										<th>Status</th>
										<td><c:choose>
												<c:when test="${project.status == 'PLANNED'}">
													<span class="badge bg-primary">PLANNED</span>
												</c:when>
												<c:when test="${project.status == 'ONGOING'}">
													<span class="badge bg-warning">ONGOING</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-success">COMPLETED</span>
												</c:otherwise>
											</c:choose></td>
									</tr>

									<tr>
										<th>Start Date</th>
										<td>${project.startDate}</td>
									</tr>

									<tr>
										<th>End Date</th>
										<td>${project.endDate}</td>
									</tr>

									<tr>
										<th>Total Team Members</th>
										<td>${totalTeamMembers}</td>
									</tr>

								</table>
								
								<br>

								<!-- Team Members Table -->
								<c:if test="${not empty teamMembers}">
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
													<th class="text-center">Actions</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach var="tm" items="${teamMembers}" varStatus="i">
													<tr>
														<td class="text-dark-emphasis">${i.count}</td>

														<!-- Profile Picture -->
														<td class="text-center"><c:if
																test="${not empty tm.assignedTo.profilePictureURL}">
																<img src="${tm.assignedTo.profilePictureURL}"
																	class="rounded-circle" width="40" height="40"
																	alt="Profile">
															</c:if> <c:if test="${empty tm.assignedTo.profilePictureURL}">
																<span class="text-dark-emphasis">N/A</span>
															</c:if></td>

														<!-- Name -->
														<td class="text-dark-emphasis">${tm.assignedTo.firstName}
															${tm.assignedTo.lastName}</td>

														<!-- Contact -->
														<td class="text-dark-emphasis">${tm.assignedTo.contactNumber}</td>

														<!-- Email -->
														<td class="text-dark-emphasis">${tm.assignedTo.email}</td>

														<!-- Role In Project -->
														<td class="text-dark-emphasis">${tm.roleInProject}</td>

														<!-- Actions -->
														<td class="text-center"><a
															href="viewDeveloper?userId=${tm.assignedTo.userId}"
															class="btn btn-sm btn-primary"> <i
																class="mdi mdi-eye"></i> View
														</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</c:if>
							</div>
						</div>

					</div>
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