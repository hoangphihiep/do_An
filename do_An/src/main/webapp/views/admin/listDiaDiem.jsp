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
    <a href="<c:url value='/admin/diaDiem/add'/>" style="background-color: #0071c2; margin-top: 20px; margin-right: 20px; color: white; padding: 10px 20px; border: none; border-radius: 5px; font-size: 14px; cursor: pointer; float: right; display: inline-block; text-decoration: none;">Thêm địa điểm mới</a>
    <section style="background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-top: 70px;">
        <table id="reservationTable" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr style="background-color: #f8f9fa; border-bottom: 2px solid #ddd;">
                    <th style="padding: 10px; text-align: left; width: 50px; border-right: 1px solid #ddd;">STT</th>
                    <th style="padding: 10px; text-align: left; width: 150px; border-right: 1px solid #ddd;">Tên địa điểm</th>
                    <th style="padding: 10px; text-align: left; width: 200px; border-right: 1px solid #ddd;">Mô tả</th>
                    <th style="padding: 10px; text-align: left; width: 300px; border-right: 1px solid #ddd;">Ảnh địa điểm</th>
                    <th style="padding: 10px; text-align: left; width: 100px; border-right: 1px solid #ddd;">Số lượng khách sạn</th>
                    <th style="padding: 10px; text-align: left; border-right: 1px solid #ddd;">Hành động</th>
                </tr>
            </thead>
            <tbody>
                <!-- Mẫu mã giảm giá -->
                <c:forEach items="${listdiadiem}" var="diadiem" varStatus="STT">
                    <tr style="border-bottom: 1px solid #ddd;">
                        <td style="padding: 10px; border-right: 1px solid #ddd;">${STT.index+1}</td>
                        <td style="padding: 10px; border-right: 1px solid #ddd;">${diadiem.ten}</td>
                        <td style="padding: 10px; border-right: 1px solid #ddd;">${diadiem.moTa}</td>
                        <c:if test="${diadiem.urlHinhAnh.substring(0,5) != 'https' }">
                            <c:url value="/image?fname=${diadiem.urlHinhAnh}" var="imgUrl"></c:url>
                        </c:if>
                        <c:if test="${diadiem.urlHinhAnh.substring(0,5) == 'https' }">
                            <c:url value="${diadiem.urlHinhAnh}" var="imgUrl"></c:url>
                        </c:if>
                        <td style="padding: 10px; border-right: 1px solid #ddd;"><img id="previewImage1" src="${imgUrl}"
                                style="width: 297px; height: 223px; object-fit: cover;"></td>
                        <td style="padding: 10px; border-right: 1px solid #ddd;">${diadiem.soKhachSan}</td>

                        <td style="padding: 10px; border-right: 1px solid #ddd;">
                            <a href="<c:url value='/admin/diaDiem/edit?id=${diadiem.id}'/>"
                                style="background-color: #28A745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Chỉnh
                                sửa</a>
                            <a href="<c:url value='/admin/diaDiem/delete?id=${diadiem.id}'/>"
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