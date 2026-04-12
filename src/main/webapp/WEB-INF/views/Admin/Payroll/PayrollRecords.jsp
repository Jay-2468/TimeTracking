<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payroll List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Payroll Records</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Payroll Records</h3>
					<a href="generatePayroll" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> Generate Payroll
					</a>
				</div>

				<div class="card shadow-sm">

					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-body">
									<div class="table-responsive">
										<table
											class="table table-bordered table-hover hackathon-table"
											id="myTable">
											<thead class="table-secondary">
												<tr>
													<th>#</th>
													<th>Name</th>
													<th>Total Hours</th>
													<th>Rate Per Hour</th>
													<th>Base Salary</th>
													<th>Bonus</th>
													<th>Deductions</th>
													<th>Final Salary</th>
													<th>Role</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>

											<tbody>
												<c:choose>
													<c:when test="${empty payrolls}">
														<tr>
															<td colspan="8">No data found</td>
														</tr>
													</c:when>

													<c:otherwise>
														<c:forEach var="payroll" items="${payrolls}" varStatus="i">
															<tr>
																<td class="text-dark-emphasis">${i.count}</td>
																<td class="text-dark-emphasis">${payroll.user.firstName}
																	${payroll.user.lastName}</td>
																<td class="text-dark-emphasis">${payroll.totalHours}</td>
																<td class="text-dark-emphasis"><i class="mdi mdi-currency-usd"></i>${payroll.hourlyRate}</td>
																<td class="text-dark-emphasis"><i class="mdi mdi-currency-usd"></i>${payroll.hourlyRate * payroll.totalHours}</td>
																<td class="text-dark-emphasis"><i class="mdi mdi-currency-usd"></i>${empty payroll.bonus ? 0 : payroll.bonus}
																</td>
																<td class="text-dark-emphasis"><i class="mdi mdi-currency-usd"></i>${empty payroll.deductions ? 0 : payroll.deductions}
																</td>
																<td class="text-dark-emphasis"><i class="mdi mdi-currency-usd"></i>${payroll.netSalary}</td>
																<td class="text-dark-emphasis">${payroll.user.role}</td>
																<td><span class="badge bg-info">${payroll.status}</span>
																</td>
																<td><a
																	href="editPayroll?payrollId=${payroll.payrollId}"
																	class="btn btn-sm btn-info"><i
																		class="mdi mdi-pencil"></i>Edit </a> <a
																	href="paySalary?payrollId=${payroll.payrollId}"
																	class="btn btn-sm btn-info"><i class="mdi mdi-currency-usd"></i>Pay </a></td>
															</tr>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

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
