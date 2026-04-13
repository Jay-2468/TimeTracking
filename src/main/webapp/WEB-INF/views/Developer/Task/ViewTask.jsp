<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Details</title>
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

				<h2 class="text-dark font-weight-bold mb-2">Task Details</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Task Details</h3>
					<a href="tasksList" class="btn btn-secondary btn-sm">Back to List</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<div class="row">
							<div class="col-md-12">

								<table class="table table-borderless">

									<tr>
										<th width="30%">Task Name</th>
										<td>${task.taskName}</td>
									</tr>

									<tr>
										<th>Description</th>
										<td>${task.description}</td>
									</tr>

									<tr>
										<th>Project</th>
										<td>${task.project.projectName}</td>
									</tr>

									<tr>
										<th>Module</th>
										<td>${task.module.moduleName}</td>
									</tr>

									<tr>
										<th>Assigned To</th>
										<td>${task.assignedTo.firstName} ${task.assignedTo.lastName}</td>
									</tr>

									<tr>
										<th>Priority</th>
										<td>
											<c:choose>
												<c:when test="${task.priority == 'LOW'}">
													<span class="badge bg-success">LOW</span>
												</c:when>
												<c:when test="${task.priority == 'MEDIUM'}">
													<span class="badge bg-warning">MEDIUM</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-danger">HIGH</span>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>

									<tr>
										<th>Status</th>
										<td>
											<c:choose>
												<c:when test="${task.status == 'PENDING'}">
													<span class="badge bg-secondary">PENDING</span>
												</c:when>
												<c:when test="${task.status == 'IN_PROGRESS'}">
													<span class="badge bg-warning">IN PROGRESS</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-success">COMPLETED</span>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>

									<tr>
										<th>Deadline</th>
										<td>${task.deadline}</td>
									</tr>

									<%-- <tr>
										<th>Progress</th>
										<td>
											<div class="progress">
												<div class="progress-bar" role="progressbar"
													style="width: ${task.progress}%;">
													${task.progress}%
												</div>
											</div>
										</td>
									</tr> --%>

									<tr>
										<th>Archived</th>
										<td>
											<c:choose>
												<c:when test="${task.isArchived}">
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
										<td>${task.createdAt}</td>
									</tr>

									<tr>
										<th>Updated At</th>
										<td>${task.updatedAt}</td>
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