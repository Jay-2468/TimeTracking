<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Generate Payroll</title>

<jsp:include page="../../GlobalCSS.jsp"></jsp:include>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../includes/AdminHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../includes/AdminLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">

				<div class="d-flex justify-content-between align-items-center mb-3">
				<h2 class="text-dark font-weight-bold mb-2">Generate Payroll</h2>
					<a href="payrollRecords" class="btn btn-secondary btn-sm"> Back to
						Payroll List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">
					<h3 class="mb-3 text-center text-dark-emphasis">Generate Payroll</h3>

						<form action="generatePayroll" method="post">

							<div class="row">

								<!-- User Dropdown (FK) -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Select Employee</label> <select
										name="userId" class="form-select text-dark border-secondary" required>

										<option value="">-- Select Employee --</option>

										<!-- users list must be sent from servlet -->
										<c:forEach items="${users}" var="user">
											<option value="${user.userId}">${user.firstName}
												${user.lastName}</option>
										</c:forEach>

									</select>
								</div>

								<!-- Total Hours -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Total Hours</label> <input
										type="number" step="0.01" name="totalHours"
										class="form-control text-dark border-secondary" placeholder="Enter total working hours"
										required>
								</div>

								<!-- Salary Amount -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Salary Amount</label> <input
										type="number" step="0.01" name="salaryAmount"
										class="form-control text-dark border-secondary" placeholder="Enter salary amount"
										required>
								</div>

								<!-- Payment Date -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Payment Date</label> <input
										type="date" name="paymentDate" id="paymentDate"
										class="form-control text-dark border-secondary" required>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Generate
									Payroll</button>
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

	<!-- Auto Set Today as Default Payment Date -->
	<script>
		window.onload = function() {
			let today = new Date().toISOString().split('T')[0];
			document.getElementById("paymentDate").value = today;
		};
	</script>

</body>
</html>
