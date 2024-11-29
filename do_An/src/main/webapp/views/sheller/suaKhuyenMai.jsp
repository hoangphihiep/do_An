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
            <form action="${pageContext.request.contextPath}/sheller/khuyenMai/update" method="post">
                <input type="text" name ="idkhuyenmai" value="${khuyenmai.id}" hidden="hidden"> 
                <label for="tenkhuyenmai" style="display: block; margin-bottom: 5px;">Khuyến mãi:</label>
                <input type="text" id="tenkhuyenmai" name="tenkhuyenmai" value ="${khuyenmai.ten}" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                
                <label for="mota" style="display: block; margin-bottom: 5px;">Mô tả:</label>
                <input type="text" id="mota" name="mota" value ="${khuyenmai.moTa}" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                    
                <label for="discount-amount" style="display: block; margin-bottom: 5px;">Phần trăm giảm giá:</label>
                <input type="number" id="discount-amount" name="discount-amount" value ="${khuyenmai.giaTriGiam}"  
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">

                <label for="ngaybatdau" style="display: block; margin-bottom: 5px;">Ngày bắt đầu:</label>
                <input type="date" id="ngaybatdau" name="ngaybatdau" value ="${khuyenmai.thoiGianBatDau}"
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
				
				<label for="ngayketthuc" style="display: block; margin-bottom: 5px;">Ngày kết thúc:</label>
                <input type="date" id="ngayketthuc" name="ngayketthuc" value ="${khuyenmai.thoiGianKetThuc}"
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">      
                
                <label for="khachsan" style="display: block; margin-bottom: 5px;">Khách sạn:</label>
				<select id="khachsan" name="idKhachSan" style="width: 101%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;" onchange="loadRooms(this.value)">
				    <option value="">-- Chọn khách sạn --</option>
				    <c:forEach items="${listkhachsan}" var="khachsan">
				        <option value="${khachsan.id}" ${khachsan.id == khuyenmai.idKS ? 'selected' : ''}>${khachsan.ten}</option>
				    </c:forEach>
				</select>
				
				<!-- Dropdown Phòng -->
				<label for="phong" style="display: block; margin-bottom: 5px;">Phòng:</label>
				<select id="phong" name="idPhong" style="width: 101%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
				    <option value="">-- Chọn phòng --</option>
				</select>
                <button type="submit" style="background-color: #007BFF; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
                    Sửa
                </button>
            </form>
        </section>
    </div>
    <script>
	function loadRooms(idKhachSan) {
	    if (!idKhachSan) {
	        document.getElementById('phong').innerHTML = '<option value="">-- Chọn phòng --</option>';
	        return;
	    }
	
	    const url = "/do_An/sheller/khuyenMai/getRooms?idKS=" + idKhachSan;
	    console.log(`Fetching with URL: ${url}`);
	    fetch(url)
	        .then(response => response.json())
	        .then(data => {
	            const roomDropdown = document.getElementById('phong');
	            roomDropdown.innerHTML = '<option value="">-- Chọn phòng --</option>';
	            const selectedRoomId = "${khuyenmai.idPhong}"; // Lấy id phòng từ backend
	
	            data.forEach(room => {
	                const option = document.createElement('option');
	                option.value = room.id;
	                option.textContent = room.ten;
	                // Đặt thuộc tính "selected" nếu phòng khớp với `khuyenmai.idPhong`
	                if (room.id == selectedRoomId) {
	                    option.selected = true;
	                }
	                roomDropdown.appendChild(option);
	            });
	        })
	        .catch(error => console.error('Error fetching rooms:', error));
	}
	
	// Khi trang load, nếu đã có idKhachSan, tự động load danh sách phòng
	document.addEventListener('DOMContentLoaded', () => {
	    const selectedKhachSanId = document.getElementById('khachsan').value;
	    if (selectedKhachSanId) {
	        loadRooms(selectedKhachSanId);
	    }
	});
	</script>
</body>
</html>