<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Payroll</title>
<head>
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
				<h2 class="text-dark font-weight-bold mb-2">Overview Dashboard</h2>

				<!-- Page Main Content -->
				<div class="container mt-4">

					<h2>Edit Payroll</h2>

					<form action="updatePayroll" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="payrollId" value="${payroll.payrollId}" />

						<!-- User -->
						<div class="form-group">
							<label>User</label> <select name="user.userId"
								class="form-control">
								<c:forEach var="u" items="${users}">
									<option value="${u.userId}"
										${u.userId == payroll.user.userId ? 'selected' : ''}>
										${u.firstName} ${u.lastName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Total Hours -->
						<div class="form-group">
							<label>Total Hours</label> <input type="number" step="0.01"
								name="totalHours" class="form-control"
								value="${payroll.totalHours}" />
						</div>

						<!-- Hourly Rate -->
						<div class="form-group">
							<label>Hourly Rate</label> <input type="number" step="0.01"
								name="hourlyRate" class="form-control"
								value="${payroll.hourlyRate}" />
						</div>

						<!-- Bonus -->
						<div class="form-group">
							<label>Bonus</label> <input type="number" step="0.01"
								name="bonus" class="form-control" value="${payroll.bonus}" />
						</div>

						<!-- Deductions -->
						<div class="form-group">
							<label>Deductions</label> <input type="number" step="0.01"
								name="deductions" class="form-control"
								value="${payroll.deductions}" />
						</div>

						<!-- Net Salary (Read Only) -->
						<div class="form-group">
							<label>Net Salary</label> <input type="number" step="0.01"
								class="form-control" value="${payroll.netSalary}" readonly />
						</div>

						<!-- Payment Date -->
						<div class="form-group">
							<label>Payment Date</label> <input type="datetime-local"
								name="paymentDate" class="form-control"
								value="${payroll.paymentDate}" />
						</div>

						<!-- Period Start -->
						<div class="form-group">
							<label>Period Start Date</label> <input type="date"
								name="periodStartDate" class="form-control"
								value="${payroll.periodStartDate}" />
						</div>

						<!-- Period End -->
						<div class="form-group">
							<label>Period End Date</label> <input type="date"
								name="periodEndDate" class="form-control"
								value="${payroll.periodEndDate}" />
						</div>

						<!-- Status -->
						<div class="form-group">
							<label>Status</label> <select name="status" class="form-control">
								<c:forEach var="s" items="${statuses}">
									<option value="${s}"
										${s.toString() == payroll.status.toString() ? 'selected' : ''}>
										${s}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Paid By -->
						<div class="form-group">
							<label>Paid By</label> <select name="paidBy.userId"
								class="form-control">
								<c:forEach var="u" items="${users}">
									<option value="${u.userId}"
										${u.userId == payroll.paidBy.userId ? 'selected' : ''}>
										${u.firstName} ${u.lastName}</option>
								</c:forEach>
							</select>
						</div>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="payrollRecords" class="btn btn-secondary">Cancel</a>

					</form>

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