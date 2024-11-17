<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/do_An/assets/frontend/layout/css/style.css" rel="stylesheet">

<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="/do_An/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="/do_An/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<script src="/do_An/Content/js/sweetalert2.min.js"></script>
</head>
<body>
	<div class="layout fullPage">
		<!-- Begin Header -->
		<%@ include file="/commons/sheller/navbar.jsp"%>
		<!-- End Header -->

		<div class="main">
			<!-- Begin content -->
			<sitemesh:write property="body" />
			<!-- End content -->
		</div>
	</div>
	
	<script src="/do_An/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="/do_An/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
	<script src="/do_An/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/do_An/assets/frontend/layout/scripts/back-to-top1.js" type="text/javascript"></script>
	<script src="/do_An/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="/do_An/assets/global/plugins/select2/select2.min.js"></script>
	<script type="text/javascript" src="/do_An/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/do_An/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script src="/do_An/assets/frontend/layout/scripts/layout1.js" type="text/javascript"></script>
	<script src="/do_An/assets/admin/layout2/scripts/demo.js" type="text/javascript"></script>
	<script src="/do_An/assets/global/scripts/metronic1.js" type="text/javascript"></script>
	<script src="/do_An/assets/admin/pages/scripts/table-managed.js"></script>
	<script>
		jQuery(document).ready(function() {       
		   	Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
		   	TableManaged.init();
		});
	</script>
</body>
</html>