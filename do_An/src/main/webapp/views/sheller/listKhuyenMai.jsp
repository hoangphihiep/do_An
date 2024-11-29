<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0;">
    
    <%@ include file="/commons/sheller/headerKhuyenMai.jsp"%>
    <!-- Content -->
    <div style="padding: 20px;">
        <!-- Bảng danh sách mã giảm giá -->
        <a href="<c:url value='/sheller/khuyenMai/add'/>" style="background-color: #0071c2; margin-top: 20px; margin-right: 20px; color: white; padding: 10px 20px; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; float: right; display: inline-block; text-decoration: none;">Thêm khuyến mãi mới</a>
        <section style="background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-top: 70px;">
            <table id="reservationTable" style="width: 100%; border-collapse: collapse; ">
                <thead>
                    <tr style="background-color: #007BFF; color: white; text-align: left;">
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">STT</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Khuyến mãi</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Mô tả</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Giảm giá (%)</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Ngày bắt đầu</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Ngày kết thúc</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Tên phòng</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Tên khách sạn</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Trạng thái</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Mẫu mã giảm giá -->
                    <c:forEach items="${listkhuyenmai}" var="khuyenmai" varStatus="STT">
	                    <tr>	
	                    		<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${STT.index+1}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.ten}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.moTa}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.giaTriGiam}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.thoiGianBatDau}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.thoiGianKetThuc}</td>
		                        <c:if test="${empty khuyenmai.phong.ten}">
		                        	<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">Tất cả các phòng</td>
		                        </c:if>
		                        <c:if test="${!empty khuyenmai.phong.ten}">
		                        	<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.phong.ten}</td>
		                        </c:if>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${khuyenmai.khachsan.ten}</td>
		                        <c:if test="${khuyenmai.status == 1}">
		                        	<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">Đã được duyệt</td>
		                        </c:if>
		                        <c:if test="${khuyenmai.status == 2}">
		                        	<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">Đang chờ duyệt</td>
		                        </c:if>
		                        <c:if test="${khuyenmai.status == 3}">
		                        	<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">Không được duyệt</td>
		                        </c:if>
		                        
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">
		                            <a href="<c:url value='/sheller/khuyenMai/edit?id=${khuyenmai.id}'/>" style="background-color: #28A745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Chỉnh sửa</a>
		                            <a href="<c:url value='/sheller/khuyenMai/delete?id=${khuyenmai.id}'/>" style="background-color: #DC3545; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Xóa</a>
		                        </td>	
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
</body>
</html>