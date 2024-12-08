<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<body>
	<script>
		link_active = 2;
	</script>
	<div class="c80">
		<h3 style="text-align: center; color: #444; margin-bottom: 0px">Thông
			tin Khách sạn</h3>
		<div class="row">
			<div class="col-md-3">
				<div style="margin-top: 20px">
					<div
						style="text-align: center; font-size: 18px; font-weight: bold; color: #007AD9; margin-top: 20px">
						${ks.danhGia} &#9733;  ${strDanhGia[ks.danhGia]}
					</div>
					<div
						style="border-radius: 3px; border: 1px solid #c0c0c0; margin-bottom: 20px; padding: 0 0 10px 0">
							<c:if test="${ks.urlHinhAnhThanhPho.substring(0,5) != 'https' }">
	                            <c:url value="/image?fname=${ks.urlHinhAnhThanhPho}" var="imgUrl"></c:url>
	                        </c:if>
	                        <c:if test="${ks.urlHinhAnhThanhPho.substring(0,5) == 'https' }">
	                            <c:url value="${ks.urlHinhAnhThanhPho}" var="imgUrl"></c:url>
	                        </c:if>
						<div
							style="width: 261px; height: 229px; border-radius: 3px; background: linear-gradient(transparent 70%, black), url(${imgUrl}); background-size: 261px 229px; background-repeat: no-repeat; background-position: center">
						</div>
						<div
							style="position: relative; top: -30px; left: 20px; color: white; font-size: 16px">
							Cách ${ks.tenDiaDiem} ${ks.cachTrungTam}m</div>
						<div style="margin: -10px 10px 0 10px">Một trong những khu
							vực đẹp nhất ở ${ks.tenDiaDiem}</div>
					</div>
					<div
						style="border-radius: 3px; background-color: #E9F0FA; border: 1px solid #CCE1FF; text-align: center; padding: 12px 8px 16px 8px; margin-bottom: 20px">
						Bạn thích chỗ nghỉ này, nhưng vẫn chưa chắc chắn?
						<button class="btn btn-kstuongtu">Xem các khách sạn tương
							tự</button>
					</div>
					<div
						style="border-radius: 3px; border: 1px solid #c0c0c0; text-align: center; padding: 12px 8px 16px 8px">
						Có thể bạn thắc mắc?<br /> Đang vướng mắc một điều gì đó?<br />
						<button class="btn btn-default"
							style="width: 90%; margin-top: 17px; border: 1px solid #0077CC; color: #0077CC">Đặt
							câu hỏi</button>
					</div>
					
				</div>
			</div>
			<div class="col-md-9">
				<div style="margin: 14px 0 5px 12px">
					<div style="font-size: 24px; font-weight: bold">${ks.ten}</div>
					<button class="btn-datngay"
						style="margin-top: -10px; padding: 3px; font-size: 14px; width: 90px; height: 30px; float: right"
						onClick="window.location = '#phongtrong'">Đặt ngay</button>
				</div>
				<div
					style="font-size: 14px; color: #007AD9; margin: 4px 0 10px 12px">
					<img style="height: 22px" src="/do_An/Content/Images/Position.png"
						alt="Img" /> ${ks.diaChi}
				</div>

				<div
					style="margin-top: 20px; background-color: #E9F0FA; border-radius: 3px; display: flex; gap: 10px;">

					<!-- Main Large Image (70% of space) -->
					<div style="flex-basis: 70%;">
						<c:forEach items="${listAnh}" var="anh">
							<c:if test="${anh.vaiTroCuaAnh == 'AnhChinh'}">
								<div style="margin-right: 10px;">
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
									<img style="width: 585px; height: 389px; border-radius: 10px;"
										src="${imgUrl}" alt="Main Image">
								</div>
							</c:if>
						</c:forEach>
					</div>

					<!-- Side Smaller Images (30% of space) -->
					<div
						style="flex-basis: 30%; display: grid; grid-template-columns: repeat(2, 1fr); gap: 10px;">
						<c:forEach items="${listAnh}" var="anh">
							<c:if test="${anh.vaiTroCuaAnh.startsWith('Anhphu')}">
								<!-- Display images in two columns, so each row will have two images -->
								<div style="display: flex; gap: 10px;">
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
										style="width: 124px; height: 124px; border-radius: 10px; flex: 1;"
										src="${imgUrl}" alt="Side Image">
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div>
					<div style="margin-left: 19px; margin-top: 18px">
						<div
							style="color: #FEBB02; height: 32px; position: relative; margin-left: -px;">
							<div
								style="position: absolute; font-size: 26px; left: 10px; top: -10px">&#10026;</div>
							<div
								style="position: absolute; font-size: 16px; font-weight: bold; left: 40px; top: -4px">
								Một trong những chỗ nghỉ bán chạy nhất ở ${ks.tenDiaDiem} của
								chúng tôi!</div>
						</div>
						<div>
							<div style="font-size: 14px; color: #222">Cách trung tâm:
								${ks.cachTrungTam} m</div>
							<div style="font-size: 14px; color: #222">${ks.tenLoaiKhachSan}</div>
							<div style="font-size: 14px">Giáp biển: ${ks.giapBien ? "Có" : "Không"}</div>
							<div style="font-size: 14px; color: #222; margin-top: 8px">${ks.moTa}</div>
						</div>
					</div>
				</div>
				<div>
					<h3 id="phongtrong">Phòng trống</h3>
					<div
						style="height: 120px; background-color: #FFD257; border: 1px solid #E2AA11; padding: 10px 0 0 20px">
						<span>Bạn muốn nghỉ tại <b>${ks.ten}</b> vào lúc nào?
						</span>
						<form action="${pageContext.request.contextPath}/khachsan"
							method="get">
							<div class="row" style="margin-top: 20px;">
								<div class="col-md-3">
									<label for="ngayDen" class="form-label">Ngày nhận phòng</label>
									<input type="date" class="form-control" id="ngayDen"
										name="ngayDen" required
										value="${ngayDen != null ? ngayDen : ''}">
								</div>
								<div class="col-md-3">
									<label for="ngayTra" class="form-label">Ngày trả phòng</label>
									<input type="date" class="form-control" id="ngayTra"
										name="ngayTra" required
										value="${ngayDi != null ? ngayDi : ''}">
								</div>
								<div class="col-md-6 d-flex align-items-end"
									style="margin-top: 18px">
									<button type="submit" class="btn btn-primary w-100">Kiểm
										tra phòng trống</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-left: 0px; margin-top: 10px;">
		<table
			style="width: 100%; max-width: 1180px; margin: auto; border-collapse: collapse; font-family: Arial, sans-serif; border: 1px solid #ddd; background-color: #f9f9f9;">
			<thead>
				<tr
					style="background-color: #0078d4; color: white; text-align: left; font-size: 16px;">
					<th style="padding: 15px; border: 1px solid #ddd; width: 300px;">Phòng</th>
					<th style="padding: 15px; border: 1px solid #ddd; text-align: center;">Số lượng khách</th>
					<th style="padding: 15px; border: 1px solid #ddd; text-align: center;">Giá cho 1 đêm</th>
					<th style="padding: 15px; border: 1px solid #ddd;">Các tiện nghi</th>
					<th style="padding: 15px; border: 1px solid #ddd; text-align: center;">Số phòng</th>
					<th style="padding: 15px; border: 1px solid #ddd; text-align: center;"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="phong" items="${listPhong}">
					<tr>
						<td style="padding: 15px; border: 1px solid #ddd; vertical-align: top;">
						    <div style="display: flex; flex-direction: column; align-items: flex-start;">
						        <!-- Tên phòng -->
						        <strong style="font-size: 16px; margin-bottom: 10px;">${phong.ten}</strong>
						        
						        <!-- Kiểm tra đường dẫn ảnh -->
						        <c:if test="${phong.anhPhong.substring(0,5) != 'https' }">
						            <c:url value="/image?fname=${phong.anhPhong}" var="imgUrl"></c:url>
						        </c:if> 
						        <c:if test="${phong.anhPhong.substring(0,5) == 'https' }">
						            <c:url value="${phong.anhPhong}" var="imgUrl"></c:url>
						        </c:if> 
						        
						        <!-- Ảnh -->
						        <img src="${imgUrl}" alt="Phòng" style="width: 260px; height: 200px; border-radius: 5px; object-fit: cover;">
						    	<strong style="font-size: 16px; margin-bottom: 10px; margin-top: 10px;">Diện tích: ${phong.dienTich} m2</strong>
						    	<strong style="font-size: 16px; margin-bottom: 10px;">Mô tả: ${phong.moTa}</strong>
						    </div>
						</td>
						<td
							style="padding: 15px; border: 1px solid #ddd; text-align: center; vertical-align: middle;">
							<span style="font-size: 16px;">${phong.sucChuaToiDa}</span>
						</td>
						<td style="padding: 15px; border: 1px solid #ddd; text-align: center; vertical-align: middle; font-weight: bold; color: #0078d4;">
							<c:forEach var="khuyenmai" items="${listkhuyenmai}">
								<c:if test="${khuyenmai.idPhong == phong.id}">
									<p style="font-size: 14px; color: red; font-weight: bold; margin: 10px 0;">ƯU ĐÃI ${khuyenmai.ten} GIẢM ${khuyenmai.giaTriGiam}% HÔM NAY</p>
								</c:if>	
								<c:if test="${khuyenmai.idPhong == 0}">
									<p style="font-size: 14px; color: red; font-weight: bold; margin: 10px 0;">ƯU ĐÃI ${khuyenmai.ten} GIẢM ${khuyenmai.giaTriGiam}% HÔM NAY</p>
								</c:if>	
							</c:forEach>
							
							<c:if test="${phong.giaThue > phong.tienThueSauKhiGiam}">
								<div style="margin: 10px 0;">
            						<span style="font-size: 14px; text-decoration: line-through; color: #999;">${phong.giaThue} VND</span> </div>
								${phong.tienThueSauKhiGiam} VND
							</c:if>
							<c:if test="${phong.giaThue == phong.tienThueSauKhiGiam}">
								${phong.giaThue} VND
							</c:if>
						</td>
						<td
							style="padding: 15px; border: 1px solid #ddd; font-size: 14px; line-height: 1.8;">
							<c:forEach items="${fn:split(phong.tienNghi, ',')}" var="tienNghi">
						        ✔️ ${tienNghi.trim()} <br>
						    </c:forEach>
						</td>
						<td
							style="padding: 15px; border: 1px solid #ddd; text-align: center; vertical-align: middle;">
							${phong.soPhongTrong}
						</td>
						<td>
							<button type="button" style="margin-left: 4px; margin-right: 4px;" onClick="window.location='datPhong?id=${phong.id}'">Đặt Phòng</button>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

	<!--Danh sách tiện ích -->
	<div
		style="font-size: 28px; margin-left: 165px; font-weight: bold; font-family: 'Arial', sans-serif; color: #2c3e50; text-align: left; margin-top: 20px; letter-spacing: 1px;">Tất
		cả những tiện ích tại ${ks.ten}</div>
	<form>
		<table
			style="width: 100%; border-collapse: collapse; margin-top: 20px; margin-left: 165px;">
			<tr>
				<!-- Cột 1: Các tiện ích lân cận -->
				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/store.png" alt="Icon 1"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Các tiện ích lân cận
				</th>

				<!-- Cột 2: Tiện nghi phòng -->
				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/open-door.png" alt="Icon 2"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Tiện nghi phòng
				</th>

				<!-- Cột 3: Dịch vụ khách sạn -->
				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/support.png" alt="Icon 3"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Dịch vụ khách sạn
				</th>
			</tr>
			<tr>
				<!-- Danh sách tiện ích lân cận -->
				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 1}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>

				<!-- Danh sách tiện nghi phòng -->
				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 2}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>

				<!-- Danh sách dịch vụ khách sạn -->
				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 3}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</form>

	<form>
		<table
			style="width: 100%; border-collapse: collapse; margin-top: 20px; margin-left: 165px;">
			<tr>
				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/taxi.png" alt="Icon 4"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Vận chuyển
				</th>

				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/elevator.png" alt="Icon 5"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Tiện ích công cộng
				</th>

				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/air-conditioner.png" alt="Icon 6"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Tiện ích chung
				</th>
			</tr>
			<tr>
				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 4}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>

				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 5}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>

				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 6}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</form>

	<form>
		<table
			style="width: 100%; border-collapse: collapse; margin-top: 20px; margin-left: 165px;">
			<tr>
				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/food.png" alt="Icon 4"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Ẩm thực
				</th>

				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">
					<img src="/do_An/Content/Images/wifi-signal.png" alt="Icon 5"
					style="width: 20px; height: 20px; vertical-align: middle;">
					Kết nối mạng
				</th>
				<th
					style="width: 33.33%; text-align: left; font-weight: bold; padding-bottom: 10px;">

				</th>
			</tr>
			<tr>
				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 7}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>

				<td style="vertical-align: top; padding: 10px;">
					<ul style="list-style-type: circle; margin: 0; padding-left: 20px;">
						<c:forEach var="tienich" items="${listTienIch}">
							<c:if test="${tienich.idLoaiTienNghi == 8}">
								<li style="margin-bottom: 5px;">${tienich.tenTienNghi}</li>
							</c:if>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</form>

	<!-- hiển thị đánh giá của khách hàng  -->
	<div
		style="display: flex; align-items: center; margin-top: 20px; font-family: Arial, sans-serif; margin-left: 165px;">
		<!-- Điểm đánh giá tổng quát -->
		<div
			style="display: flex; justify-content: center; align-items: center; width: 100px; height: 100px; border-radius: 50%; background-color: #f0f8ff; position: relative; margin-right: 20px;">
			<div style="font-size: 36px; color: #007bff;">${trungBinhCong}</div>
			<c:if test="${trungBinhCong >= 8}">
				<div
					style="font-size: 14px; font-weight: bold; color: #007bff; position: absolute; bottom: -20px; text-align: center; width: 100%;">Ấn
					tượng</div>
			</c:if>
			<c:if test="${trungBinhCong >= 6 && trungBinhCong < 8}">
				<div
					style="font-size: 14px; font-weight: bold; color: #007bff; position: absolute; bottom: -20px; text-align: center; width: 100%;">Bình
					thường</div>
			</c:if>
			<c:if test="${trungBinhCong < 6} ">
				<div
					style="font-size: 14px; font-weight: bold; color: #007bff; position: absolute; bottom: -20px; text-align: center; width: 100%;">Tạm
					ổn</div>
			</c:if>
		</div>

		<!-- Chi tiết đánh giá -->
		<div style="flex-grow: 1;">
			<p
				style="margin: 0; font-size: 14px; color: #555; margin-left: -120px;">Từ
				${count} đánh giá của khách đã ở</p>

			<!-- Thanh đánh giá Tuyệt vời -->
			<div style="display: flex; align-items: center; margin-bottom: 10px;">
				<div style="width: 100px; font-weight: bold; font-size: 14px;">Tuyệt
					vời</div>
				<div
				    style="flex-grow: 1; height: 10px; background-color: #f0f0f0; border-radius: 5px; overflow: hidden; margin-right: 10px; max-width: 850px;">
				    <div style="width: ${tuyetVoi}%; height: 100%; background-color: #007bff; border-radius: 5px;"></div>
				    <!-- Chiều dài tùy thuộc vào tỷ lệ đánh giá -->
				</div>
				<div
					style="width: 30px; text-align: right; font-weight: bold; font-size: 14px;">${tuyetVoi}</div>
			</div>

			<!-- Thanh đánh giá Rất tốt -->
			<div style="display: flex; align-items: center; margin-bottom: 10px;">
				<div style="width: 100px; font-weight: bold; font-size: 14px;">Rất
					tốt</div>
				<div
					style="flex-grow: 1; height: 10px; background-color: #f0f0f0; border-radius: 5px; overflow: hidden; margin-right: 10px; max-width: 850px;">
					<div
						style="width: ${ratTot}%; height: 100%; background-color: #007bff;border-radius: 5px;"></div>
				</div>
				<div
					style="width: 30px; text-align: right; font-weight: bold; font-size: 14px;">${ratTot}</div>
			</div>

			<!-- Thanh đánh giá Hài lòng -->
			<div style="display: flex; align-items: center; margin-bottom: 10px;">
				<div style="width: 100px; font-weight: bold; font-size: 14px;">Hài
					lòng</div>
				<div
					style="flex-grow: 1; height: 10px; background-color: #f0f0f0; border-radius: 5px; overflow: hidden; margin-right: 10px; max-width: 850px;">
					<div
						style="width: ${haiLong}%; height: 100%; background-color: #007bff;border-radius: 5px;"></div>
				</div>
				<div
					style="width: 30px; text-align: right; font-weight: bold; font-size: 14px;">${haiLong}</div>
			</div>

			<!-- Thanh đánh giá Trung bình -->
			<div style="display: flex; align-items: center; margin-bottom: 10px;">
				<div style="width: 100px; font-weight: bold; font-size: 14px;">Trung
					bình</div>
				<div
					style="flex-grow: 1; height: 10px; background-color: #f0f0f0; border-radius: 5px; overflow: hidden; margin-right: 10px; max-width: 850px;">
					<div
						style="width: ${trungBinh}%;height: 100%; background-color: #007bff;border-radius: 5px;"></div>
				</div>
				<div
					style="width: 30px; text-align: right; font-weight: bold; font-size: 14px;">${trungBinh}</div>
			</div>

			<!-- Thanh đánh giá Kém -->
			<div style="display: flex; align-items: center; margin-bottom: 10px;">
				<div style="width: 100px; font-weight: bold; font-size: 14px;">Kém</div>
				<div
					style="flex-grow: 1; height: 10px; background-color: #f0f0f0; border-radius: 5px; overflow: hidden; margin-right: 10px;max-width: 850px;">
					<div
						style="width: ${kem}%;height: 100%; background-color: #007bff;border-radius: 5px;"></div>
				</div>
				<div
					style="width: 30px; text-align: right; font-weight: bold; font-size: 14px;">${kem}</div>
			</div>
		</div>

	</div>
	<!-- Phản hồi từ khách hàng -->
	<c:forEach var="danhGia" items="${listDanhGia}">
		<table style="margin-left: 165px;">

			<tr>
				<th
					style="width: 20%; text-align: left; font-weight: bold; padding-bottom: 10px;"></th>
				<th
					style="width: 70%; text-align: left; font-weight: bold; padding-bottom: 10px;"></th>
			</tr>
			<tr
				style="width: 80%; margin: 20px auto; border: 1px solid #e0e0e0; padding: 20px; border-radius: 10px; background-color: #f9f9f9;">
				<td style="vertical-align: top; padding: 10px;">
					<div style="display: flex; align-items: center;">
						<img style="width: 50px; height: 50px; border-radius: 50%;"
							src="https://via.placeholder.com/50" alt="User Avatar">
						<div>
							<div style="font-weight: bold; margin-left: 10px">${danhGia.tenKhachHang}</div>

						</div>
					</div>
				</td>
				<td>
					<div style="color: #007bff; margin-left: -1px; font-weight: bold;">${danhGia.diem}/
						10</div>
					<div style="margin-top: 10px; font-size: 14px;">
						${danhGia.noiDung} <br>
						<c:if
							test="${danhGia.urlHinhAnhDanhGia.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${danhGia.urlHinhAnhDanhGia}"
								var="imgUrl"></c:url>
						</c:if>
						<c:if
							test="${danhGia.urlHinhAnhDanhGia.substring(0,5) == 'https' }">
							<c:url value="${danhGia.urlHinhAnhDanhGia}" var="imgUrl"></c:url>
						</c:if>
						<img src="${imgUrl}" alt="Review Image">
					</div>
					<div
						style="margin-top: 20px; padding: 10px; border-left: 3px solid #007bff; background-color: #f0f8ff; font-size: 14px;">
						<div style="color: #007bff; font-weight: bold;">Trả lời của
							khách sạn</div>
						<div style="font-size: 12px; color: #888; margin-bottom: 10px;">25
							Jun 2024</div>
						<div class="hotel-reply-content">
							Xin chào anh/chị Nguyen D. T.,<br> Lời chào trân trọng từ
							khách sạn Mường Thanh Luxury Đà Nẵng!<br> Tôi rất lấy làm
							vinh dự và hạnh phúc khi nhận được đánh giá của anh/chị về chất
							lượng dịch vụ của Khách sạn.<br> Chăm sóc khách hàng bằng sự
							tận tâm và chuyên nghiệp luôn là tiêu chí hàng đầu của chúng tôi.<br>
							Mong sớm gặp lại anh/chị và gia đình lần tới.<br> Trân
							trọng,<br> Ngô Thị Hương<br> Giám đốc Khách sạn
						</div>
					</div>
				</td>
			</tr>
		</table>
	</c:forEach>
	<div style="margin-left: -20px; margin-top: 20px">
		<ul
			style="display: flex; list-style-type: none; padding: 0; justify-content: center; align-items: center;">
			<!-- Nút đầu tiên và nút trước -->
			<li style="margin: 0 5px;"><a href="?page=1"
				style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == 1 ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&laquo;</a>
			</li>
			<li style="margin: 0 5px;"><a
				href="?page=${currentPage > 1 ? currentPage - 1 : 1}"
				style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == 1 ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&lsaquo;</a>
			</li>

			<!-- Các trang giữa -->
			<c:forEach var="i" begin="1" end="${endPage}">
				<li style="margin: 0 5px;"><a href="?page=${i}"
					style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == i ? '#fff' : '#333'}; border: 1px solid ${currentPage == i ? '#007bff' : '#ddd'}; border-radius: 4px; background-color: ${currentPage == i ? '#007bff' : 'transparent'};">
						${i} </a></li>
			</c:forEach>

			<!-- Nút kế tiếp và nút cuối -->
			<li style="margin: 0 5px;"><a
				href="?page=${currentPage < endPage ? currentPage + 1 : endPage}"
				style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == endPage ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&rsaquo;</a>
			</li>
			<li style="margin: 0 5px;"><a href="?page=${endPage}"
				style="display: block; padding: 8px 12px; text-decoration: none; color: ${currentPage == endPage ? '#ccc' : '#333'}; border: 1px solid #ddd; border-radius: 4px;">&raquo;</a>
			</li>
		</ul>
	</div>
</body>
</html>