<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0;">
	<%@ include file="/commons/sheller/headerDatPhong.jsp"%>
	
	<div style="max-width: 1200px; margin: auto; padding: 20px;">
		<table id="reservationTable" style="width: 100%;  border-collapse: collapse; text-align: left;">
	        <!-- Table Header -->
	        <thead>
	            <tr style="background-color: #333; color: white;">
	                <th style="padding: 10px; text-align: center;">STT</th>
	                <th style="padding: 10px;">Thông Tin Khách Hàng</th>
	                <th style="padding: 10px;">Khách Sạn</th>
	                <th style="padding: 10px;">Thông Tin Phòng Đặt</th>
	                <th style="padding: 10px; text-align: center;">Hành Động</th>
	            </tr>
	        </thead>
	        
	        <!-- Table Body -->
	        <tbody>
	        	<c:forEach items="${listDP}" var="dp" varStatus="STT">
	        		<!-- Row 1 -->
		            <tr style="border-bottom: 1px solid #ccc;">
		                <td style="padding: 10px; text-align: center;">${STT.index+1}</td>
		                <td style="padding: 10px;">
		                    <p style="margin: 0; font-weight: bold; color: #007bff;">ID Đặt Phòng: ${dp.id}</p>
		                    <p style="margin: 5px 0;">Tên: ${dp.user.fullname}</p>
		                    <p style="margin: 0;">Điện Thoại: ${dp.user.phone}</p>
		                </td>
		                <td style="padding: 10px;">
		                    <p style="margin: 0;">Phòng: ${dp.phong.ten}</p>
		                    <p style="margin: 5px 0;">Giá: ${dp.phong.giaThue} vnd</p>
		                    <p style="margin: 0;">Tổng: ${dp.thanhTien} vnd</p>
		                </td>
		                <td style="padding: 10px;">
		                	<p style="margin: 5px 0;">Ngày Đặt: ${dp.ngayDat}</p>
		                    <p style="margin: 5px 0;">Ngày Đến: ${dp.ngayDen}</p>
		                    <p style="margin: 5px 0;">Ngày Trả: ${dp.ngayTra}</p>
		                    <p style="margin: 5px 0;">Thời Gian Thanh Toán Còn 
							    <c:choose>
							        <c:when test="${dp.thoiGianConLaiTT > 0}">
							            <span style="color: white; background-color: #28a745; padding: 2px 6px; border-radius: 5px;">
							                ${dp.thoiGianConLaiTT} ngày
							            </span>
							        </c:when>
							        <c:otherwise>
							            <span style="color: white; background-color: #dc3545; padding: 2px 6px; border-radius: 5px;">
							                Đã Hết Hạn
							            </span>
							        </c:otherwise>
							    </c:choose>
							</p>
		                    <p style="margin: 5px 0;">Thời Gian Ở Còn Lại 
							    <c:choose>
							        <c:when test="${dp.thoiGianOConLai > 0}">
							            <span style="color: white; background-color: #28a745; padding: 2px 6px; border-radius: 5px;">
							                ${dp.thoiGianOConLai} ngày
							            </span>
							        </c:when>
							        <c:otherwise>
							            <span style="color: white; background-color: #dc3545; padding: 2px 6px; border-radius: 5px;">
							                Đã Hết Hạn
							            </span>
							        </c:otherwise>
							    </c:choose>
							</p>
		                </td>
		                <td style="padding: 10px; text-align: center;">
		                	<c:choose>
							        <c:when test="${dp.thanhToan == false}">
							            <a href="<c:url value='/sheller/datPhong/xacNhanTT?id=${dp.id}'/>" style="padding: 5px 10px; color: white; background-color: #28a745; border: none; border-radius: 3px; cursor: pointer; margin-bottom: 5px; display: inline-block; text-decoration: none;">✔ Xác Nhận Thanh Toán</a><br>
							        </c:when>
							        <c:otherwise>
							            <a href="#" style="padding: 5px 10px; color: white; background-color: #28a745; border: none; border-radius: 3px; cursor: pointer; margin-bottom: 5px; display: inline-block; text-decoration: none;">Đã thanh toán</a><br>
							        </c:otherwise>
							    </c:choose>
		                    
		                    <a href="<c:url value='/sheller/datPhong/huyDatPhong?id=${dp.id}'/>" 
							   style="padding: 5px 10px; color: white; background-color: #dc3545; border: none; 
							          border-radius: 3px; cursor: pointer; margin-top: 10px; display: inline-block; text-decoration: none;">
							    🗑 Hủy Đặt Phòng
							</a>
		                </td>
		            </tr>
	        	</c:forEach>
	            
	        </tbody>
	    </table>
	</div>
	
</body>
</html>