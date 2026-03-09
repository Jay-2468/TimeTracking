<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Project Manager Dashboard</title>

<jsp:include page="../GlobalCSS.jsp"></jsp:include>
<style>
body {
	background-color: #f4f6f9;
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
	<jsp:include page="includes/PMHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="includes/PMLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">Project Manager
					Dashboard</h2>

				<h2 class="mb-4">Welcome, ${user.firstName}</h2>

				<div class="row">

					<!-- Total Projects -->
					<div class="col-md-3">
						<div class="card card-box bg-primary text-white">
							<div class="card-body">
								<h5>Total Projects</h5>
								<h3>${totalProjects}</h3>
							</div>
						</div>
					</div>

					<!-- Total Modules -->
					<div class="col-md-3">
						<div class="card card-box bg-success text-white">
							<div class="card-body">
								<h5>Total Modules</h5>
								<h3>${totalModules}</h3>
							</div>
						</div>
					</div>

					<!-- Team Members -->
					<div class="col-md-3">
						<div class="card card-box bg-warning text-white">
							<div class="card-body">
								<h5>Team Members</h5>
								<h3>${totalTeamMembers}</h3>
							</div>
						</div>
					</div>

					<!-- Pending Timesheets -->
					<div class="col-md-3">
						<div class="card card-box bg-danger text-white">
							<div class="card-body">
								<h5>Pending Approvals</h5>
								<h3>${totalPendingTimesheets}</h3>
							</div>
						</div>
					</div>

				</div>

				<hr class="my-4">

				<!-- Quick Actions -->
				<div class="row text-center">

					<div class="col-md-3">
						<a href="pm-projects" class="btn btn-outline-primary w-100">View
							Projects</a>
					</div>

					<div class="col-md-3">
						<a href="pm-team" class="btn btn-outline-success w-100">View
							Team</a>
					</div>

					<div class="col-md-3">
						<a href="pm-timesheets" class="btn btn-outline-warning w-100">Approve
							Timesheets</a>
					</div>

					<div class="col-md-3">
						<a href="pm-report" class="btn btn-outline-dark w-100">Generate
							Report</a>
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