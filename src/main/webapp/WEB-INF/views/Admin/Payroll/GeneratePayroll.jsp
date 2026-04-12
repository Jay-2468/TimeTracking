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
					<a href="payrollRecords" class="btn btn-secondary btn-sm"> Back
						to Payroll List </a>
				</div>



				<div class="card shadow-sm">
					<div class="card-body">
						<h3 class="mb-3 text-center text-dark-emphasis">Generate
							Payroll</h3>

						<form action="generatePayroll" method="post">

							<div class="row">

								<!-- User Dropdown (FK) -->
								<div class="col-md-12 mb-3">
									<label class="form-label text-dark fw-semibold">Select
										Employee</label> <select name="userId"
										class="form-select text-dark border-secondary" required>

										<option value="">-- Select Employee --</option>

										<c:forEach items="${employees}" var="user">
											<option value="${user.userId}">${user.firstName}
												${user.lastName} - ${user.role}</option>
										</c:forEach>

									</select>
								</div>

								<!-- Start Date -->
								<div class="mb-3">
									<label class="form-label text-dark fw-semibold">Month Start
										Date</label> <input type="date" name="periodStartDate"
										class="form-control text-dark-emphasis border-secondary" value="${startDate}" readonly>
								</div>

								<!-- End Date -->
								<div class="mb-3">
									<label class="form-label text-dark fw-semibold">Month End
										Date</label> <input type="date" name="periodEndDate"
										class="form-control text-dark-emphasis border-secondary" value="${endDate}" readonly>
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

</body>
</html>
