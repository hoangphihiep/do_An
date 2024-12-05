<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<div style="background-color: #F7F7F7; height: auto; border: 1px solid #E0E0E0;">
    <!-- Phần hình ảnh và overlay -->
    <div style="position: relative; text-align: center; color: white;">
        <!-- Ảnh nền -->
        <img src="/do_An/Content/Images/back.jpg" alt="Hotel Background" style="width: 100%; height: 500px; object-fit: cover;">
        
        <!-- Overlay -->
        <div style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.5);"></div>

        <!-- Nội dung -->
        <div style="position: absolute; top: 65%; left: 50%; transform: translate(-50%, -50%); text-align: center; z-index: 2;">
            <h1 style="font-size: 48px; margin: 0;">Tìm kiếm ưu đãi khách sạn, chỗ nghỉ ...</h1>
            <p style="font-size: 18px; margin: 10px 0;">Từ những khu nghỉ dưỡng thanh bình đến những căn hộ hạng sang hiện đại</p>

            <!-- Form tìm kiếm -->
            <div style="
    margin-top: 80px;
    background: rgba(255, 255, 255, 0.6); /* Màu nền trắng với độ trong suốt 80% */
    padding: 20px 30px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    display: inline-block;
    text-align: left;
    backdrop-filter: blur(10px); /* Làm mờ nội dung phía sau */
    -webkit-backdrop-filter: blur(10px); /* Hỗ trợ trên trình duyệt Webkit như Safari */
">
    <form action="${pageContext.request.contextPath}/danhsachks/timkiem" method="post" onsubmit="return validateForm()" style="margin-top: 20px;">
        <div style="display: flex; justify-content: center; align-items: center; gap: 20px;">
            <!-- Trường nhập địa điểm -->
            <div>
                <div style="color: black;font-size:20px;">Chọn địa điểm</div>
                <input type="text" id="a" name="tenThanhPhoTimKiem" placeholder="Nhập thành phố"
                       style="padding-left: 20px; height: 50px; width: 250px; font-size: 18px; border: 2px solid #FEBB02; border-radius: 5px; transition: border-color 0.3s ease, box-shadow 0.3s ease;" />
                <span id="error-a" style="color: red; font-size: 14px; display: none;">Vui lòng nhập thành phố.</span>
            </div>
            <!-- Trường nhập ngày đến -->
            <div style="margin-right: 20px;">
                <div style="color: black; font-size:20px;">Ngày đến</div>
                <input type="date" id="b" name="thoiGianDen"
                       style="color: black; padding-left: 20px; height: 50px; width: 250px; font-size: 18px; border: 2px solid #FEBB02; border-radius: 5px; transition: border-color 0.3s ease, box-shadow 0.3s ease;" />
                <span id="error-b" style="color: red; font-size: 14px; display: none;">Vui lòng chọn ngày đến.</span>
            </div>
            <!-- Trường nhập ngày đi -->
            <div style="margin-right: 20px;font-size:20px;">
                <div style="color: black;">Ngày đi</div>
                <input type="date" id="c" name="thoiGianDi"
                       style="color: black; padding-left: 20px; height: 50px; width: 250px; font-size: 18px; border: 2px solid #FEBB02; border-radius: 5px; transition: border-color 0.3s ease, box-shadow 0.3s ease;" />
                <span id="error-c" style="color: red; font-size: 14px; display: none;">Vui lòng chọn ngày đi.</span>
            </div>
            <!-- Nút tìm kiếm -->
            <button type="submit" style="margin-top: 27px; height: 50px; width: 150px; font-size: 18px; background-color: #FEBB02; color: white; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s ease, box-shadow 0.3s ease;">Tìm kiếm</button>
        </div>
    </form>
</div>

        </div>
    </div>
</div>


