<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>

<jsp:include page="AdminCSS.jsp"></jsp:include>
</head>
<body>

	<!-- Header -->
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<!-- Sidebar -->
	<jsp:include page="AdminLeftSidebar.jsp"></jsp:include>

	<!-- Main Content -->
	<div class="content p-4">

		<div class="d-flex justify-content-between align-items-center mb-3">
			<h3 class="mb-0">Task List</h3>
			<a href="newTask" class="btn btn-primary btn-sm"> + New Task </a>
		</div>

		<!-- Empty State -->
		<c:if test="${empty taskList}">
			<div class="alert alert-warning">No tasks found.</div>
		</c:if>

		<!-- Task Table -->
		<c:if test="${not empty taskList}">
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
						<c:forEach var="task" items="${taskList}" varStatus="i">
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
								<td>${task.assignedTo}</td>

								<!-- Actions -->
								<td class="text-center"><a
									href="viewTask?taskId=${task.taskId}"
									class="btn btn-sm btn-info text-white"> View </a> <a
									href="editTask?taskId=${task.taskId}"
									class="btn btn-sm btn-warning"> Edit </a> <a
									href="deleteTask?taskId=${task.taskId}"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Are you sure you want to delete this task?')">
										Delete </a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>

	</div>

</body>
</html>
