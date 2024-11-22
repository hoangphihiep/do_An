<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f9f9f9;">
    <!-- Content -->
    <%@ include file="/commons/sheller/headerGiamGia.jsp"%>
    <div style="padding: 20px;">
        <!-- Tạo mã giảm giá -->
        <section style=" margin: 30px auto; max-width: 500px; background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h2 style="color: #007BFF; margin-bottom: 15px;">Tạo mã giảm giá</h2>
            <form action="${pageContext.request.contextPath}/sheller/giamGia/update" method="post">
                <label for="discount-code" style="display: block; margin-bottom: 5px;">Mã giảm giá:</label>
                <input type="text" id="discount-code" name="discount-code" value ="${giamgia.maGiamGia}" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                
                <label for="discount-amount" style="display: block; margin-bottom: 5px;">Phần trăm giảm giá:</label>
                <input type="number" id="discount-amount" name="discount-amount" value ="${giamgia.phanTramGiamGia}"  
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">

                <label for="ngaybatdau" style="display: block; margin-bottom: 5px;">Ngày bắt đầu:</label>
                <input type="date" id="ngaybatdau" name="ngaybatdau" value ="giamgia.ngayBatDau"
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
				
				<label for="ngayketthuc" style="display: block; margin-bottom: 5px;">Ngày kết thúc:</label>
                <input type="date" id="ngayketthuc" name="ngayketthuc" value ="${giamgia.ngayKetThuc}"
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                
                <label for="soluongma" style="display: block; margin-bottom: 5px;">Số lượng:</label>
                <input type="text" id="soluongma" name="soluongma" value ="${giamgia.soLuongMa}" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                    
                <label for="soluongma" style="display: block; margin-bottom: 5px;">Số lượng đã sử dụng:</label>
                <input type="text" id="soluongma" name="soluongma" value ="${giamgia.soLanDaSuDung}" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                
                <label for="apdung" style="display: block; margin-bottom: 5px;">Áp dụng cho:</label>
                <select name="apdung" style="width: 101%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
		            <option value="Giảm giá cho người mới" ${giamgia.apDung == 'Giảm giá cho người mới' ? 'selected' : ''}>Giảm giá cho người mới</option>
		            <option value="Khách hàng thân thiết" ${giamgia.apDung == 'Khách hàng thân thiết' ? 'selected' : ''}>Khách hàng thân thiết</option>
		            <option value="Số tiền lớn hơn 5.000.000 VNĐ" ${giamgia.apDung == 'Số tiền lớn hơn 5.000.000 VNĐ' ? 'selected' : ''}>Số tiền lớn hơn 5.000.000 VNĐ</option>
		            <c:forEach items="${listKhachDP}" var="khachdp">
		            	<option value="${giamgia.apDung == khachdp.user.fullname ? 'selected' : ''}">${khachdp.user.fullname}</option>
		            </c:forEach>
		        </select>
                <button type="submit" style="background-color: #007BFF; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
                    Tạo mã
                </button>
            </form>
        </section>
    </div>
</body>
</html>