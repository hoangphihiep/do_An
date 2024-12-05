<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif;">
    <div style="width: 900px; margin: 50px auto; background-color: #fff; padding: 20px; border: 1px solid #ccc; border-radius: 4px;">
        <h1 style="font-size: 24px; font-weight: bold; color: #333;">Thiết lập phòng</h1>

        <!-- Phần chính -->
        <form action="${pageContext.request.contextPath}/sheller/phong" method="post" enctype="multipart/form-data">
        	<div style="display: flex; gap: -20px;">
            <!-- Chi tiết phòng ở -->
	            <div style="flex: 1;">
	                <h2 style="font-size: 18px; font-weight: bold; color: #333;">Chi tiết phòng ở</h2>
	
	                <!-- Tên phòng -->
	                <div style="margin-bottom: 10px;">
	                    <label style="font-size: 14px; color: #666;">Tên phòng:</label>
	                    <div>
	                    	<input id="tenphong" name="tenphong" type="text" style="width: 78%; margin-top: 10px; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
	                    </div>
	                    
	                </div>
	
	                <!-- Kích thước -->
	                <div style="margin-bottom: 10px;">
	                    <label style="font-size: 14px; color: #666;">Kích thước:</label>
	                    <div style="display: flex; margin-top: 10px; align-items: center;">
	                        <input id="kichthuoc" name="kichthuoc" type="text" style="width: 72%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
	                        <span style="font-size: 14px; color: #666; margin-left: 5px;">m2</span>
	                    </div>
	                </div>
	                
	                <!-- Mô tả -->
	                <div style="margin-bottom: 10px;">
	                    <label style="font-size: 14px; color: #666;">Mô tả:</label>
	                    <div style="display: flex; margin-top: 10px; align-items: center;">
	                        <input id="mota" name="mota" type="text" style="width: 78%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
	                    </div>
	                </div>
	
	                <!-- Sức chứa -->
	                <div style="margin-bottom: 10px;">
	                    <label style="font-size: 14px; color: #666;">Sức chứa:</label>
	                    <p style="font-size: 12px; color: #666;">Số lượng người tối đa có thể ngủ thoải mái theo số lượng giường cấp</p>
	                    <input id="soluongnguoi" name="soluongnguoi" type="text" style="width: 78%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
	                </div>
	                
	                <div style="width: 400px; margin-left: -18px; padding: 20px; border-radius: 8px;">
				        <h2 style="font-size: 16px; font-weight: bold; color: #333;">Có loại giường nào trong phòng này?</h2>
				
				        <!-- Loại giường -->
				         <!-- Giường đơn -->
					    <div style="padding: 10px 0;">
					        <div style="display: flex; align-items: center; justify-content: space-between;">
					            <div style="display: flex; align-items: center;">
					                <img src="/do_An/Content/Images/single-bed.png" alt="Giường đơn" style="margin-right: 10px; width: 50px; height: 50px;">
					                <div>
					                    <p style="margin: 0; font-size: 14px; font-weight: bold; color: #333;">Giường đơn</p>
					                    <p style="margin: 0; font-size: 12px; color: #666;">Rộng 90 - 130 cm</p>
					                </div>
					            </div>
					            <div style="display: flex; align-items: center;">
					                <button type="button" onclick="decrease('singleBed')" 
					                style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">-</button>
					                <span id="singleBed" style="padding: 0 10px; font-size: 14px; margin-top: 12px;">0</span>
					                <button type="button" onclick="increase('singleBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">+</button>
					            </div>
					        </div>
					        <input type="hidden" name="singleBedCount" id="singleBedCount" value="0">
					    </div>
					
					    <!-- Giường đôi -->
					    <div style="padding: 10px 0;">
					        <div style="display: flex; align-items: center; justify-content: space-between;">
					            <div style="display: flex; align-items: center;">
					                <img src="/do_An/Content/Images/double-bed.png" alt="Giường đôi" style="margin-right: 10px; width: 50px; height: 50px;">
					                <div>
					                    <p style="margin: 0; font-size: 14px; font-weight: bold; color: #333;">Giường đôi</p>
					                    <p style="margin: 0; font-size: 12px; color: #666;">Rộng 131 - 150 cm</p>
					                </div>
					            </div>
					            <div style="display: flex; align-items: center;">
					                <button type="button" onclick="decrease('doubleBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">-</button>
					                <span id="doubleBed" style="padding: 0 10px; font-size: 14px; margin-top: 12px;">0</span>
					                <button type="button" onclick="increase('doubleBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">+</button>
					            </div>
					        </div>
					        <input type="hidden" name="doubleBedCount" id="doubleBedCount" value="0">
					    </div>
					
					    <!-- Giường lớn (King) -->
					    <div style="padding: 10px 0;">
					        <div style="display: flex; align-items: center; justify-content: space-between;">
					            <div style="display: flex; align-items: center;">
					                <img src="/do_An/Content/Images/king-bed.png" alt="Giường lớn (cỡ King)" style="margin-right: 10px; width: 50px; height: 50px;">
					                <div>
					                    <p style="margin: 0; font-size: 14px; font-weight: bold; color: #333;">Giường lớn (cỡ King)</p>
					                    <p style="margin: 0; font-size: 12px; color: #666;">Rộng 151 - 180 cm</p>
					                </div>
					            </div>
					            <div style="display: flex; align-items: center;">
					                <button type="button" onclick="decrease('kingBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">-</button>
					                <span id="kingBed" style="padding: 0 10px; font-size: 14px; margin-top: 12px;">0</span>
					                <button type="button" onclick="increase('kingBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">+</button>
					            </div>
					        </div>
					        <input type="hidden" name="kingBedCount" id="kingBedCount" value="0">
					    </div>
					
					    <!-- Giường cực lớn (Super-king) -->
					    <div style="padding: 10px 0;">
					        <div style="display: flex; align-items: center; justify-content: space-between;">
					            <div style="display: flex; align-items: center;">
					                <img src="/do_An/Content/Images/bed.png" alt="Giường cực lớn (cỡ Super-king)" style="margin-right: 10px; width: 50px; height: 50px;">
					                <div>
					                    <p style="margin: 0; font-size: 14px; font-weight: bold; color: #333;">Giường cực lớn (cỡ Super-king)</p>
					                    <p style="margin: 0; font-size: 12px; color: #666;">Rộng 181 - 210 cm</p>
					                </div>
					            </div>
					            <div style="display: flex; align-items: center;">
					                <button type="button" onclick="decrease('superkingBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">-</button>
					                <span id="superkingBed" style="padding: 0 10px; font-size: 14px; margin-top: 12px;">0</span>
					                <button type="button" onclick="increase('superkingBed')" style="border: 1px solid #ccc; background-color: #fff; color: #333; width: 30px; 
					                height: 30px; font-size: 18px; cursor: pointer; display: flex; align-items: center; 
					                justify-content: center;">+</button>
					            </div>
					        </div>
					        <input type="hidden" name="superkingBedCount" id="superkingBedCount" value="0">
					    </div>
				    </div>
	
	                <!-- Số phòng -->
	                <div style="margin-bottom: 10px;">
	                    <label style="font-size: 14px; color: #666;">Số lượng phòng:</label>
	                    <div style="display: flex; margin-top: 10px; align-items: center;"> 
	                    	<input name="slphong" id="slphong type="text" style="width: 78%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
	                    </div>
	                    
	                </div>
	
	                <!-- Giá mỗi đêm -->
	                <h3 style="font-size: 18px; font-weight: bold; color: #333;">Giá mỗi đêm</h3>
	                
	                <div style="margin-bottom: 10px;">
	                    <label style="font-size: 14px; color: #666;">Giá tối thiểu mỗi đêm:</label>
	                    <div style="display: flex; margin-top: 10px; align-items: center;">
	                        <input name="giathue" id="giathue" type="text" style="width: 72%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
	                        <span style="font-size: 14px; color: #666; margin-left: 5px;">VND</span>
	                    </div>
	                </div>
	            </div>
	
	             <div style="width: 35%; display: flex; flex-direction: column; align-items: center;  margin-right: 80px;">
		            <h3 style="font-size: 20px; color: #333; font-weight: bold; margin-top: 13px;">Thêm hình ảnh của phòng</h3>
		            <!-- Khu vực hiển thị hình ảnh xem trước -->
		            <div id="previewContainer" style="width: 140%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
		                <span id="placeholderText" style="color: #aaa; font-size: 14px;">Chưa có ảnh</span>
		                <img id="previewImage" src="#" alt="Xem trước hình ảnh" style="display: none; width: 100%; height: 100%; object-fit: cover;">
		            </div>
		
		            <!-- Input file và nút Upload -->
		            <input type="file" id="imageUpload" name="imageUpload" style="display: none;" accept="image/*" onchange="previewImage(event)">
		            <button type="button" onclick="document.getElementById('imageUpload').click()" style="margin-top: 10px; padding: 8px 20px; border: 1px solid #ccc; background-color: #fff; color: #333; cursor: pointer; border-radius: 4px;">Upload</button>
		            
		            <div style="width: 300px; margin: 0 auto; font-family: Arial, sans-serif; margin-right: 70px; ">
		            	<h3 >Khách có thể sử dụng gì trong phòng này?</h3>
		            	<!-- Common Amenities Section -->
				        <div>
				            <h4>Tiện nghi chung</h4>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="tv" name="tv"> TV màn hình phẳng</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="dieuhoa" name="dieuhoa"> Điều hòa không khí</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="banlamviec" name="banlamviec"> Bàn làm việc</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="tudequanao" name="tudequanao"> Tủ hoặc phòng để quần áo</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="hethongsuu" name="hethongsuu"> Hệ thống sưởi</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="quatmay" name="quatmay"> Quạt máy</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="ketantoan" name="ketantoan"> Két an toàn</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="khantamvstaigiuong" name="khantamvstaigiuong"> Khăn tắm/Đồ vệ sinh tại giường</label><br>
				        </div>
				
				        <!-- Outdoor and View Section -->
				        <div>
				            <h4>Không gian ngoài trời và tầm nhìn</h4>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="bancong" name="bancong"> Ban công</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="sanhien" name="sanhien"> Sân hiên</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="tamnhinrakhungcanh" name="tamnhinrakhungcanh"> Tầm nhìn ra khung cảnh</label>
				        </div>
				
				        <!-- Food and Drink Section -->
				        <div>
				            <h4>Đồ ăn thức uống</h4>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="amdunnuoc" name="amdunnuoc"> Ấm đun nước điện</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="maypha" name="maypha"> Máy pha trà/cà phê</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="banan" name="banan"> Bàn ăn</label><br>
				            <label style="font-size: 14px; color: #666;"><input type="checkbox" id="lovisong" name="lovisong"> Lò vi sóng</label>
				        </div>
		            </div>
		        </div>
	        </div>
	
	        <!-- Nút điều hướng -->
	        <div style="text-align: center; margin-top: 20px;">
	            <button type="submit" style="background-color: #0071c2; color: #fff; padding: 8px 16px; border: none; border-radius: 4px; cursor: pointer;">Hoàn tất</button>
	        </div>
        </form>
        
    </div>
    <script>
	    window.onload = function() {
	        function previewImage(event) {
	            const placeholderText = document.getElementById('placeholderText');
	            const previewImage = document.getElementById('previewImage');
	            const file = event.target.files[0];
	
	            if (file) {
	                const reader = new FileReader();
	                reader.onload = function(e) {
	                    placeholderText.style.display = 'none'; // Ẩn văn bản "Chưa có ảnh"
	                    previewImage.src = e.target.result; // Gán đường dẫn ảnh cho img
	                    previewImage.style.display = 'block'; // Hiển thị ảnh xem trước
	                };
	                reader.readAsDataURL(file);
	            }
	        }
	
	        // Gán hàm cho sự kiện onchange của input
	        document.getElementById('imageUpload').onchange = previewImage;
	    };
	    <% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
		    Swal.fire({
		        title: 'Bạn thêm phòng thành công!',
		        text: 'Bạn có muốn thêm phòng khác không?',
		        icon: 'success',
		        showCancelButton: true,
		        confirmButtonColor: '#3085d6',
		        cancelButtonColor: '#d33',
		        confirmButtonText: 'Yes',
		        cancelButtonText: 'No'
		    }).then((result) => {
		        if (result.isDismissed) {
		            // Chuyển hướng khi nhấn "No"
		            window.location.href = '<%= request.getContextPath() %>/sheller/home';
		        }
		        // Nếu nhấn "Yes", sẽ ở lại trang hiện tại mà không làm gì
		    });
		<% } %>
	</script>
    <script>
    function increase(id) {
	        let counter = document.getElementById(id);
	        let count = parseInt(counter.textContent);
	        counter.textContent = count + 1;
	        document.getElementById(id + "Count").value = count + 1; // Cập nhật giá trị vào input ẩn tương ứng
	    }
	
	    function decrease(id) {
	        let counter = document.getElementById(id);
	        let count = parseInt(counter.textContent);
	        if (count > 0) { // Đảm bảo số không giảm xuống dưới 0
	            counter.textContent = count - 1;
	            document.getElementById(id + "Count").value = count - 1; // Cập nhật giá trị vào input ẩn tương ứng
	        }
	    }
	</script>
</body>
</html>
