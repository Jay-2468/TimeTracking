<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Generate Invoice</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Generate Invoice</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Generate Invoice</h3>
					<a href="invoiceList" class="btn btn-secondary btn-sm"> Back to
						Invoices </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<form action="generateInvoice" method="post">

							<div class="row">

								<!-- Total Hours -->
								<div class="col-md-4 mb-3">
									<label class="form-label">Total Hours</label> <input
										type="number" step="0.01" name="totalHours" id="totalHours"
										class="form-control" placeholder="Enter total hours" required>
								</div>

								<!-- Rate Per Hour -->
								<div class="col-md-4 mb-3">
									<label class="form-label">Rate Per Hour</label> <input
										type="number" step="0.01" name="ratePerHour" id="ratePerHour"
										class="form-control" placeholder="Enter hourly rate" required>
								</div>

								<!-- Total Amount -->
								<div class="col-md-4 mb-3">
									<label class="form-label">Total Amount</label> <input
										type="number" step="0.01" name="totalAmount" id="totalAmount"
										class="form-control" readonly>
								</div>

								<!-- Invoice Date -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Invoice Date</label> <input
										type="date" name="invoiceDate" id="invoiceDate"
										class="form-control" required>
								</div>

								<!-- Payment Status -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Payment Status</label> <select
										name="paymentStatus" class="form-select" required>
										<option value="">-- Select Status --</option>
										<option value="PAID">Paid</option>
										<option value="UNPAID">Unpaid</option>
									</select>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Generate
									Invoice</button>
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

	<!-- Auto Calculate Total Amount -->
	<script>
		function calculateTotal() {
			let hours = parseFloat(document.getElementById("totalHours").value) || 0;
			let rate = parseFloat(document.getElementById("ratePerHour").value) || 0;

			let total = hours * rate;
			document.getElementById("totalAmount").value = total.toFixed(2);
		}

		document.getElementById("totalHours").addEventListener("input",
				calculateTotal);
		document.getElementById("ratePerHour").addEventListener("input",
				calculateTotal);

		// Auto set today's date
		window.onload = function() {
			let today = new Date().toISOString().split('T')[0];
			document.getElementById("invoiceDate").value = today;
		};
	</script>

</body>
</html>
