<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập bằng OTP</title>
<style>
.otp-container {
	width: 100%;
	max-width: 400px;
	background-color: #fff;
	padding: 20px;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	text-align: center;
}

.otp-header {
	font-size: 1.8rem;
	margin-bottom: 20px;
	color: #333;
}

.otp-instructions {
	font-size: 1.2rem;
	color: #666;
	margin-bottom: 20px;
}

.otp-input-group {
	display: flex;
	justify-content: space-between;
	margin-bottom: 20px;
}

.otp-submit-btn {
	width: 100%;
	padding: 10px;
	background-color: #e0e0e0;
	color: #aaa;
	font-size: 1.5rem;
	border: none;
	border-radius: 5px;
	cursor: not-allowed;
}

.resend-timer {
	font-size: 1.2rem;
	color: #333;
	margin-top: 10px;
}

.alt-login {
	font-size: 1.2rem;
	margin-top: 20px;
	text-decoration: none;
	color: #007bff;
	cursor: pointer;
}

.footer-note {
	font-size: 1rem;
	color: #666;
	margin-top: 20px;
}

.footer-note a {
	text-decoration: none;
	color: #007bff;
}
</style>

</head>
<body>
	<div
		style="width: 100%; max-width: 400px; padding: 20px; margin: 50px auto; background-color: white; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);">
		<!-- Form Title -->
		<div class="otp-container"> 
			<h1 class="otp-header">Đăng nhập bằng OTP</h1>
			<p class="otp-instructions">Nhập OTP được cung cấp trong thư điện
				tử gửi cho ${email}.</p>
			<form action="/do_An/sheller1/xacThucOTP" method="post">
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
			<div style = "font-size: 1.5rem;color: #666;margin-left: 110px; margin-top: 20px;">
		            Gửi lại email <span id="countdown" style="color: #333;">01:30</span>
		    </div>
		    <hr>
		    <div style = " margin-left: 85px; font-size: 1.5rem;cursor: pointer;text-decoration: none;">Đăng nhập bằng cách khác</div>
		    <br>
		    <a href="/do_An/sheller/dangNhap" class="btn btn-link" style="margin-left: 100px; margin-top: -10px; display: inline-block; text-decoration: none;">Sử dụng mật khẩu</a>
		    <div style = " font-size: 1.4rem;color: #666;margin-top: 10px; margin-left: 45px;">
		            Khi đăng nhập, tôi đồng ý với các Điều khoản.
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
<script type="text/javascript">
//Kiểm tra biến isSuccess và hiển thị SweetAlert nếu đăng ký thành công
<% if (Boolean.TRUE.equals(request.getAttribute("isSuccess"))) { %>
    Swal.fire({
        title: 'Giờ bạn là đối tác của chúng tôi!',
        text: 'Hãy đăng ký khách sạn của bạn!',
        icon: 'success',
        confirmButtonText: 'OK'
    }).then((result) => {
        if (result.isConfirmed) {
            // Chuyển hướng sau khi nhấn OK
            window.location.href = '<%= request.getContextPath() %>/sheller/dangChoNghi/ThongTinCoBan';
        }
    });
<% } %>
</script>

</body>
</html>
