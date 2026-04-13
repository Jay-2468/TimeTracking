<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
				<h2 class="text-dark font-weight-bold mb-2">Overview Dashboard</h2>

				<!-- Page Main Content -->
				<div class="container mt-4">

					<h2>Edit Module</h2>

					<form action="updateModule" method="post">

						<!-- Hidden ID -->
						<input type="hidden" name="moduleId" value="${module.moduleId}" />

						<!-- Module Name -->
						<div class="form-group">
							<label>Module Name</label> <input type="text" name="moduleName"
								class="form-control" value="${module.moduleName}" required />
						</div>

						<!-- Project Dropdown -->
						<div class="form-group">
							<label>Project</label> <select name="project.projectId"
								class="form-control">
								<c:forEach var="p" items="${projects}">
									<option value="${p.projectId}"
										${p.projectId == module.project.projectId ? 'selected' : ''}>
										${p.projectName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Description -->
						<div class="form-group">
							<label>Description</label>
							<textarea name="description" class="form-control">${module.description}</textarea>
						</div>

						<button type="submit" class="btn btn-success">Update</button>
						<a href="listModules" class="btn btn-secondary">Cancel</a>

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