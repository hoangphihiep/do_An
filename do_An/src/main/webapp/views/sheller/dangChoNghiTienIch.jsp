<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/sheller/tienIch" method="post">
		<div style="font-family: Arial, sans-serif; color: #333; padding: 20px; background-color: #f7f7f7; width: 800px; margin: auto;">
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
		                <input type="checkbox" id="atm" name="atm">
		                <label for="atm" style="font-size: 14px;">Máy ATM/Ngân hàng</label><br>
		                <input type="checkbox" id="thammyvien" name="thammyvien">
		                <label for="thammyvien" style="font-size: 14px;">Thẩm mỹ viện</label><br>
		                <input type="checkbox" id="CHthucpham" name="CHthucpham">
		                <label for="CHthucpham" style="font-size: 14px;">Cửa hàng thực phẩm</label><br>
		                <input type="checkbox" id="Giacui" name="Giatui">
		                <label for="Giacui" style="font-size: 14px;">Giặt ủi</label><br>
		                <input type="checkbox" id="sieuthi" name="sieuthi">
		                <label for="sieuthi" style="font-size: 14px;">Siêu thị</label>
		            </div>
		        </div>
		        
		        <!-- Dịch vụ khách sạn -->
		        <div style="flex: 1; min-width: 300px;">
		            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Dịch vụ khách sạn</h4>
		            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
		                <input type="checkbox" id="reception-desk" name="reception-desk">
		                <label for="reception-desk" style="font-size: 14px;">Quầy lễ tân</label><br>
		                <input type="checkbox" id="DVGiacui" name="DVGiatui">
		                <label for="DVGiacui" style="font-size: 14px;">Dịch vụ giặt ủi</label><br>
		                <input type="checkbox" id="luuTruHanhLy" name="luuTruHanhLy">
		                <label for="luuTruHanhLy" style="font-size: 14px;">Dịch vụ lưu trữ/bảo quản hành lý</label><br>
		                <input type="checkbox" id="tour-assistance" name="tour-assistance">
		                <label for="tour-assistance" style="font-size: 14px;">Dịch vụ hỗ trợ đặt tour</label><br>
		                <input type="checkbox" id="leTan24h" name="leTan24h">
		                <label for="leTan24h" style="font-size: 14px;">Lễ tân 24h</label>
		            </div>
		        </div>
		        
		        <!-- Vận chuyển -->
		        <div style="flex: 1; min-width: 300px;">
		            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Vận chuyển</h4>
		            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
		                <input type="checkbox" id="duadonsanbay" name="duadonsanbay">
		                <label for="duadonsanbay" style="font-size: 14px;">Đưa đón sân bay</label><br>
		                <input type="checkbox" id="thuexehoi" name="thuexehoi">
		                <label for="thuexehoi" style="font-size: 14px;">Cho thuê xe hơi</label><br>
		                <input type="checkbox" id="baidauxe" name="baidauxe">
		                <label for="baidauxe" style="font-size: 14px;">Bãi đậu xe</label>
		            </div>
		        </div>
		        
		        <!-- Tiện nghi công cộng -->
		        <div style="flex: 1; min-width: 300px;">
		            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Tiện nghi công cộng</h4>
		            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
		                <input type="checkbox" id="nhahang" name="nhahang">
		                <label for="nhahang" style="font-size: 14px;">Nhà hàng</label><br>
		                <input type="checkbox" id="wifi" name="wifi">
		                <label for="wifi" style="font-size: 14px;">WiFi tại khu vực chung</label><br>
		                <input type="checkbox" id="elevator" name="elevator">
		                <label for="elevator" style="font-size: 14px;">Thang máy</label>
		            </div>
		        </div>
		        
		        <!-- Tiện nghi chung -->
		        <div style="flex: 1; min-width: 300px;">
		            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Tiện nghi chung</h4>
		            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
		                <input type="checkbox" id="maylanh" name="maylanh">
		                <label for="nmaylanh" style="font-size: 14px;">Máy lạnh</label><br>
		                <input type="checkbox" id="phonggd" name="phonggd">
		                <label for="phonggd" style="font-size: 14px;">Phòng gia đình</label><br>
		            </div>
		        </div>
		        
		        <!-- Ẩm thực -->
		        <div style="flex: 1; min-width: 300px;">
		            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Ẩm thực</h4>
		            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
		                <input type="checkbox" id="restaurant-meal" name="restaurant-meal">
		                <label for="restaurant-meal" style="font-size: 14px;">Bữa sáng</label><br>
		                <input type="checkbox" id="quaybar" name="quaybar">
		                <label for="quaybar" style="font-size: 14px;">Quầy bar</label>
		            </div>
		        </div>
		        
		        <!-- Kết nối mạng -->
		        <div style="flex: 1; min-width: 300px;">
		            <h4 style="font-size: 15px; font-weight: bold; margin-bottom: 5px;">Ẩm thực</h4>
		            <div style="border: 1px solid #ccc; padding: 10px; border-radius: 4px;">
		                <input type="checkbox" id="wififree" name="wififree">
		                <label for="wififree" style="font-size: 14px;">Wifi (miễn phí)</label><br>
		            </div>
		        </div>
		    </div>
		</div>
		<div style="max-width: 150px; margin: auto; padding: 20px;">
			<!-- Button submit để gửi form -->
			<button type="submit" style="display: block; background-color: #1a73e8; color: white; text-align: center; padding: 10px; font-size: 18px; font-weight: bold; text-decoration: none; border-radius: 5px; margin-top: 20px; cursor: pointer;">
				  Tiếp tục
			</button>
		</div>
	</form>
</body>
</html>