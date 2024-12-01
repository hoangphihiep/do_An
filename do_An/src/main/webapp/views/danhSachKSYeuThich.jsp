<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Danh sách Khách sạn</title>
</head>
<body>
	<div style = "width: 90%;margin-right: 100px; margin-top: 70px;">
		<h3 style="text-align: center; color: #444; margin-bottom: 0px">Các khách sạn yêu thích</h3>
		<div class="row">
				<div class="col-md-9">
					<c:forEach var="ksthich" items="${listThichKhachSan}">
					<div
						style="display: flex; border: 1px solid #ccc; border-radius: 10px; overflow: hidden; width: 800px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
						<div style="width: 300px; display: flex; flex-direction: column;">
							<c:forEach items="${anhMap[ksthich.idKS]}" var="anh">
								<c:if test="${anh.vaiTroCuaAnh == 'AnhChinh'}">
									<c:choose>
										<c:when
											test="${anh.urlAnhKhachSan.substring(0, 6) == 'https:'}">
											<c:url value="${anh.urlAnhKhachSan}" var="imgUrl"></c:url>
										</c:when>
										<c:otherwise>
											<c:url value="/image?fname=${anh.urlAnhKhachSan}"
												var="imgUrl"></c:url>
										</c:otherwise>
									</c:choose>
									<div
										style="position: relative; display: inline-block; width: 100%;">
										<img
											style="width: 100%; height: 260px; object-fit: cover; border-radius: 5px; margin-top: 5px; margin-left: 5px;"
											src="${imgUrl}" alt="Hotel Image">
										<div
											style="position: absolute; top: 10px; right: 0px; width: 50px; height: 50px; display: flex; justify-content: center; align-items: center;">
											<div onclick="toggleHeart(this, ${ksthich.ks.id})"
												style="width: 40px; height: 40px; border-radius: 50%; background-color: white; display: flex; justify-content: center; align-items: center; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); cursor: pointer;">
												<svg id="heart" xmlns="http://www.w3.org/2000/svg"
													width="20" height="20" viewBox="0 0 24 24"
													fill="red"
													stroke="black" stroke-width="2" stroke-linecap="round"
													stroke-linejoin="round"> <path
													d="M20.8 4.6a5.6 5.6 0 0 0-7.8 0L12 5.6l-1-1a5.6 5.6 0 0 0-7.8 7.8l1 1 7.8 7.8 7.8-7.8 1-1a5.6 5.6 0 0 0 0-7.8z"></path>
												</svg>
											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
							<div
								style="display: flex; justify-content: space-between; margin-top: 5px;">
								<c:forEach items="${anhMap[ksthich.idKS]}" var="anh" begin="0" end="3">
									<c:if test="${anh.vaiTroCuaAnh.startsWith('Anhphu')}">
										<!-- Display images in two columns, so each row will have two images -->
										<c:choose>
											<c:when
												test="${anh.urlAnhKhachSan.substring(0, 6) == 'https:'}">
												<c:url value="${anh.urlAnhKhachSan}" var="imgUrl"></c:url>
											</c:when>
											<c:otherwise>
												<c:url value="/image?fname=${anh.urlAnhKhachSan}"
													var="imgUrl"></c:url>
											</c:otherwise>
										</c:choose>
										<img
											style="width: 72px; height: 60px; object-fit: cover; border-radius: 5px; flex: 1; margin-left: 10px;"
											src="${imgUrl}" alt="Side Image">
									</c:if>
								</c:forEach>
							</div>
						</div>
						<div
							style="padding: 20px; width: 100%; display: flex; flex-direction: column; justify-content: space-between;">
							<div
								style="display: flex; justify-content: space-between; align-items: flex-start;">
								<a
									href="${pageContext.request.contextPath}/khachsan?id=${ksthich.idKS}"
									class="link-khachsan"
									style="display: inline-block; text-decoration: none;">
									<h2 style="margin: 0; font-size: 24px; margin-top: -10px;">${ksthich.ks.ten}</h2>
								</a>
								<div id="star-rating-${ksthich.ks.id}"
									style="display: flex; align-items: center; gap: 5px;"></div>
							</div>
							<div style="font-size: 14px; color: #666; margin-top: -10px;">${ksthich.ks.diaChi}</div>
							<div style="text-align: right;">
								<div
									style="text-decoration: line-through; color: #999; font-size: 14px;"></div>
								<c:forEach items="${phongMap[ksthich.ks.id]}" var="phong">
									<c:if test="${phong.giaThue > phong.tienThueSauKhiGiam}">
										<div style="margin: 10px 0;">
											<span
												style="font-size: 14px; text-decoration: line-through; color: #999;">${phong.giaThue}
												VND</span>
										</div>
										<div style="color: red; font-size: 24px; font-weight: bold;">${phong.tienThueSauKhiGiam}
											VNĐ</div>
									</c:if>
									<c:if test="${phong.giaThue == phong.tienThueSauKhiGiam}">
										<div style="color: red; font-size: 24px; font-weight: bold;">${phong.giaThue}
											VNĐ</div>
									</c:if>
								</c:forEach>
							</div>
							<div style="margin-top: -60px;">
								<c:if test="${!empty khyenMaiMap[ksthich.ks.id]}">
									<div style="font-size: 14px; color: #666; margin-top: -10px;">Ưu đãi:</div>
									<c:forEach items="${khyenMaiMap[ksthich.ks.id]}" var="khuyenMai">
										<span
											style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${khuyenMai.ten}</span>
									</c:forEach>
								</c:if>
							</div>
							<div style="margin-top: 20px;">
								<c:if test="${!empty tienIchMap[ksthich.ks.id]}">
									<div style="font-size: 14px; color: #666; margin-top: -10px;">Cơ sở lưu trú này có:</div>
									<c:forEach items="${tienIchMap[ks.id]}" var="tienIch">
										<c:if test="${tienIch.idLoaiTienNghi == 5}">
											<span
												style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${tienIch.tenTienNghi}</span>
										</c:if>
										<c:if test="${tienIch.idLoaiTienNghi == 7}">
											<span
												style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${tienIch.tenTienNghi}</span>
										</c:if>
										<c:if test="${tienIch.idLoaiTienNghi == 8}">
											<span
												style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${tienIch.tenTienNghi}</span>
										</c:if>
									</c:forEach>
								</c:if>


							</div>
							<div style="color: #0071c2; font-size: 16px;">
								<div style="font-size: 14px; color: #666; margin-top: 10px;">
									<span style="font-weight: bold; color: #077812">${ksthich.ks.tenDiaDiem}</span>
									- Cách trung tâm: ${ksthich.ks.cachTrungTam} m
								</div>
								<div style="font-size: 14px; color: #666; margin-top: 10px;">${ksthich.ks.tenLoaiKhachSan}</div>
								<div style="font-size: 14px; color: #666; margin-top: 10px;">${ksthich.ks.giapBien?"Có":"Không"}
									giáp biển</div>
								<div style="font-size: 13px; color: #666666">${ksthich.ks.moTa}</div>
							</div>
						</div>
					</div>

					<br>
					</c:forEach> 
					<div style="margin-left: 100px">
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
				
			</div>
		</div>

 <script>
    // Hàm hiển thị số sao
    function displayStars(rating, containerId) {
        const maxStars = 5;
        const starContainer = document.getElementById(containerId);

        // Xóa sao cũ (nếu có)
        starContainer.innerHTML = '';

        for (let i = 1; i <= maxStars; i++) {
            const star = document.createElement('span');
            star.style.color = (i <= rating) ? '#f57c00' : '#ccc';
            star.style.fontSize = '20px';
            star.innerHTML = '★';
            starContainer.appendChild(star);
        }
    }

    // Gọi hàm hiển thị sao cho từng khách sạn
    <c:forEach var="ksthich" items="${listThichKhachSan}">
        displayStars(${ksthich.ks.danhGia}, 'star-rating-${ksthich.ks.id}');
    </c:forEach>
</script>

<!-- Thêm JavaScript -->
<script type="text/javascript">
    function submitForm() {
        document.getElementById("filterForm").submit();
    }
</script>

<script>
	function toggleHeart(element, ksId) {
	    console.log("Hàm toggleHeart đã được gọi");
	    console.log("ksId:", ksId);
	
	    const heart = element.querySelector('#heart');
	    const isRed = heart.getAttribute('fill') === 'red';
	
	    // Toggle heart color
	    heart.setAttribute('fill', isRed ? 'none' : 'red');
	
	    // Tạo XHR Request
	    const xhr = new XMLHttpRequest();
	    xhr.open("POST", "/do_An/danhsachks/thichKS", true);
	    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
	    
	    xhr.send("favorite=" + (!isRed) + "&ksId=" + ksId);
	    // Kiểm tra phản hồi từ server
	    xhr.onload = function () {
	        if (xhr.status === 200) {
	            console.log("Phản hồi thành công:", xhr.responseText);
	        } else {
	            console.error("Lỗi gửi yêu cầu:", xhr.status, xhr.statusText);
	        }
	    };
	}
</script>
</body>
</html>