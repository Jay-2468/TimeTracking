<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Notification</title>

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

				<div class="d-flex justify-content-between align-items-center mb-3">
				<h2 class="text-dark font-weight-bold mb-2">Send Notification</h2>
					<a href="notificationsList" class="btn btn-secondary btn-sm">
						Back to Notifications </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">
					<h3 class="mb-3 text-dark-emphasis text-center">Send Notification</h3>

						<form action="sendNotification" method="post">

							<div class="row">

								<!-- Notification Type -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Notification Type</label> <select
										name="notificationType" class="form-select text-dark border-secondary" required>
										<option value="">-- Select Type --</option>
										<option value="DEADLINE">Deadline</option>
										<option value="IDLE">Idle</option>
										<option value="ALERT">Alert</option>
									</select>
								</div>

								<!-- Message -->
								<div class="col-12 mb-3">
									<label class="form-label text-dark fw-semibold">Message</label>
									<textarea name="message" class="form-control text-dark border-secondary" rows="5"
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
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>
		</div>
		<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->

</body>
</html>
