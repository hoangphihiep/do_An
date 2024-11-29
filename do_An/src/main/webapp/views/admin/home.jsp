<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/do_An/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="/do_An/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="/do_An/assets/admin/layout2/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="/do_An/assets/admin/layout2/css/themes/grey.css" rel="stylesheet" type="text/css" id="style_color"/>
</head>
<body>
	<%@ include file="/commons/sheller/navbar.jsp"%>
	<div class="page-sidebar navbar-collapse collapse">
		<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu "
			data-keep-expanded="false" data-auto-scroll="true"
			data-slide-speed="200">
			<li class="start active ">
				<a href="index.html"> <i class="icon-home"></i> 
					<span class="title">Tài khoản</span> 
					<span class="selected"></span>
				</a>
			</li>
			<li>
				<a href="javascript:;"> <i class="icon-basket"></i> 
					<span class="title">Khách sạn</span> 
					<span class="arrow "></span>
				</a>
			</li>
			<li>
				<a href="javascript:;"> <i class="icon-rocket"></i> 
					<span class="title">Đặt phòng</span> 
					<span class="arrow "></span>
				</a>
			</li>
			<li>
				<a href="javascript:;"> <i class="icon-diamond"></i> 
					<span class="title">Chiếc khấu</span> 
					<span class="arrow "></span>
				</a>
			</li>
			<li>
				<a href="javascript:;"> <i class="icon-puzzle"></i> 
					<span class="title">Khuyến mãi</span> 
					<span class="arrow "></span>
				</a>
			</li>
			<li>
				<a href="javascript:;"> <i class="icon-settings"></i> 
					<span class="title">Danh mục</span> 
					<span class="arrow "></span>
				</a>
			</li>
		</ul>
	</div>
	
</body>
</html>