<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<title>PrimeFaces</title>
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/bootstrap.min.css" />
<!-- // -->
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/style.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/font.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/carousel.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/style2.css" />

<!--<link href="https://fonts.googleapis.com/css?family=Quicksand&amp;display=swap" rel="stylesheet"/>-->

</head>
<body>
	<!-- Layout section -->
	<div class="layout fullPage">
		<!-- Begin Header -->
		<%@ include file="/commons/user/header.jsp"%>
		<!-- End Header -->

		<div class="main">
			<!-- Begin content -->
			<sitemesh:write property="body" />
			<!-- End content -->
		</div>
		
		<!-- Begin Footer -->
		<%@ include file="/commons/user/footer.jsp"%>
		<!-- End Footer -->
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/do_An/Content/js/bootstrap.min.js"></script>
	<script src="/do_An/Content/js/carousel.js"></script>
	<script src="/do_An/Content/js/range.js"></script>
	<!-- Thêm Bootstrap JS và jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wnumb/1.1.0/wNumb.min.js"></script>
    <script>
	    $(window).on("load", function() {
	        const urlParams = new URLSearchParams(window.location.search);
	        if (urlParams.get("showLoginModal") === "true") {
	            const modalElement = $("#dangnhap");
	            modalElement.modal("show");
	            
	            // Kiểm tra và ép buộc hiển thị modal nếu cần
	            modalElement.find(".modal-dialog").css("display", "block");
	            modalElement.removeClass("fade");
	        }
	    });

	</script>
	<script>
		$(window).on("load", function() {
		    const urlParams = new URLSearchParams(window.location.search);
		    if (urlParams.get("showRegisterModal") === "true") {
		    	const modalElement = $("#dangky");
		        modalElement.modal("show");
		    	
		        modalElement.find(".modal-dialog").css("display", "block");
	            modalElement.removeClass("fade");
		    }
		});
	</script>
	<script>
		$(window).on("load", function() {
		    const urlParams = new URLSearchParams(window.location.search);
		    if (urlParams.get("showForgotPassword") === "true") {
		    	const modalElement = $("#quenMatKhau");
		        modalElement.modal("show");
		    	
		        modalElement.find(".modal-dialog").css("display", "block");
	            modalElement.removeClass("fade");
		    }
		});
	</script>
	<script>
		$(window).on("load", function() {
		    const urlParams = new URLSearchParams(window.location.search);
		    if (urlParams.get("showOTP") === "true") {
		    	const modalElement = $("#xacThucOTP");
		        modalElement.modal("show");
		    	
		        modalElement.find(".modal-dialog").css("display", "block");
	            modalElement.removeClass("fade");
		    }
		});
	</script>
	<script>
		$(window).on("load", function() {
		    const urlParams = new URLSearchParams(window.location.search);
		    if (urlParams.get("showResetPassword") === "true") {
		    	const modalElement = $("#capNhatMatKhau");
		        modalElement.modal("show");
		    	
		        modalElement.find(".modal-dialog").css("display", "block");
	            modalElement.removeClass("fade");
		    }
		});
	</script>
</body>
</html>