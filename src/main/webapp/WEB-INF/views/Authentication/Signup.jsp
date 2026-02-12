<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Signup</title>

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
							<h3 class="text-center mb-4">Create Account</h3>

							<!-- multipart required for profile picture -->
							<form action="register" method="post"
								enctype="multipart/form-data">

								<!-- First Name -->
								<div class="mb-3">
									<label class="form-label">First Name</label> <input type="text"
										name="firstName" class="form-control" required>
								</div>

								<!-- Last Name -->
								<div class="mb-3">
									<label class="form-label">Last Name</label> <input type="text"
										name="lastName" class="form-control" required>
								</div>

								<!-- Email -->
								<div class="mb-3">
									<label class="form-label">Email</label> <input type="email"
										name="email" class="form-control" required>
								</div>

								<!-- Contact Number -->
								<div class="mb-3">
									<label class="form-label">Contact Number</label> <input
										type="tel" name="contactNumber" class="form-control"
										pattern="[0-9]{10}" placeholder="10-digit number" required>
								</div>

								<!-- Password -->
								<div class="mb-3">
									<label class="form-label">Password</label> <input
										type="password" name="password" class="form-control" required>
								</div>

								<!-- Profile Picture -->
								<div class="mb-3">
									<label class="form-label">Profile Picture</label> <input
										type="file" name="profilePicture" class="form-control"
										accept="image/*">
								</div>


								<div class="mb-4">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> I agree to
											all Terms & Conditions
										</label>
									</div>
								</div>

								<!-- Submit Button -->
								<div class="d-grid">
									<button type="submit" class="btn btn-primary">Sign Up</button>
								</div>

							</form>

							<div class="text-center mt-3">
								<small> Already have an account? <a href="login">Login</a>
								</small>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
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

</body>
</html>