<!-- tìm kiếm theo thành phố -->
<div class="c80" style="margin-top: 40px">
	<h2>Tìm theo Thành phố</h2>
	<div class="row">
		<form action="${pageContext.request.contextPath}/home" method="post">
			<c:forEach items="${listdiadiem}" var="diadiem" begin="0" end="1">
				<a href="${pageContext.request.contextPath}/danhsachks?id=${diadiem.id}" style="display: block; text-decoration: none; color: inherit;">
					<div class="col-md-6">
						<div class="div-zoom">
							<img class="img-zoom" src="${diadiem.urlHinhAnh}" alt="Img" width="1000" style="margin-right: 150px;"/>
						</div>
						<div class="chu-goc-trai">
							<span style="font-size: 28px; font-weight: bold;">${diadiem.ten}</span>
							<img src="/do_An/Content/Images/VietNamFlag.png" alt="VietNam"
								valign="middle" /> <br /> <span style="font-size: 16px;">
								${diadiem.soKhachSan} khách sạn </span>
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
			<c:forEach items="${listdiadiem}" var="diadiem" begin="2" end="4">
				<a href="${pageContext.request.contextPath}/danhsachks?id=${diadiem.id}" style="display: block; text-decoration: none; color: inherit;">
					<div class="col-md-4">
						<div class="div-zoom">
							<img class="img-zoom" src="${diadiem.urlHinhAnh}" alt="Img" width="1000" style="margin-right: 150px;"/>
						</div>
						<div class="chu-goc-trai">
							<span style="font-size: 28px; font-weight: bold;">${diadiem.ten}</span>
							<img src="/do_An/Content/Images/VietNamFlag.png" alt="VietNam"
								valign="middle" /> <br /> <span style="font-size: 16px;">
								${diadiem.soKhachSan} khách sạn </span>
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
                            <a href="${pageContext.request.contextPath}/danhsachks?idloaiks=${loaiks.id}" style="text-decoration: none">
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
    <div class="row" style="display: flex; flex-wrap: nowrap; overflow-x: auto; padding-bottom: 10px;">
        <div class="MultiCarousel-inner" style="display: flex;">
            <c:forEach items="${listks}" begin="0" end="9" var="ks">
                <div class="col-md-3 ks-noibat" style="flex: 0 0 auto; margin-right: 10px;">
                    <a href="${pageContext.request.contextPath}/khachsan?id=${ks.id}">
                        <div class="item">
                            <div class="div-ks">
                                <c:if test="${ks.anhks.urlAnhKhachSan.substring(0,5) != 'https' }">
                                    <c:url value="/image?fname=${ks.anhks.urlAnhKhachSan}" var="imgUrl"></c:url>
                                </c:if>
                                <c:if test="${ks.anhks.urlAnhKhachSan.substring(0,5) == 'https' }">
                                    <c:url value="${ks.anhks.urlAnhKhachSan}" var="imgUrl"></c:url>
                                </c:if>
                                <img style="height: 220px; display: block; width: 100%;" src="${imgUrl}" alt="Img" />
                            </div>
                            <br />
                            <div style="padding-left: 10px;">
                                <span style="font-size: 18px; font-weight: bold; color: #0077CC">${ks.ten}</span>
                                <br />
                                <span style="font-size: 14px; color: #777777">${ks.tenDiaDiem}</span>
                                <span style="font-size: 14px; color: #777777"> - ${ks.tenLoaiKhachSan}</span>
                                <br />
                                <span style="font-size: 16px; font-weight: bold; color: #003580">
                                    ${ks.danhGia} &#9733; - ${strDanhGia[ks.danhGia]}
                                </span>
                            </div>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<script>
	function validateForm() {
	    // Lấy giá trị của từng trường
	    const city = document.getElementById("a").value;
	    const checkIn = document.getElementById("b").value;
	    const checkOut = document.getElementById("c").value;
	
	    // Đặt biến kiểm tra
	    let isValid = true;
	
	    // Kiểm tra và hiển thị lỗi cho trường "Chọn địa điểm"
	    if (!city) {
	        document.getElementById("error-a").style.display = "block";
	        isValid = false;
	    } else {
	        document.getElementById("error-a").style.display = "none";
	    }
	
	    // Kiểm tra và hiển thị lỗi cho trường "Ngày đến"
	    if (!checkIn) {
	        document.getElementById("error-b").style.display = "block";
	        isValid = false;
	    } else {
	        document.getElementById("error-b").style.display = "none";
	    }
	
	    // Kiểm tra và hiển thị lỗi cho trường "Ngày đi"
	    if (!checkOut) {
	        document.getElementById("error-c").style.display = "block";
	        isValid = false;
	    } else {
	        document.getElementById("error-c").style.display = "none";
	    }
	
	    return isValid;
}
</script>
