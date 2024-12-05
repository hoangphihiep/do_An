<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Registration</title>
</head>
<body style="margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #003580; color: white;">

    <!-- Header Section -->
    <div style="background-color: #003580; color: white; padding: 20px; display: flex; justify-content: space-between; align-items: center;">
        <h1 style="font-size: 24px; margin: 0;">UTEBooking</h1>
        <div style="display: flex; gap: 10px; align-items: center;">
	        <!-- Flag Icon -->
	        <div style="width: 30px; height: 30px; background-color: red; border-radius: 50%; display: flex; justify-content: center; align-items: center;">
	            <span style="font-size: 20px; color: yellow;">★</span>
	        </div>
	        <!-- Help Button -->
	        <button style="background-color: #0071c2; color: white; border: none; padding: 5px 15px; border-radius: 5px; cursor: pointer;">
	            Trợ giúp
	        </button>
	    </div>
    </div>

    <!-- Main Content Section -->
    <div style="display: flex; justify-content: center; align-items: center; height: 80vh;">
        <!-- Left Content -->
        <div style="flex: 1; padding-left: 50px;">
            <h2 style="font-size: 50px; font-weight: bold; color: white; line-height: 1.2;">
                Đăng bất cứ chỗ nghỉ nào trên UTEBooking
            </h2>
            <p style="font-size: 20px; color: white; max-width: 500px; line-height: 1.5;">
                Dù host là nghề tay trái hay công việc toàn thời gian, hãy đăng nhà của bạn ngay hôm nay và nhanh chóng có thêm nguồn thu nhập.
            </p>
        </div>

        <!-- Registration Form Section -->
        <div style="background-color: white; color: #333; padding: 30px; width: 350px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); margin-right: 50px;">
            <h3 style="font-size: 22px; font-weight: bold; color: #333; margin-top: 0; margin-bottom: 15px;">Đăng ký miễn phí</h3>
            <ul style="padding: 0; list-style-type: none; margin: 0 0 20px 0;">
                <li style="display: flex; align-items: center; margin-bottom: 10px;">
                    <span style="color: green; font-size: 20px; margin-right: 10px;">✔</span>
                    45% host nhận được đơn đặt đầu tiên trong vòng 1 tuần
                </li>
                <li style="display: flex; align-items: center; margin-bottom: 10px;">
                    <span style="color: green; font-size: 20px; margin-right: 10px;">✔</span>
                    Chọn một trong hai cách nhận đơn đặt: xác nhận tức thì và xem trước để duyệt
                </li>
                <li style="display: flex; align-items: center; margin-bottom: 10px;">
                    <span style="color: green; font-size: 20px; margin-right: 10px;">✔</span>
                    Chúng tôi xử lý thanh toán thay Quý vị
                </li>
            </ul>
            <a style="background-color: #0071c2; color: white; padding: 12px; width: 35%; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; display: inline-block; text-decoration: none;"
            href="${pageContext.request.contextPath }/sheller1/dangKy">
                Bắt đầu ngay →
            </a>
            <p style="font-size: 14px; color: #333; margin-top: 15px;">
                Quý vị đã bắt đầu quá trình đăng ký? 
                <a href="#" style="color: #0071c2; text-decoration: none;">Tiếp tục các bước đăng ký</a>
            </p>
        </div>
    </div>

    <!-- Footer Section -->
    <div style="background-color: #f8f8f8; padding: 20px; text-align: center; font-size: 14px; color: #333;">
        <a href="#" style="margin: 0 10px; color: #0071c2; text-decoration: none;">An tâm đăng chỗ nghỉ</a> |
        <a href="#" style="margin: 0 10px; color: #0071c2; text-decoration: none;">Nổi bật ngay từ đầu</a> |
        <a href="#" style="margin: 0 10px; color: #0071c2; text-decoration: none;">Tiếp cận nguồn khách toàn cầu, có tính đặc trưng</a> |
        <a href="#" style="margin: 0 10px; color: #0071c2; text-decoration: none;">Chia sẻ từ các host khác</a> |
        <a href="#" style="margin: 0 10px; color: #0071c2; text-decoration: none;">Giải đáp thắc mắc</a>
    </div>

</body>
</html>