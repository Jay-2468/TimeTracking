<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../GlobalCSS.jsp"></jsp:include>

<style>
body {
	background-color: #f4f6f9;
}

.card {
	border-radius: 12px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
}

.stat-number {
	font-size: 24px;
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<jsp:include page="includes/AdminHeader.jsp"></jsp:include>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<jsp:include page="includes/AdminLeftSidebar.jsp"></jsp:include>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<h2 class="text-dark font-weight-bold mb-2">Welcome
						${user.firstName}!</h2>

					<!-- Page Title -->
					<div class="d-flex justify-content-between mb-4">
						<h3>Admin Dashboard</h3>
					</div>

					<!-- 🔹 Statistics Cards -->
					<div class="row g-4">

						<div class="col-md-3">
							<div class="card p-3">
								<h6>Total Users</h6>
								<div class="stat-number text-primary">${totalUsers}</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card p-3">
								<h6>Total Projects</h6>
								<div class="stat-number text-success">${totalProjects}</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card p-3">
								<h6>Pending Timesheets</h6>
								<div class="stat-number text-warning">${pendingTimesheets}</div>
							</div>
						</div>

						<div class="col-md-3">
							<div class="card p-3">
								<h6>Unpaid Invoices</h6>
								<div class="stat-number text-danger">${unpaidInvoices}</div>
							</div>
						</div>

					</div>

					<!-- 🔹 Charts Section -->
					<div class="row mt-5">

						<div class="col-md-6">
							<div class="card p-3">
								<h6>Weekly Hours Overview</h6>
								<canvas id="hoursChart"></canvas>
							</div>
						</div>

						<div class="col-md-6">
							<div class="card p-3">
								<h6>Monthly Revenue</h6>
								<canvas id="revenueChart"></canvas>
							</div>
						</div>

					</div>

					<!-- 🔹 Recent Activity -->
					<div class="row mt-5">
						<div class="col-md-12">
							<div class="card p-3">
								<h6>Recent Activities</h6>
								<ul class="list-group list-group-flush">
									<c:forEach items="${recentActivities}" var="activity">
										<li class="list-group-item">${activity}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>

				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<jsp:include page="../GlobalFooter.jsp"></jsp:include>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- Chart.js -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

	<script>
    // Weekly Hours Chart
    new Chart(document.getElementById('hoursChart'), {
        type: 'bar',
        data: {
            labels: JSON.parse('${weekLabels}'),
            datasets: [{
                label: 'Hours',
                data: JSON.parse('${weekHours}'),
                borderWidth: 1
            }]
        }
    });

    // Monthly Revenue Chart
    new Chart(document.getElementById('revenueChart'), {
        type: 'line',
        data: {
            labels: JSON.parse('${monthLabels}'),
            datasets: [{
                label: 'Revenue',
                data: JSON.parse('${monthlyRevenue}'),
                borderWidth: 2
            }]
        }
    });
	</script>

</body>
</html>
