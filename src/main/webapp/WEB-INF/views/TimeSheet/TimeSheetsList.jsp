<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Time Sheet List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Weekly TimeSheets</h3>
					<a href="createTimeSheet" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i> Create TimeSheet
					</a>
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

								<c:if test="${empty timeSheetsList}">
									<tr>
										<td colspan="5" class="text-muted">No TimeSheets Found.</td>
									</tr>
								</c:if>

								<c:forEach items="${timeSheetsList}" var="sheet">
									<tr>

										<td>${sheet.weekStart}</td>
										<td>${sheet.weekEnd}</td>
										<td>${sheet.totalHours}</td>

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
										<td><a href="viewTimeSheet?id=${sheet.timesheetId}"
											class="btn btn-sm btn-info"><i class="mdi mdi-eye"></i>
												View </a> <a href="editTimeSheet?id=${sheet.timesheetId}"
											class="btn btn-sm btn-warning"> <i class="mdi mdi-pencil"></i>Edit
										</a> <a href="deleteTimeSheet?id=${sheet.timesheetId}"
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
			<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
</body>
</html>
