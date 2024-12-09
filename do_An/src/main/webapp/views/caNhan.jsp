<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang Cá Nhân</title>
</head>
<body>
	<div style="margin-top: 40px; margin-left: -40px;">
		<div style="display: flex; gap: 20px;">
			<div style="flex: 2; margin-right: 120px;">
				<%-- <span style="font-size:14px">${sessionScope['TaiKhoan'].hoTen}, bạn có thể chỉnh sửa thông tin cá nhân của mình ở đây!</span> --%>
				<div
					style="width: 120%; margin: 50px auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
					<!-- <h2 style="text-align: left; color: #b89f73; border-bottom: 2px solid #ddd; padding-bottom: 10px;">Personal details</h2> -->
					<table
						style="width: 100%; border-collapse: collapse; margin-top: 20px;">
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Tên:</th>
							<td id="ten" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${ten}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Họ
								và tên:</th>
							<td id="hovaten" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${hovaten}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Ngày
								sinh:</th>
							<td id="ngaysinh" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${ngaysinh}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Giới
								tính:</th>
							<td id="gioitinh" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${gioitinh}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Email:</th>
							<td id="email" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${email}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Điện
								thoại:</th>
							<td id="dienthoai" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${dienthoai}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Địa
								chỉ:</th>
							<td id="diachi" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${diaChi}</td>
						</tr>
						<tr>
							<th
								style="width: 30%; text-align: left; padding: 15px; background-color: #f9f9f9; border: 1px solid #ddd;">Mật
								khẩu:</th>
							<td id="matkhau" contenteditable="true"
								style="width: 70%; text-align: left; padding: 15px; background-color: #f5f5f5; border: 1px solid #ddd;">${matkhau}</td>
						</tr>
					</table>
					<div style="margin-top: 0">
						<button id="saveBtn" type="submit">Cập Nhật Thông Tin</button>
					</div>
					<script>
					document.getElementById("saveBtn").addEventListener("click", function() {
					    // Lấy dữ liệu từ các ô đã chỉnh sửa
					    var ten = document.getElementById("ten").innerText;
					    var hovaten = document.getElementById("hovaten").innerText;
					    var ngaysinh = document.getElementById("ngaysinh").innerText;
					    var gioitinh = document.getElementById("gioitinh").innerText;
					    var email = document.getElementById("email").innerText;
					    var dienthoai = document.getElementById("dienthoai").innerText;
					    var diachi = document.getElementById("diachi").innerText;
					    var matkhau = document.getElementById("matkhau").innerText;

					    // Gửi yêu cầu AJAX tới servlet
					    var xhr = new XMLHttpRequest();
					    xhr.open("POST", "/do_An/myAccount", true);
					    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

					    // Xử lý kết quả trả về từ servlet (nếu cần)
					    xhr.onreadystatechange = function() {
					        if (xhr.readyState === 4 && xhr.status === 200) {
					            alert("Dữ liệu đã được lưu thành công!");
					        }
					    };

					    // Gửi dữ liệu đã chỉnh sửa
					    xhr.send("ten=" + encodeURIComponent(ten)
					        + "&hovaten=" + encodeURIComponent(hovaten)
					        + "&ngaysinh=" + encodeURIComponent(ngaysinh)
					        + "&gioitinh=" + encodeURIComponent(gioitinh)
					        + "&email=" + encodeURIComponent(email)
					        + "&dienthoai=" + encodeURIComponent(dienthoai)
					        + "&diachi=" + encodeURIComponent(diachi)
					        + "&matkhau=" + encodeURIComponent(matkhau));
					});

					</script>
				</div>
			</div>
			<div style="flex: 1; margin-right: 120px;margin-top: 50px;">
				
					<div
						style="border-radius: 3px; background-color: #E9F0FA; border: 1px solid #CCE1FF; padding: 10px 12px 10px 12px; margin-bottom: 20px; font-size: 13px">
						Kiếm thêm thu nhập bằng cách đăng ký chỗ nghỉ trên QLKS, dù đó là
						nhà, khách sạn hay bất cứ kiểu chỗ nghỉ nào.<br /> <a href="#"
							style="font-weight: bold">Tìm hiểu thêm</a>
						<hr
							style="border: none; height: 1px; background-color: #CCE1FF; margin-top: 8px; margin-bottom: 8px" />
						Tìm phòng giá thấp? Chúng tôi có cả một trang dành riêng để giúp
						bạn tìm được ưu đãi tuyệt vời ở mọi nơi bạn muốn.<br /> <a
							href="#" style="font-weight: bold">Tiết lộ ưu đãi</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
