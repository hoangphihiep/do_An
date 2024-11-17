<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<div class="header" style="background-color: #003580; padding: 20px; color: white; display: flex; align-items: center; justify-content: space-between;">
    <nav style="margin-left: 100px;">
        <a href="#" class="nav-link active" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Trang chủ Nhóm chỗ nghỉ</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Đặt phòng</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Đánh giá</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Tài chính</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Chỉnh sửa đồng loạt</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Trung tâm Cơ hội dành cho Nhóm chỗ nghỉ</a>
        <a href="#" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Phân tích</a>
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