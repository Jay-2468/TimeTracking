<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Module Details</title>
<jsp:include page="../../GlobalCSS.jsp"></jsp:include>
</head>
<body>

	<!-- Header -->
	<jsp:include page="../includes/AdminHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">

		<!-- Sidebar -->
		<jsp:include page="../includes/AdminLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">

				<h2 class="text-dark font-weight-bold mb-2">Module Details</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Module Details</h3>
					<a href="modulesList" class="btn btn-secondary btn-sm">Back to List</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<div class="row">
							<div class="col-md-12">

								<table class="table table-borderless">

									<tr>
										<th width="30%">Module Name</th>
										<td>${module.moduleName}</td>
									</tr>

									<tr>
										<th>Description</th>
										<td>${module.description}</td>
									</tr>

									<tr>
										<th>Project</th>
										<td>${module.project.projectName}</td>
									</tr>

									<tr>
										<th>Created By</th>
										<td>${module.createdBy.firstName} ${module.createdBy.lastName}</td>
									</tr>

									<tr>
										<th>Updated By</th>
										<td>
											<c:if test="${not empty module.updatedBy}">
												${module.updatedBy.firstName} ${module.updatedBy.lastName}
											</c:if>
											<c:if test="${empty module.updatedBy}">
												<span class="text-muted">N/A</span>
											</c:if>
										</td>
									</tr>

									<tr>
										<th>Status</th>
										<td>
											<c:choose>
												<c:when test="${module.status == 'ACTIVE'}">
													<span class="badge bg-success">ACTIVE</span>
												</c:when>
												<c:when test="${module.status == 'INACTIVE'}">
													<span class="badge bg-warning">INACTIVE</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-danger">ARCHIVED</span>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>

									<tr>
										<th>Archived</th>
										<td>
											<c:choose>
												<c:when test="${module.isArchived}">
													<span class="badge bg-danger">YES</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-success">NO</span>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>

									<tr>
										<th>Created At</th>
										<td>${module.createdAt}</td>
									</tr>

									<tr>
										<th>Updated At</th>
										<td>${module.updatedAt}</td>
									</tr>

								</table>

							</div>
						</div>

					</div>
				</div>

			</div>

			<!-- Footer -->
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>

		</div>
	</div>

</body>
</html>