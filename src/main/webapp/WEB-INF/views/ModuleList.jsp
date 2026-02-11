<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Module List</title>

<jsp:include page="AdminCSS.jsp"></jsp:include>
</head>
<body>

<!-- Header -->
<jsp:include page="AdminHeader.jsp"></jsp:include>

<!-- Sidebar -->
<jsp:include page="AdminLeftSidebar.jsp"></jsp:include>

<!-- Main Content -->
<div class="content p-4">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3 class="mb-0">Module List</h3>
        <a href="newModule" class="btn btn-primary btn-sm">
            + New Module
        </a>
    </div>

    <!-- Empty State -->
    <c:if test="${empty moduleList}">
        <div class="alert alert-warning">
            No modules found.
        </div>
    </c:if>

    <!-- Module Table -->
    <c:if test="${not empty moduleList}">
        <div class="table-responsive">
            <table class="table table-bordered table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Module Name</th>
                        <th>Description</th>
                        <th>Project Name</th>
                        <th class="text-center">Actions</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="module" items="${moduleList}" varStatus="i">
                        <tr>
                            <td>${i.index + 1}</td>
                            <td>${module.moduleName}</td>
                            <td>${module.description}</td>
                            <td>${module.projectId}</td>
                            <td class="text-center">
                                <a href="viewModule?moduleId=${module.moduleId}" 
                                   class="btn btn-sm btn-info text-white">
                                    View
                                </a>
                                <a href="editModule?moduleId=${module.moduleId}" 
                                   class="btn btn-sm btn-warning">
                                    Edit
                                </a>
                                <a href="deleteModule?moduleId=${module.moduleId}" 
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('Are you sure you want to delete this module?')">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
    </c:if>

</div>

</body>
</html>
