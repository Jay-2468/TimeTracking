<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Time Log</title>
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
				<h2 class="text-dark font-weight-bold mb-2">Overview Dashboard</h2>

				<!-- Page Main Content -->

				<div class="container mt-4">

					<h2>Edit Time Log</h2>

					<form action="updateTimeLog" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="logId" value="${log.logId}" />

						<!-- Task -->
						<div class="form-group">
							<label>Task</label> <select name="task.taskId"
								class="form-control">
								<c:forEach var="t" items="${tasks}">
									<option value="${t.taskId}"
										${t.taskId == log.task.taskId ? 'selected' : ''}>
										${t.taskName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Project -->
						<div class="form-group">
							<label>Project</label> <select name="project.projectId"
								class="form-control">
								<c:forEach var="p" items="${projects}">
									<option value="${p.projectId}"
										${p.projectId == log.project.projectId ? 'selected' : ''}>
										${p.projectName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Start Time -->
						<div class="form-group">
							<label>Start Time</label> <input type="datetime-local"
								name="startTime" class="form-control" value="${log.startTime}" />
						</div>

						<!-- End Time -->
						<div class="form-group">
							<label>End Time</label> <input type="datetime-local"
								name="endTime" class="form-control" value="${log.endTime}" />
						</div>

						<!-- Break Start -->
						<div class="form-group">
							<label>Break Start</label> <input type="datetime-local"
								name="breakStartTime" class="form-control"
								value="${log.breakStartTime}" />
						</div>

						<!-- Break End -->
						<div class="form-group">
							<label>Break End</label> <input type="datetime-local"
								name="breakEndTime" class="form-control"
								value="${log.breakEndTime}" />
						</div>

						<!-- Break Duration (Read Only) -->
						<div class="form-group">
							<label>Break Duration</label> <input type="number" step="0.01"
								class="form-control" value="${log.breakDuration}" readonly />
						</div>

						<!-- Total Hours (Read Only) -->
						<div class="form-group">
							<label>Total Hours</label> <input type="number" step="0.01"
								class="form-control" value="${log.totalHours}" readonly />
						</div>

						<!-- Log Type -->
						<div class="form-group">
							<label>Log Type</label> <select name="logType"
								class="form-control">
								<c:forEach var="logType" items="${logTypes}">
									<option value="${logType}"
										${logType.toString() == log.logType.toString() ? 'selected' : ''}>
										${logType}</option>
								</c:forEach>
							</select>
						</div>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="timeLogsList" class="btn btn-secondary">Cancel</a>

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