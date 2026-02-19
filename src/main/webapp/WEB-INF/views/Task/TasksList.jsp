<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Task List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Task List</h3>
					<a href="newTask" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> New Task
					</a>
				</div>

				<!-- Empty State -->
				<c:if test="${empty tasksList}">
					<div class="alert alert-warning">No tasks found.</div>
				</c:if>

				<!-- Task Table -->
				<c:if test="${not empty tasksList}">
					<div class="table-responsive">
						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark">
								<tr>
									<th>#</th>
									<th>Task Name</th>
									<th>Description</th>
									<th>Priority</th>
									<th>Deadline</th>
									<th>Status</th>
									<th>Assigned To</th>
									<th class="text-center">Actions</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="task" items="${tasksList}" varStatus="i">
									<tr>
										<td>${i.index + 1}</td>

										<td>${task.taskName}</td>
										<td>${task.description}</td>

										<!-- Priority Badge -->
										<td><c:choose>
												<c:when test="${task.priority == 'HIGH'}">
													<span class="badge bg-danger">High</span>
												</c:when>
												<c:when test="${task.priority == 'MEDIUM'}">
													<span class="badge bg-warning text-dark">Medium</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-success">Low</span>
												</c:otherwise>
											</c:choose></td>

										<td>${task.deadline}</td>

										<!-- Status Badge -->
										<td><c:choose>
												<c:when test="${task.status == 'PENDING'}">
													<span class="badge bg-secondary">Pending</span>
												</c:when>
												<c:when test="${task.status == 'IN_PROGRESS'}">
													<span class="badge bg-primary">In Progress</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-success">Completed</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Assigned User -->
										<%--<td>${task.assignedTo.firstName} ${task.assignedTo.lastName}</td>
								 --%>
										<%--<td>${user.firstName}
									${user.lastName}</td> --%>
										<td>${userMap[task.assignedTo]}</td>

										<!-- Actions -->
										<td class="text-center"><a
											href="viewTask?taskId=${task.taskId}"
											class="btn btn-sm btn-info text-white"> <i
												class="mdi mdi-eye"></i> View
										</a> <a href="editTask?taskId=${task.taskId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>
												Edit
										</a> <a href="deleteTask?taskId=${task.taskId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this task?')">
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
