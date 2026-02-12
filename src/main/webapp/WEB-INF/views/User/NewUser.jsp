<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Create New User</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Create New User</h3>
					<a href="userList" class="btn btn-secondary btn-sm"> Back to
						List </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<!-- multipart required for profile picture -->
						<form action="createUser" method="post">

							<div class="row">

								<!-- First Name -->
								<div class="col-md-6 mb-3">
									<label class="form-label">First Name</label> <input type="text"
										name="firstName" class="form-control" required>
								</div>

								<!-- Last Name -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Last Name</label> <input type="text"
										name="lastName" class="form-control" required>
								</div>

								<!-- Contact Number -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Contact Number</label> <input
										type="tel" name="contactNumber" class="form-control"
										pattern="[0-9]{10}" placeholder="10-digit number" required>
								</div>

								<!-- Email -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Email</label> <input type="email"
										name="email" class="form-control" required>
								</div>

								<!-- Password -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Password</label> <input
										type="password" name="password" class="form-control" required>
								</div>

								<!-- Role -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Role</label> <select name="role"
										class="form-select" required>
										<option value="">-- Select Role --</option>
										<option value="ADMIN">Admin</option>
										<option value="PROJECT_MANAGER">Project Manager</option>
										<option value="DEVELOPER">Developer</option>
									</select>
								</div>

								<!-- Profile Picture -->
								<div class="col-12 mb-3">
									<label class="form-label">Profile Picture</label> <input
										type="file" name="profilePicture" class="form-control"
										accept="image/*">
								</div>

							</div>

							<!-- Submit Button -->
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary">Create
									User</button>
								<a href="admin-dashboard" class="btn btn-secondary"> Cancel
								</a>
							</div>

						</form>

					</div>
					<!-- partial:partials/_footer.html -->
					<jsp:include page="../Admin/AdminFooter.jsp"></jsp:include>
				</div>
				<!-- main-panel ends -->
			</div>
			<!-- page-body-wrapper ends -->
		</div>
	</div>
</body>
</html>
