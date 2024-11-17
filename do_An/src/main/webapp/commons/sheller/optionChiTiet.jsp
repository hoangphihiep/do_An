<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>	
<!-- BEGIN SIDEBAR -->
<div class="sidebar">
    <a href="/do_An/sheller/suaChoNghi/ThongTinCoBan" class="sidebar-item">
        <i style="mask: url('icon-home.svg') no-repeat center;"></i>
        <span>Thông tin khách sạn</span>
    </a>
    <a href="/do_An/sheller/suaChoNghi/tienIch" class="sidebar-item">
        <i style="mask: url('icon-basket.svg') no-repeat center;"></i>
        <span>Tiện nghi khách sạn</span>
    </a>
    <div class="sidebar-item">
        <i style="mask: url('icon-diamond.svg') no-repeat center;"></i>
        <span>Phòng của khách sạn</span>
        <div class="submenu">
	        <c:forEach items="${listPhong}" var="phong">
		            <a href="<c:url value='/sheller/suaChoNghi/phong?idPhong=${phong.id}'/>" class="submenu-item">${phong.ten}</a> 
	        </c:forEach>
        </div>   
    </div>
    <a href="/do_An/sheller/suaChoNghi/anhKhachSan" class="sidebar-item">
        <i style="mask: url('icon-diamond.svg') no-repeat center;"></i>
        <span>Ảnh khách sạn</span>
    </a>
</div>