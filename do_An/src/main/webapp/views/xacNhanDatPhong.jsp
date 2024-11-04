<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body >
	<div style="font-family: Arial, sans-serif; color: #333; line-height: 1.6; max-width: 600px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 8px;">
		<form action="${pageContext.request.contextPath}/xacNhan" method="POST">
			<h2 style="text-align: center; color: #333;">Bạn kiểm tra lại thông tin trước khi xác nhận.</h2>	    
		    <h3 style="color: #8a8a5c;">Thông tin khách hàng</h3>
		    <p><strong>Họ và tên:</strong> ${hovaten}</p>
		    <p><strong>Email:</strong> ${email}</p>
		    <p><strong>Số điện thoại:</strong> ${phone}</p>
		    <p><strong>Tên phòng:</strong> ${tenPhong}</p>
		    <p><strong>Ngày nhận phòng:</strong> ${ngayDen}</p>
		    <p><strong>Ngày trả phòng:</strong> ${ngayDi}</p>
		    <p><strong>Số lượng phòng đặt:</strong> ${slphongdat}</p>
			<p><strong>Tông tiền:</strong> ${thanhTien}</p>
		    
		    <h3 style="color: #8a8a5c; margin-top: 30px;">Yêu cầu đặc biệt</h3>
		    <p>${specialRequests}</p>
		    
		    <h3 style="color: #8a8a5c; margin-top: 30px;">Thanh toán</h3>
		    <c:if test="${payment == 'Thanh toán khi nhận phòng' }">
				<p>Bây giờ bạn đã xác nhận và đảm bảo đặt phòng và thanh toán khi nhận phòng. Tất cả các khoản thanh toán phải được thực hiện tại khách sạn trong thời gian lưu trú của bạn, trừ khi có quy định khác trong chính sách khách sạn hoặc trong điều kiện phòng.</p>
		    	<p><strong>Khách sạn này chấp nhận các hình thức thanh toán sau:</strong></p>
		    	<p>MoMo</p>
			</c:if>     
		    <h3 style="color: #8a8a5c; margin-top: 30px;">Đừng quên</h3>
		    <p>Bạn có thể thay đổi hoặc hủy đặt chỗ của mình thông qua lịch sử đặt phòng của chúng tôi.</p>
		    <p style="margin-top: 20px;">Chúng tôi chúc bạn có một kỳ nghỉ vui vẻ!</p>
		
			<button style="background-color: #33b5e5; color: white; padding: 10px 20px; border-radius: 20px; font-weight: bold; margin-left: 220px;">
	            Xác nhận
	        </button>
		</form>
	</div>
</body>
</html>