<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payroll List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Payroll Records</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Payroll Records</h3>
					<a href="createPayroll" class="btn btn-primary btn-sm">
						Generate Payroll </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table
							class="table table-bordered table-hover align-middle text-center">
							<thead class="table-dark">
								<tr>
									<th>Employee Name</th>
									<th>Total Hours</th>
									<th>Salary Amount</th>
									<th>Payment Date</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>

								<c:if test="${empty payrolls}">
									<tr>
										<td colspan="5" class="text-muted">No Payroll Records
											Found.</td>
									</tr>
								</c:if>

								<c:forEach items="${payrolls}" var="payroll">
									<tr>

										<!-- Employee Name (Join or DTO mapping required) -->
										<td>${payroll.userName}</td>

										<td>${payroll.totalHours}</td>

										<td><strong> <fmt:formatNumber
													value="${payroll.salaryAmount}" type="currency" />
										</strong></td>

										<td><fmt:formatDate value="${payroll.paymentDate}"
												pattern="dd-MM-yyyy" /></td>

										<td><a href="viewPayroll?id=${payroll.id}"
											class="btn btn-sm btn-info"> View </a> <a
											href="editPayroll?id=${payroll.id}"
											class="btn btn-sm btn-warning"> Edit </a> <a
											href="deletePayroll?id=${payroll.id}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this payroll record?')">
												Delete </a></td>

									</tr>
								</c:forEach>

							</tbody>

						</table>

					</div>

				</div>
			</div>
			<!-- partial:partials/_footer.html -->
			<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->

</body>
</html>
