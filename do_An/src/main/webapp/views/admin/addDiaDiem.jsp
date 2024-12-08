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
        <section style=" margin-left: 250px; margin-top: 10px; max-width: 500px; background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
            <h2 style="color: #007BFF; margin-bottom: 15px;">Tạo địa điểm mới</h2>
            <form action="${pageContext.request.contextPath}/admin/diaDiem/insert" method="post" enctype="multipart/form-data">
                <label for="diadiem" style="display: block; margin-bottom: 5px;">Tên địa điểm:</label>
				<input type="text" id="tendiadiem" name="tendiadiem" placeholder="Nhập tên địa điểm" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">
                    
                <label for="mota" style="display: block; margin-bottom: 5px;">Mô tả:</label>
				<input type="text" id="mota" name="mota" placeholder="Nhập mô tả" 
                    style="width: 97%; padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 5px;">

				<div style="margin-bottom: 15px;">
					<div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
						<div id="previewContainer1" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
							<span id="placeholderText1" style="color: #aaa; font-size: 14px;">Chưa có ảnh</span> <img id="previewImage1" src="#" alt="Xem trước hình ảnh"
								style="display: none; width: 100%; height: 100%; object-fit: cover;">
						</div>
						<input type="file" id="imageUpload1" name="image1"
							style="display: none;" accept="image/*"
							onchange="previewImage(event, 'previewImage1', 'placeholderText1')">
						<button type="button"
							onclick="document.getElementById('imageUpload1').click()"
							style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
				</div>

				<button type="submit" style="background-color: #007BFF; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">
                    Tạo địa điểm
                </button>
            </form>
        </section>
    </div>
	<script>
	        // Function to preview images
	        function previewImage(event, previewId, placeholderId) {
	            const placeholderText = document.getElementById(placeholderId);
	            const imagePreview = document.getElementById(previewId);
	            const file = event.target.files[0];
	
	            if (file) {
	                const reader = new FileReader();
	                reader.onload = function(e) {
	                    placeholderText.style.display = 'none'; // Ẩn văn bản "Chưa có ảnh"
	                    imagePreview.src = e.target.result; // Gán đường dẫn ảnh cho img
	                    imagePreview.style.display = 'block'; // Hiển thị ảnh xem trước
	                };
	                reader.readAsDataURL(file);
	            }
	        }
    </script>
</body>
</html>