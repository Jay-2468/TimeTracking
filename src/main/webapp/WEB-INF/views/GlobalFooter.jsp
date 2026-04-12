<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<footer class="footer">
	<div class="footer-inner-wraper">
		<div
			class="d-sm-flex justify-content-center justify-content-sm-between">
			<span
				class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright
				© 2026 All rights reserved. </span> <span
				class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted
				& made with <i class="mdi mdi-heart text-danger"></i>
			</span>
		</div>
	</div>
</footer>

<!-- container-scroller -->
<!-- plugins:js -->
<script src="${path}/assets/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="${path}/assets/vendors/chart.js/chart.umd.js"></script>
<script
	src="${path}/assets/vendors/jquery-circle-progress/js/circle-progress.min.js"></script>
<script src="${path}/assets/js/jquery.cookie.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="${path}/assets/js/off-canvas.js"></script>
<script src="${path}/assets/js/hoverable-collapse.js"></script>
<script src="${path}/assets/js/misc.js"></script>
<script src="${path}/assets/js/settings.js"></script>
<script src="${path}/assets/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page -->
<script src="${path}/assets/js/dashboard.js"></script>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- DataTables -->
<script src="https://cdn.datatables.net/2.3.7/js/dataTables.js"></script>

<!-- Buttons -->
<script
	src="https://cdn.datatables.net/buttons/3.2.6/js/dataTables.buttons.js"></script>

<!-- Export dependencies -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>

<!-- Buttons features -->
<script
	src="https://cdn.datatables.net/buttons/3.2.6/js/buttons.html5.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/3.2.6/js/buttons.print.min.js"></script>

<!-- WebSocket -->
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>

<script>
// Datatable
let table = new DataTable('#myTable', {
	responsive : true,

	layout : {
		topStart : [ 'pageLength', {
			buttons: [
                { extend: 'copy', className: 'btn-copy' },
                { extend: 'csv', className: 'btn-csv' },
                { extend: 'excel', className: 'btn-excel' },
                { extend: 'pdf', className: 'btn-pdf' },
                { extend: 'print', className: 'btn-print' }
            ]
		} ],
		topEnd : 'search',
		bottomStart : 'info',
		bottomEnd : 'paging'
	}
});
	// Change Themes
    const themeStyle = document.getElementById("theme-style");
    const themeIcon = document.getElementById("themeIcon");
    const toggleBtn = document.getElementById("themeToggle");

    const darkQuery = window.matchMedia('(prefers-color-scheme: dark)');

    // Apply theme function
    function applyTheme(theme) {
        if (theme === "dark") {
            themeStyle.href = "${path}/assets/css/vertical-dark-layout/style.css";
            themeIcon.classList.remove("mdi-brightness-7");
            themeIcon.classList.add("mdi-brightness-2");
        } else {
            themeStyle.href = "${path}/assets/css/vertical-light-layout/style.css";
            themeIcon.classList.remove("mdi-brightness-2");
            themeIcon.classList.add("mdi-brightness-7");
        }
    }

    // Detect system theme
    function getSystemTheme() {
        return darkQuery.matches ? "dark" : "light";
    }

    // Initial load logic
    let savedTheme = localStorage.getItem("theme");

    if (savedTheme) {
        applyTheme(savedTheme); // user preference
    } else {
        applyTheme(getSystemTheme()); // system preference
    }

    // Toggle click (manual override)
    toggleBtn.addEventListener("click", () => {
        let currentTheme = localStorage.getItem("theme") || getSystemTheme();
        let newTheme = currentTheme === "dark" ? "light" : "dark";

        localStorage.setItem("theme", newTheme);
        applyTheme(newTheme);
    });

    // Auto-update when system theme changes
    darkQuery.addEventListener("change", (e) => {
        // Only apply if user has NOT overridden
        if (!localStorage.getItem("theme")) {
            applyTheme(e.matches ? "dark" : "light");
        }
    });
    //==================================================================================== 
    
    // Web Socket Connection
    /* var socket = new SockJS('/ws');
    var stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
    	console.log("Connected: " + frame);
        let userId = document.getElementById("userId").value;

        stompClient.subscribe('/topic/notifications/' + userId, function (notification) {

            let data = JSON.parse(notification.body);

            showNotification(data);
        });
    }); */
  	//==================================================================================== 
     
  	// Show Notifications (No Reload)
    /* function showNotification(data) {

        let container = document.getElementById("notificationContainer");

        let html = `
            <div class="notification">
                <strong>${data.title}</strong><br/>
                ${data.message}
            </div>
        `;

        container.innerHTML = html + container.innerHTML;

        // Optional: increase badge count
        let badge = document.getElementById("notificationCount");
        badge.innerText = parseInt(badge.innerText || 0) + 1;
    } */
</script>