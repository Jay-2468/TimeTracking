<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="sidebar sidebar-offcanvas" id="sidebar">
	<ul class="nav">
		<li class="nav-item nav-category">Main</li>
		<li class="nav-item"><a class="nav-link"
			href="/developer-dashboard"> <span class="icon-bg"><i
					class="mdi mdi-cube menu-icon"></i></span> <span class="menu-title">Dashboard</span>
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
						href="/developer/projectsList">List Projects</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTasks" aria-expanded="false"
			aria-controls="manageTasks"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">View Tasks</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTasks">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/developer/tasksList">List Tasks</a></li>
				</ul>
			</div></li>

		<li class="nav-item"><a class="nav-link"
			data-bs-toggle="collapse" href="#manageTeams" aria-expanded="false"
			aria-controls="manageTeams"> <span class="icon-bg"><i
					class="mdi mdi-crosshairs-gps menu-icon"></i></span> <span
				class="menu-title">View Team</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="manageTeams">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="/developer/viewTeamMembers">View Team Members</a></li>
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
					<li class="nav-item"><a class="nav-link"
						href="/developer/createTimeLog">Add New Time Log</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/developer/timeLogsList">List Time Logs</a></li>
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
						href="/developer/createTimesheet">Add New Timesheet</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/developer/timesheetsList">List Timesheets</a></li>
				</ul>
			</div></li>

		<li class="nav-item sub-menu"><a class="nav-link"
			href="/developer/viewNotifications"> <span class="icon-bg"><i
				class="mdi mdi-crosshairs-gps menu-icon"></i></span><span class="menu-title">View
				Notifications</span></a></li>

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