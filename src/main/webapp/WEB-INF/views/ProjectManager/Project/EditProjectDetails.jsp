<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Project Details</title>
<jsp:include page="../../GlobalCSS.jsp"></jsp:include>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../includes/PMHeader.jsp"></jsp:include>

	<div class="container-fluid page-body-wrapper">
		<!-- Sidebar -->
		<jsp:include page="../includes/PMLeftSidebar.jsp"></jsp:include>

		<!-- Main Content -->
		<div class="main-panel">
			<div class="content-wrapper">
				<h2 class="text-dark font-weight-bold mb-2">Edit User Details</h2>

				<!-- Page Main Content -->
				<div class="container mt-4">

					<h2>Edit Project</h2>

					<form action="updateProject" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="projectId" value="${project.projectId}" />

						<div class="form-group">
							<label>Project Name</label> <input type="text" name="projectName"
								class="form-control" value="${project.projectName}" required />
						</div>

						<div class="form-group">
							<label>Description</label>
							<textarea name="description" class="form-control">${project.description}</textarea>
						</div>

						<!-- Manager -->
						<%-- <div class="form-group">
							<label>Manager</label> <select name="manager.userId"
								class="form-control">
								<c:forEach var="u" items="${users}">
									<option value="${u.userId}"
										${u.userId == project.manager.userId ? 'selected' : ''}>
										${u.firstName} ${u.lastName}</option>
								</c:forEach>
							</select>
						</div> --%>

						<!-- Priority -->
						<%-- <div class="form-group">
							<label>Priority</label> <select name="priority"
								class="form-control">
								<c:forEach var="p" items="${priorities}">
									<option value="${p}"
										${p.toString() == project.priority.toString() ? 'selected' : ''}>
										${p}</option>
								</c:forEach>
							</select>
						</div> --%>

						<!-- Dates -->
						<div class="form-group">
							<label>Start Date</label> <input type="date" name="startDate"
								class="form-control" value="${project.startDate}" />
						</div>

						<div class="form-group">
							<label>End Date</label> <input type="date" name="endDate"
								class="form-control" value="${project.endDate}" />
						</div>

						<!-- Estimated Hours -->
						<%-- <div class="form-group">
            <label>Estimated Hours</label>
            <input type="number" name="estimatedHours"
                class="form-control" value="${project.estimatedHours}" />
        </div> --%>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="listProjects" class="btn btn-secondary">Cancel</a>

					</form>

				</div>

				<!-- partial:partials/_footer.html -->
				<jsp:include page="../../GlobalFooter.jsp"></jsp:include>
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
</body>
</html>