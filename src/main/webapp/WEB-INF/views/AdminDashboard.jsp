<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        body {
            overflow-x: hidden;
        }
        .sidebar {
            min-height: 100vh;
            background-color: #212529;
        }
        .sidebar a {
            color: #ffffff;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #343a40;
        }
    </style>
</head>

<body>

<div class="container-fluid">
    <div class="row">

        <!-- Sidebar -->
        <nav class="col-md-3 col-lg-2 d-md-block sidebar p-3">
            <h4 class="text-white text-center mb-4">Admin Panel</h4>

            <ul class="nav flex-column">
                <li class="nav-item mb-2">
                    <a class="nav-link text-white" href="#">
                        <i class="bi bi-speedometer2 me-2"></i> Dashboard
                    </a>
                </li>

                <li class="nav-item mb-2">
                    <a class="nav-link text-white" href="users">
                        <i class="bi bi-people me-2"></i> Manage Users
                    </a>
                </li>

                <li class="nav-item mb-2">
                    <a class="nav-link text-white" href="projects">
                        <i class="bi bi-kanban me-2"></i> Projects
                    </a>
                </li>

                <li class="nav-item mb-2">
                    <a class="nav-link text-white" href="reports">
                        <i class="bi bi-bar-chart me-2"></i> Reports
                    </a>
                </li>

                <li class="nav-item mb-2">
                    <a class="nav-link text-white" href="settings">
                        <i class="bi bi-gear me-2"></i> Settings
                    </a>
                </li>

                <li class="nav-item mt-4">
                    <a class="nav-link text-danger" href="logout">
                        <i class="bi bi-box-arrow-right me-2"></i> Logout
                    </a>
                </li>
            </ul>
        </nav>

        <!-- Main Content -->
        <main class="col-md-9 col-lg-10 ms-sm-auto px-4 py-4 bg-light">
            <h2 class="mb-4">Dashboard</h2>

            <!-- Stats Cards -->
            <div class="row g-3 mb-4">
                <div class="col-sm-6 col-lg-3">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h6>Total Users</h6>
                            <h3>120</h3>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-lg-3">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h6>Total Projects</h6>
                            <h3>35</h3>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-lg-3">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h6>Active Tasks</h6>
                            <h3>87</h3>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-lg-3">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h6>Pending Reports</h6>
                            <h3>5</h3>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Welcome Section -->
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5>Welcome, Admin 👋</h5>
                    <p class="text-muted">
                        Use the navigation menu on the left to manage users, projects, and reports.
                    </p>
                </div>
            </div>

        </main>

    </div>
</div>

</body>
</html>
