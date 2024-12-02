<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<div class="header" style="background-color: #003580; padding: 20px; color: white; display: flex; align-items: center; justify-content: space-between;">
    <nav style="margin-left: 245px;">
        <a href="/do_An/sheller/home" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Trang chủ Nhóm chỗ nghỉ</a>
        <a href="/do_An/sheller/danhSachDatPhong" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Đặt phòng</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Đánh giá</a>
        <a href="/do_An/sheller/doanhThu" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Doanh thu</a>
        <a href="/do_An/sheller/danhSachGiamGia" class="nav-link active" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Giảm giá</a>
        <a href="/do_An/sheller/danhSachKhuyenMai" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Khuyến mãi</a>
        <a href="/do_An/sheller/danhSachChiecKhau" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Chiếc khấu</a>
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