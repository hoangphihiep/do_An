<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<div
	style="background-color: #F7F7F7; height: 230px; border: 1px solid #E0E0E0;">
	<div class="c80" style="margin-top: 40px">
		<h2>Tìm kiếm ưu đãi khách sạn, chỗ nghỉ ...</h2>
		<h5>Từ những khu nghỉ dưỡng thanh bình đến những căn hộ hạng sang
			hiện đại</h5>
		<div class="tim-kiem">
			<form action="${pageContext.request.contextPath}/danhsachks/timkiem" method="post">
				 <div style="display: flex; justify-content: flex-start; align-items: center; margin-bottom: 23px;">
   					<div style="margin-right: 20px;">
        				<div>Chọn địa điểm</div>
        				<input type="text" style="padding-left: 20px;height: 50px;width: 250px;font-size: 18px;border: 2px solid #FEBB02;border-radius: 5px;transition: border-color 0.3s ease, box-shadow 0.3s ease;" id="a" name="tenThanhPhoTimKiem" placeholder="Nhập thành phố"/>
    				</div>
    				<div style="margin-right: 20px;">
        				<div>Ngày đến</div>
        				<input type="date" style="padding-left: 20px;height: 50px;width: 250px;font-size: 18px;border: 2px solid #FEBB02;border-radius: 5px;transition: border-color 0.3s ease, box-shadow 0.3s ease;" id="b" placeholder="Ngày đến" name="thoiGianDen"/>
    				</div>
    				<div style="margin-right: 20px;">
        				<div>Ngày đi</div>
        				<input type="date" style="padding-left: 20px;height: 50px;width: 250px;font-size: 18px;border: 2px solid #FEBB02;border-radius: 5px;transition: border-color 0.3s ease, box-shadow 0.3s ease;" id="c" placeholder="Ngày trả" name="thoiGianDi"/>
    				</div>
    				<button type="submit" style="height: 50px;width: 150px;font-size: 18px;background-color: #FEBB02;color: white;border: none;border-radius: 5px;cursor: pointer;transition: background-color 0.3s ease, box-shadow 0.3s ease; margin-top: 18px;">Tìm kiếm</button>
				</div> 
			</form>
		</div>
	</div>
</div> 

<!-- tìm kiếm theo thành phố -->
<div class="c80">
	<h2>Tìm theo Thành phố</h2>
	<div class="row">
		<form action="${pageContext.request.contextPath}/home" method="post">
			<c:forEach items="${listthanhpho}" var="thanhpho" begin="0" end="1">
				<a href="${pageContext.request.contextPath}/home?id=${thanhpho.id}" style="display: block; text-decoration: none; color: inherit;">
					<div class="col-md-6">
						<div class="div-zoom">
							<img class="img-zoom" src="${thanhpho.urlHinhAnh}" alt="Img" width="1000" style="margin-right: 150px;"/>
						</div>
						<div class="chu-goc-trai">
							<span style="font-size: 28px; font-weight: bold;">${thanhpho.ten}</span>
							<img src="/do_An/Content/Images/VietNamFlag.png" alt="VietNam"
								valign="middle" /> <br /> <span style="font-size: 16px;">
								${thanhpho.soKhachSan} khách sạn </span>
						</div>
					</div>
				</a>
			</c:forEach>
		</form>
	</div>
</div>
<div class="c80">
	<div class="row">
		<form action="${pageContext.request.contextPath}/home" method="post">
			<c:forEach items="${listthanhpho}" var="thanhpho" begin="2" end="4">
				<a href="${pageContext.request.contextPath}/home?id=${thanhpho.id}" style="display: block; text-decoration: none; color: inherit;">
					<div class="col-md-4">
						<div class="div-zoom">
							<img class="img-zoom" src="${thanhpho.urlHinhAnh}" alt="Img" width="1000" style="margin-right: 150px;"/>
						</div>
						<div class="chu-goc-trai">
							<span style="font-size: 28px; font-weight: bold;">${thanhpho.ten}</span>
							<img src="/do_An_CNTT/Content/Images/VietNamFlag.png" alt="VietNam"
								valign="middle" /> <br /> <span style="font-size: 16px;">
								${thanhpho.soKhachSan} khách sạn </span>
						</div>
					</div>
				</a>
			</c:forEach>
		</form>
	</div>
</div>

<!-- tìm kiếm theo loại khách sạn  -->
<div class="c80">
        <h2>Tìm theo Loại khách sạn</h2>
        <div class="row">
            <div class="MultiCarousel" data-items="1,2,3,4" data-slide="1" id="MultiCarousel" data-interval="1000">
                <div class="MultiCarousel-inner">
                    <form action="${pageContext.request.contextPath}/home" method="post">
                        <c:forEach items="${listloaiks}" var="loaiks">
                            <a href="${pageContext.request.contextPath}/home?id=${loaiks.id}" style="text-decoration: none">
                                <div class="item">
                                    <div class="img-loaiks"><img src="${loaiks.urlHinhAnh}" alt="Img"/></div>
                                    <br/>
                                    <div style="padding-left: 10px;">
                                        <span style="font-size: 18px; font-weight: bold">${loaiks.ten}</span>
                                        <br/>
                                        <span style="font-size: 16px;">
                                            Gồm ${loaiks.soKhachSan} khách sạn
                                        </span>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </form>
                </div>
                <button class="btn btn-primary leftLst"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></button>
                <button class="btn btn-primary rightLst"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></button>
            </div>
        </div>
    </div>

<!-- khách sạn nổi bật -->
<div class="c80">
        <h2>Các Khách sạn nổi bật</h2>
        <div class="row">
            <c:forEach items="${listks}" begin="0" end="3" var="ks">
                <div class="col-md-3 ks-noibat">
                    <form action="${pageContext.request.contextPath}/home" method="post">
                        <a href="${pageContext.request.contextPath}/home?id=${ks.id}">
                            <div class="div-ks">
                                <img style="height: 220px" src="/do_An_CNTT/Content/Images/KhachSan/3.jpg" alt="Img"/>
                            </div>
                            <div style="font-size: 18px; font-weight: bold; color: #0077CC">${ks.ten}</div>
                            <div style="font-size: 14px; color: #777777 ">${ks.tenThanhPho}</div>
                            <div style="font-size: 14px; color: #777777">${ks.tenLoaiKhachSan}</div>
                            <div style="font-size: 16px; font-weight: bold; color: #003580">${ks.danhGia} &#9733; - ${strDanhGia[ks.danhGia]}</div>
                        </a>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>


