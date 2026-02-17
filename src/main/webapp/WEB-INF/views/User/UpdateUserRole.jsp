<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User Role</title>

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
				<h2 class="text-dark font-weight-bold mb-2">Update User Role</h2>

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h3 class="mb-0">Update User Role</h3>
					<a href="usersList" class="btn btn-secondary btn-sm"> Back to
						Users </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">

						<form action="updateUserRole" method="post">

							<div class="row">

								<!-- Select User -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Select User</label> <select
										name="userId" id="userSelect" class="form-select" required>

										<option value="">-- Select User --</option>

										<c:forEach items="${usersList}" var="user">
											<option value="${user.userId}" data-role="${user.role}">
												${user.firstName} ${user.lastName}</option>
										</c:forEach>

									</select>
								</div>

								<!-- Current Role (Readonly Display) -->
								<div class="col-md-6 mb-3">
									<label class="form-label">Current Role</label> <input
										type="text" id="currentRole" class="form-control" readonly>
								</div>

								<!-- New Role -->
								<div class="col-md-6 mb-3">
									<label class="form-label">New Role</label> <select
										name="newRole" class="form-select" required>
										<option value="">-- Select New Role --</option>
										<!-- <option value="ADMIN">Admin</option>
										<option value="PROJECT_MANAGER">Project Manager</option>
										<option value="DEVELOPER">Developer</option> -->
										<c:forEach items="${userRole}" var="role">
											<option value="${role}">${role}</option>
										</c:forEach>
									</select>
								</div>

							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary">Update
									Role</button>
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

	<!-- Script to Show Current Role -->
	<script>
		document.getElementById("userSelect").addEventListener(
				"change",
				function() {

					let selectedOption = this.options[this.selectedIndex];
					let role = selectedOption.getAttribute("data-role");

					document.getElementById("currentRole").value = role ? role
							: "";
				});
	</script>

</body>
</html>
