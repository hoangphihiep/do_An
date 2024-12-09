<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<div style="background-color: #003580;height: 100px;">
	<a href="/do_An/home" style="display: inline-block; text-decoration: none;">
		<!-- Tựa đề chính -->
        <h1 style="margin: 0; margin-left: 100px; font-size: 60px; font-weight: bold; letter-spacing: 3px; color: white;">UTE BOOKING</h1>
        <!-- Dòng mô tả -->
        <p style="margin: 0; margin-left: 220px; font-size: 20px; letter-spacing: 2px; color: #00bfff; font-weight: bold;">HOTEL & VILLAS</p>
	</a>
	<!-- Form đăng nhập -->
    <div id="head-dangnhap" style="float: right; margin-right: 60px; margin-top: 30px">
        <c:choose>
            <c:when test="${empty username}">
                <div class="header-right">
                    <span style="margin-right: 30px; color: white; font-weight: 500"></span>
                    <a href="${pageContext.request.contextPath }/login" style="width: 95px; height: 30px; font-size: 13px !important; margin-right: 15px; color: white; background-color: #007bff; text-decoration: none; padding: 5px; text-align: center;">Đăng nhập</a>
                    <a href="#" data-toggle="modal" data-target="#dangky" style="width: 95px; height: 30px; font-size: 13px !important; margin-right: 20px; color: white; background-color: #28a745; text-decoration: none; padding: 5px; text-align: center;">Đăng ký</a>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <a href="/do_An/myAccount/trangCaNhan" style="margin-right: 20px; color: white; font-weight: bold">Xin chào, <strong>${username}</strong></a>
                    <a href="<c:url value='/logout'/>" style="color: #00BBFF; font-weight: bold">Đăng Xuất</a>
                </div>
            </c:otherwise>
        </c:choose>
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
                    	<c:if test="${alert !=null}">
							<h3 class="alert alertdanger">${alert}</h3>
						</c:if>
                        <div class="form-group">
                            <label for="taiKhoan">Tài Khoản</label>
                            <input type="text" class="form-control" id="taiKhoan" name="username" placeholder="Tên Tên Khoản ..." required>
                        </div>
                        <div class="form-group">
                            <label for="matKhau">Mật Khẩu</label>
                            <input type="password" class="form-control" id="matKhau" name="password" placeholder="Mật Khẩu ..." required>
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" checked="checked" name="remember" id="remember-me">
                                <label class="form-check-label" for="remember-me">Remember me</label>
                           		<div class="pass-link">
                                	<a href="#" data-toggle="modal" data-target="#quenMatKhau" data-dismiss="modal" class="btn btn-link p-0">Forgot password?</a>
                           		</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                	 <input type="hidden" name="redirectURL" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/home">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Đăng Nhập</button>
                </div>
            </form>
            <div class="text-center mb-3">
                <span>Nếu chưa có tài khoản, </span>
                <!-- Nút mở modal Đăng Ký -->
                <button type="button" class="btn btn-link" style ="margin-top: -5px;" data-toggle="modal" data-target="#dangky" data-dismiss="modal">
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
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="modal-body" style="max-height: 70vh; overflow-y: auto;"> <!-- Giới hạn chiều cao và thêm thanh cuộn -->
                    <div class="form-dang-ky">
                        <!-- Form đăng ký -->
                        <c:if test="${alert1 !=null}">
							<h3 class="alert alertdanger">${alert1}</h3>
						</c:if>
                        <div class="form-group">
                            <label for="dkTaiKhoan">Tên</label>
                            <input type="text" class="form-control" id="Username" name="Username" placeholder="Tên của bạn ..." required>
                        </div>
                        <div class="form-group">
                            <label for="hoTen">Họ Tên</label>
                            <input type="text" class="form-control" id="Fullname" name="Fullname" placeholder="Họ và tên của bạn ..." required>
                        </div>
                        <div class="form-group">
                            <label for="Email">Email</label>
                            <input type="text" class="form-control" id="Email" name="Email" placeholder="Email của bạn ..." required>
                        </div>
                        <div class="form-group">
                            <label for="soDienThoai">Số Điện Thoại</label>
                            <input type="text" class="form-control" id="Phone" name="Phone" placeholder="Số điện thoại ..." required>
                        </div>
                        <div class="form-group">
                            <label for="ngaySinh">Ngày Sinh</label>
                            <input type="date" class="form-control" id="DateofBirth" name="DateofBirth" placeholder="Ngày sinh của bạn ..." required>
                        </div>
                        <div class="form-group">
                            <label for="Address">Địa chỉ</label>
                            <input type="text" class="form-control" id="Address" name="Address" placeholder="Địa chỉ của bạn ..." required>
                        </div>
                        <div class="form-group">
                            <label for="dkMatKhau">Mật Khẩu</label>
                            <input type="password" class="form-control" id="Password" name="Password" placeholder="Mật Khẩu ..." required>
                        </div>
                        <div class="form-group">
                            <label for="dkNhapLaiMatKhau">Nhập lại Mật Khẩu</label>
                            <input type="password" class="form-control" id="Psw-repeat" name="Psw-repeat" placeholder="Nhập lại Mật Khẩu ..." required>
                        </div>
                        
                        <div class="form-group">
                            <label>Giới Tính</label><br/>
                            <div class="form-check">
    							<input class="form-check-input" type="radio" name="gioiTinh" id="dot-1" value="Nam">
    							<label class="form-check-label" for="dot-1">
        							<span class="dot one"></span> <span class="gender">Nam</span></label>
							</div>
							<div class="form-check">
    							<input class="form-check-input" type="radio" name="gioiTinh" id="dot-2" value="Nữ">
    							<label class="form-check-label" for="dot-2">
        							<span class="dot two"></span> <span class="gender">Nữ</span></label>
							</div>
							<div class="form-check">
    						<input class="form-check-input" type="radio" name="gioiTinh" id="dot-3" value="Không muốn tiết lộ">
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
                     <button type="submit" class="btn btn-primary" style="width: 100%;">Tiếp theo</button>
                </div>
            </form>
            <div class="text-center mb-3">
                <span>Nếu đã có tài khoản, </span>
                <a href="#" data-toggle="modal" data-target="#dangnhap" data-dismiss="modal" class="btn btn-link">Đăng Nhập</a>
            </div>
        </div>
    </div>
