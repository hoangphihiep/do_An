<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Thêm thư viện SweetAlert -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
    <div style="width: 100%; max-width: 400px; padding: 20px; margin: 50px auto; background-color: white; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);">
        <!-- Form Title -->
        <h2 style="font-size: 20px; color: #333; margin-bottom: 5px;">Bạn muốn là đối tác của chúng tôi</h2>
        <!-- Form -->
        <form action="${pageContext.request.contextPath }/sheller/dangKy" method="post">
            <label for="email" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Địa chỉ email</label>
            <input type="email" id="email" name="email" value="${email}" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 14px; margin-bottom: 20px;" required>
            
            <label for="password" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Mật khẩu</label>
            <div style="position: relative;">
                <input type="password" id="password" name="password" value="" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 14px; margin-bottom: 20px;" required>
                <span onclick="togglePassword()" style="position: absolute; right: 10px; top: 33%; transform: translateY(-50%); cursor: pointer;">👁️</span>
            </div>
            
            <label for="Repassword" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Xác nhận lại mật khẩu</label>
            <input type="password" id="Repassword" name="Repassword" value="" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 14px; margin-bottom: 20px;" required>
            
            <!-- Continue Button -->
            <button type="submit" style="width: 100%; padding: 10px; background-color: #0071c2; color: white; border: none; border-radius: 5px; font-size: 16px; font-weight: bold; cursor: pointer; margin-bottom: 20px;">Tiếp tục</button>
        </form>
    </div>
    
    <script>
        function togglePassword() {
            const passwordField = document.getElementById("password");
            if (passwordField.type === "password") {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }
        
     	// Kiểm tra biến isSuccess và hiển thị SweetAlert nếu đăng ký thành công
        <% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
            Swal.fire({
                title: 'Giờ bạn là đối tác của chúng tôi!',
                text: 'Hãy đăng ký khách sạn của bạn!',
                icon: 'success',
                confirmButtonText: 'OK'
            }).then((result) => {
                if (result.isConfirmed) {
                    // Chuyển hướng sau khi nhấn OK
                    window.location.href = '<%= request.getContextPath() %>/sheller/dangChoNghi/ThongTinCoBan';
                }
            });
        <% } %>
    </script>
</body>
</html>
