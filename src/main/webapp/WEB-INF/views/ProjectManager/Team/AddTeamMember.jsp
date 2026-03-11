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

				<h2 class="text-dark font-weight-bold mb-4">Add Team Member</h2>

				<div class="card">
					<div class="card-body">

						<form action="saveTeamMember" method="post">

							<div class="form-group">
								<label>Select Project</label> <select name="projectId"
									class="form-control">
									<option value="">-- Select Project --</option>

									<c:forEach items="${projects}" var="p">
										<option value="${p.projectId}">${p.projectName}</option>
									</c:forEach>

								</select>
							</div>

							<div class="form-group">
								<label>Select Developer</label> <select name="userId"
									class="form-control">
									<option value="">-- Select Developer --</option>

									<c:forEach items="${developers}" var="d">
										<option value="${d.userId}">${d.firstName}
											${d.lastName}</option>
									</c:forEach>

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

</body>
</html>