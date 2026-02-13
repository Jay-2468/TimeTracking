<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invoice List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Invoice List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Invoices</h3>
					<a href="createInvoice" class="btn btn-primary btn-sm">
						Generate Invoice </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table
							class="table table-bordered table-hover align-middle text-center">
							<thead class="table-dark">
								<tr>
									<th>Total Hours</th>
									<th>Rate / Hour</th>
									<th>Total Amount</th>
									<th>Invoice Date</th>
									<th>Payment Status</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>

								<c:if test="${empty invoices}">
									<tr>
										<td colspan="6" class="text-muted">No Invoices Found.</td>
									</tr>
								</c:if>

								<c:forEach items="${invoices}" var="invoice">
									<tr>

										<td>${invoice.totalHours}</td>

										<td><fmt:formatNumber value="${invoice.ratePerHour}"
												type="currency" /></td>

										<td><strong> <fmt:formatNumber
													value="${invoice.totalAmount}" type="currency" />
										</strong></td>

										<td><fmt:formatDate value="${invoice.invoiceDate}"
												pattern="dd-MM-yyyy" /></td>

										<!-- Payment Status Badge -->
										<td><c:choose>
												<c:when test="${invoice.paymentStatus == 'PAID'}">
													<span class="badge bg-success">Paid</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-danger">Unpaid</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Actions -->
										<td><a href="viewInvoice?id=${invoice.id}"
											class="btn btn-sm btn-info"> View </a> <a
											href="editInvoice?id=${invoice.id}"
											class="btn btn-sm btn-warning"> Edit </a> <a
											href="deleteInvoice?id=${invoice.id}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this invoice?')">
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