</div>

<!-- Xác thực OTP  -->
<div class="modal fade" id="xacThucOTP" tabindex="-1" role="dialog" aria-labelledby="xacThucLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style = "background-color: #fff;padding: 20px;border-radius: 10px;width: 320px;box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);text-align: center;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
				<h5 class="modal-title" style = "font-size: 1.5rem">Đăng nhập bằng OTP</h5>   
			</div>
			<form action="${pageContext.request.contextPath}/xacThucOTP" method="post">
		        <p style = "font-size: 1.5rem;color: #666;margin-bottom: 20px;">Nhập OTP được cung cấp trong thư điện tử gửi cho ${email}.</p>
		        <div style="display: flex;justify-content: space-between;margin-bottom: 20px;">
	                <input class="otp-input" name="otp1" style="width: 40px;height: 40px;font-size: 1.2rem;text-align: center;border: 1px solid #ddd;border-radius: 5px;" type="text" maxlength="1" oninput="moveToNextInput(this)">
	                <input class="otp-input" name="otp2" style="width: 40px;height: 40px;font-size: 1.2rem;text-align: center;border: 1px solid #ddd;border-radius: 5px;" type="text" maxlength="1" oninput="moveToNextInput(this)">
	                <input class="otp-input" name="otp3" style="width: 40px;height: 40px;font-size: 1.2rem;text-align: center;border: 1px solid #ddd;border-radius: 5px;" type="text" maxlength="1" oninput="moveToNextInput(this)">
	                <input class="otp-input" name="otp4" style="width: 40px;height: 40px;font-size: 1.2rem;text-align: center;border: 1px solid #ddd;border-radius: 5px;" type="text" maxlength="1" oninput="moveToNextInput(this)">
	                <input class="otp-input" name="otp5" style="width: 40px;height: 40px;font-size: 1.2rem;text-align: center;border: 1px solid #ddd;border-radius: 5px;" type="text" maxlength="1" oninput="moveToNextInput(this)">
	                <input class="otp-input" name="otp6" style="width: 40px;height: 40px;font-size: 1.2rem;text-align: center;border: 1px solid #ddd;border-radius: 5px;" type="text" maxlength="1" oninput="moveToNextInput(this)">
            	</div>
            	<button id="continueBtn" style="width: 100%;padding: 10px;background-color: #e0e0e0;color: #aaa;font-size: 1.5rem;border: none;border-radius: 5px;cursor: not-allowed;" disabled>Tiếp tục</button>
            </form>
		    <div style = "font-size: 1.5rem;color: #666;margin: 10px 0;">
		            Gửi lại email <span id="countdown" style="color: #333;">01:30</span>
		    </div>
		    <hr>
		    <div style = "font-size: 1.5rem;cursor: pointer;text-decoration: none;">Đăng nhập bằng cách khác</div>
		    <br>
		    <a href="#" data-toggle="modal" data-target="#dangnhap" data-dismiss="modal" class="btn btn-link">Sử dụng mật khẩu</a>
		    <div style = " font-size: 1.4rem;color: #666;margin-top: 20px;">
		            Khi đăng nhập, tôi đồng ý với các Điều khoản sử dụng và Chính sách bảo mật của Agoda.
		    </div>
		</div>
	</div>
</div>

