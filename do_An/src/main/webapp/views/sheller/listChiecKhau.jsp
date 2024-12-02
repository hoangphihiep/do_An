<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f5f5f5; margin: 0; padding: 0;">
    
    <%@ include file="/commons/sheller/headerChiecKhau.jsp"%>
    <!-- Content -->
    <div style="padding: 20px;">
        <section style="background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); margin-top: 70px;">
            <table id="reservationTable" style="width: 100%; border-collapse: collapse; ">
                <thead>
                    <tr style="background-color: #007BFF; color: white; text-align: left;">
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">STT</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Khách sạn</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Chiếc khấu (%)</th>
                        <th style="padding: 10px; border: 1px solid #ddd; text-align: center;">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listchieckhau}" var="chieckhau" varStatus="STT">
	                    <tr>	
	                    		<td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${STT.index+1}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${chieckhau.ks.ten}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">${chieckhau.tiLeChiecKhau}</td>
		                        <td style="padding: 10px; border: 1px solid #ddd; text-align: center;">
		                            <a href="#" data-toggle="modal" data-target="#thongbao" data-id="${chieckhau.idKS}" 
					               onclick="setModalId(${chieckhau.idKS})" style="background-color: #28A745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer; text-align: center; display: inline-block; text-decoration: none;">Gửi yêu cầu</a>
		                        </td>	
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </div>
    <div class="modal fade" id="thongbao" tabindex="-1" role="dialog" aria-labelledby="dangnhapLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 style="margin: 0; font-size: 18px; color: #333;">Yêu cầu thay đổi chiếc khấu</h5>
		                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
		                    <span aria-hidden="true">&times;</span>
		                </button>
		            </div>
		            <form action="/do_An/sheller/chiecKhau/yeuCauSua" method="get">
		                <div class="modal-body">
		                    <div style="margin-bottom: 15px;">
		                     	<input type="hidden" id="modal-id" name="id" value="">
			                </div>
			                <div style="margin-bottom: 15px;">
			                    <label for="noidung" style="display: block; margin-bottom: 5px; font-size: 14px; color: #555;">Nội Dung</label>
			                    <textarea id="noidung" name="noidung" rows="4" style="width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 5px; font-size: 14px;"></textarea>
			                </div>
			                <button type="submit" style="width: 100%; padding: 10px; background-color: #28A745; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer;">
			                    Gửi
			                </button>
		                </div>
		         
		            </form>
		        </div>
		    </div>
		</div>
		<script>
		    function setModalId(id) {
		        document.getElementById('modal-id').value = id;
		    }
		</script>
</body>
</html>