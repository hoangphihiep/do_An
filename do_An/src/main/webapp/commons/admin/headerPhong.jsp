<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<div class="header" style="background-color: #3a4b59; padding: 20px; color: white; display: flex; align-items: center; justify-content: space-between; margin-left: -130px;">
    <nav style="margin-left: 200px;">
        <a href="/do_An/admin/chiTietKS/thongTinKhachSan" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Thông tin khách sạn</a>
        <a href="/do_An/admin/chiTietKS/tienIch" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Tiện nghi</a>
        <div class="dropdown">
            <a href="#" class="nav-link active" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Phòng</a>
            <div class="dropdown-content">
                <c:forEach items="${listPhong}" var="phong">
		            <a href="<c:url value='/admin/chiTietKS/phongKhachSan?idPhong=${phong.id}'/>" class="submenu-item" style="display: inline-block; text-decoration: none;">${phong.ten}</a> 
	       		</c:forEach>
            </div>
        </div>
        <a href="/do_An/admin/chiTietKS/anhKhachSan" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Ảnh khách sạn</a>
    </nav>
</div>

<style>
    /* CSS cho trạng thái "active" */
    .nav-link.active {
        background-color: #005bb5; /* Màu tô khi active */
        color: white;
    }
</style>

<script>
    // Lấy tất cả các liên kết trong thanh điều hướng
    const navLinks = document.querySelectorAll('.nav-link');

    // Lặp qua từng liên kết và thêm sự kiện click
    navLinks.forEach(link => {
        link.addEventListener('click', function() {
            // Loại bỏ lớp 'active' khỏi tất cả các liên kết
            navLinks.forEach(link => link.classList.remove('active'));
            // Thêm lớp 'active' vào liên kết được nhấn
            this.classList.add('active');
        });
    });
</script>