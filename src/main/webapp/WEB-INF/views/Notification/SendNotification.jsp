<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Notification</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Send Notification</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Send Notification</h3>
					<a href="notificationList" class="btn btn-secondary btn-sm">
						Back to Notifications </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<form action="sendNotification" method="post">

							<div class="row">

								<!-- Notification Type -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Notification Type</label> <select
										name="notificationType" class="form-select" required>
										<option value="">-- Select Type --</option>
										<option value="DEADLINE">Deadline</option>
										<option value="IDLE">Idle</option>
										<option value="ALERT">Alert</option>
									</select>
								</div>

								<!-- Message -->
								<div class="col-12 mb-3">
									<label class="form-label">Message</label>
									<textarea name="message" class="form-control" rows="5"
										placeholder="Enter notification message..." required></textarea>
								</div>

							</div>

							<!-- Submit Button -->
							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Send
									Notification</button>
							</div>

						</form>

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
