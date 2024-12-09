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
    <div style="background-color: #ffffff; padding: 20px; border: 1px solid #ddd; border-radius: 8px; margin-left: -96px; margin-top: 0px">
        <h2 style="margin-bottom: 20px;">Khuyến mãi</h2>
        <table id="reservationTable" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr style="background-color: #f8f9fa; border-bottom: 1px solid #ddd;">
                    <th style="padding: 10px; text-align: left;">STT</th>
                    <th style="padding: 10px; text-align: left;">Khuyến mãi</th>
                    <th style="padding: 10px; text-align: left; width: 100px;">Mô tả</th>
                    <th style="padding: 10px; text-align: left;">Giảm giá (%)</th>
                    <th style="padding: 10px; text-align: left;">Thời gian bắt đầu</th>
                    <th style="padding: 10px; text-align: left;">Thời gian kết thúc</th>
                    <th style="padding: 10px; text-align: left;">Phòng</th>
                    <th style="padding: 10px; text-align: left;">Khách sạn</th>
                    <th style="padding: 10px; text-align: left;">Trạng thái</th>
                    <th style="padding: 10px; text-align: left; width: 100px;">Thao tác</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listkhuyenmai}" var="khuyenmai" varStatus="STT">
            		<tr style="border-bottom: 1px solid #ddd;">
	                    <td style="padding: 10px;">${STT.index+1}</td>
	                    <td style="padding: 10px;">${khuyenmai.ten}</td>
	                    <td style="padding: 10px;">${khuyenmai.moTa}</td>
	                    <td style="padding: 10px;">${khuyenmai.giaTriGiam}</td>
	                    <td style="padding: 10px;">${khuyenmai.thoiGianBatDau}</td>
	                    <td style="padding: 10px;">${khuyenmai.thoiGianKetThuc}</td>
	                    <c:if test="${empty khuyenmai.phong.ten}">
		                    <td style="padding: 10px;">Tất cả các phòng</td>
		                </c:if>
		                <c:if test="${!empty khuyenmai.phong.ten}">
		                    <td style="padding: 10px;">${khuyenmai.phong.ten}</td>
		                </c:if>
		                <td style="padding: 10px;">${khuyenmai.khachsan.ten}</td>
		                <c:if test="${khuyenmai.status == 1}">
		                    <td style="padding: 10px;">Đã được duyệt</td>
		                </c:if>
		                <c:if test="${khuyenmai.status == 2}">
		                    <td style="padding: 10px;">Đang chờ duyệt</td>
		                </c:if>
		                <c:if test="${khuyenmai.status == 3}">
		                    <td style="padding: 10px;">Không được duyệt</td>
		                </c:if>
	                    <td style="padding: 10px;">
	                    	<c:if test="${khuyenmai.status == 2}">
	                    		<a href="<c:url value='/admin/khuyenMai/duyet?id=${khuyenmai.id}'/>" 
								   style="background-color: #28a745; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">
								   Chấp nhận
								</a>
	                    	</c:if>
	                    	<c:if test="${khuyenmai.status == 3}">
	                    		<a href="<c:url value='/admin/khuyenMai/duyet?id=${khuyenmai.id}'/>" 
								   style="background-color: #28a745; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">
								   Chấp nhận
								</a>
	                    	</c:if>
	                    	<c:if test="${khuyenmai.status == 1 || khuyenmai.status == 2}">
								<a href="#" data-toggle="modal" data-target="#thongbao" data-id="${khuyenmai.id}" 
												   onclick="setModalId(${khuyenmai.id})"
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
		            <form action="/do_An/admin/khuyenMai/huy" method="get">
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