<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Developer Dashboard</title>

<jsp:include page="../GlobalCSS.jsp"></jsp:include>

<style>
body {
	background: #f4f6f9;
}

.card-box {
	border-radius: 10px;
	transition: 0.3s;
}

.card-box:hover {
	transform: scale(1.03);
}
</style>

</head>

<body>

	<!-- Header -->
	<jsp:include page="includes/DeveloperHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="includes/DeveloperLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">Developer Dashboard</h2>

				<h2 class="mb-4">Welcome ${sessionScope.userName}</h2>

				<div class="row">

					<!-- Projects -->

					<div class="col-md-3">
						<div class="card text-white bg-primary card-box">
							<div class="card-body">
								<h5>Total Projects</h5>
								<h3>${totalProjects}</h3>
							</div>
						</div>
					</div>

					<!-- Tasks -->

					<div class="col-md-3">
						<div class="card text-white bg-success card-box">
							<div class="card-body">
								<h5>Total Tasks</h5>
								<h3>${totalTasks}</h3>
							</div>
						</div>
					</div>

					<!-- Pending -->

					<div class="col-md-3">
						<div class="card text-white bg-warning card-box">
							<div class="card-body">
								<h5>Pending Tasks</h5>
								<h3>${pendingTasks}</h3>
							</div>
						</div>
					</div>

					<!-- Timesheets -->

					<div class="col-md-3">
						<div class="card text-white bg-danger card-box">
							<div class="card-body">
								<h5>Submitted Timesheets</h5>
								<h3>${submittedTimesheets}</h3>
							</div>
						</div>
					</div>

				</div>

				<hr class="my-4">

				<h4>Quick Actions</h4>

				<div class="row text-center mt-3">

					<div class="col-md-3">
						<a href="dev-tasks" class="btn btn-outline-primary w-100">
							View My Tasks </a>
					</div>

					<div class="col-md-3">
						<a href="add-timesheet" class="btn btn-outline-success w-100">
							Submit Timesheet </a>
					</div>

					<div class="col-md-3">
						<a href="my-timesheets" class="btn btn-outline-warning w-100">
							View Timesheets </a>
					</div>

				</div>

			</div>

			<!-- partial:partials/_footer.html -->
			<jsp:include page="../GlobalFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->

</body>
</html>