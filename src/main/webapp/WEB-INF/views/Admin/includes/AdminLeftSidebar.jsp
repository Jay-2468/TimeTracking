<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item nav-category">Main</li>
		<li class="nav-item"><a class="nav-link" href="/"> <span
				class="icon-bg"><i class="mdi mdi-cube menu-icon"></i></span> <span
				class="menu-title">Dashboard</span>
		</a></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageUsers" aria-expanded="false"
			aria-controls="manageUsers"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Users</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageUsers">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/newUser">Add
							New User</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/usersList">List
							Users</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/updateRole">Update
							User Role</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageProjects"
			aria-expanded="false" aria-controls="manageProjects"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">Manage Projects</span> <i
				class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageProjects">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/newProject">Add
							New Project</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/projectsList">List
							Projects</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/assignProject">Assign
							Projects</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageModules" aria-expanded="false"
			aria-controls="manageModules"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Modules</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageModules">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/newModule">Create
							New Module</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/modulesList">List
							Modules</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTasks" aria-expanded="false"
			aria-controls="manageTasks"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Tasks</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTasks">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/newTask">Add
							New Task</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/tasksList">List
							Tasks</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTimeLogs"
			aria-expanded="false" aria-controls="manageTimeLogs"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">Manage Time Logs</span> <i
				class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTimeLogs">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/createTimeLog">Add
							New Time Log</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/timeLogsList">List
							Time Logs</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTimesheets"
			aria-expanded="false" aria-controls="manageTimesheets"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">Manage Timesheets</span> <i
				class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTimesheets">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/admin/createTimesheet">Add New Timesheet</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/timesheetsList">List
							Timesheets</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#managePayroll" aria-expanded="false"
			aria-controls="managePayroll"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Payroll</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="managePayroll">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/generatePayroll">Create
							Payroll</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/payrollRecords">List
							Payrolls</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageInvoice" aria-expanded="false"
			aria-controls="manageInvoice"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Invoice</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageInvoice">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/generateInvoice">Generate
							Invoices</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/invoiceList">List
							Invoices</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageReports" aria-expanded="false"
			aria-controls="manageReports"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Reports</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageReports">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link" href="/admin/generateReport">Generate
							Reports</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/listReports">List
							Reports</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageNotifications"
			aria-expanded="false" aria-controls="manageNotifications"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">Manage Notifications</span> <i
				class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageNotifications">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/admin/createNotification">Send Notification</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/admin/notificationsList">List Notifications</a></li>
				</ul>
			</div></li>

		<li class="nav-item sidebar-user-actions">
			<div class="user-details">
				<div class="d-flex justify-content-between align-items-center">
					<div>
						<div class="d-flex align-items-center">
							<div class="sidebar-profile-img">
								<c:if test="${not empty sessionScope.user.profilePictureURL}">
									<img src="${sessionScope.user.profilePictureURL}" alt="image"
										width=31 height=31>
								</c:if>

								<c:if test="${empty sessionScope.user.profilePictureURL}">
									<img src="../../../assets/images/faces/face28.png" alt="image"
										width=31 height=31>
								</c:if>
							</div>
							<div class="sidebar-profile-text">
								<p class="mb-1">${user.firstName}</p>
							</div>
						</div>
					</div>
					<div class="badge badge-danger">3</div>
				</div>
			</div>
		</li>
		<li class="nav-item sidebar-user-actions">
			<div class="sidebar-user-menu">
				<a href="#" class="nav-link"><i
					class="mdi mdi-weather-sunny menu-icon"></i> <span
					class="menu-title">Settings</span> </a>
			</div>
		</li>
		<li class="nav-item sidebar-user-actions">
			<div class="sidebar-user-menu">
				<a href="#" class="nav-link"><i
					class="mdi mdi-speedometer menu-icon"></i> <span class="menu-title">Take
						Tour</span></a>
			</div>
		</li>
		<li class="nav-item sidebar-user-actions">
			<div class="sidebar-user-menu">
				<a href="/admin/logout" class="nav-link"><i
					class="mdi mdi-logout menu-icon"></i> <span class="menu-title">Log
						Out</span></a>
			</div>
		</li>
	</ul>
</nav>