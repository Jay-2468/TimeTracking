<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Project List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Project List</h3>
					<a href="newProject" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> New Project
					</a>
				</div>

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
										<td>${i.index + 1}</td>
										<td>${project.projectName}</td>
										<td>${project.description}</td>
										<td>${project.startDate}</td>
										<td>${project.endDate}</td>
										<td class="text-center"><a
											href="editProject?projectId=${project.projectId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>
												Edit
										</a> <a href="deleteProject?projectId=${project.projectId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this project?')">
												<i class="mdi mdi-delete"></i> Delete
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
			</div>
			<!-- partial:partials/_footer.html -->
			<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
</body>
</html>
