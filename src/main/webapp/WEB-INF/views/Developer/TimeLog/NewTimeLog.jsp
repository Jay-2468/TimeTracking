<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Time Log</title>

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

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h2 class="text-dark font-weight-bold mb-2">Create Time Log</h2>
					<a href="timeLogsList" class="btn btn-secondary btn-sm"> Back
						to List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">
						<h3 class="mb-3 text-center text-dark-emphasis">Create Time Log</h3>

						<form action="saveTimeLog" method="post">

							<div class="row">

								<!-- Start Time -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Start Time</label> <input
										type="datetime-local" name="startTime" id="startTime"
										class="form-control text-dark border-secondary" required>
								</div>

								<!-- End Time -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">End Time</label> <input
										type="datetime-local" name="endTime" id="endTime"
										class="form-control text-dark border-secondary" required>
								</div>

								<!-- Total Hours -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Total Hours</label> <input
										type="number" step="0.01" name="totalHours" id="totalHours"
										class="form-control text-dark border-secondary" readonly>
								</div>

								<!-- Log Type -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Log Type</label> <select
										name="logType" class="form-select text-dark border-secondary" required>
										<option value="">-- Select Log Type --</option>
										<option value="AUTO">Auto</option>
										<option value="MANUAL">Manual</option>
									</select>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Save Time
									Log</button>
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

	<!-- Auto Calculate Hours Script -->
	<script>
		document.getElementById("endTime").addEventListener("change",
				calculateHours);
		document.getElementById("startTime").addEventListener("change",
				calculateHours);

		function calculateHours() {
			let start = new Date(document.getElementById("startTime").value);
			let end = new Date(document.getElementById("endTime").value);

			if (start && end && end > start) {
				let diff = (end - start) / (1000 * 60 * 60);
				document.getElementById("totalHours").value = diff.toFixed(2);
			}
		}
	</script>
</body>
</html>
