<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>

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
							<h4>Hello! let's get started</h4>
							<h6 class="font-weight-light">Sign in to continue.</h6>
							<form class="pt-3" action="authenticate" method="post">
								<div class="form-group">
									<input type="email" name="email" class="form-control form-control-lg"
										id="email" placeholder="Email">
								</div>
								<div class="form-group">
									<input type="password" name="password" class="form-control form-control-lg"
										id="password" placeholder="Password">
								</div>
								<div class="mt-3">
									<button type="submit"
										class="btn d-grid btn-primary btn-lg font-weight-medium auth-form-btn"
										>LOGIN</button>
								</div>
								<div
									class="my-2 d-flex justify-content-between align-items-center">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> Keep me
											signed in
										</label>
									</div>
									<a href="/forgotPassword" class="auth-link text-black">Forgot password?</a>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Don't have an account? <a href="/signup"
										class="text-primary">Create</a>
								</div>
								<br>
								<span class="text-danger">${error}</span>
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
