<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px; color: #333;">
	
	<form action="${pageContext.request.contextPath}/sheller/sua/thongTinCoBan" method="post">
		<div style="max-width: 800px; margin: 50px auto; padding: 20px; background-color: #fff; border: 1px solid #ddd; border-radius: 8px; margin-left: -56px;">
		    <h2 style="font-size: 20px; color: #0071c2; margin-bottom: 10px;">Thông tin cơ bản</h2>
		    <p style="font-size: 16px; color: #333; margin-bottom: 20px;">Giúp bạn tiếp cận đối tượng khách hàng phù hợp nhất.</p>
			<!-- Chọn loại chổ nghỉ -->
		    <div style="margin-bottom: 20px;">
		        <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Chọn loại chổ nghỉ</h3>
		        <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Đánh giá giúp khách hàng hình dung cụ thể về nơi ở</p>
		        <select name="accommodationType" style="width: 43%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
		            <option value="Khách sạn" ${ks.tenLoaiKhachSan == 'Khách sạn' ? 'selected' : ''}>Khách sạn</option>
				    <option value="Biệt thự" ${ks.tenLoaiKhachSan == 'Biệt thự' ? 'selected' : ''}>Biệt thự</option>
				    <option value="Resort" ${ks.tenLoaiKhachSan == 'Resort' ? 'selected' : ''}>Resort</option>
				    <option value="Nhà khách" ${ks.tenLoaiKhachSan == 'Nhà khách' ? 'selected' : ''}>Nhà khách</option>
				    <option value="Nhà trọ" ${ks.tenLoaiKhachSan == 'Nhà trọ' ? 'selected' : ''}>Nhà trọ</option>
				    <option value="Căn hộ" ${ks.tenLoaiKhachSan == 'Căn hộ' ? 'selected' : ''}>Căn hộ</option>
		        </select>
		    </div>
		    
		    <!-- Đặt tên cho khách sạn -->
			<div style="margin-bottom: 20px;">
			    <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Đặt tên cho chổ nghỉ</h3>
			    <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Hãy chọn tên nghe hấp dẫn và thu hút.</p>
			    <label for="hotel-name" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Đặt tên:</label>
	    		<input type="text" id="hotel-name" name="hotel-name" value="${ks.ten}" style="width: 70%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
			</div>
	
		
		    <!-- Mô tả nhà của bạn -->
		    <div style="margin-bottom: 20px;">
		        <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Mô tả chổ nghỉ của bạn</h3>
		        <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Những đặc điểm nổi bật của chổ nghỉ để thu hút du khách</p>
		        <input type="text" id="moTa" name="moTa" value="${ks.moTa}" style="width: 80%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
		    </div>
		    
		    <!-- Phần vị trí của bạn -->
		    <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Vị trí của bạn</h4>
		    <p style="font-size: 13px; color: #666; margin-bottom: 15px;">Khách hàng chỉ nhận được địa chỉ cụ thể một khi đã xác nhận phòng</p>
		    
		    <!-- Ô nhập địa chỉ -->
		    <label for="address" style="display: block; font-size: 14px; font-weight: bold; margin-bottom: 5px;">Địa chỉ :</label>
		    <input type="text" id="address" name="address" value="${ks.diaChi}" style="width: 80%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px; margin-bottom: 20px;">
		    
		    <!-- Tên thành phố và tỉnh -->
		    <div style="display: flex; gap: 20px;">
		        <div style="flex: 1;">
		            <label for="city" style="display: block; font-size: 14px; font-weight: bold; margin-bottom: 5px;">Tên địa điểm</label>
		            <select id="city" name="city" style="width: 20%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
		                <option value="Hà Nội" ${ks.tenDiaDiem == 'Hà Nội' ? 'selected' : ''}>Hà Nội</option>
		                <option value="TP. Hồ Chí Minh" ${ks.tenDiaDiem == 'TP. Hồ Chí Minh' ? 'selected' : ''}>TP. Hồ Chí Minh</option>
		                <option value="Đà Nẵng" ${ks.tenDiaDiem == 'Đà Nẵng' ? 'selected' : ''}>Đà Nẵng</option>
		                <option value="Đà Lạt" ${ks.tenDiaDiem == 'Đà Lạt' ? 'selected' : ''}>Đà Lạt</option>
		                <option value="Hội An" ${ks.tenDiaDiem == 'Hội An' ? 'selected' : ''}>Hội An</option>
		                <option value="Phú Quốc" ${ks.tenDiaDiem == 'Phú Quốc' ? 'selected' : ''}>Phú Quốc</option>
		                <option value="Sapa" ${ks.tenDiaDiem == 'Sapa' ? 'selected' : ''}>Sapa</option>
		                <option value="Huế" ${ks.tenDiaDiem == 'Huế' ? 'selected' : ''}>Huế</option>
		                <option value="Nha Trang" ${ks.tenDiaDiem == 'Nha Trang' ? 'selected' : ''}>Nha Trang</option>
		                <option value="Buôn Ma Thuột" ${ks.tenDiaDiem == 'Buôn Ma Thuột' ? 'selected' : ''}>Buôn Ma Thuột</option>
		                <option value="Đồng Nai" ${ks.tenDiaDiem == 'Đồng Nai' ? 'selected' : ''}>Đồng Nai</option>
		            </select>
		        </div>
		    </div>
		
		    <!-- Thông tin có ích -->
		    <div style="display: flex; justify-content: space-between; margin-bottom: 20px;">
		        <div style="flex: 1; margin-right: 10px;">
		            <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Thông tin có ích</h3>
		            <label for="distance-city" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px;">Cách trung tâm</label>
		            <input type="text" id="distance-city" name="distance-city" value="${ks.cachTrungTam}" style="width: 60%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
		            <span style="font-size: 14px; color: #666; margin-left: 5px; margin-top: 5px;">km</span>
		        </div>
		        <div style="flex: 1; margin-left: -50px; margin-top: 6px;">
		            <label for="distance-airport" style="display: block; font-size: 14px; color: #333; margin-bottom: 5px; margin-top: 35px;">Giáp biển</label>
		            <select name="giapBien" style="width: 43%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
			            <option value="1" ${ks.giapBien == true ? 'selected' : ''}>Có</option>
			            <option value="0" ${ks.giapBien == false ? 'selected' : ''}>Không</option>
		        	</select>
		        </div>
		    </div>
		
		    <!-- Xếp loại sao -->
		    <div style="margin-bottom: 20px;">
		        <h3 style="font-size: 16px; font-weight: bold; color: #333; margin-bottom: 5px;">Xếp loại sao</h3>
		        <p style="font-size: 14px; color: #666; margin-bottom: 10px;">Đánh giá giúp khách hàng hình dung cụ thể về nơi ở</p>
		        <select name="danhGia" style="width: 43%; padding: 8px; font-size: 14px; border: 1px solid #ccc; border-radius: 4px;">
		            <option value="1" ${ks.danhGia == 1 ? 'selected' : ''}>1 Sao</option>
		            <option value="2" ${ks.danhGia == 2 ? 'selected' : ''}>2 Sao</option>
		            <option value="3" ${ks.danhGia == 3 ? 'selected' : ''}>3 Sao</option>
		            <option value="4" ${ks.danhGia == 4 ? 'selected' : ''}>4 Sao</option>
		            <option value="5" ${ks.danhGia == 5 ? 'selected' : ''}>5 Sao</option>
		        </select>
		    </div>
		</div>	
		<div style="max-width: 150px; margin-left: 280px; padding: 20px; margin-top: -70px;">
			<!-- Button submit để gửi form -->
			<button type="submit" style="display: block; background-color: #1a73e8; color: white; text-align: center; padding: 10px; font-size: 18px; font-weight: bold; text-decoration: none; border-radius: 5px; cursor: pointer;">
			   Sửa
			</button>
		</div>
	</form>
	<script>
        <% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
            Swal.fire({
                title: 'Bạn đã chỉnh sửa thành công!',
                text: 'Bạn có muốn chỉnh sửa tiếp không?',
                icon: 'success',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes',
                cancelButtonText: 'No'
            }).then((result) => {
                if (result.isConfirmed) {
                    // Chuyển hướng khi nhấn "Yes"
                	window.location.href = '<%= request.getContextPath() %>/sheller/suaChoNghi/ThongTinCoBan';
                } else if (result.isDismissed) {
                    // Chuyển hướng khi nhấn "No"
                    window.location.href = '<%= request.getContextPath() %>/sheller/home';
                }
            });
        <% } %>
    </script>
</body>
</html>