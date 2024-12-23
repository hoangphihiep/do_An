<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/sheller/dangNhap" method="post">
		<div style="width: 400px; padding: 20px; margin: 50px auto; border: 1px solid #ddd; border-radius: 8px; background-color: #fff; box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);">
		    <h2 style="font-size: 20px; color: #333; margin: 0 0 20px; text-align: center;">Đăng nhập để quản lý chỗ nghỉ</h2>
		    
		    <label for="username" style="display: block; font-size: 14px; color: #555; margin-bottom: 8px;">Tên đăng nhập</label>
		    <input type="text" id="username" name="username" placeholder="Tên đăng nhập" style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ccc; border-radius: 4px; margin-bottom: 20px; box-sizing: border-box;">
		    
		    <label for="password" style="display: block; font-size: 14px; color: #555; margin-bottom: 8px;">Mật khẩu</label>
		    <input type="text" id="password" name="password" placeholder="Mật khẩu" style="width: 100%; padding: 10px; font-size: 16px; border: 1px solid #ccc; border-radius: 4px; margin-bottom: 20px; box-sizing: border-box;">
		    
		    <button type="submit" style="width: 100%; padding: 12px; font-size: 16px; color: #fff; background-color: #0071c2; border: none; border-radius: 4px; cursor: pointer;">
		        Đăng nhập
		    </button>
		    
		    <p style="font-size: 14px; color: #0071c2; text-align: center; margin: 20px 0;">
		        <a href="#" style="color: #0071c2; text-decoration: none;">Quý vị gặp trở ngại khi đăng nhập?</a>
		    </p>
		
		    <p style="font-size: 14px; color: #333; text-align: center; margin-bottom: 20px;">
		        Quý vị có thắc mắc về chỗ nghỉ của mình hay extranet? Hãy ghé thăm <a href="#" style="color: #0071c2; text-decoration: none;">Trung tâm Trợ giúp Đối tác</a> để tìm hiểu thêm.
		    </p>
		</div>
	</form>
	<script>
     	// Kiểm tra biến isSuccess và hiển thị SweetAlert nếu đăng ký thành công
        <% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
            Swal.fire({
                title: 'Bạn đăng nhập thành công',
                text: 'Hãy tới trang quản lý của bạn!',
                icon: 'success',
                confirmButtonText: 'OK'
            }).then((result) => {
                if (result.isConfirmed) {
                    // Chuyển hướng sau khi nhấn OK
                    window.location.href = '<%= request.getContextPath() %>/waiting';
                }
            });
        <% } else if (Boolean.FALSE.equals(request.getAttribute("isSuccess"))) { %>
            Swal.fire({
                text: '<%= request.getAttribute("alertMsg") %>',
                title: 'Đăng nhập thất bại!',
                icon: 'error',
                confirmButtonText: 'OK'
            });
        <% } %>
    </script>
</body>
</html>