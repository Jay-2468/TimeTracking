<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Module</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <jsp:include page="AdminCSS.jsp"></jsp:include>
</head>
<body class="bg-light">

<jsp:include page="AdminHeader.jsp"></jsp:include>

<jsp:include page="AdminSidebar.jsp"></jsp:include>

<div class="content">
    <div class="row justify-content-center align-items-center min-vh-100">
        <div class="col-12 col-sm-10 col-md-8 col-lg-6">

            <div class="card shadow">
                <div class="card-body p-4">
                    <h3 class="text-center mb-4">Create New Module</h3>

                    <form action="createModule" method="post">

                        <!-- Module Name -->
                        <div class="mb-3">
                            <label class="form-label">Module Name</label>
                            <input type="text" name="moduleName" class="form-control" required>
                        </div>

                        <!-- Description -->
                        <div class="mb-3">
                            <label class="form-label">Description</label>
                            <textarea name="description" class="form-control" rows="4" required></textarea>
                        </div>

                        <!-- Submit Button -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">
                                Create Module
                            </button>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
