<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lịch Sử</title>
    </head>
    <body>
        
        <div style = "margin-top: 70px;">
            <!-- Tiêu đề -->
			<div style = "display: flex; gap: 20px;">
            <div style = "flex: 2; margin-right: 100px;">
                <form id="form" class="form-dskhachsan">
                    <!-- Hộp thoại xác nhận -->
                    <div id="confirmDialog" class="confirmDialog" style="display: none;">
                        <button type="button" class="ui-confirmdialog-yes">Có</button>
                        <button type="button" class="ui-confirmdialog-no">Không</button>
                    </div>

                    <!-- Danh sách lịch sử đặt phòng -->
                    <c:forEach var="lichSu" items="${listLichSu}">
					    <div style="border: 1px solid #c0c0c0; border-radius: 5px; margin-top: 20px">
					        <div class="row" style="padding: 10px 0 10px 20px">
					            <div class="col-md-3">
					                <c:if test="${lichSu.anhPhong.substring(0,5) != 'https' }">
										<c:url value="/image?fname=${lichSu.anhPhong}" var="imgUrl"></c:url>
									</c:if> 
									<c:if test="${lichSu.anhPhong.substring(0,5) == 'https' }">
										<c:url value="${lichSu.anhPhong}" var="imgUrl"></c:url>
									</c:if>
									
					                <img src="${imgUrl}" style="width: 100%; height: auto; border-radius: 5px;">
					            </div>
					            <div class="col-md-6">
					                <div style="font-weight: bold; color: #444">
					                    <span style="font-size: 18px; color: #077812">${lichSu.tenPhong}</span> - 
					                    <a href="${pageContext.request.contextPath}/thongTinKhachSan?id=${lichSu.idKhachSan}" style="font-size: 16px; color: #0077CC">
					                        ${lichSu.tenKhachSan}
					                    </a>
					                </div>
					                <div style="font-size: 14px; color: #444444; margin-bottom: 5px">Ngày đặt: ${lichSu.ngayDat}</div>
					                <div style="font-size: 14px; margin-bottom: 5px">Đặt từ <span style="color: #007AD9; font-weight: bold">${lichSu.ngayDen}</span> đến <span style="color: #8A2BE2; font-weight: bold">${lichSu.ngayTra}</span></div>
					                <div style="font-size: 14px; color: #444444; margin-bottom: 5px">Dịch vụ: ${lichSu.dichVu}</div>
					                <div style="font-size: 14px; margin-bottom: 5px">Tổng tiền: <span style="color: #E6004C; font-weight: bold">${lichSu.thanhTien} VND</span></div>
					                <div style="font-size: 14px; color: #444444; margin-bottom: 5px">Ghi chú: ${lichSu.ghiChu}</div>
					            </div>
					            <div class="col-md-3" style="text-align: right">
					                <div style="margin: 10px 20px">
					                    <c:choose>
					                        <c:when test="${lichSu.trangThai == 0}">
					                            <button type="button" class="cancel-button" onclick="huyDatPhong(${lichSu.id})" style="cursor: pointer;">
					                                Hủy Đặt
					                            </button>
					                        </c:when>
					                        <c:when test="${lichSu.trangThai == 1}">
					                            <button style="border-color: red; background-color: red !important" disabled="true">Quá Hạn</button>
					                        </c:when>
					                        <c:when test="${lichSu.trangThai == 2}">
					                            <button style="border-color: green; background-color: green !important" disabled="true">Đã Hủy</button>
					                        </c:when>
					                    </c:choose>
					                </div>
					            </div>
					        </div>
					    </div>
					</c:forEach>
                </form>
                </div>
            </div>
        </div>
        
        <script>
            // Script để hiển thị hộp thoại xác nhận
            function huyDatPhong(id) {
                if (confirm("Bạn có chắc chắn muốn hủy đặt phòng này không?")) {
                    window.location.href = '${pageContext.request.contextPath}/huyDatPhong?id=' + id;
                }
            }
        </script>
    </body>
</html>
