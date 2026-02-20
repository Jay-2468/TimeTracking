<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>


<!-- plugins:css -->
<link rel="stylesheet"
	href="../../assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="../../assets/vendors/flag-icon-css/css/flag-icons.min.css">
<link rel="stylesheet"
	href="../../assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet"
	href="../../assets/css/vertical-light-layout/style.css">
<!-- End layout styles -->

<style>
body {
	background-color: #f4f6f9;
}

.card {
	border-radius: 12px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
}
</style>

</head>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth">
				<div class="row flex-grow">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left p-5">
							<div class="brand-logo">
								<img src="">
							</div>
							<h3 class="text-center mb-4">Reset Password</h3>

							<form action="verifyOtpAndChangePassword" method="post">

								<!-- Email -->
								<div class="mb-3">
									<label class="form-label">Email Address</label> <input
										type="email" name="email" class="form-control" required>
								</div>

								<!-- Current Password -->
								<div class="mb-3">
									<label class="form-label">Current Password</label> <input
										type="password" name="password" class="form-control" required>
								</div>

								<!-- New Password -->
								<div class="mb-3">
									<label class="form-label">New Password</label> <input
										type="password" name="newPassword" class="form-control"
										required>
								</div>

								<!-- OTP -->
								<div class="mb-3">
									<label class="form-label">Enter OTP</label> <input type="text"
										name="otp" class="form-control" maxlength="6" required>
								</div>

								<!-- Submit Button -->
								<div class="d-grid">
									<button type="submit" class="btn btn-primary">Reset
										Password</button>
								</div>

							</form>

						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="../../assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="../../assets/js/off-canvas.js"></script>
	<script src="../../assets/js/hoverable-collapse.js"></script>
	<script src="../../assets/js/misc.js"></script>
	<script src="../../assets/js/settings.js"></script>
	<script src="../../assets/js/todolist.js"></script>
	<!-- endinject -->
</body>
</html>