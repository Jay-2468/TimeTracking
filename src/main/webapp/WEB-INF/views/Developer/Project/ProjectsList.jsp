<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Projects List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Projects List</h3>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<!-- Empty State -->
						<c:if test="${empty projectsList}">
							<div class="alert alert-warning">No projects found.</div>
						</c:if>

						<!-- Project Table -->
						<c:if test="${not empty projectsList}">
							<div class="table-responsive">
								<table class="table table-bordered table-hover align-middle">
									<thead class="table-dark">
										<tr>
											<th>#</th>
											<th>Project Name</th>
											<th>Description</th>
											<th>Start Date</th>
											<th>End Date</th>
											<th class="text-center">Actions</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="project" items="${projectsList}" varStatus="i">
											<tr>
												<td class="text-dark-emphasis">${i.count}</td>

												<td class="text-dark-emphasis">${project.project.projectName}</td>

												<td class="text-dark-emphasis">${project.project.description}</td>

												<td class="text-dark-emphasis">${project.project.startDate}</td>

												<td class="text-dark-emphasis">${project.project.endDate}</td>

												<td class="text-center"><a
													href="viewProject?projectId=${project.project.projectId}"
													class="btn btn-sm btn-info"> <i class="mdi mdi-eye"></i>
														View
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
			<!-- partial:partials/_footer.html -->
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
</body>
</html>
