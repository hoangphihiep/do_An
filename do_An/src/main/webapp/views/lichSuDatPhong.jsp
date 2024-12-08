<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
    <body>
        
        <div style = "margin-top: 70px;">
            <!-- Tiêu đề -->
			<div style = "display: flex; gap: 20px;">
            <div style = "flex: 2; margin-right: 100px;">
                <form id="form" class="form-dskhachsan">
                    <!-- Hộp thoại xác nhận -->
                    <div id="confirmDialog" class="confirmDialog" style="display: none;">
                        <button type="button" class="ui-confirmdialog-yes">Có</button>
                        <button type="button" class="ui-confirmdialog-no">Không</button>
                    </div>

                    <!-- Danh sách lịch sử đặt phòng -->
                    <c:forEach var="lichSu" items="${listLichSu}">
					    <div style="border: 1px solid #c0c0c0; border-radius: 5px; margin-top: 20px">
					        <div class="row" style="padding: 10px 0 10px 20px">
					            <div class="col-md-3" style="margin-left: -30px; margin-top: -20px">
					                <c:if test="${lichSu.anhPhong.substring(0,5) != 'https' }">
										<c:url value="/image?fname=${lichSu.anhPhong}" var="imgUrl"></c:url>
									</c:if> 
									<c:if test="${lichSu.anhPhong.substring(0,5) == 'https' }">
										<c:url value="${lichSu.anhPhong}" var="imgUrl"></c:url>
									</c:if>
									
					                <img src="${imgUrl}" style="width: 198px; height: 156px; border-radius: 5px;">
					            </div>
					            <div class="col-md-6">
					                <div style="font-weight: bold; color: #444">
					                    <span style="font-size: 18px; color: #077812">${lichSu.tenPhong}</span> - 
					                    <a href="${pageContext.request.contextPath}/khachsan?id=${lichSu.idKhachSan}" style="font-size: 16px; color: #0077CC">
					                        ${lichSu.tenKhachSan}
					                    </a>
					                </div>
					                <div style="font-size: 14px; color: #444444; margin-bottom: 5px">Ngày đặt: ${lichSu.ngayDat}</div>
					                <div style="font-size: 14px; margin-bottom: 5px">Đặt từ <span style="color: #007AD9; font-weight: bold">${lichSu.ngayDen}</span> đến <span style="color: #8A2BE2; font-weight: bold">${lichSu.ngayTra}</span></div>
					                <div style="font-size: 14px; margin-bottom: 5px">Tổng tiền: <span style="color: #E6004C; font-weight: bold">${lichSu.thanhTien} VND</span></div>
					                <div style="font-size: 14px; color: #444444; margin-bottom: 5px">Ghi chú: ${lichSu.ghiChu}</div>
					            </div>
					            <div class="col-md-3" style="text-align: right">
					                <div style="margin: 10px 20px">
					                    <c:choose>
					                        <c:when test="${lichSu.trangThai == 0}">
					                        	<button style="display: flex; align-items: center; padding: 10px 20px; border: 1px solid #4CAF50; border-radius: 5px; background-color: white; color: #4CAF50; font-size: 16px; cursor: pointer; margin-left: 50px">			      
											        Đã đặt
											    </button>
					                            <button type="button" class="cancel-button" onclick="huyDatPhong(${lichSu.id})" style="cursor: pointer; margin-right:22px">
					                                Hủy Đặt
					                            </button>
					                        </c:when>
					                        <c:when test="${lichSu.trangThai == 1}">
					                            <button style="display: flex; align-items: center; padding: 10px 20px; border: 1px solid #4CAF50; border-radius: 5px; background-color: white; color: #4CAF50; font-size: 16px; cursor: pointer;">
											        Đã thanh toán
											    </button>
					                        	<a href="#" data-toggle="modal" data-target="#comment" data-id="${lichSu.idKhachSan}" 
												   onclick="setModalId(${lichSu.idKhachSan})" 
												   style="padding: 10px 20px; color: white; background-color: #28a745; border: none; border-radius: 3px; cursor: pointer; margin-bottom: 5px; margin-top: 10px; margin-right: 37px; display: inline-block; text-decoration: none;">
												    Đánh giá
												</a>
					                        </c:when>
					                        <c:when test="${lichSu.trangThai == 2}">
					                            <button style="display: flex; align-items: center; padding: 10px 20px; border: 1px solid #4CAF50; border-radius: 5px; background-color: white; color: #4CAF50; font-size: 16px; cursor: pointer; margin-top: 34px; margin-left: 21px">
											        Quá hạn
											    </button>
					                        </c:when>
					                    </c:choose>
					                </div>
					            </div>
					        </div>
					    </div>
					</c:forEach>
                </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="comment" tabindex="-1" role="dialog" aria-labelledby="dangnhapLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 style="margin: 0; font-size: 18px; color: #333;">Đánh Giá</h5>
		                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
		                    <span aria-hidden="true">&times;</span>
		                </button>
		            </div>
		            <form action="\do_An\comment" method="post" enctype="multipart/form-data">
		                <div class="modal-body">
		                     <div style="margin-bottom: 15px;">
		                     	<input type="hidden" id="modal-id" name="id" value="">
			                    <label for="danhgia" style="display: block; margin-bottom: 5px; font-size: 14px; color: #555;">Đánh Giá</label>
			                    <select id="danhgia" name="danhgia" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 14px;">
			                        <option value="1">1 điểm</option>
			                        <option value="2">2 điểm</option>
			                        <option value="3">3 điểm</option>
			                        <option value="4">4 điểm</option>
			                        <option value="5">5 điểm</option>
			                        <option value="6">6 điểm</option>
			                        <option value="7">7 điểm</option>
			                        <option value="8">8 điểm</option>
			                        <option value="9">9 điểm</option>
			                        <option value="10">10 điểm</option>
			                    </select>
			                </div>
			                <div style="margin-bottom: 15px;">
			                    <label for="comment" style="display: block; margin-bottom: 5px; font-size: 14px; color: #555;">Nội Dung</label>
			                    <textarea id="comment" name="comment" rows="4" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 14px;"></textarea>
			                </div>
			                <div style="margin-bottom: 15px;">
			                    <div style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
			                        <div id="previewContainer1" style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
			                            <span id="placeholderText1" style="color: #aaa; font-size: 14px;">Chưa có ảnh</span>
			                            <img id="previewImage1" src="#" alt="Xem trước hình ảnh" style="display: none; width: 100%; height: 100%; object-fit: cover;">
			                        </div>
			                        <input type="file" id="imageUpload1" name="image1" style="display: none;" accept="image/*" onchange="previewImage(event, 'previewImage1', 'placeholderText1')">
			                        <button type="button" onclick="document.getElementById('imageUpload1').click()" style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
			                    </div>
			                </div>
			                
			                <button type="submit" style="width: 100%; padding: 10px; background-color: #28A745; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer;">
			                    Gửi
			                </button>
		                </div>
		         
		            </form>
		        </div>
		    </div>
		</div>
        <div style="margin-left: -70px; margin-top: 20px">
					    <ul style="display: flex; list-style-type: none; padding: 0; justify-content: center; align-items: center;">
					        <!-- Nút đầu tiên và nút trước -->
					        <li style="margin: 0 5px;">
					            <a href="?page=1" style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == 1 ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&laquo;</a>
					        </li>
					        <li style="margin: 0 5px;">
					            <a href="?page=${currentPage > 1 ? currentPage - 1 : 1}" style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == 1 ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&lsaquo;</a>
					        </li>
					
					        <!-- Các trang giữa -->
					        <c:forEach var="i" begin="1" end="${endPage}">
					            <li style="margin: 0 5px;">
					                <a href="?page=${i}" style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == i ? '#fff' : '#333'}; border: 1px solid ${currentPage == i ? '#007bff' : '#ddd'}; border-radius: 4px; background-color: ${currentPage == i ? '#007bff' : 'transparent'};">
					                    ${i}
					                </a>
					            </li>
					        </c:forEach>
					
					        <!-- Nút kế tiếp và nút cuối -->
					        <li style="margin: 0 5px;">
					            <a href="?page=${currentPage < endPage ? currentPage + 1 : endPage}" style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == endPage ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&rsaquo;</a>
					        </li>
					        <li style="margin: 0 5px;">
					            <a href="?page=${endPage}" style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == endPage ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&raquo;</a>
					        </li>
					    </ul>
					</div>
				</div>
        
        <script>
            // Script để hiển thị hộp thoại xác nhận
            function huyDatPhong(id) {
                if (confirm("Bạn có chắc chắn muốn hủy đặt phòng này không?")) {
                    window.location.href = '${pageContext.request.contextPath}/huyDatPhong?id=' + id;
                }
            }
        </script>
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
    <script>
	    function setModalId(id) {
	        document.getElementById('modal-id').value = id;
	    }
	</script>
    </body>
</html>
