<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Task</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Create New Task</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Create New Task</h3>
					<a href="tasksList" class="btn btn-secondary btn-sm"> Back to
						List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<form action="createTask" method="post">

							<!-- Module (Module list) -->
							<div class="mb-3">
								<label class="form-label">Select Module</label> <select
									name="moduleId" class="form-select" required>
									<option value="">-- Select Module --</option>

									<c:forEach var="module" items="${moduleList}">
										<option value="${module.moduleId}">${module.projectId}
											- ${module.moduleName}</option>
									</c:forEach>

								</select>
							</div>

							<!-- Task Name -->
							<div class="mb-3">
								<label class="form-label">Task Name</label> <input type="text"
									name="taskName" class="form-control" required>
							</div>

							<!-- Description -->
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea name="description" class="form-control" rows="4"
									required></textarea>
							</div>

							<!-- Priority -->
							<div class="mb-3">
								<label class="form-label">Priority</label> <select
									name="priority" class="form-select" required>
									<option value="">-- Select Priority --</option>
									<option value="HIGH">High</option>
									<option value="MEDIUM">Medium</option>
									<option value="LOW">Low</option>
								</select>
							</div>

							<!-- Deadline -->
							<div class="mb-3">
								<label class="form-label">Deadline</label> <input type="date"
									name="deadline" class="form-control" required>
							</div>

							<!-- Assigned To (User List) -->
							<div class="mb-3">
								<label class="form-label">Assign To</label> <select
									name="assignedTo" class="form-select" required>
									<option value="">-- Select User --</option>

									<c:forEach var="user" items="${usersList}">
										<option value="${user.userId}">${user.firstName}
											${user.lastName}</option>
									</c:forEach>

								</select>
							</div>

							<!-- Submit Button -->
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary">Create
									Task</button>
								<a href="admin-dashboard" class="btn btn-secondary"> Cancel
								</a>
							</div>

						</form>

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
