<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Hình Ảnh</title>

</head>
<body>
	<form action="${pageContext.request.contextPath }/sheller/anhKS" method ="post" enctype="multipart/form-data">
		<div style="font-family: Arial, sans-serif; width: 900px; margin: 50px auto; display: flex; gap: 20px;">
	        <!-- Phần chính tải ảnh -->
	        <div style="flex: 1;">
	            <h2 style="font-size: 18px; font-weight: bold; color: #333;">Khách sạn của Quý vị trông ra sao?</h2>
	            <p style="font-size: 14px; color: #666; margin-bottom: 20px;">
	                Đăng tải ít nhất 5 ảnh của chỗ nghỉ. Càng đăng nhiều, Quý vị càng có cơ hội nổi bật trước khách hàng. Quý vị có thể thêm tối đa 8 tệp.
	            </p>
	            <div style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: center;"> 
	            	<!-- Image Upload Placeholder for image1 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview1" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput1" name="image1" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview1')">
			            <button type="button" onclick="document.getElementById('fileInput1').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
			
			        <!-- Image Upload Placeholder for image2 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview2" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput2" name="image2" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview2')">
			            <button type="button" onclick="document.getElementById('fileInput2').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
			        
			        <!-- Image Upload Placeholder for image3 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview3" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput3" name="image3" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview3')">
			            <button type="button" onclick="document.getElementById('fileInput3').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
		            
		            <!-- Image Upload Placeholder for image4 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview4" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput4" name="image4" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview4')">
			            <button type="button" onclick="document.getElementById('fileInput4').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
			        
			        <!-- Image Upload Placeholder for image5 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview5" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput5" name="image5" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview5')">
			            <button type="button" onclick="document.getElementById('fileInput5').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
			        
			        <!-- Image Upload Placeholder for image6 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview6" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput6" name="image6" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview6')">
			            <button type="button" onclick="document.getElementById('fileInput6').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
			        
			        <!-- Image Upload Placeholder for image7 -->
			        <div style="width: 170px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			            <div id="imagePreview7" style="flex: 1; display: flex; justify-content: center; align-items: center;">
			            </div>
			            <input type="file" id="fileInput7" name="image7" accept="image/*" style="display: none;" onchange="handleFileUpload(event, 'imagePreview7')">
			            <button type="button" onclick="document.getElementById('fileInput7').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">
			                +
			            </button>
			        </div>
	            </div>
	             
	            <!-- Nút tiếp tục -->
	            <button type="submit" style="background-color: #0071c2; color: #fff; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin-top: 20px; font-size: 14px;">
    				Hoàn thành
				</button>
	        </div>
	        
	        <!-- Phần hướng dẫn bên phải -->
	        <div style="width: 250px; background-color: #f7f7f7; padding: 20px; border: 1px solid #ccc; border-radius: 4px;">
	            <h3 style="color: #333; font-size: 15px; font-weight: bold; margin-bottom: 10px;">Nếu tôi không có ảnh chụp chuyên nghiệp thì sao?</h3>
	            <p style="font-size: 13px; color: #666;">
	                Khách hàng có thể sẽ thấy khó tưởng tượng ra chỗ nghỉ của Quý vị nếu không có hình ảnh. Chúng tôi có một vài mẹo cho Quý vị về cách tạo ảnh chất lượng ngay cả khi không cần chụp chuyên nghiệp.
	            </p>
	            <p style="font-size: 13px; color: #0071c2;">Xem cách để tạo ảnh đẹp cho chỗ nghỉ của Quý vị</p>
	            <p style="font-size: 13px; color: #666;">
	                Tất cả các ảnh tải lên cần phải là ảnh thật về khách sạn của Quý vị. Ảnh cần rõ ràng và không chứa bất kỳ nội dung nào không liên quan đến chỗ nghỉ.
	            </p>
	        </div>
	    </div>
	</form>
	<script>
		function handleFileUpload(event, previewId) {
		    const files = event.target.files;
		    const imagePreview = document.getElementById(previewId);
		    imagePreview.innerHTML = ''; // Xóa ảnh cũ trước khi thêm ảnh mới
	
		    for (const file of files) {
		        const reader = new FileReader();
		        reader.onload = function(e) {
		            const div = document.createElement('div');
		            div.style.border = '2px solid #ccc';
		            div.style.width = '170px'; // Kích thước khung hiển thị
		            div.style.height = '170px';
		            div.style.position = 'relative';
		            
		            const img = document.createElement('img');
		            img.src = e.target.result;
		            img.style.width = '150px';  // Kích thước ảnh
		            img.style.height = '150px';
		            img.style.objectFit = 'cover';
		            img.style.borderRadius = '10px'; // Góc bo tròn nếu cần
	
		            // Tạo nút đóng
		            const closeButton = document.createElement('span');
		            closeButton.innerHTML = '&times;';
		            closeButton.style.position = 'absolute';
		            closeButton.style.top = '-10px';
		            closeButton.style.right = '-10px';
		            closeButton.style.backgroundColor = '#fff';
		            closeButton.style.border = '1px solid #ccc';
		            closeButton.style.borderRadius = '50%';
		            closeButton.style.cursor = 'pointer';
		            closeButton.style.padding = '2px 6px';
		            closeButton.onclick = () => div.remove(); // Xóa ảnh khi nhấn nút đóng
	
		            div.appendChild(img);
		            div.appendChild(closeButton);
		            imagePreview.appendChild(div);
		        };
		        reader.readAsDataURL(file);
		    }
		}
		<% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
		    Swal.fire({
		        title: 'Bạn thêm đăng ký khách sạn thành công!',
		        text: 'Bạn có muốn thêm phòng không?',
		        icon: 'success',
		        showCancelButton: true,
		        confirmButtonColor: '#3085d6',
		        cancelButtonColor: '#d33',
		        confirmButtonText: 'Yes',
		        cancelButtonText: 'No'
		    }).then((result) => {
		        if (result.isConfirmed) {
		            // Chuyển hướng khi nhấn "Yes"
		            window.location.href = '<%= request.getContextPath() %>/sheller/dangChoNghi/phong';
		        } else if (result.isDismissed) {
		            // Chuyển hướng khi nhấn "No"
		            window.location.href = '<%= request.getContextPath() %>/sheller/home';
		        }
		    });
		<% } %>
	</script>
</body>
</html>
