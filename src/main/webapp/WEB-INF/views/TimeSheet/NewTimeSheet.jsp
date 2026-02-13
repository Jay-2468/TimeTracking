<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New TimeSheet</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Create New Time
					Sheet</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Create Weekly Time Sheet</h3>
					<a href="timeSheetList" class="btn btn-secondary btn-sm"> Back
						to List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<form action="saveTimeSheet" method="post">

							<div class="row">

								<!-- Week Start -->
								<div class="col-md-4 mb-3">
									<label class="form-label">Week Start</label> <input type="date"
										name="weekStart" id="weekStart" class="form-control" required>
								</div>

								<!-- Week End -->
								<div class="col-md-4 mb-3">
									<label class="form-label">Week End</label> <input type="date"
										name="weekEnd" id="weekEnd" class="form-control" required>
								</div>

								<!-- Total Hours -->
								<div class="col-md-4 mb-3">
									<label class="form-label">Total Hours</label> <input
										type="number" step="0.01" name="totalHours"
										class="form-control" placeholder="Enter total weekly hours"
										required>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Save
									TimeSheet</button>
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

	<!-- Optional: Auto Set Week End (7 Days After Start) -->
	<script>
		document.getElementById("weekStart").addEventListener(
				"change",
				function() {

					let startDate = new Date(this.value);
					if (!isNaN(startDate)) {

						// Add 6 days (7-day week)
						startDate.setDate(startDate.getDate() + 6);

						let yyyy = startDate.getFullYear();
						let mm = String(startDate.getMonth() + 1).padStart(2,
								'0');
						let dd = String(startDate.getDate()).padStart(2, '0');

						document.getElementById("weekEnd").value = yyyy + "-"
								+ mm + "-" + dd;
					}
				});
	</script>

</body>
</html>
