<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Danh sách Khách sạn</title>
</head>
<body>
	<div style = "width: 90%;margin: auto;">
		<h3 style="text-align: center; color: #444; margin-bottom: 0px">Các
			Khách sạn tìm thấy</h3>
		<div class="row">
			
			<div class="col-md-3">
				<div
					style="border: 1px solid #c0c0c0; border-radius: 5px; margin-top: 20px">
					<form id="filterForm" method="post" action="${pageContext.request.contextPath}/danhsachks/locks">
					    <div style="padding: 10px 0 8px 20px">
					        <span style="font-size: 16px; font-weight: bold">Chọn lọc theo</span>
					    </div>
						<div>
						  <div class="row">
						    <div class="col-sm-12">
						      <div id="slider-range"></div>
						    </div>
						  </div>
						  <div class="row slider-labels">
						    <div class="col-xs-6 caption">
						      <strong>Min:</strong> <span id="slider-range-value1"></span>
						    </div>
						    <div class="col-xs-6 text-right caption">
						      <strong>Max:</strong> <span id="slider-range-value2"></span>
						    </div>
						  </div>
						  <div class="row">
						    <div class="col-sm-12">
						        <input type="hidden" name="min-value" value="">
						        <input type="hidden" name="max-value" value="">
						    </div>
						  </div>
						</div>
					    <!-- Xếp hạng -->
					    <div class="khoi-loc">
					        <div class="head">Xếp hạng</div>
					        <c:forEach var="xephang" items="${listxh}" varStatus="status">
					            <div>
					                <input type="checkbox" class="filter-checkbox" name="ranking" value="${xephang.label}" 
					                <c:if test="${xephang.checked}">checked="checked"</c:if> 
					                onchange="submitForm()" />
					                ${xephang.label}
					            </div>
					        </c:forEach>
					    </div>
					
					    <!-- Loại khách sạn -->
					    <div class="khoi-loc">
					        <div class="head">Loại khách sạn</div>
					        <c:forEach var="loaiks" items="${listloaiks}">
					            <div>
					                <input type="checkbox" class="filter-checkbox" name="hotelType" value="${loaiks.label}" 
					                <c:if test="${loaiks.checked}">checked="checked"</c:if> 
					                onchange="submitForm()" />
					                ${loaiks.label}
					            </div>
					        </c:forEach>
					    </div>
					
					    <!-- Tiện ích -->
					    <div class="khoi-loc">
					        <div class="head">Tiện ích</div>
					        <c:forEach var="buaan" items="${listBuaAn}">
					            <div>
					                <input type="checkbox" class="filter-checkbox" name="mealType" value="${buaan.label}" 
					                <c:if test="${buaan.checked}">checked="checked"</c:if> 
					                onchange="submitForm()" />
					                ${buaan.label}
					            </div>
					        </c:forEach>
					    </div>
					
					    <!-- Cách trung tâm -->
					    <div class="khoi-loc">
					        <div class="head">Cách trung tâm</div>
					        <c:forEach var="cachtrungtam" items="${listCachTrungTam}">
					            <div>
					                <input type="checkbox" class="filter-checkbox" name="distanceFromCenter" value="${cachtrungtam.label}" 
					                <c:if test="${cachtrungtam.checked}">checked="checked"</c:if> 
					                onchange="submitForm()" />
					                ${cachtrungtam.label}
					            </div>
					        </c:forEach>
					    </div>
					
					    <!-- Giáp biển -->
					    <div class="khoi-loc">
					        <div class="head">Giáp biển</div>
					        <c:forEach var="giapbien" items="${listGiapBien}">
					            <div>
					                <input type="checkbox" class="filter-checkbox" name="nearSea" value="${giapbien.label}" 
					                <c:if test="${giapbien.checked}">checked="checked"</c:if> 
					                onchange="submitForm()" />
					                ${giapbien.label}
					            </div>
					        </c:forEach>
					    </div>
					    
					</form>
				</div>
			</div>

					<div class="col-md-9">
					<c:forEach var="ks" items="${listks}">
						<a href="<c:url value='/khachsan?id=${ks.id}'/>" class="link-khachsan">
							<div style="display: flex; border: 1px solid #ccc; border-radius: 10px; overflow: hidden; width: 800px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
						        <div style="width: 300px; display: flex; flex-direction: column;">
							        <c:forEach items="${anhMap[ks.id]}" var="anh">
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
													<img style="width: 100%; height: 200px; object-fit: cover; border-radius: 5px; margin-top: 5px; margin-left: 5px;" src="${imgUrl}" alt="Hotel Image">
											</c:if>
										</c:forEach>
										
											<div style="display: flex; justify-content: space-between; margin-top: 5px;">
									            <c:forEach items="${anhMap[ks.id]}" var="anh" begin="0" end="3">
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
							        <div style="padding: 20px; width: 100%; display: flex; flex-direction: column; justify-content: space-between;">
							            <div style="display: flex; justify-content: space-between; align-items: flex-start;">
							                <h2 style="margin: 0; font-size: 24px; margin-top: -10px;">${ks.ten}</h2>
							                <div id="star-rating-${ks.id}" style="display: flex; align-items: center; gap: 5px;">
							                     
							                </div>
							            </div>
							            <div style="text-align: right;">
							                <div style="text-decoration: line-through; color: #999; font-size: 14px;"></div>
							                <c:forEach items="${phongMap[ks.id]}" var="phong" >
							                	<div style="color: red; font-size: 24px; font-weight: bold;">${phong.giaThue} VNĐ</div>
							            	</c:forEach>
							            </div>
							            <div style="font-size: 14px; color: #666; margin-top: -30px;">${ks.diaChi}</div>
							            <div style="margin-top: 20px;">
							            	<div style="font-size: 14px; color: #666; margin-top: -10px;">Cơ sở lưu trú này có: </div>
							            	<c:forEach items="${tienIchMap[ks.id]}" var="tienIch" >
								                <c:if test="${tienIch.idLoaiTienNghi == 5}">
									                <span style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${tienIch.tenTienNghi}</span>
							            		</c:if>
							            		<c:if test="${tienIch.idLoaiTienNghi == 7}">
									                <span style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${tienIch.tenTienNghi}</span>
							            		</c:if>
							            		<c:if test="${tienIch.idLoaiTienNghi == 8}">
									                <span style="display: inline-block; padding: 5px 10px; background-color: #f2f2f2; border-radius: 5px; margin-right: 10px;">${tienIch.tenTienNghi}</span>
							            		</c:if>
							            	</c:forEach>
							            	
							            </div>
							            <div style="color: #0071c2; font-size: 16px;">
							                <div style="font-size: 14px; color: #666; margin-top: 10px;"><span style="font-weight: bold; color: #077812">${ks.tenThanhPho}</span> - Cách trung tâm: ${ks.cachTrungTam} m</div>
							            	<div style="font-size: 14px; color: #666; margin-top: 10px;">${ks.tenLoaiKhachSan}</div>
                                            <div style="font-size: 14px; color: #666; margin-top: 10px;">${ks.giapBien?"Có":"Không"} giáp biển </div>
                                            <div style="font-size: 13px; color: #666666">${ks.moTa}</div>
							            </div>
							            
							        </div>
							     </div> 
							   </a> 
							   <br>
							</c:forEach> 
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
    <c:forEach var="ks" items="${listks}">
        displayStars(${ks.danhGia}, 'star-rating-${ks.id}');
    </c:forEach>
</script>

<!-- Thêm JavaScript -->
<script type="text/javascript">
    function submitForm() {
        document.getElementById("filterForm").submit();
    }
</script>

</body>
</html>