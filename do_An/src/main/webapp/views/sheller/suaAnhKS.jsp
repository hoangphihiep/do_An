<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/sheller/sua/anhKS" method="post" enctype="multipart/form-data">
        <div style="font-family: Arial, sans-serif; width: 900px; margin: 50px auto; margin-left: -56px;">
            <!-- Phần chính tải ảnh -->
            <div style="text-align: center;">
                <h2 style="font-size: 18px; font-weight: bold; color: #333;">Khách sạn của Quý vị trông ra sao?</h2>
                <p style="font-size: 14px; color: #666; margin-bottom: 20px;">
                    Đăng tải ít nhất 5 ảnh của chỗ nghỉ. Càng đăng nhiều, Quý vị càng có cơ hội nổi bật trước khách hàng. Quý vị có thể thêm tối đa 8 tệp.
                </p>

                <!-- Sử dụng CSS Grid để sắp xếp ảnh -->
                <div style="display: grid; grid-template-columns: repeat(3, 1fr); gap: 20px; justify-items: center;">
                    <!-- Hàng đầu tiên chứa 1 ảnh -->
                    <div style="grid-column: span 3;">
                        <div style="width: 400px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
                            <div id="previewContainer1" style="width: 100%; height: 200px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
                                <span id="placeholderText1" style="color: #aaa; font-size: 14px;"></span>
                                <c:if test="${image1.substring(0,5) != 'https' }">
									<c:url value="/image?fname=${image1}" var="imgUrl"></c:url>
								</c:if> 
								<c:if test="${image1.substring(0,5) == 'https' }">
									<c:url value="${image1}" var="imgUrl"></c:url>
								</c:if>
                                <img id="previewImage1" src="${imgUrl}" style="width: 100%; height: 100%; object-fit: cover;">
                            </div>
                            <input type="file" id="imageUpload1" name="image1" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage1', 'placeholderText1')">
                            <input type="hidden" name="image1Url" value="${imgUrl}">
                            <button type="button" onclick="document.getElementById('imageUpload1').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
                        </div>
                    </div>

                    <!-- Hàng thứ hai chứa 3 ảnh -->
                    <div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					    <div id="previewContainer2" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
					        <span id="placeholderText2" style="color: #aaa; font-size: 14px;"></span>
					        <c:if test="${image2.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image2}" var="imgUrl"></c:url>
							</c:if> 
							<c:if test="${image2.substring(0,5) == 'https' }">
								<c:url value="${image2}" var="imgUrl"></c:url>
							</c:if>
					        <img id="previewImage2" src="${imgUrl}" style="width: 100%; height: 100%; object-fit: cover;">
					    </div>
					    <input type="file" id="imageUpload2" name="image2" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage2', 'placeholderText2')">
					    <input type="hidden" name="image2Url" value="${imgUrl}">
					    <button type="button" onclick="document.getElementById('imageUpload2').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
					
					<div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					    <div id="previewContainer3" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
					        <span id="placeholderText3" style="color: #aaa; font-size: 14px;"></span>
					    	<c:if test="${image3.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image3}" var="imgUrl"></c:url>
							</c:if> 
							<c:if test="${image3.substring(0,5) == 'https' }">
								<c:url value="${image3}" var="imgUrl"></c:url>
							</c:if>  
					        <img id="previewImage3" src="${imgUrl}" style="width: 100%; height: 100%; object-fit: cover;">
					    </div>
					    <input type="file" id="imageUpload3" name="image3" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage3', 'placeholderText3')">
					    <input type="hidden" name="image3Url" value="${imgUrl}">
					    <button type="button" onclick="document.getElementById('imageUpload3').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
					
					<div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					    <div id="previewContainer4" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
					        <span id="placeholderText4" style="color: #aaa; font-size: 14px;"></span>
					    	<c:if test="${image4.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image4}" var="imgUrl"></c:url>
							</c:if> 
							<c:if test="${image4.substring(0,5) == 'https' }">
								<c:url value="${image4}" var="imgUrl"></c:url>
							</c:if>     
					        <img id="previewImage4" src="${imgUrl}" style="width: 100%; height: 100%; object-fit: cover;">
					    </div>
					    <input type="file" id="imageUpload4" name="image4" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage4', 'placeholderText4')">
					    <input type="hidden" name="image4Url" value="${imgUrl}">
					    <button type="button" onclick="document.getElementById('imageUpload4').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>

                    <!-- Ảnh 5 -->
					<div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					    <div id="previewContainer5" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
					        <span id="placeholderText5" style="color: #aaa; font-size: 14px;"></span>
					        <c:if test="${image5.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image5}" var="imgUrl"></c:url>
							</c:if> 
							<c:if test="${image5.substring(0,5) == 'https' }">
								<c:url value="${image5}" var="imgUrl"></c:url>
							</c:if>   
					        <img id="previewImage5" src="${imgUrl}" style=" width: 100%; height: 100%; object-fit: cover;">
					    </div>
					    <input type="file" id="imageUpload5" name="image5" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage5', 'placeholderText5')">
					    <input type="hidden" name="image5Url" value="${imgUrl}">
					    <button type="button" onclick="document.getElementById('imageUpload5').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
					
					<!-- Ảnh 6 -->
					<div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					    <div id="previewContainer6" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
					        <span id="placeholderText6" style="color: #aaa; font-size: 14px;"></span>
					        <c:if test="${image6.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image6}" var="imgUrl"></c:url>
							</c:if> 
							<c:if test="${image6.substring(0,5) == 'https' }">
								<c:url value="${image6}" var="imgUrl"></c:url>
							</c:if>
					        <img id="previewImage6" src="${imgUrl}" style="width: 100%; height: 100%; object-fit: cover;">
					    </div>
					    <input type="file" id="imageUpload6" name="image6" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage6', 'placeholderText6')">
					    <input type="hidden" name="image6Url" value="${imgUrl}">
					    <button type="button" onclick="document.getElementById('imageUpload6').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
					
					<!-- Ảnh 7 -->
					<div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					    <div id="previewContainer7" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
					        <span id="placeholderText7" style="color: #aaa; font-size: 14px;"></span>
					        <c:if test="${image7.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image7}" var="imgUrl"></c:url>
							</c:if> 
							<c:if test="${image7.substring(0,5) == 'https' }">
								<c:url value="${image7}" var="imgUrl"></c:url>
							</c:if>
					        <img id="previewImage7" src="${imgUrl}" style="width: 100%; height: 100%; object-fit: cover;">
					    </div>
					    <input type="file" id="imageUpload7" name="image7" value="${imgUrl}" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage7', 'placeholderText7')">
					    <input type="hidden" name="image7Url" value="${imgUrl}">
					    <button type="button" onclick="document.getElementById('imageUpload7').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
                </div>

                <div style="max-width: 150px; margin-left: 400px; padding: 20px; margin-top: -10px;">
					<!-- Button submit để gửi form -->
					<button type="submit" style="display: block; background-color: #1a73e8; color: white; text-align: center; padding: 10px; font-size: 18px; font-weight: bold; text-decoration: none; border-radius: 5px; cursor: pointer;">
					   Sửa
					</button>
				</div>
            </div>
        </div>
    </form>

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

        <% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
            Swal.fire({
                title: 'Bạn đã chỉnh sửa thành công!',
                text: 'Bạn có muốn chỉnh sửa tiếp không?',
                icon: 'success',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes',
                cancelButtonText: 'No'
            }).then((result) => {
                if (result.isConfirmed) {
                    // Chuyển hướng khi nhấn "Yes"
                    window.location.href = '<%= request.getContextPath() %>/sheller/suaChoNghi/anhKhachSan';
                } else if (result.isDismissed) {
                    // Chuyển hướng khi nhấn "No"
                    window.location.href = '<%= request.getContextPath() %>/sheller/home';
                }
            });
        <% } %>
    </script>
</body>
</html>