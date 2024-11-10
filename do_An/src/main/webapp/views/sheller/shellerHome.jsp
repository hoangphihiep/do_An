<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0;">
    <div class="header" style="background-color: #003580; padding: 20px; color: white; display: flex; align-items: center; justify-content: space-between;">
        <nav>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px; background-color: #0071c2;">Trang chủ Nhóm chỗ nghỉ</a>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Đặt phòng</a>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Đánh giá</a>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Tài chính</a>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Chỉnh sửa đồng loạt</a>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Trung tâm Cơ hội dành cho Nhóm chỗ nghỉ</a>
            <a href="#" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px;">Phân tích</a>
        </nav>
    </div>
    <div style="max-width: 1200px; margin: auto; padding: 20px;">
        <div style="font-size: 24px; font-weight: bold; margin-bottom: 10px;">Trang chủ Nhóm chỗ nghỉ</div>
        <div style="color: #666; font-size: 14px;">Chỗ nghỉ chưa có trên Booking.com (3)</div>
        <p>Phát triển kinh doanh bằng cách thêm các chỗ nghỉ này vào nền tảng du lịch trực tuyến lớn nhất thế giới, Booking.com.</p>
        <button style="background-color: #0071c2; color: white; padding: 10px 20px; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; float: right;">Thêm chỗ nghỉ mới</button>
        
        <div style="width: 100%; background-color: white; border-radius: 8px; overflow: hidden; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); margin-top: 20px;">
            <div style="display: flex; align-items: center; padding: 15px 10px; border-bottom: 1px solid #eaeaea; background-color: #f9f9f9; font-weight: bold; color: #333;">
                <div style="flex: 2; text-align: left;">Tên</div>
                <div style="flex: 1; text-align: center;">Vị trí</div>
                <div style="flex: 1; text-align: center;">Tiến trình đăng ký</div>
                <div style="flex: 1; text-align: center;">Hành động</div>
            </div>
            <div style="display: flex; align-items: center; padding: 15px 10px; border-bottom: 1px solid #eaeaea;">
                <div style="flex: 2; display: flex; align-items: center;">
                    <img src="house-icon.png" alt="Icon" style="width: 32px; height: 32px; margin-right: 10px;">Chỗ nghỉ chưa đặt tên
                </div>
                <div style="flex: 1; text-align: center;">Việt Nam</div>
                <div style="flex: 1; text-align: center;">
                    <div style="width: 60%; background-color: #eaeaea; height: 10px; border-radius: 5px; overflow: hidden; display: inline-block;">
                        <div style="width: 10%; background-color: #d9534f; height: 100%;"></div>
                    </div>
                    10%
                </div>
                <div style="flex: 1; text-align: center;">
                    <a href="#" style="color: #0071c2; text-decoration: none; margin-right: 15px;">Tiếp tục đăng ký</a>
                    <span style="color: #d9534f; cursor: pointer;">Xóa</span>
                </div>
            </div>
            <div style="display: flex; align-items: center; padding: 15px 10px; border-bottom: 1px solid #eaeaea;">
                <div style="flex: 2; display: flex; align-items: center;">
                    <img src="house-icon.png" alt="Icon" style="width: 32px; height: 32px; margin-right: 10px;">Chỗ nghỉ chưa đặt tên
                </div>
                <div style="flex: 1; text-align: center;">Việt Nam</div>
                <div style="flex: 1; text-align: center;">
                    <div style="width: 60%; background-color: #eaeaea; height: 10px; border-radius: 5px; overflow: hidden; display: inline-block;">
                        <div style="width: 10%; background-color: #d9534f; height: 100%;"></div>
                    </div>
                    10%
                </div>
                <div style="flex: 1; text-align: center;">
                    <a href="#" style="color: #0071c2; text-decoration: none; margin-right: 15px;">Tiếp tục đăng ký</a>
                    <span style="color: #d9534f; cursor: pointer;">Xóa</span>
                </div>
            </div>
            <div style="display: flex; align-items: center; padding: 15px 10px; border-bottom: 1px solid #eaeaea;">
                <div style="flex: 2; display: flex; align-items: center;">
                    <img src="villa-icon.png" alt="Icon" style="width: 32px; height: 32px; margin-right: 10px;">VilaHome
                </div>
                <div style="flex: 1; text-align: center;">Việt Nam</div>
                <div style="flex: 1; text-align: center;">
                    <div style="width: 60%; background-color: #eaeaea; height: 10px; border-radius: 5px; overflow: hidden; display: inline-block;">
                        <div style="width: 90%; background-color: #5cb85c; height: 100%;"></div>
                    </div>
                    90%
                </div>
                <div style="flex: 1; text-align: center;">
                    <a href="#" style="color: #0071c2; text-decoration: none; margin-right: 15px;">Tiếp tục đăng ký</a>
                    <span style="color: #d9534f; cursor: pointer;">Xóa</span>
                </div>
            </div>
        </div>

        <div style="margin-top: 20px; display: flex; align-items: center;">
            <input type="text" style="width: 100%; padding: 10px; border: 1px solid #eaeaea; border-radius: 5px; font-size: 14px;" placeholder="Lọc theo ID chỗ nghỉ, tên hoặc vị trí">
        </div>

        <div style="display: flex; margin-top: 20px; font-size: 14px;">
            <div style="padding: 10px; cursor: pointer; color: #0071c2; margin-right: 10px; border-bottom: 2px solid #0071c2; font-weight: bold;">Hoạt động</div>
            <div style="padding: 10px; cursor: pointer; color: #0071c2; margin-right: 10px;">Hiệu suất</div>
            <div style="padding: 10px; cursor: pointer; color: #0071c2; margin-right: 10px;">Cài đặt</div>
        </div>
    </div>
</body>
</html>