<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f9f9f9;">
    
    <%@ include file="/commons/sheller/headerGiamGia.jsp"%>
    <!-- Content -->
    <div style="padding: 20px;">
        <!-- Bảng danh sách mã giảm giá -->
        <a href="<c:url value='/sheller/giamGia/add'/>" style="background-color: #0071c2; margin-top: 20px; margin-right: 20px; color: white; padding: 10px 20px; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; float: right; display: inline-block; text-decoration: none;">Thêm giảm giá mới</a>
        <section style="background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-top: 70px;">
            <table id="reservationTable" style="width: 100%; border-collapse: collapse; ">
                <thead>
                    <tr style="background-color: #007BFF; color: white; text-align: left;">
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">STT</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Mã</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Giảm giá (%)</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Ngày bắt đầu</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Ngày kết thúc</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Số lượng</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Số lượng sử dụng</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Đối tượng</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Mẫu mã giảm giá -->
                    <c:forEach items="${listGiamGia}" var="giamgia" varStatus="STT">
	                    <tr>	
	                    		<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${STT.index+1}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.maGiamGia}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.phanTramGiamGia}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.ngayBatDau}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.ngayKetThuc}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.soLuongMa}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.soLanDaSuDung}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${giamgia.apDung}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">
		                            <a href="<c:url value='/sheller/giamGia/edit?id=${giamgia.id}'/>" style="background-color: #28A745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Chỉnh sửa</a>
		                            <a href="<c:url value='/sheller/giamGia/delete?id=${giamgia.id}'/>" style="background-color: #DC3545; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Xóa</a>
		                        </td>	
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
</body>
</html>