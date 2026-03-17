<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item nav-category">Main</li>
		<li class="nav-item"><a class="nav-link" href="/pm-dashboard">
				<span class="icon-bg"><i class="mdi mdi-cube menu-icon"></i></span>
				<span class="menu-title">Dashboard</span>
		</a></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageProjects"
			aria-expanded="false" aria-controls="manageProjects"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">View Projects</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageProjects">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/pm/projectsList">List Projects</a></li>
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
					<li class="nav-item"><a class="nav-link" href="/pm/newModule">Create
							New Module</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/pm/modulesList">List Modules</a></li>
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
					<li class="nav-item"><a class="nav-link" href="/pm/newTask">Add
							New Task</a></li>
					<li class="nav-item"><a class="nav-link" href="/pm/tasksList">List
							Tasks</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTeam" aria-expanded="false"
			aria-controls="manageTeam"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">Manage Team</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTeam">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/pm/addTeamMember">Add Team Members</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/pm/viewTeamMembers">View Team Members</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageDevelopers"
			aria-expanded="false" aria-controls="manageDevelopers"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">View Developers</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageDevelopers">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/pm/developersList">List Developers</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTimeLogs"
			aria-expanded="false" aria-controls="manageTimeLogs"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">View Time Logs</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTimeLogs">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/pm/timeLogsList">List Time Logs</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTimeSheets"
			aria-expanded="false" aria-controls="manageTimeSheets"> <span
				class="icon-bg"><i class="mdi mdi-crosshairs-gps menu-icon"></i></span>
				<span class="menu-title">Time Sheets</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTimeSheets">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/pm/timesheetsList">List Time Sheets</a></li>
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
					<li class="nav-item"><a class="nav-link"
						href="/pm/createReport">Generate Reports</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/pm/reportsList">List Reports</a></li>
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
						href="/pm/createNotification">Send Notification</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/pm/notificationsList">List Notifications</a></li>
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
				<a href="/pm/logout" class="nav-link"><i
					class="mdi mdi-logout menu-icon"></i> <span class="menu-title">Log
						Out</span></a>
			</div>
		</li>
	</ul>
</nav>