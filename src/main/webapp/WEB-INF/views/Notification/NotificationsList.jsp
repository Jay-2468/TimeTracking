<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notification List</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Notifications List</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Notifications</h3>
					<a href="createNotification" class="btn btn-primary btn-sm"> <i
						class="mdi mdi-plus-circle-outline"></i>Send Notification
					</a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body table-responsive">

						<table class="table table-bordered table-hover align-middle">
							<thead class="table-dark text-center">
								<tr>
									<th>Message</th>
									<th>Type</th>
									<th>Sent Time</th>
									<th>Status</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>

								<c:if test="${empty notifications}">
									<tr>
										<td colspan="5" class="text-center text-muted">No
											Notifications Found.</td>
									</tr>
								</c:if>

								<c:forEach items="${notifications}" var="notification">
									<tr>

										<!-- Message -->
										<td>${notification.message}</td>

										<!-- Notification Type Badge -->
										<td class="text-center"><c:choose>
												<c:when
													test="${notification.notificationType == 'DEADLINE'}">
													<span class="badge bg-danger">Deadline</span>
												</c:when>
												<c:when test="${notification.notificationType == 'IDLE'}">
													<span class="badge bg-warning text-dark">Idle</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-info text-dark">Alert</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Sent Time -->
										<td class="text-center">${notification.sentTime}</td>

										<!-- Status Badge -->
										<td class="text-center"><c:choose>
												<c:when test="${notification.status == 'READ'}">
													<span class="badge bg-success">Read</span>
												</c:when>
												<c:otherwise>
													<span class="badge bg-secondary">Unread</span>
												</c:otherwise>
											</c:choose></td>

										<!-- Actions -->
										<td class="text-center"><a
											href="viewNotification?notificationId=${notification.notificationId}"
											class="btn btn-sm btn-info"> <i class="mdi mdi-eye"></i> View </a> <a
											href="markAsRead?notificationId=${notification.notificationId}"
											class="btn btn-sm btn-success"> <i class="mdi mdi-read"></i>Mark as Read </a> <a
											href="deleteNotification?notificationId=${notification.notificationId}"
											class="btn btn-sm btn-danger"
											onclick="return confirm('Are you sure you want to delete this notification?')">
												<i class="mdi mdi-delete"></i> Delete </a></td>

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
