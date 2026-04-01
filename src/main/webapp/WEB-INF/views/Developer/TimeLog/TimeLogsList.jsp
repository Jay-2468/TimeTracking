<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time Log List</title>

<jsp:include page="../../GlobalCSS.jsp"></jsp:include>

</head>
<body>

	<!-- Header -->
	<jsp:include page="../includes/DeveloperHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../includes/DeveloperLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">Time Log List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Time Log List</h3>
					<a href="createTimeLog" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> Add Time Log
					</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark text-center">
								<tr>
									<th>Task Name</th>
									<th>Start Time</th>
									<th>End Time</th>
									<th>Break Duration</th>
									<th>Total Hours</th>
									<th>Log Type</th>
									<th>Approval Status</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>

								<c:forEach items="${timeLogsList}" var="log">
									<tr>

										<td class="text-dark-emphasis">${log.task.taskName}</td>
										<td class="text-dark-emphasis">${log.startTime}</td>
										<td class="text-dark-emphasis">${log.endTime}</td>
										<c:choose>
											<c:when
												test="${empty log.breakStartTime or empty log.breakEndTime}">
												<td class="text-dark-emphasis">0 min</td>
											</c:when>
											<c:otherwise>
												<td class="text-dark-emphasis">${log.breakDuration} min</td>
											</c:otherwise>
										</c:choose>
										<td class="text-dark-emphasis">${log.totalHours}</td>

										<!-- Log Type Badge -->
										<td class="text-center"><c:choose>
												<c:when test="${log.logType == 'AUTO'}">
													<span class="badge bg-info text-dark">Auto</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-secondary">Manual</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Approval Status Badge -->
										<td class="text-center"><c:choose>
												<c:when test="${log.approvalStatus == 'APPROVED'}">
													<span class="badge bg-success">Approved</span>
												</c:when>
												<c:when test="${log.approvalStatus == 'REJECTED'}">
													<span class="badge bg-danger">Rejected</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-warning text-dark">Pending</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Actions -->
										<td class="text-center"><a
											href="viewTimeLog?logId=${log.logId}"
											class="btn btn-sm btn-info"> <i class="mdi mdi-eye"></i>
												View
										</a> <a href="editTimeLog?logId=${log.logId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>
												Edit
										</a> <a href="deleteTimeLog?logId=${log.logId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this log?')">
												<i class="mdi mdi-delete"></i> Delete
										</a></td>

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
