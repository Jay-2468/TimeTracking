<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Module List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Module List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Module List</h3>
					<a href="newModule" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> New Module
					</a>
				</div>

				<!-- Empty State -->
				<c:if test="${empty modulesList}">
					<div class="alert alert-warning">No modules found.</div>
				</c:if>

				<!-- Module Table -->
				<c:if test="${not empty modulesList}">
					<div class="table-responsive">
						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark">
								<tr>
									<th>#</th>
									<th>Module Name</th>
									<th>Description</th>
									<th>Project Name</th>
									<th class="text-center">Actions</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="module" items="${modulesList}" varStatus="i">
									<tr>
										<td>${i.index + 1}</td>
										<td>${module.moduleName}</td>
										<td>${module.description}</td>
										<td>${projectMap[module.projectId]}</td>
										<td class="text-center"><a
											href="viewModule?moduleId=${module.moduleId}"
											class="btn btn-sm btn-info text-white"> <i
												class="mdi mdi-eye"></i> View
										</a> <a href="editModule?moduleId=${module.moduleId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>
												Edit
										</a> <a href="deleteModule?moduleId=${module.moduleId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this module?')">
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
