<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Generate Report</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Generate Report</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Generate Report</h3>
					<a href="reportsList" class="btn btn-secondary btn-sm"> Back to
						Reports </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<form action="generateReport" method="post">

							<div class="row">

								<!-- Report Type -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Report Type</label> <select
										name="reportType" class="form-select" required>
										<option value="">-- Select Report Type --</option>
										<option value="PROJECT">Project</option>
										<option value="PRODUCTIVITY">Productivity</option>
										<option value="BILLING">Billing</option>
									</select>
								</div>

								<!-- Generated Date -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Generated Date</label> <input
										type="datetime-local" name="generatedDate" id="generatedDate"
										class="form-control" readonly>
								</div>

								<!-- Report Data -->
								<div class="col-12 mb-3">
									<label class="form-label">Report Data</label>
									<textarea name="reportData" class="form-control" rows="6"
										placeholder="Enter report summary or details..." required></textarea>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Generate
									Report</button>
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

	<!-- Auto Set Current DateTime -->
	<script>
		window.onload = function() {
			let now = new Date();

			let yyyy = now.getFullYear();
			let mm = String(now.getMonth() + 1).padStart(2, '0');
			let dd = String(now.getDate()).padStart(2, '0');
			let hh = String(now.getHours()).padStart(2, '0');
			let min = String(now.getMinutes()).padStart(2, '0');

			document.getElementById("generatedDate").value = yyyy + "-" + mm
					+ "-" + dd + "T" + hh + ":" + min;
		};
	</script>

</body>
</html>
