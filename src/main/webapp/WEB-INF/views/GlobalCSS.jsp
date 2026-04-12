<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- plugins:css -->
<link rel="stylesheet"
	href="${path}/assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="${path}/assets/vendors/flag-icon-css/css/flag-icons.min.css">
<link rel="stylesheet"
	href="${path}/assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="${path}/assets/vendors/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${path}/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link id="theme-style" rel="stylesheet"
	href="${path}/assets/css/vertical-light-layout/style.css">
<!-- End layout styles -->
<link rel="shortcut icon" href="${path}/assets/images/favicon.png" />

<!-- DataTable CSS -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.3.7/css/dataTables.dataTables.css" />

<!-- Button CSS -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/3.2.6/css/buttons.dataTables.css" />

<style>
body {
	transition: all 0.3s ease;
}

.btn-copy, .btn-csv, .btn-excel, .btn-pdf, .btn-print {
	color: white !important;
	border-radius: 5px !important;
	border: none !important;
}

/* Individual colors */
.btn-copy {
	background-color: #2196F3 !important;
}

.btn-csv {
	background-color: #FF9800 !important;
}

.btn-excel {
	background-color: #4CAF50 !important;
}

.btn-pdf {
	background-color: #F44336 !important;
}

.btn-print {
	background-color: #9C27B0 !important;
}

/* ===== DATATABLE TEXT COLORS ===== */
/* Whole table text */
#myTable {
	color: #494949 !important;
}

/* Length dropdown */
.dt-length label, .dt-length select {
	color: #494949 !important;
}

/* Search */
.dt-search label, .dt-search input {
	color: #494949 !important;
	border-color: #494949 !important;
}

/* Info text */
.dt-info {
	color: #494949 !important;
}

/* Active page */
.dt-paging .dt-paging-button .current {
	background-color: #C2C2C2 !important;
	color: #fff !important;
}
</style>