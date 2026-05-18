<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Time Log Details</title>
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

				<h2 class="text-dark font-weight-bold mb-2">Time Log Details</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Time Log Details</h3>
					<a href="timeLogsList" class="btn btn-secondary btn-sm">Back to
						List</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<table class="table table-borderless">

							<tr>
								<th width="30%">User</th>
								<td>${timeLog.user.firstName}${timeLog.user.lastName}</td>
							</tr>

							<tr>
								<th>Project</th>
								<td>${timeLog.project.projectName}</td>
							</tr>

							<tr>
								<th>Task</th>
								<td>${timeLog.task.taskName}</td>
							</tr>

							<tr>
								<th>Log Date</th>
								<td>${timeLog.logDate}</td>
							</tr>

							<tr>
								<th>Start Time</th>
								<td>${timeLog.startTime}</td>
							</tr>

							<tr>
								<th>End Time</th>
								<td>${timeLog.endTime}</td>
							</tr>

							<tr>
								<th>Break Time</th>
								<td><c:if test="${not empty timeLog.breakStartTime}">
										${timeLog.breakStartTime} - ${timeLog.breakEndTime}
									</c:if> <c:if test="${empty timeLog.breakStartTime}">
										<span class="text-muted">No Break</span>
									</c:if></td>
							</tr>

							<tr>
								<th>Break Duration</th>
								<td>${timeLog.breakDuration}hrs</td>
							</tr>

							<tr>
								<th>Total Hours</th>
								<td><strong>${timeLog.totalHours} hrs</strong></td>
							</tr>

							<tr>
								<th>Log Type</th>
								<td><c:choose>
										<c:when test="${timeLog.logType == 'AUTO'}">
											<span class="badge bg-primary">AUTO</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-info text-dark">MANUAL</span>
										</c:otherwise>
									</c:choose></td>
							</tr>

							<tr>
								<th>Approval Status</th>
								<td><c:choose>
										<c:when test="${timeLog.approvalStatus == 'APPROVED'}">
											<span class="badge bg-success">APPROVED</span>
										</c:when>
										<c:when test="${timeLog.approvalStatus == 'REJECTED'}">
											<span class="badge bg-danger">REJECTED</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-warning">PENDING</span>
										</c:otherwise>
									</c:choose></td>
							</tr>

							<tr>
								<th>Approved By</th>
								<td><c:if test="${not empty timeLog.approvedBy}">
										${timeLog.approvedBy.firstName} ${timeLog.approvedBy.lastName}
									</c:if> <c:if test="${empty timeLog.approvedBy}">
										<span class="text-muted">Not Approved Yet</span>
									</c:if></td>
							</tr>

							<tr>
								<th>Approval Remark</th>
								<td><c:if test="${not empty timeLog.approvalRemark}">
										${timeLog.approvalRemark}
									</c:if> <c:if test="${empty timeLog.approvalRemark}">
										<span class="text-muted">N/A</span>
									</c:if></td>
							</tr>

							<tr>
								<th>Editable</th>
								<td><c:choose>
										<c:when test="${timeLog.isEditable}">
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
										<c:when test="${timeLog.isDeleted}">
											<span class="badge bg-danger">YES</span>
										</c:when>
										<c:otherwise>
											<span class="badge bg-success">NO</span>
										</c:otherwise>
									</c:choose></td>
							</tr>

							<tr>
								<th>Created At</th>
								<td>${timeLog.createdAt}</td>
							</tr>

							<tr>
								<th>Updated At</th>
								<td>${timeLog.updatedAt}</td>
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