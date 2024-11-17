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
</head>
<body>
	<form action="${pageContext.request.contextPath}/sheller/sua/tienIch" method="post">
		<div style="font-family: Arial, sans-serif; color: #333; padding: 20px; background-color: #fff;; width: 800px; margin: 50px auto; margin-left: -56px;">
		    <!-- Phần tiêu đề -->
		    <h2 style="color: #0071c2; font-size: 18px; font-weight: bold; margin-bottom: 10px;">Tiện nghi</h2>
		    <h3 style="font-size: 16px; font-weight: bold; margin-bottom: 5px;">Có gì độc đáo và tuyệt vời về chỗ nghỉ của quý đối tác</h3>
		    <p style="font-size: 14px; color: #666; margin-bottom: 20px;">Mỗi phòng nhà đều có nét độc đáo riêng. Hãy cho chúng tôi biết tại sao phòng và nhà của quý đối tác lại nổi bật.</p>
		    
		    <!-- Các nhóm tiện nghi -->
		    	<div style="display: flex; flex-wrap: wrap; gap: 20px;">
			        <!-- Tiện ích lân cận -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Tiện ích lân cận</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="atm" name="atm" ${atm == true ? 'checked' : ''}>
			                <label for="atm" style="font-size: 14px;">Máy ATM/Ngân hàng</label><br>
			                <input type="checkbox" id="thammyvien" name="thammyvien" ${thammyvien == true ? 'checked' : ''}>
			                <label for="thammyvien" style="font-size: 14px;">Thẩm mỹ viện</label><br>
			                <input type="checkbox" id="CHthucpham" name="CHthucpham" ${CHthucpham == true ? 'checked' : ''}>
			                <label for="CHthucpham" style="font-size: 14px;">Cửa hàng thực phẩm</label><br>
			                <input type="checkbox" id="Giacui" name="Giatui" ${Giatui == true ? 'checked' : ''}>
			                <label for="Giacui" style="font-size: 14px;">Giặt ủi</label><br>
			                <input type="checkbox" id="sieuthi" name="sieuthi" ${sieuthi == true ? 'checked' : ''}>
			                <label for="sieuthi" style="font-size: 14px;">Siêu thị</label>
			            </div>
			        </div>
			        
			        <!-- Dịch vụ khách sạn -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Dịch vụ khách sạn</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="reception-desk" name="reception-desk" ${reception_desk == true ? 'checked' : ''}>
			                <label for="reception-desk" style="font-size: 14px;">Quầy lễ tân</label><br>
			                <input type="checkbox" id="DVGiacui" name="DVGiatui" ${DVGiatui == true ? 'checked' : ''}>
			                <label for="DVGiacui" style="font-size: 14px;">Dịch vụ giặt ủi</label><br>
			                <input type="checkbox" id="luuTruHanhLy" name="luuTruHanhLy" ${luuTruHanhLy == true ? 'checked' : ''}>
			                <label for="luuTruHanhLy" style="font-size: 14px;">Dịch vụ lưu trữ/bảo quản hành lý</label><br>
			                <input type="checkbox" id="tour-assistance" name="tour-assistance" ${tour_assistance == true ? 'checked' : ''}>
			                <label for="tour-assistance" style="font-size: 14px;">Dịch vụ hỗ trợ đặt tour</label><br>
			                <input type="checkbox" id="leTan24h" name="leTan24h" ${leTan24h == true ? 'checked' : ''}>
			                <label for="leTan24h" style="font-size: 14px;">Lễ tân 24h</label>
			            </div>
			        </div>
			        
			        <!-- Vận chuyển -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Vận chuyển</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="duadonsanbay" name="duadonsanbay" ${duadonsanbay == true ? 'checked' : ''}>
			                <label for="duadonsanbay" style="font-size: 14px;">Đưa đón sân bay</label><br>
			                <input type="checkbox" id="thuexehoi" name="thuexehoi" ${thuexehoi == true ? 'checked' : ''}>
			                <label for="thuexehoi" style="font-size: 14px;">Cho thuê xe hơi</label><br>
			                <input type="checkbox" id="baidauxe" name="baidauxe" ${baidauxe == true ? 'checked' : ''}>
			                <label for="baidauxe" style="font-size: 14px;">Bãi đậu xe</label>
			            </div>
			        </div>
			        
			        <!-- Tiện nghi công cộng -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Tiện nghi công cộng</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="nhahang" name="nhahang" ${nhahang == true ? 'checked' : ''}>
			                <label for="nhahang" style="font-size: 14px;">Nhà hàng</label><br>
			                <input type="checkbox" id="wifi" name="wifi" ${wifi == true ? 'checked' : ''}>
			                <label for="wifi" style="font-size: 14px;">WiFi tại khu vực chung</label><br>
			                <input type="checkbox" id="elevator" name="elevator" ${elevator == true ? 'checked' : ''}>
			                <label for="elevator" style="font-size: 14px;">Thang máy</label>
			            </div>
			        </div>
			        
			        <!-- Tiện nghi chung -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Tiện nghi chung</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="maylanh" name="maylanh" ${maylanh == true ? 'checked' : ''}>
			                <label for="nmaylanh" style="font-size: 14px;">Máy lạnh</label><br>
			                <input type="checkbox" id="phonggd" name="phonggd" ${phonggd == true ? 'checked' : ''}>
			                <label for="phonggd" style="font-size: 14px;">Phòng gia đình</label><br>
			            </div>
			        </div>
			        
			        <!-- Ẩm thực -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Ẩm thực</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="restaurant-meal" name="restaurant-meal" ${buasang == true ? 'checked' : ''}>
			                <label for="restaurant-meal" style="font-size: 14px;">Bữa sáng</label><br>
			                <input type="checkbox" id="quaybar" name="quaybar" ${quaybar == true ? 'checked' : ''}>
			                <label for="quaybar" style="font-size: 14px;">Quầy bar</label>
			            </div>
			        </div>
			        
			        <!-- Kết nối mạng -->
			        <div style="flex: 1; min-width: 300px;">
			            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Tiện ích khác</h4>
			            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
			                <input type="checkbox" id="wififree" name="wififree" ${wififree == true ? 'checked' : ''}>
			                <label for="wififree" style="font-size: 14px;">Wifi (miễn phí)</label><br>
			            </div>
			        </div>
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
                	window.location.href = '<%= request.getContextPath() %>/sheller/suaChoNghi/tienIch';
                } else if (result.isDismissed) {
                    // Chuyển hướng khi nhấn "No"
                    window.location.href = '<%= request.getContextPath() %>/sheller/home';
                }
            });
        <% } %>
    </script>
</body>
</html>