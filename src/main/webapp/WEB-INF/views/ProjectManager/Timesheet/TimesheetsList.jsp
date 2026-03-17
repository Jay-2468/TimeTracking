<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timesheet List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Timesheet List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0 text-dark-emphasis">Weekly Timesheets</h3>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table
							class="table table-bordered table-hover align-middle text-center">
							<thead class="table-dark">
								<tr>
									<th>Week Start</th>
									<th>Week End</th>
									<th>Total Hours</th>
									<th>Status</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>

								<c:if test="${empty timesheetsList}">
									<tr>
										<td colspan="5" class="text-muted">No Timesheets Found.</td>
									</tr>
								</c:if>

								<c:forEach items="${timesheetsList}" var="sheet">
									<tr>

										<td class="text-dark-emphasis">${sheet.weekStart}</td>
										<td class="text-dark-emphasis">${sheet.weekEnd}</td>
										<td class="text-dark-emphasis">${sheet.totalHours}</td>

										<!-- Status Badge -->
										<td><c:choose>
												<c:when test="${sheet.status == 'APPROVED'}">
													<span class="badge bg-success">Approved</span>
												</c:when>
												<c:when test="${sheet.status == 'REJECTED'}">
													<span class="badge bg-danger">Rejected</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-warning text-dark">Submitted</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Actions -->
										<td><a href="viewTimesheet?id=${sheet.timesheetId}"
											class="btn btn-sm btn-info"><i class="mdi mdi-eye"></i>
												View </a> <a href="editTimesheet?id=${sheet.timesheetId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>Edit
										</a> <a href="deleteTimesheet?id=${sheet.timesheetId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this timesheet?')">
												<i class="mdi mdi-delete"></i>Delete
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
