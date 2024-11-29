<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Table -->
    <div style="background-color: #ffffff; padding: 20px; border: 1px solid #ddd; border-radius: 8px; margin-left: -128px; margin-top: 0px">
        <h2 style="margin-bottom: 20px;">Khách sạn</h2>
        <table id="reservationTable" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr style="background-color: #f8f9fa; border-bottom: 1px solid #ddd;">
                    <th style="padding: 10px; text-align: left;">STT</th>
                    <th style="padding: 10px; text-align: left; width: 130px;">Tên khách sạn</th>
                    <th style="padding: 10px; text-align: left; width: 150px;">Địa chỉ</th> 
                    <th style="padding: 10px; text-align: left;">Chủ khách sạn</th>
                    <th style="padding: 10px; text-align: left;">Trạng thái</th>
                    <th style="padding: 10px; text-align: left;">Tình trạng</th>
                    <th style="padding: 10px; text-align: left;">Thao tác</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listkhachsan}" var="khachsan" varStatus="STT">
            		<tr style="border-bottom: 1px solid #ddd;">
	                    <td style="padding: 10px;">${STT.index+1}</td>
	                    <td style="padding: 10px;">
	                    	<a href="<c:url value='/admin/chiTietKS/thongTinKhachSan?id=${khachsan.id}'/>" 
								  style="display: inline-block; text-decoration: none;">
								  ${khachsan.ten}
							</a>	
	                    </td>
	                    <td style="padding: 10px;">${khachsan.diaChi}</td>
	                    <td style="padding: 10px;">${khachsan.sheller.fullname}</td>
	                    <c:if test="${khachsan.status == 1}">
	                    	<td style="padding: 10px; color: green;">Đã được duyệt</td>
	                    </c:if>
	                    <c:if test="${khachsan.status == 2}">
	                    	<td style="padding: 10px; color: yellow;">Đang chờ duyệt</td>
	                    </c:if>
	                    <c:if test="${khachsan.status == 3}">
	                    	<td style="padding: 10px; color: red;">Không được duyệt</td>
	                    </c:if>
	                    <td style="padding: 10px;">
	                    	<c:if test="${khachsan.active == true}">
	                    		<span style="background-color: #17a2b8; color: white; padding: 5px 10px; border-radius: 4px;">Hoạt động</span>
	                    	</c:if>
	                    	<c:if test="${khachsan.active == false}">
	                    		<span style="background-color: #007bff; color: white; padding: 5px 10px; border-radius: 4px;">Không hoạt động</span>
	                    	</c:if>
	                    </td>
	                    <td style="padding: 10px;">
	                    	<c:if test="${khachsan.status == 2}">
	                    		<a href="<c:url value='/admin/khachSan/duyet?id=${khachsan.id}'/>" 
								   style="background-color: #28a745; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">
								   Chấp nhận
								</a>
	                    	</c:if>
	                    	<c:if test="${khachsan.status == 3}">
	                    		<a href="<c:url value='/admin/khachSan/duyet?id=${khachsan.id}'/>" 
								   style="background-color: #28a745; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">
								   Chấp nhận
								</a>
	                    	</c:if>
	                    	<c:if test="${khachsan.status == 1 || khachsan.status == 2}">
								<a href="#" data-toggle="modal" data-target="#thongbao" data-id="${khachsan.id}" 
												   onclick="setModalId(${khachsan.id})"
									style="background-color: #dc3545; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">
									Hủy </a>
	                    	</c:if>	
	                    </td>
	                </tr>
	                
            	</c:forEach>
                
            </tbody>
        </table>
    </div>
    <div class="modal fade" id="thongbao" tabindex="-1" role="dialog" aria-labelledby="dangnhapLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 style="margin: 0; font-size: 18px; color: #333;">Thông báo</h5>
		                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
		                    <span aria-hidden="true">&times;</span>
		                </button>
		            </div>
		            <form action="/do_An/admin/khachSan/huy" method="get">
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