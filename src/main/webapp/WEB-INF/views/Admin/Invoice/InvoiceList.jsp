<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invoice List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Invoice List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Invoices</h3>
					<a href="generateInvoice" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> Generate Invoice
					</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table
							class="table table-bordered table-hover align-middle text-center">
							<thead class="table-dark">
								<tr>
									<th>#</th>
									<th>Invoice No</th>
									<th>Project</th>
									<th>Total</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</thead>

							<tbody>

								<c:if test="${empty invoices}">
									<tr>
										<td colspan="6" class="text-dark-emphasis">No Invoices
											Found.</td>
									</tr>
								</c:if>

								<c:forEach items="${invoices}" var="invoice" varStatus="i">
									<tr>
										<td class="text-dark-emphasis">${i.count}</td>
										<td class="text-dark-emphasis">${invoice.invoiceNumber}</td>
										<td class="text-dark-emphasis">${invoice.project.projectName}</td>
										<td class="text-dark-emphasis">${invoice.totalAmount}</td>
										<td class="text-dark-emphasis">${invoice.paymentStatus}</td>
										<td><a href="downloadInvoice?invoiceId=${invoice.invoiceId}"
											class="btn btn-success btn-sm"> Download </a></td>
									</tr>
								</c:forEach>

							</tbody>

						</table>

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
