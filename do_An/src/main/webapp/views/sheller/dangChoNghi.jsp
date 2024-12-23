<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	<form action="${pageContext.request.contextPath}/sheller/thongTinCoBan" method="post">
		<div style="max-width: 800px; margin: 50px auto; padding: 20px; background-color: #fff; border: 1px solid #ddd; border-radius: 8px;">
		    <h2 style="font-size: 20px; color: #0071c2; margin-bottom: 10px;">Thông tin cơ bản</h2>
		    <p style="font-size: 16px; color: #333; margin-bottom: 20px;">Giúp bạn tiếp cận đối tượng khách hàng phù hợp nhất.</p>
			<!-- Chọn loại chổ nghỉ -->
		    <div style="margin-bottom: 20px;">
		        <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Chọn loại chổ nghỉ</h3>
		        <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Đánh giá giúp khách hàng hình dung cụ thể về nơi ở</p>
		        <select name="accommodationType" style="width: 43%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
		            <option value="">-- Chọn khách sạn --</option>
				    <c:forEach items="${listloaiks}" var="loaiks">
				        <option value="${loaiks.ten}">${loaiks.ten}</option>
				    </c:forEach>
		        </select>
		    </div>
		    
		    <!-- Đặt tên cho khách sạn -->
			<div style="margin-bottom: 20px;">
			    <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Đặt tên cho chổ nghỉ</h3>
			    <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Hãy chọn tên nghe hấp dẫn và thu hút.</p>
			    <label for="hotel-name" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Đặt tên:</label>
	    		<input type="text" id="hotel-name" name="hotel-name" style="width: 70%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
			</div>
	
		
		    <!-- Mô tả nhà của bạn -->
		    <div style="margin-bottom: 20px;">
		        <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Mô tả chổ nghỉ của bạn</h3>
		        <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Những đặc điểm nổi bật của chổ nghỉ để thu hút du khách</p>
		        <input type="text" id="moTa" name="moTa" style="width: 80%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
		    </div>
		    
		    <!-- Phần vị trí của bạn -->
		    <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Vị trí của bạn</h4>
		    <p style="font-size: 13px; color: #666; margin-bottom: 15px;">Khách hàng chỉ nhận được địa chỉ cụ thể một khi đã xác nhận phòng</p>
		    
		    <!-- Ô nhập địa chỉ -->
		    <label for="address" style="display: block; font-size: 14px; font-weight: bold; margin-bottom: 5px;">Địa chỉ :</label>
		    <input type="text" id="address" name="address" style="width: 80%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; margin-bottom: 20px;" required>
		    
		    <!-- Tên thành phố và tỉnh -->
		    <div style="display: flex; gap: 20px;">
		        <div style="flex: 1;">
		            <label for="city" style="display: block; font-size: 14px; font-weight: bold; margin-bottom: 5px;">Tên thành phố</label>
		            <select id="city" name="city" style="width: 20%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
		               	<option value="">-- Chọn địa điểm --</option>
					    <c:forEach items="${listdiadiem}" var="diadiem">
					        <option value="${diadiem.ten}">${diadiem.ten}</option>
					    </c:forEach>
		            </select>
		        </div>
		    </div>
		
		    <!-- Thông tin có ích -->
		    <div style="display: flex; justify-content: space-between; margin-bottom: 20px;">
		        <div style="flex: 1; margin-right: 10px;">
		            <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Thông tin có ích</h3>
		            <label for="distance-city" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Cách trung tâm</label>
		            <input type="text" id="distance-city" name="distance-city" style="width: 60%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
		            <span style="font-size: 14px; color: #666; margin-left: 5px; margin-top: 5px;">km</span>
		        </div>
		        <div style="flex: 1; margin-left: -50px; margin-top: 6px;">
		            <label for="distance-airport" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px; margin-top: 35px;">Giáp biển</label>
		            <select name="giapBien" style="width: 43%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
			            <option value="" selected hidden>Chọn trả lời</option>
			            <option value="1">Có</option>
			            <option value="0">Không</option>
		        	</select>
		        </div>
		    </div>
		
		    <!-- Xếp loại sao -->
		    <div style="margin-bottom: 20px;">
		        <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Xếp loại sao</h3>
		        <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Đánh giá giúp khách hàng hình dung cụ thể về nơi ở</p>
		        <select name="danhGia" style="width: 43%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; " required>
		            <option value="" selected hidden>Chọn xếp loại sao</option>
		            <option value="1">1 Sao</option>
		            <option value="2">2 Sao</option>
		            <option value="3">3 Sao</option>
		            <option value="4">4 Sao</option>
		            <option value="5">5 Sao</option>
		        </select>
		    </div>
		    <div style="max-width: 150px; margin: auto; padding: 20px;">
				<!-- Button submit để gửi form -->
				<button type="submit" style="display: block; background-color: #1a73e8; color: white; text-align: center; padding: 10px; font-size: 18px; font-weight: bold; text-decoration: none; border-radius: 5px; margin-top: 20px; cursor: pointer;">
				   Tiếp tục
				</button>
			</div>
		</div>	
	</form>
	
</body>
</html>