<!-- Modal Quên Mật Khẩu -->
<div class="modal fade" id="quenMatKhau" tabindex="-1" role="dialog" aria-labelledby="quenMatKhauLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Quên Mật Khẩu</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="\do_An\forgotPassword" method="post">
                <div class="modal-body">
                	<c:if test="${alert !=null}">
						<h3 class="alert alertdanger">${alert}</h3>
					</c:if>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Nhập địa chỉ email của bạn" required />
                    </div>
                    <div id="alertForgotPassword">
                        <!-- Thông báo lỗi hoặc thành công nếu có -->
                        <c:if test="${alertForgotPassword != null}">
                            <div class="alert alert-danger">${alertForgotPassword}</div>
                        </c:if>
                    </div>
                    <div class="text-center">
                        <p>Một mã xác nhận hoặc liên kết đặt lại mật khẩu sẽ được gửi tới email của bạn.</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Gửi yêu cầu</button>
                </div>
            </form>
            <div class="text-center mb-3">
                <span>Nhớ mật khẩu? </span>
                <!-- Nút mở modal Đăng Nhập -->
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#dangnhap" data-dismiss="modal">
                    Đăng Nhập
                </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Cập nhật mật khẩu -->
<div class="modal fade" id="capNhatMatKhau" tabindex="-1" role="dialog" aria-labelledby="capNhatMatKhauLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        	<c:if test="${alert1 !=null}">
				<h3 class="alert alertdanger">${alert1}</h3>
			</c:if>
            <div class="modal-header">
                <h5 class="modal-title">Cập Nhật Mật Khẩu</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="capNhatMatKhauForm" action="\do_An\updatePassword" method="post">
                <div class="modal-body">
                    <!-- Thông báo lỗi hoặc thành công nếu có -->
                    <c:if test="${alertUpdatePassword != null}">
                        <div class="alert alert-danger">${alertUpdatePassword}</div>
                    </c:if>
                    <div class="form-group">
                        <label for="newPassword">Mật Khẩu Mới</label>
                        <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="Nhập mật khẩu mới" required />
                    </div>
                    <div class="form-group">
                        <label for="confirmPassword">Xác Nhận Mật Khẩu</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Xác nhận mật khẩu mới" required />
                    </div>
                    <div id="alertUpdatePassword">
                        <!-- Thông báo lỗi xác nhận mật khẩu nếu có -->
                        <c:if test="${passwordMismatch != null}">
                            <div class="alert alert-danger">${passwordMismatch}</div>
                        </c:if>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Cập Nhật Mật Khẩu</button>
                    <!-- Nút bỏ qua cập nhật mật khẩu -->
                    <button type="button" class="btn btn-secondary" style="width: 100%; margin-top: 10px; margin-left: -100px;" onclick="skipUpdatePassword()">
    					Bỏ Qua Cập Nhật
					</button>
					<input type="hidden" id="skipUpdate" name="skipUpdate" value="false" />
                </div>
            </form>
            <div class="text-center mb-3">
                <span>Quay lại </span>
                <!-- Nút mở modal Đăng Nhập -->
                <button type="button" style ="margin-top: -5px;" class="btn btn-link" data-toggle="modal" data-target="#dangnhap" data-dismiss="modal">
                    Đăng Nhập
                </button>
                
            </div>
        </div>
    </div>
</div>
<script>
	// Hàm đếm ngược thời gian từ 1 phút 30 giây
	function startCountdown(duration, display) {
	    let timer = duration, minutes, seconds;
	    const countdownInterval = setInterval(() => {
	        minutes = parseInt(timer / 60, 10);
	        seconds = parseInt(timer % 60, 10);
	
	        minutes = minutes < 10 ? "0" + minutes : minutes;
	        seconds = seconds < 10 ? "0" + seconds : seconds;
	
	        display.textContent = minutes + ":" + seconds;
	
	        if (--timer < 0) {
	            clearInterval(countdownInterval);
	            display.textContent = "Đã hết thời gian";
	        }
	    }, 1000);
	}
	
	document.addEventListener("DOMContentLoaded", () => {
	    const countdownElement = document.getElementById("countdown");
	    startCountdown(90, countdownElement); // 1 phút 30 giây (90 giây)
	});
</script>

<script>
	// Hàm chuyển sang ô tiếp theo sau khi nhập
	function moveToNextInput(currentInput) {
	    if (currentInput.value.length === 1) {
	        const nextInput = currentInput.nextElementSibling;
	        if (nextInput && nextInput.classList.contains("otp-input")) {
	            nextInput.focus();
	        }
	    }
	    checkOTPInputs();
	}
	
	// Kiểm tra các ô nhập OTP đã đầy đủ hay chưa
	function checkOTPInputs() {
	    const inputs = document.querySelectorAll(".otp-input");
	    const allFilled = Array.from(inputs).every(input => input.value.length === 1);
	    const continueBtn = document.getElementById("continueBtn");
	
	    if (allFilled) {
	        continueBtn.disabled = false;
	        continueBtn.style.backgroundColor = "#007bff";
	        continueBtn.style.color = "#fff";
	        continueBtn.style.cursor = "pointer";
	    } else {
	        continueBtn.disabled = true;
	        continueBtn.style.backgroundColor = "#e0e0e0";
	        continueBtn.style.color = "#aaa";
	        continueBtn.style.cursor = "not-allowed";
	    }
	}
</script>
<script>
    function skipUpdatePassword() {
        document.getElementById("skipUpdate").value = "true";
        document.getElementById("capNhatMatKhauForm").submit();
    }
</script>