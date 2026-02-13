<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time Log List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Time Log List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Time Log List</h3>
					<a href="createTimeLog" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> Add Time Log
					</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark text-center">
								<tr>
									<th>Start Time</th>
									<th>End Time</th>
									<th>Total Hours</th>
									<th>Log Type</th>
									<th>Approval Status</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>

								<c:forEach items="${timeLogsList}" var="log">
									<tr>

										<td>${log.start_time}</td>
										<td>${log.end_time}</td>
										<td>${log.total_hours}</td>

										<!-- Log Type Badge -->
										<td class="text-center"><c:choose>
												<c:when test="${log.log_type == 'AUTO'}">
													<span class="badge bg-info text-dark">Auto</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-secondary">Manual</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Approval Status Badge -->
										<td class="text-center"><c:choose>
												<c:when test="${log.approval_status == 'APPROVED'}">
													<span class="badge bg-success">Approved</span>
												</c:when>
												<c:when test="${log.approval_status == 'REJECTED'}">
													<span class="badge bg-danger">Rejected</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-warning text-dark">Pending</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Actions -->
										<td class="text-center"><a
											href="viewTimeLog?logId=${log.id}"
											class="btn btn-sm btn-info"> <i class="mdi mdi-eye"></i>
												View
										</a> <a href="editTimeLog?logId=${log.id}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>
												Edit
										</a> <a href="deleteTimeLog?logId=${log.id}"
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
			<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
</body>
</html>
