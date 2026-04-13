<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User Details</title>
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
				<h2 class="text-dark font-weight-bold mb-2">Edit User Details</h2>

				<!-- Page Main Content -->
				<div class="container mt-4">
					<h2>Edit User</h2>

					<form action="updateUser" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="userId" value="${user.userId}" />

						<div class="form-group">
							<label>First Name</label> <input type="text" name="firstName"
								class="form-control" value="${user.firstName}" required />
						</div>

						<div class="form-group">
							<label>Last Name</label> <input type="text" name="lastName"
								class="form-control" value="${user.lastName}" />
						</div>

						<div class="form-group">
							<label>Email</label> <input type="email" name="email"
								class="form-control" value="${user.email}" required />
						</div>

						<div class="form-group">
							<label>Contact Number</label> <input type="text"
								name="contactNumber" class="form-control"
								value="${user.contactNumber}" />
						</div>

						<div class="form-group">
							<label>Hourly Rate</label> <input type="number" step="0.01"
								name="hourlyRate" class="form-control"
								value="${user.hourlyRate}" />
						</div>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="usersList" class="btn btn-secondary">Cancel</a>

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