<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/do_An/Content/js/sweetalert2.min.js"></script>
</head>
<body>
	<div class="layout fullPage">
		<!-- Begin Header -->
		<%@ include file="/commons/sheller/header.jsp"%>
		<!-- End Header -->

		<div class="main">
			<!-- Begin content -->
			<sitemesh:write property="body" />
			<!-- End content -->
		</div>
	</div>
</body>
</html>