<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
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
					<h2 class="text-dark font-weight-bold mb-4">Assign Project to
						Employee</h2>
				</div>


				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-dark-emphasis mb-4">Assign
							Project</h3>

						<form action="saveProjectAssignment" method="post">

							<!-- Select Project -->
							<div class="form-group">
								<label class="text-dark fw-semibold">Select Project</label> <select
									name="projectId"
									class="form-control text-dark border-secondary"
									onchange="loadUsers(this.value)" required>

									<option value="">-- Select Project --</option>

									<c:forEach items="${projects}" var="p">
										<option value="${p.projectId}">${p.projectName}</option>
									</c:forEach>

								</select>
							</div>

							<br>

							<!-- Select Employee -->
							<div class="form-group">
								<label class="text-dark fw-semibold">Select Project
									Manager</label> <select name="userId" id="userDropdown"
									class="form-control text-dark border-secondary" required>

									<option value="">-- Select Project Manager --</option>

								</select>
							</div>

							<br>

							<button type="submit" class="btn btn-primary">Assign
								Project</button>

						</form>

					</div>
				</div>

			</div>

			<!-- Footer -->
			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>

		</div>
	</div>

<script>
function loadUsers(projectId) {

    if (!projectId) return;

    fetch('/admin/getUsersByProject?projectId=' + projectId)
        .then(response => response.json())
        .then(data => {

            let userDropdown = document.getElementById("userDropdown");
            userDropdown.innerHTML = '<option value="">-- Select Project Manager --</option>';

            data.forEach(user => {
                let option = document.createElement("option");
                option.value = user.userId;
                option.text = user.firstName + " " + user.lastName;
                userDropdown.appendChild(option);
            });

        })
        .catch(error => console.error("Error:", error));
}
</script>
</body>
</html>