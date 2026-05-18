<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Timesheet</title>
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
				<h2 class="text-dark font-weight-bold mb-2">Edit Timesheet</h2>

				<!-- Page Main Content -->
				<div class="container mt-4">

					<h2>Edit Timesheet</h2>

					<form action="updateTimesheet" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="timesheetId"
							value="${timesheet.timesheetId}" />

						<!-- Week Start -->
						<div class="form-group">
							<label>Week Start</label> <input type="date" name="weekStart"
								class="form-control" value="${timesheet.weekStart}" />
						</div>

						<!-- Week End -->
						<div class="form-group">
							<label>Week End</label> <input type="date" name="weekEnd"
								class="form-control" value="${timesheet.weekEnd}" />
						</div>

						<!-- Total Hours (Read Only) -->
						<div class="form-group">
							<label>Total Hours</label> <input type="number" step="0.01"
								class="form-control" value="${timesheet.totalHours}" readonly />
						</div>

						<!-- Status -->
						<div class="form-group">
							<label>Status</label> <select name="status" class="form-control">
								<c:forEach var="s" items="${statuses}">
									<option value="${s}"
										${s.toString() == timesheet.status.toString() ? 'selected' : ''}>
										${s}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Approved By -->
						<div class="form-group">
							<label>Approved By</label> <select name="approvedBy.userId"
								class="form-control">
								<c:forEach var="u" items="${users}">
									<option value="${u.userId}"
										${u.userId == timesheet.approvedBy.userId ? 'selected' : ''}>
										${u.firstName} ${u.lastName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Approval Remark -->
						<div class="form-group">
							<label>Approval Remark</label>
							<textarea name="approvalRemark" class="form-control">
                ${timesheet.approvalRemark}
            </textarea>
						</div>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="listTimesheets" class="btn btn-secondary">Cancel</a>

					</form>

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