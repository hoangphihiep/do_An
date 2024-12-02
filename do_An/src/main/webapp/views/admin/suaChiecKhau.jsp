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
<div style="padding: 20px;">
        <!-- Tạo mã giảm giá -->
        <section style=" margin-left: 250px; margin-top: 100px; max-width: 500px; background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h2 style="color: #007BFF; margin-bottom: 15px;">Tạo chiếc khấu</h2>
            <form action="${pageContext.request.contextPath}/admin/chiecKhau/update" method="post">
                <input type="text" name ="idchieckhau" value="${chieckhau.id}" hidden="hidden"> 
                <label for="khachsan" style="display: block; margin-bottom: 5px;">Khách sạn:</label>
				<select id="khachsan" name="idKhachSan" style="width: 101%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;" onchange="loadRooms(this.value)">
				    <option value="">-- Chọn khách sạn --</option>
				    <c:forEach items="${listkhachsan}" var="khachsan">
				        <option value="${khachsan.id}" ${khachsan.id == chieckhau.idKS ? 'selected' : ''}>${khachsan.ten}</option>
				    </c:forEach>
				</select>
                
                <label for="discount-amount" style="display: block; margin-bottom: 5px;">Phần trăm chiếc khấu:</label>
                <input type="number" id="discount-amount" name="discount-amount" value ="${chieckhau.tiLeChiecKhau}"
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">

                <button type="submit" style="background-color: #007BFF; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
                    Sửa
                </button>
            </form>
        </section>
    </div>
</body>
</html>