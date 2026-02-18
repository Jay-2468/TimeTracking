<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Create New Module</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Create New Module</h2>
				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Create New Module</h3>
					<a href="moduleList" class="btn btn-secondary btn-sm"> Back to
						List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">
						<form action="createModule" method="post">

							<!-- Module Name -->
							<div class="mb-3">
								<label class="form-label">Module Name</label> <input type="text"
									name="moduleName" class="form-control" required>
							</div>

							<!-- Description -->
							<div class="mb-3">
								<label class="form-label">Description</label>
								<textarea name="description" class="form-control" rows="4"
									required></textarea>
							</div>

							<!-- Porject -->
							<div class="mb-3">
								<label class="form-label">Project</label> <select
									name="projectId" class="form-control">
									<option value="-1">---Select Project---</option>

									<c:forEach items="${projectsList}" var="pl">
										<option value="${pl.projectId}">${pl.projectName}</option>
									</c:forEach>

								</select>
							</div>

							<!-- Submit Button -->
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary">Create
									Module</button>
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
