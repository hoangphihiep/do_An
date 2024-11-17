<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0;">
    
    <%@ include file="/commons/sheller/header.jsp"%>
    
    <div style="max-width: 1200px; margin: auto; padding: 20px;">
        <div style="font-size: 24px; font-weight: bold; margin-bottom: 10px;">Trang chủ Nhóm chỗ nghỉ</div>
        <button style="background-color: #0071c2; margin-top: -10px; color: white; padding: 10px 20px; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; float: right;">Thêm chỗ nghỉ mới</button>
        <div style="color: #666; font-size: 14px;">Chỗ nghỉ chưa có trên Booking.com (3)</div>
        
        <p>Phát triển kinh doanh bằng cách thêm các chỗ nghỉ này vào nền tảng du lịch trực tuyến lớn nhất thế giới, Booking.com.</p>
        
        
        <table id="sample_2">
	        <thead>
	            <tr style="background-color: #f9f9f9; color: #333; font-weight: bold;">
	                <th>STT</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left;">Loại khách sạn</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left;">Tên khách sạn</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left;">Địa chỉ</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: center;">Hạng sao</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: center;">Trạng thái</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: center;">Xem chi tiết</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: center;">Xóa</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${listKS}" var="ks" varStatus="STT">
	        		<tr>
		                <td style="padding: 12px; text-align: left; border-bottom: 1px solid #eaeaea;">${STT.index+1}</td>
		                <td style="padding: 12px; text-align: left; border-bottom: 1px solid #eaeaea;">${ks.tenLoaiKhachSan}</td>
		                <td style="padding: 12px; text-align: left; border-bottom: 1px solid #eaeaea;">${ks.ten}</td>
		                <td style="padding: 12px; text-align: left; border-bottom: 1px solid #eaeaea;">${ks.diaChi}</td>
		                <td style="padding: 12px; text-align: center; border-bottom: 1px solid #eaeaea;">${ks.danhGia}</td>
		                <td style="padding: 12px; text-align: center; border-bottom: 1px solid #eaeaea;">Đã được duyệt</td>
		                <td style="padding: 12px; text-align: center; border-bottom: 1px solid #eaeaea;">
		                	<a href="<c:url value='/sheller/suaChoNghi/ThongTinCoBan?id=${ks.id}'/>" style="background-color: #007bff; color: white; padding: 5px 10px; border: none; border-radius: 4px; cursor: pointer;">Xem chi tiết</a>
		                </td>
		                <td style="padding: 12px; text-align: center; border-bottom: 1px solid #eaeaea;">
		                    <button style="background-color: #d9534f; color: white; padding: 5px 10px; border: none; border-radius: 4px; cursor: pointer;">Xóa</button>
		                </td>
		            </tr>
	        	</c:forEach>
	        </tbody>
	    </table>
    </div>
</body>
</html>