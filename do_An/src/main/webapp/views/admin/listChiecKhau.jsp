<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Table -->
	<div style="background-color: #ffffff; padding: 20px; border: 1px solid #ddd; border-radius: 8px; margin-left: -96px; margin-top: 0px">
        <!-- Bảng danh sách mã giảm giá -->
        <a href="<c:url value='/admin/chiecKhau/add'/>" style="background-color: #0071c2; margin-top: 20px; margin-right: 20px; color: white; padding: 10px 20px; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; float: right; display: inline-block; text-decoration: none;">Thêm chiếc khấu mới</a>
        <section style="background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-top: 70px;">
            <table id="reservationTable" style="width: 100%; border-collapse: collapse;">
                <thead>
                    <tr style="background-color: #f8f9fa; border-bottom: 1px solid #ddd;">
	                    <th style="padding: 10px; text-align: left;">STT</th>
	                    <th style="padding: 10px; text-align: left;">Tên khách sạn</th>
	                    <th style="padding: 10px; text-align: left; width: 100px;">Chiếc khấu (%)</th>
	                    <th style="padding: 10px; text-align: left;">Hành động</th>
	               	</tr>
                </thead>
                <tbody>
                    <!-- Mẫu mã giảm giá -->
                    <c:forEach items="${listchieckhau}" var="chieckhau" varStatus="STT">
	                    <tr>
							<td style="padding: 10px;">${STT.index+1}</td>
							<td style="padding: 10px;">${chieckhau.ks.ten}</td>
							<td style="padding: 10px;">${chieckhau.tiLeChiecKhau}</td>

							<td style="padding: 10px;">
								<a href="<c:url value='/admin/chiecKhau/edit?id=${chieckhau.id}'/>"
								style="background-color: #28A745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Chỉnh
									sửa</a> 
								<a href="<c:url value='/admin/chiecKhau/delete?id=${chieckhau.id}'/>"
								style="background-color: #DC3545; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Xóa</a>
							</td>
						</tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
</body>
</html>