<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.grownited.dto.ProjectDto"%>
<%@ page import="java.util.List"%>

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

					<!-- Page Title -->
					<div class="d-flex justify-content-between mb-4">
						<h3>Admin Dashboard</h3>
					</div>

					<h2 class="text-dark-emphasis font-weight-bold mb-2">Welcome
						${user.firstName}!</h2>

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

						<div class="col-md-12">
							<div class="card p-3">
								<canvas id="myChart"></canvas>
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
	 const ctx = document.getElementById('myChart');
	    const myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            
	        	labels: [ 
				<c:forEach items="${projects}" var="p" varStatus="loop">
    					"${p.projectName}"${!loop.last ? ',' : ''}
				</c:forEach>
	        	],
	            
	            datasets: [{
	                label: 'Projects-Hours',
	                data: [ 
	    				<c:forEach items="${projects}" var="p" varStatus="loop">
    						${p.estimatedHours}${!loop.last ? ',' : ''}
					</c:forEach>
	                ],
	                backgroundColor: [
	                    'rgba(255, 99, 132, 0.2)',
	                    'rgba(54, 162, 235, 0.2)',
	                    'rgba(255, 206, 86, 0.2)',
	                    'rgba(75, 192, 192, 0.2)',
	                    'rgba(153, 102, 255, 0.2)',
	                    'rgba(255, 159, 64, 0.2)'
	                ],
	                borderColor: [
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderWidth: 1
	            }]
	        },
	        options: {
	            scales: {
	                y: {
	                    beginAtZero: true
	                }
	            }
	        }
	    });
	</script>

</body>
</html>
