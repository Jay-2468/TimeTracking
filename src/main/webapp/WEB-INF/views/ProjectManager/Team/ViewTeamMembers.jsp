<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Team Members</title>

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
				<h2 class="text-dark font-weight-bold mb-2">My Team Members</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Team Members</h3>
					<a href="addTeamMember" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> Add Team Members
					</a>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered table-hover hackathon-table"
										id="myTable">
										<thead>
											<tr>
												<th>#</th>
												<th>Name</th>
												<th>Email</th>
												<th>Role</th>
												<th>Project</th>
												<th>Status</th>
												<th>Action</th>
											</tr>
										</thead>

										<tbody>
											<c:choose>
												<c:when test="${empty teamMembers}">
													<tr>
														<td colspan="7">No team members found</td>
													</tr>
												</c:when>

												<c:otherwise>
													<c:forEach var="member" items="${teamMembers}"
														varStatus="i">
														<tr>
															<td class="text-dark-emphasis">${i.count}</td>

															<td class="text-dark-emphasis">${member.user.firstName}
																${member.user.lastName}</td>

															<td class="text-dark-emphasis">${member.user.email}</td>

															<td class="text-dark-emphasis">${member.roleInProject}</td>

															<td class="text-dark-emphasis">${member.project.projectName}</td>

															<td><span class="badge bg-success">
																	${member.status} </span></td>

															<td><a href="view-user?userId=${member.user.userId}"
																class="btn btn-sm btn-primary"> View </a></td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</tbody>
									</table>
								</div>
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