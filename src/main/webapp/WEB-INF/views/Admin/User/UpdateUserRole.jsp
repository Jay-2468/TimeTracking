<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User Role</title>

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
					<h2 class="text-dark font-weight-bold mb-2">Update User Role</h2>
					<a href="usersList" class="btn btn-secondary btn-sm"> Back to
						Users </a>
				</div>

				<div class="card shadow-sm">
					<div class="card-body">
						<h3 class="mb-3 text-center text-dark-emphasis">Update User
							Role</h3>

						<form action="updateUserRole" method="post">

							<div class="row">

								<!-- Select User -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Select User</label> <select
										name="userId" id="userSelect" class="form-select text-dark border-secondary" required>

										<option value="">-- Select User --</option>

										<c:forEach items="${usersList}" var="user">
											<option value="${user.userId}" data-role="${user.role}">
												${user.firstName} ${user.lastName}</option>
										</c:forEach>

									</select>
								</div>

								<!-- Current Role (Readonly Display) -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">Current Role</label> <input
										type="text" id="currentRole" class="form-control text-dark border-secondary" readonly>
								</div>

								<!-- New Role -->
								<div class="col-md-6 mb-3">
									<label class="form-label text-dark fw-semibold">New Role</label> <select
										name="newRole" class="form-select text-dark border-secondary" required>
										<option value="">-- Select New Role --</option>
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
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>
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
