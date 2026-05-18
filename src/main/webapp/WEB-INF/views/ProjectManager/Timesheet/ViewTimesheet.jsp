<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timesheet Details</title>
<jsp:include page="../../GlobalCSS.jsp"></jsp:include>
</head>
<body>

	<!-- Header -->
	<jsp:include page="../includes/PMHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">

		<!-- Sidebar -->
		<jsp:include page="../includes/PMLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">

				<h2 class="text-dark font-weight-bold mb-2">Timesheet Details</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Timesheet Details</h3>
					<a href="timesheetsList" class="btn btn-secondary btn-sm">Back
						to List</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<table class="table table-borderless">

							<tr>
								<th width="30%">User</th>
								<td>${timesheet.user.firstName}${timesheet.user.lastName}</td>
							</tr>

							<tr>
								<th>Week Start</th>
								<td>${timesheet.weekStart}</td>
							</tr>

							<tr>
								<th>Week End</th>
								<td>${timesheet.weekEnd}</td>
							</tr>

							<tr>
								<th>Total Hours</th>
								<td><strong>${timesheet.totalHours} hrs</strong></td>
							</tr>

							<tr>
								<th>Status</th>
								<td><c:choose>
										<c:when test="${timesheet.status == 'SUBMITTED'}">
											<span class="badge bg-warning">SUBMITTED</span>
										</c:when>
										<c:when test="${timesheet.status == 'APPROVED'}">
											<span class="badge bg-success">APPROVED</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-danger">REJECTED</span>
										</c:otherwise>
									</c:choose></td>
							</tr>

							<tr>
								<th>Approved By</th>
								<td><c:if test="${not empty timesheet.approvedBy}">
										${timesheet.approvedBy.firstName} ${timesheet.approvedBy.lastName}
									</c:if> <c:if test="${empty timesheet.approvedBy}">
										<span class="text-muted">Not Approved Yet</span>
									</c:if></td>
							</tr>

							<tr>
								<th>Approved At</th>
								<td><c:if test="${not empty timesheet.approvedAt}">
										${timesheet.approvedAt}
									</c:if> <c:if test="${empty timesheet.approvedAt}">
										<span class="text-muted">N/A</span>
									</c:if></td>
							</tr>

							<tr>
								<th>Approval Remark</th>
								<td><c:if test="${not empty timesheet.approvalRemark}">
										${timesheet.approvalRemark}
									</c:if> <c:if test="${empty timesheet.approvalRemark}">
										<span class="text-muted">N/A</span>
									</c:if></td>
							</tr>

							<tr>
								<th>Editable</th>
								<td><c:choose>
										<c:when test="${timesheet.isEditable}">
											<span class="badge bg-success">YES</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-danger">NO</span>
										</c:otherwise>
									</c:choose></td>
							</tr>

							<tr>
								<th>Deleted</th>
								<td><c:choose>
										<c:when test="${timesheet.isDeleted}">
											<span class="badge bg-danger">YES</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-success">NO</span>
										</c:otherwise>
									</c:choose></td>
							</tr>

							<tr>
								<th>Created At</th>
								<td>${timesheet.createdAt}</td>
							</tr>

							<tr>
								<th>Updated At</th>
								<td>${timesheet.updatedAt}</td>
							</tr>

						</table>

					</div>
				</div>

			</div>

			<!-- Footer -->
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>

		</div>
	</div>

</body>
</html>