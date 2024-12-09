<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body style="font-family: Arial, sans-serif; background-color: #eaf3ff; margin: 0; padding: 0;">
    <form action="${pageContext.request.contextPath}\xacNhan">
	    <div style="max-width: 1350px; margin: auto; padding: 20px;">
	        <div style="background-color: #1a73e8; color: white; padding: 15px; text-align: center; font-size: 24px; font-weight: bold;">
	            Hotel Booking
	        </div>
		        <!-- Main Container with Flex -->
		        <div style="display: flex; flex-wrap: wrap; margin-top: 20px; gap: 20px;">
		            <!-- Booking Information and Special Requests -->
		            <div style="flex: 1; min-width: 900px;">
		                <!-- Booking Information -->
		                	<h3 style="font-size: 18px; color: #333; margin: 0 0 20px;">Đặt phòng của bạn</h3>
		                    <div style="background-color: white; padding: 40px; border-radius: 10px; margin-bottom: 20px; border: 1px solid #ccc;">
			                    
			                    <h4 style="font-size: 16px; color: #333; margin-bottom: 10px;">Thông tin chi tiết</h4>
			                    <div style="display: flex; gap: 10px; margin-bottom: 10px;">
			                        <input type="text" name="hovaten" placeholder="Họ và tên" value="${hovaten}" style="flex: 1; padding: 10px; border-radius: 5px; border: 1px solid #ccc;">
			                        <input type="text" name="email" placeholder="Email" value="${email}" style="flex: 1; padding: 10px; border-radius: 5px; border: 1px solid #ccc;">
			                    </div>
			                    <div style="display: flex; gap: 10px;">
			                        <input type="text" name="phone" placeholder="Số điện thoại" value="${sodt}" style="flex: 1; padding: 10px; border-radius: 5px; border: 1px solid #ccc;">
			                        <input type="number" id="slphongdat" name="slphongdat" placeholder="Số lượng phòng cần đặt" 
										    style="flex: 1; padding: 10px; border-radius: 5px; border: 1px solid #ccc;" 
										    max="${sophongtrong}" oninput="validateRoomCount(this)">
			                    </div>			        
			                </div>
		                <!-- Special Requests -->
		
		                    <h2 style="font-size: 20px;  margin: 0 0 10px; color: #333;">Các yêu cầu đặc biệt</h2>
		                    <textarea name="specialRequests" rows="4" placeholder="Vui lòng ghi yêu cầu vào đây" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; font-size: 16px;"></textarea>
		
							<label for="giamgia" style="display: block; margin-bottom: 5px;">Mã giảm giá:</label>
			                <select name="giamgia" id="selectGiamGia" style="width: 101%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;" onchange="updateDiscount()">
							    <option value="0" data-phantram="0">Không áp dụng mã giảm giá</option>
							    <c:forEach items="${listgiamgia}" var="giamgia">
							        <c:if test="${giamgia.apDung == 'Giảm giá cho người mới' && giamgia.status == true}">
							            <option value="${giamgia.id}" data-phantram="${giamgia.phanTramGiamGia}">${giamgia.maGiamGia} ---giảm ${giamgia.phanTramGiamGia}%</option>
							        </c:if>
							        <c:if test="${giamgia.apDung == 'Khách hàng thân thiết' && giamgia.status == true}">
								        <option value="${giamgia.id}" data-phantram="${giamgia.phanTramGiamGia}">${giamgia.maGiamGia} ---giảm ${giamgia.phanTramGiamGia}%</option>
								    </c:if>
								    <c:if test="${giamgia.apDung == 'Số tiền lớn hơn 5.000.000 VNĐ' && giamgia.status == true}">
								        <option value="${giamgia.id}" data-phantram="${giamgia.phanTramGiamGia}">${giamgia.maGiamGia} ---giảm ${giamgia.phanTramGiamGia}%</option>
								    </c:if>
								    <c:if test="${giamgia.apDung == hovaten && giamgia.status == true}">
								        <option value="${giamgia.id}" data-phantram="${giamgia.phanTramGiamGia}">${giamgia.maGiamGia} ---giảm ${giamgia.phanTramGiamGia}%</option>
								    </c:if>
							    </c:forEach>
							</select>
			                <!-- Price Details -->
			                <h2 style="font-size: 20px; margin-top: 20px;   color: #333">Chi tiết giá</h2>
			                <div style="background-color: white; border-radius: 8px; margin-top: 10px; padding: 20px;">
		                    
		                    <div style="border-top: 1px; padding-top: 10px; display: flex; justify-content: space-between; font-weight: bold;">
		                        <span id="tenPhong">${tenphong }</span>
    							<span id="giaPhong">${tienphong} VND</span>
		                    </div>
		                    <div style="border-top: 1px solid #ccc; padding-top: 10px; display: flex; justify-content: space-between; font-weight: bold;">
							    <span>Số ngày ở:</span>
							    <span>${songay} ngày</span>
							</div>
		                    <!-- Hiển thị tổng tiền sau khi nhân với số lượng phòng -->
							<div style="border-top: 1px solid #ccc; padding-top: 10px; display: flex; justify-content: space-between; font-weight: bold;">
							    <span>Tiền đặt phòng:</span>
							    <span id="tongTien">0 VND</span>
							</div>
							<div style="border-top: 1px solid #ddd; padding-top: 10px; display: flex; justify-content: space-between; font-weight: bold;">
		                        <span>Thuế và phí</span>
		                        <span>60.000 VND</span>
		                    </div>
		                    <div id="giamGiaRow" style="border-top: 1px solid #ddd; padding-top: 10px; display: none; justify-content: space-between; font-weight: bold;">
						        <span>Số tiền giảm:</span>
						        <span id="soTienGiam">0 VND</span>
						    </div>
		                    <div style="border-top: 1px solid #ddd; padding-top: 10px; display: flex; justify-content: space-between; font-weight: bold;">
							    <span>Thành tiền</span>
							    <span id="thanhTienText">0 VND</span>
							    <!-- Input ẩn để gửi giá trị thành tiền về server -->
							    <input type="hidden" name="thanhTien" id="thanhTienInput" value="0">
							</div>
		                    
							<script>
							    const giaPhong = ${tienphong}; // Giá phòng
							    const phiDichVu = 60000; // Phí dịch vụ cố định
							    const soNgayO = ${songay}
							
							    function updateDiscount() {
							        const soLuongPhong = parseInt(document.getElementById("slphongdat").value) || 0;
							        const tongTienPhong = soLuongPhong * giaPhong*soNgayO;
							        const tongTienCoPhi = tongTienPhong + phiDichVu;
							
							        const selectGiamGia = document.getElementById("selectGiamGia");
							        const selectedOption = selectGiamGia.options[selectGiamGia.selectedIndex];
							        const phanTramGiamGia = parseFloat(selectedOption.getAttribute("data-phantram")) || 0;
							
							        // Tính số tiền giảm
							        const soTienGiam = tongTienCoPhi * (phanTramGiamGia / 100);
							
							        // Hiển thị số tiền giảm
							        const giamGiaRow = document.getElementById("giamGiaRow");
							        if (soTienGiam > 0) {
							            giamGiaRow.style.display = "flex";
							            document.getElementById("soTienGiam").innerText = "-" + soTienGiam.toLocaleString() + " VND";
							        } else {
							            giamGiaRow.style.display = "none";
							        }
							
							        // Tính thành tiền sau khi giảm
							        const thanhTien = tongTienCoPhi - soTienGiam;
							
							        // Cập nhật thành tiền
							        document.getElementById("tongTien").innerText = tongTienPhong.toLocaleString() + " VND";
							        document.getElementById("thanhTienText").innerText = thanhTien.toLocaleString() + " VND";
							        document.getElementById("thanhTienInput").value = thanhTien; // Cập nhật giá trị ẩn
							    }
							
							    // Lắng nghe sự thay đổi của số lượng phòng
							    document.getElementById("slphongdat").addEventListener("input", updateDiscount);
							</script>
		                    
		                    <div style="display: flex; flex-direction: column; margin-top: 10px;">
		                        <label><input type="radio" name="payment" value="Thanh toán khi nhận phòng" checked> Thanh toán khi nhận phòng</label>
		                        <label><input type="radio" name="payment" value="Ví MoMo"> Ví MoMo</label>
		                    </div>
		                </div>
		            </div>
		
		            <!-- Summary Box -->
		            <div style="flex: 1; margin-top: 40px; ">
		                <div style="background-color: white; padding: 20px; border-radius: 10px; border: 1px solid #ccc;">
		                    <h4 style="font-size: 16px; font-weight: bold; color: #003580; margin: 0;">
		                        🏨 ${tenphong}
		                        <input type="hidden" name="tenPhong" value="${tenphong}">
		                    </h4>
		                    <c:if test="${anhphong.substring(0,5) != 'https' }">
                                    <c:url value="/image?fname=${anhphong}" var="imgUrl"></c:url>
                             </c:if>
                             <c:if test="${anhphong.substring(0,5) == 'https' }">
                                   <c:url value="${anhphong}" var="imgUrl"></c:url>
                             </c:if>          
		                     <img src="${imgUrl}" alt="Khách sạn Agena Sea Hotel" style="width: 100%; height: auto; border-radius: 10px; margin-top: 10px;">
		                    <hr style="border: none; border-top: 1px solid #e0e0e0; margin: 10px 0;">
		                    <div style="margin-bottom: 8px;">
		                        <strong>Ngày nhận phòng:</strong>
		                        <span style="float: right;">${ngayDen}</span>
		                        <input type="hidden" name="ngayDen" value="${ngayDen}">
		                    </div>
		                    <div style="margin-bottom: 8px;">
		                        <strong>Ngày trả phòng:</strong>
		                        <span style="float: right;">${ngayDi}</span>
		                        <input type="hidden" name="ngayDi" value="${ngayDi}">
		                    </div>
		                    <hr style="border: none; border-top: 1px solid #e0e0e0; margin: 10px 0;">
		                    <div style="margin-bottom: 8px;">
		                        <strong>Số lượng khách mỗi phòng:</strong>
		                        <span style="float: right; margin-right: 140px;">${slkhach}</span>
		                    </div>
		                    <div style="margin-bottom: 8px;">
		                        <strong>Số phòng còn trống:</strong>
		                        <span style="float: right; margin-right: 140px;">${sophongtrong}</span>
		                    </div>
		                </div>
		            </div>
		        </div>
		    
	     </div>
	     
	     <div style="max-width: 150px; margin: auto; padding: 20px;">
		    <!-- Button submit để gửi form -->
		    <button type="submit" style="display: block; background-color: #1a73e8; color: white; text-align: center; padding: 10px; font-size: 18px; font-weight: bold; text-decoration: none; border-radius: 5px; margin-top: 20px; cursor: pointer;">
		        Tiếp tục
		    </button>
		</div>
     </form>  
     <script>
	    const sophongtrong = ${sophongtrong}; // Gán giá trị số phòng trống từ server
	    function validateRoomCount(input) {
	        if (input.value < 1) {
	            alert("Số lượng phòng đặt phải lớn hơn hoặc bằng 1.");
	            input.value = 1; // Tự động điều chỉnh về giá trị tối thiểu
	        } else if (input.value > sophongtrong) {
	            alert(`Số lượng phòng đặt không được lớn hơn ${sophongtrong}.`);
	            input.value = sophongtrong; // Tự động điều chỉnh về giá trị tối đa
	        }
	    }
	</script>
</body>

</html>