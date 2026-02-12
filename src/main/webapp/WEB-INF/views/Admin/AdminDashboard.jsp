<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="AdminCSS.jsp"></jsp:include>
</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<jsp:include page="AdminLeftSidebar.jsp"></jsp:include>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<h2 class="text-dark font-weight-bold mb-2">Overview dashboard</h2>
					<div class="row">
						<div class="col-md-12">
							<div class="tab-content tab-transparent-content">
								<div class="tab-pane fade show active" id="business-1"
									role="tabpanel" aria-labelledby="business-tab">
									<div class="row">
										<div
											class="col-xl-3 col-lg-6 col-sm-6 grid-margin stretch-card">
											<div class="card">
												<div class="card-body text-center">
													<h5 class="mb-2 text-dark font-weight-normal">Orders</h5>
													<h2 class="mb-4 text-dark font-weight-bold">932.00</h2>
													<div
														class="dashboard-progress dashboard-progress-1 d-flex align-items-center justify-content-center item-parent">
														<i
															class="mdi mdi-lightbulb icon-md absolute-center text-dark"></i>
													</div>
													<p class="mt-4 mb-0">Completed</p>
													<h3 class="mb-0 font-weight-bold mt-2 text-dark">5443</h3>
												</div>
											</div>
										</div>
										<div
											class="col-xl-3 col-lg-6 col-sm-6 grid-margin stretch-card">
											<div class="card">
												<div class="card-body text-center">
													<h5 class="mb-2 text-dark font-weight-normal">Unique
														Visitors</h5>
													<h2 class="mb-4 text-dark font-weight-bold">756,00</h2>
													<div
														class="dashboard-progress dashboard-progress-2 d-flex align-items-center justify-content-center item-parent">
														<i
															class="mdi mdi-account-circle icon-md absolute-center text-dark"></i>
													</div>
													<p class="mt-4 mb-0">Increased since yesterday</p>
													<h3 class="mb-0 font-weight-bold mt-2 text-dark">50%</h3>
												</div>
											</div>
										</div>
										<div
											class="col-xl-3  col-lg-6 col-sm-6 grid-margin stretch-card">
											<div class="card">
												<div class="card-body text-center">
													<h5 class="mb-2 text-dark font-weight-normal">Impressions</h5>
													<h2 class="mb-4 text-dark font-weight-bold">100,38</h2>
													<div
														class="dashboard-progress dashboard-progress-3 d-flex align-items-center justify-content-center item-parent">
														<i class="mdi mdi-eye icon-md absolute-center text-dark"></i>
													</div>
													<p class="mt-4 mb-0">Increased since yesterday</p>
													<h3 class="mb-0 font-weight-bold mt-2 text-dark">35%</h3>
												</div>
											</div>
										</div>
										<div
											class="col-xl-3 col-lg-6 col-sm-6 grid-margin stretch-card">
											<div class="card">
												<div class="card-body text-center">
													<h5 class="mb-2 text-dark font-weight-normal">Followers</h5>
													<h2 class="mb-4 text-dark font-weight-bold">4250k</h2>
													<div
														class="dashboard-progress dashboard-progress-4 d-flex align-items-center justify-content-center item-parent">
														<i class="mdi mdi-cube icon-md absolute-center text-dark"></i>
													</div>
													<p class="mt-4 mb-0">Decreased since yesterday</p>
													<h3 class="mb-0 font-weight-bold mt-2 text-dark">25%</h3>
												</div>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<jsp:include page="AdminFooter.jsp"></jsp:include>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>

</body>
</html>
