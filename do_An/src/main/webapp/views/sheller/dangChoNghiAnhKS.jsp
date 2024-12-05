<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Hình Ảnh</title>
<!-- Include SweetAlert library -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
    <form action="${pageContext.request.contextPath }/sheller/anhKS" method="post" enctype="multipart/form-data">
        <div style="max-width: 900px; margin: 50px auto; padding: 20px; background-color: #fff; border: 1px solid #ddd; border-radius: 8px;">
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
                                <span id="placeholderText1" style="color: #aaa; font-size: 14px;">Chưa có ảnh</span>
                                <img id="previewImage1" src="#" alt="Xem trước hình ảnh" style="display: none; width: 100%; height: 100%; object-fit: cover;">
                            </div>
                            <input type="file" id="imageUpload1" name="image1" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage1', 'placeholderText1')" required>
                            <button type="button" onclick="document.getElementById('imageUpload1').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
                        </div>
                    </div>

                    <!-- Hàng thứ hai chứa 3 ảnh -->
                    <% for (int i = 2; i <= 4; i++) { %>
                    <div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
                        <div id="previewContainer<%=i%>" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
                            <span id="placeholderText<%=i%>" style="color: #aaa; font-size: 14px;">Chưa có ảnh</span>
                            <img id="previewImage<%=i%>" src="#" alt="Xem trước hình ảnh" style="display: none; width: 100%; height: 100%; object-fit: cover;">
                        </div>
                        <input type="file" id="imageUpload<%=i%>" name="image<%=i%>" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage<%=i%>', 'placeholderText<%=i%>')" required>
                        <button type="button" onclick="document.getElementById('imageUpload<%=i%>').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
                    </div>
                    <% } %>

                    <!-- Hàng thứ ba chứa 3 ảnh -->
                    <% for (int i = 5; i <= 7; i++) { %>
                    <div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
                        <div id="previewContainer<%=i%>" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
                            <span id="placeholderText<%=i%>" style="color: #aaa; font-size: 14px;">Chưa có ảnh</span>
                            <img id="previewImage<%=i%>" src="#" alt="Xem trước hình ảnh" style="display: none; width: 100%; height: 100%; object-fit: cover;">
                        </div>
                        <input type="file" id="imageUpload<%=i%>" name="image<%=i%>" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage<%=i%>', 'placeholderText<%=i%>')" required>
                        <button type="button" onclick="document.getElementById('imageUpload<%=i%>').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
                    </div>
                    <% } %>
                </div>

                <!-- Nút hoàn thành -->
                <button type="submit" style="background-color: #0071c2; color: #fff; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin-top: 20px; font-size: 14px;">
                    Hoàn thành
                </button>
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
                title: 'Bạn đăng ký khách sạn thành công!',
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
