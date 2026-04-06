<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../../GlobalCSS.jsp"></jsp:include>

<style>
body {
	background: #f4f6f9;
}

.form-container {
	background: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>

	<jsp:include page="../includes/PMHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">

		<jsp:include page="../includes/PMLeftSidebar.jsp"></jsp:include>

		<div class="main-panel">
			<div class="content-wrapper">

				<div class="d-flex justify-content-between align-items-center mb-3">
					<h2 class="text-dark font-weight-bold mb-4">Add Team Member</h2>
					<a href="viewTeamMembers" class="btn btn-secondary btn-sm">
						Back to View Members </a>
				</div>


				<div class="card">
					<div class="card-body">
						<h3 class="mb-3 text-center text-dark-emphasis">Add New Team
							Member</h3>

						<form action="saveTeamMember" method="post">

							<div class="form-group">
								<label class="text-dark fw-semibold">Select Project</label> <select
									name="projectId"
									class="form-control text-dark border-secondary"
									onchange="loadUsers(this.value)">
									
									<option value="">-- Select Project --</option>

									<c:forEach items="${projects}" var="p">
										<option value="${p.project.projectId}">${p.project.projectName}</option>
									</c:forEach>

								</select>
							</div>

							<div class="form-group">
								<label class="text-dark fw-semibold">Select Developer</label> <select
									name="userId" id="userDropdown"
									class="form-control text-dark border-secondary" required>
									
									<option value="">-- Select Developer --</option>

								</select>
							</div>

							<br>

							<button type="submit" class="btn btn-primary">Add Member
							</button>

						</form>

					</div>
				</div>

			</div>

			<jsp:include page="../../GlobalFooter.jsp"></jsp:include>

		</div>
	</div>

	<script>
function loadUsers(projectId) {

    if (!projectId) return;

    fetch('/pm/getUsersByProject?projectId=' + projectId)
        .then(response => response.json())
        .then(data => {

            let userDropdown = document.getElementById("userDropdown");
            userDropdown.innerHTML = '<option value="">-- Select Developer --</option>';

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