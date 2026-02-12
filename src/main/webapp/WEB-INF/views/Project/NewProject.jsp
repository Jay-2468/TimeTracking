<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Project</title>

<!-- Bootstrap 5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="../Admin/AdminCSS.jsp"></jsp:include>
</head>
<body class="bg-light">
	<!-- Header -->
	<jsp:include page="../Admin/AdminHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../Admin/AdminLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<div class="d-flex justify-content-between align-items-center mb-3">
					<h2 class="text-dark font-weight-bold mb-2">Create New Project</h2>
					<a href="projectList" class="btn btn-secondary btn-sm"> Back to
						List </a>
				</div>
				<div class="card shadow">
					<div class="card-body p-4">
						<h3 class="text-center mb-4">Create Project</h3>

						<form action="createProject" method="post">

							<!-- Project Name -->
							<div class="mb-3">
								<label class="form-label">Project Name</label> <input
									type="text" name="projectName" class="form-control" required>
							</div>

							<!-- Description -->
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea name="description" class="form-control" rows="4"
									required></textarea>
							</div>

							<!-- Start Date -->
							<div class="mb-3">
								<label class="form-label">Start Date</label> <input type="date"
									name="startDate" class="form-control" required>
							</div>

							<!-- End Date -->
							<div class="mb-3">
								<label class="form-label">End Date</label> <input type="date"
									name="endDate" class="form-control" required>
							</div>

							<!-- Buttons -->
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary">Save
									Project</button>
								<a href="admin-dashboard" class="btn btn-secondary"> Cancel
								</a>
							</div>

						</form>

					</div>
				</div>
			</div>
			<!-- partial:partials/_footer.html -->
			<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
</body>
</html>
