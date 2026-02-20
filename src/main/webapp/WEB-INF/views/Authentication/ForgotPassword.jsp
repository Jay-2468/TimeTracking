<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Forgot Password</title>


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

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body class="bg-light">

	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth">
				<div class="row flex-grow">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left p-5">
							<div class="brand-logo">
								<img src="">
							</div>
							<h4 class="text-center mb-3">Forgot Password</h4>
							<p class="text-center text-muted mb-4">Enter your email
								address to reset your password</p>

							<form action="sendOTP" method="post">

								<!-- Email -->
								<div class="mb-3">
									<label class="form-label">Email Address</label> <input
										type="email" name="email" class="form-control" required>
								</div>

								<!-- Submit Button -->
								<div class="d-grid">
									<button type="submit" class="btn btn-primary">Send
										Reset Link</button>
								</div>

							</form>

							<!-- Back to Login -->
							<div class="text-center mt-3">
								<small> Remember your password? <a href="login">Login</a>
								</small>
							</div>

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
