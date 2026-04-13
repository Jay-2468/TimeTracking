<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Task Details</title>
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
				<h2 class="text-dark font-weight-bold mb-2">Overview Dashboard</h2>

				<!-- Page Main Content -->
				<div class="container mt-4">

					<h2>Edit Task</h2>

					<form action="updateTask" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="taskId" value="${task.taskId}" />

						<!-- Task Name -->
						<div class="form-group">
							<label>Task Name</label> <input type="text" name="taskName"
								class="form-control" value="${task.taskName}" required />
						</div>

						<!-- Description -->
						<div class="form-group">
							<label>Description</label>
							<textarea name="description" class="form-control">${task.description}</textarea>
						</div>

						<!-- Project -->
						<div class="form-group">
							<label>Project</label> <select name="project.projectId"
								class="form-control">
								<c:forEach var="p" items="${projects}">
									<option value="${p.projectId}"
										${p.projectId == task.project.projectId ? 'selected' : ''}>
										${p.projectName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Module -->
						<div class="form-group">
							<label>Module</label> <select name="module.moduleId"
								class="form-control">
								<c:forEach var="m" items="${modules}">
									<option value="${m.moduleId}"
										${m.moduleId == task.module.moduleId ? 'selected' : ''}>
										${m.moduleName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Assigned To -->
						<div class="form-group">
							<label>Assigned To</label> <select name="assignedTo.userId"
								class="form-control">
								<c:forEach var="u" items="${users}">
									<option value="${u.userId}"
										${u.userId == task.assignedTo.userId ? 'selected' : ''}>
										${u.firstName} ${u.lastName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Priority -->
						<div class="form-group">
							<label>Priority</label> <select name="priority"
								class="form-control">
								<c:forEach var="p" items="${priorities}">
									<option value="${p}"
										${p.toString() == task.priority.toString() ? 'selected' : ''}>
										${p}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Status -->
						<div class="form-group">
							<label>Status</label> <select name="status" class="form-control">
								<c:forEach var="s" items="${statuses}">
									<option value="${s}"
										${s.toString() == task.status.toString() ? 'selected' : ''}>
										${s}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Deadline -->
						<div class="form-group">
							<label>Deadline</label> <input type="date" name="deadline"
								class="form-control" value="${task.deadline}" />
						</div>

						<!-- Progress -->
						<div class="form-group">
							<label>Progress (%)</label> <input type="number" name="progress"
								min="0" max="100" class="form-control" value="${task.progress}" />
						</div>

						<!-- Archive -->
						<div class="form-group">
							<label>Archived</label> <select name="isArchived"
								class="form-control">
								<option value="false"
									${task.isArchived == false ? 'selected' : ''}>No</option>
								<option value="true"
									${task.isArchived == true ? 'selected' : ''}>Yes</option>
							</select>
						</div>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="tasksList" class="btn btn-secondary">Cancel</a>

					</form>

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