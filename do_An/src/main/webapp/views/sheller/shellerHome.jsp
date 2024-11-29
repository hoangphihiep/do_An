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
        
        
        <table id="reservationTable" style="width: 100%; border-collapse: collapse; text-align: left;">
	        <thead>
	            <tr style="background-color: #f9f9f9; color: #333; font-weight: bold;">
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left; width: 50px;">STT</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left; width: 130px;">Loại khách sạn</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left; width: 130px;">Tên khách sạn</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: left; width: 300px;">Địa chỉ</th>
	                <th style="padding: 12px; border-bottom: 1px solid #eaeaea; text-align: center; width: 110px;">Hạng sao</th>
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
		                <c:if test="${ks.status == 1}">
	                    	<td style="padding: 12px; color: green; text-align: center; border-bottom: 1px solid #eaeaea;">Đã được duyệt</td>
	                    </c:if>
		                <c:if test="${ks.status == 2}">
	                    	<td style="padding: 12px; color: #ffa500; text-align: center; border-bottom: 1px solid #eaeaea;">Đang chờ duyệt</td>
	                    </c:if>
	                    <c:if test="${ks.status == 3}">
	                    	<td style="padding: 12px; color: red; text-align: center; border-bottom: 1px solid #eaeaea;">Không được duyệt</td>
	                    </c:if>
		                <td style="padding: 12px; text-align: center; border-bottom: 1px solid #eaeaea;">
		                	<a href="<c:url value='/sheller/suaChoNghi/ThongTinCoBan?id=${ks.id}'/>" style="background-color: #007bff; color: white; padding: 5px 10px; border: none; border-radius: 4px; cursor: pointer;">Xem chi tiết</a>
		                </td>
		                <td style="padding: 12px; text-align: center; border-bottom: 1px solid #eaeaea;">
		                    <a href="<c:url value='/sheller/xoaChoNghi?id=${ks.id}'/>" style="background-color: #d9534f; color: white; padding: 5px 10px; border: none; border-radius: 4px; cursor: pointer;">Xóa</a>
		                </td>
		            </tr>
	        	</c:forEach>
	        </tbody>
	    </table>
    </div>
</body>
</html>