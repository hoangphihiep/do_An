<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="background-color: #003580;">
	<a href="trangchu.jsp"><img src="/do_An/Content/Images/Logo.png"
		width="299" height="62" style="margin: 10px 0px 5px 240px" /></a>
	<!-- Form đăng nhập -->
    <div id="head-dangnhap" style="float: right; margin-right: 60px; margin-top: 30px">
        <c:choose>
            <c:when test="${empty username}">
                <div class="header-right">
                    <span style="margin-right: 30px; color: white; font-weight: 500"></span>
                    <a href="#" data-toggle="modal" data-target="#dangnhap" style="width: 95px; height: 30px; font-size: 13px !important; margin-right: 15px; color: white; background-color: #007bff; text-decoration: none; padding: 5px; text-align: center;">Đăng nhập</a>
                    <a href="#" data-toggle="modal" data-target="#dangky" style="width: 95px; height: 30px; font-size: 13px !important; margin-right: 20px; color: white; background-color: #28a745; text-decoration: none; padding: 5px; text-align: center;">Đăng ký</a>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <span style="margin-right: 20px; color: white; font-weight: bold">Xin chào<strong>${username}</strong>,</span>
                    <a href="<c:url value='/logout'/>" style="color: #00BBFF; font-weight: bold">Đăng Xuất</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
	<div class="c80">
		<div class="topnav">
			<form id="form-nav" action="#" method="post">
				<a href="/do_An/home">Trang chủ</a> 
				<a href="caNhan.jsp">Cá nhân</a> 
				<a href="tinTuc.jsp">Tin tức</a> <a href="lienHe.jsp">Liên hệ</a>
			</form>
		</div>
	</div>
</div>

<div class="modal fade" id="dangnhap" tabindex="-1" role="dialog" aria-labelledby="dangnhapLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Đăng Nhập</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="\do_An\login" method="post">
                <div class="modal-body">
                    <div class="form-dang-nhap">
                        <div class="form-group">
                            <label for="taiKhoan">Tài Khoản</label>
                            <input type="text" class="form-control" id="taiKhoan" name="username" placeholder="Tên Tên Khoản ..."/>
                        </div>
                        <div class="form-group">
                            <label for="matKhau">Mật Khẩu</label>
                            <input type="password" class="form-control" id="matKhau" name="password" placeholder="Mật Khẩu ..."/>
                        </div>
                        <div class="form-group form-check">
                            <input type="checkbox" class="form-check-input" checked="checked" name="remember">
                            <label class="form-check-label" for="remember-me">Remember me</label>
                        </div>
                        <div class="pass-link">
                            <a href="#">Forgot password?</a>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Đăng Nhập</button>
                </div>
            </form>
            <div class="text-center mb-3">
                <span>Nếu chưa có tài khoản, </span>
                <!-- Nút mở modal Đăng Ký -->
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#dangky" data-dismiss="modal">
                    Đăng Ký
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Đăng Ký -->
<div class="modal fade" id="dangky" tabindex="-1" role="dialog" aria-labelledby="dangkyLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Đăng Ký</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/dangKy" method="post">
                <div class="modal-body" style="max-height: 70vh; overflow-y: auto;"> <!-- Giới hạn chiều cao và thêm thanh cuộn -->
                    <div class="form-dang-ky">
                        <!-- Form đăng ký -->
                        <div class="form-group">
                            <label for="dkTaiKhoan">Tên</label>
                            <input type="text" class="form-control" id="Username" name="Username" placeholder="Tên của bạn ..."/>
                        </div>
                        <div class="form-group">
                            <label for="hoTen">Họ Tên</label>
                            <input type="text" class="form-control" id="Fullname" name="Fullname" placeholder="Họ và tên của bạn ..."/>
                        </div>
                        <div class="form-group">
                            <label for="Email">Email</label>
                            <input type="text" class="form-control" id="Email" name="Email" placeholder="Email của bạn ..."/>
                        </div>
                        <div class="form-group">
                            <label for="soDienThoai">Số Điện Thoại</label>
                            <input type="text" class="form-control" id="Phone" name="Phone" placeholder="Số điện thoại ..."/>
                        </div>
                        <div class="form-group">
                            <label for="dkMatKhau">Mật Khẩu</label>
                            <input type="password" class="form-control" id="Password" name="Password" placeholder="Mật Khẩu ..."/>
                        </div>
                        <div class="form-group">
                            <label for="dkNhapLaiMatKhau">Nhập lại Mật Khẩu</label>
                            <input type="password" class="form-control" id="Psw-repeat" name="Psw-repeat" placeholder="Nhập lại Mật Khẩu ..."/>
                        </div>
                        <div class="form-group">
                            <label for="ngaySinh">Ngày Sinh</label>
                            <input type="date" class="form-control" id="DateofBirth" name="DateofBirth" placeholder="Ngày sinh của bạn ..."/>
                        </div>
                        <div class="form-group">
                            <label>Giới Tính</label><br/>
                            <div class="form-check">
    							<input class="form-check-input" type="radio" name="gioiTinh" id="dot-1" value="Male">
    							<label class="form-check-label" for="dot-1">
        							<span class="dot one"></span> <span class="gender">Nam</span></label>
							</div>
							<div class="form-check">
    							<input class="form-check-input" type="radio" name="gioiTinh" id="dot-2" value="Female">
    							<label class="form-check-label" for="dot-2">
        							<span class="dot two"></span> <span class="gender">Nữ</span></label>
							</div>
							<div class="form-check">
    						<input class="form-check-input" type="radio" name="gioiTinh" id="dot-3" value="Prefer not to say">
    							<label class="form-check-label" for="dot-3"> 
    								<span class="dot three"></span> <span class="gender">Không muốn tiết lộ</span> </label>
							</div>
                        </div>
                        <!-- Hiển thị thông báo lỗi nếu có -->
                        <c:if test="${not empty msg}">
                            <div class="alert alert-danger">${msg}</div>
                        </c:if>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Đăng Ký</button>
                </div>
            </form>
            <div class="text-center mb-3">
                <span>Nếu đã có tài khoản, </span>
                <a href="#" data-toggle="modal" data-target="#dangnhap" data-dismiss="modal" class="btn btn-link">Đăng Nhập</a>
            </div>
        </div>
    </div>
</div>