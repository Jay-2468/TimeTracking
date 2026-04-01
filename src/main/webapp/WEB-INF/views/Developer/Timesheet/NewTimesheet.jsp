<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Timesheet</title>

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
					<h2 class="text-dark font-weight-bold mb-2">Generate New
						Weekly Timesheet</h2>
					<a href="timesheetsList" class="btn btn-secondary btn-sm"> Back
						to List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">
						<h3 class="mb-3 text-center text-dark-emphasis">Generate
							Weekly Timesheet</h3>

						<form action="saveTimesheet" method="post">

							<div class="row">

								<!-- Week Start -->
								<div class="col-md-4 mb-3">
									<label class="form-label text-dark fw-semibold">Week
										Start</label> <input type="date" name="weekStart" id="weekStart"
										class="form-control text-dark border-secondary" required>
								</div>

								<!-- Week End -->
								<div class="col-md-4 mb-3">
									<label class="form-label text-dark fw-semibold">Week
										End</label> <input type="date" name="weekEnd" id="weekEnd"
										class="form-control text-dark border-secondary" required>
								</div>

								<!-- Total Hours -->
								<div class="col-md-4 mb-3">
									<label class="form-label text-dark fw-semibold">Total
										Hours</label> <input type="number" step="0.01" name="totalHours"
										class="form-control text-dark border-secondary" readonly>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Generate
									Timesheet</button>
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

	<!-- Optional: Auto Set Week End (7 Days After Start) -->
	<script>
    document.getElementById("weekStart").addEventListener("change", function () {
        let startDate = new Date(this.value);
        if (!isNaN(startDate)) {
            startDate.setDate(startDate.getDate() + 6);
            let yyyy = startDate.getFullYear();
            let mm = String(startDate.getMonth() + 1).padStart(2, '0');
            let dd = String(startDate.getDate()).padStart(2, '0');
            // Set weekEnd first, THEN fetch
            document.getElementById("weekEnd").value = yyyy + "-" + mm + "-" + dd;
            fetchTotalHours(); // called AFTER weekEnd is set
        }
    });

    document.getElementById("weekEnd").addEventListener("change", function () {
        fetchTotalHours();
    });
	</script>
</body>
</html>
