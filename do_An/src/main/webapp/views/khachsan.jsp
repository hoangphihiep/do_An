<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
    <script>link_active = 2;</script>
    <div class="c80">
        <h3 style="text-align: center; color: #444; margin-bottom: 0px">Thông tin Khách sạn</h3>
        <div class="row">
            <div class="col-md-3">
                <div style="margin-top: 20px">
                    <div class="div-datngay">
                        <button class="btn-datngay" onClick="window.location = '#phongtrong'">Đặt ngay</button>
                    </div>
                    <div style="border-radius: 3px; border: 1px solid #c0c0c0; margin-bottom: 20px; padding: 0 0 10px 0">
                        <div style="width: 100%; height: 230px; border-radius: 3px; background: linear-gradient(transparent 70%, black), url(${ks.urlHinhAnhThanhPho}); background-repeat: no-repeat; background-position: center">
                        </div>
                        <div style="position: relative; top: -30px; left: 20px; color: white; font-size: 16px">
                            Cách ${ks.tenThanhPho} ${ks.cachTrungTam}m
                        </div>
                        <div style="margin: -10px 10px 0 10px">
                            Một trong những khu vực đẹp nhất ở ${ks.tenThanhPho}
                        </div>
                    </div>
                    <div style="border-radius: 3px; background-color: #E9F0FA; border: 1px solid #CCE1FF; text-align: center; padding: 12px 8px 16px 8px; margin-bottom: 20px">
                        Bạn thích chỗ nghỉ này, nhưng vẫn chưa chắc chắn?
                        <button class="btn btn-kstuongtu">Xem các khách sạn tương tự</button>
                    </div>
                    <div style="border-radius: 3px; border: 1px solid #c0c0c0; text-align: center; padding: 12px 8px 16px 8px">
                        Có thể bạn thắc mắc?<br/>
                        Đang vướng mắc một điều gì đó?<br/>
                        <button class="btn btn-default" style="width: 90%; margin-top: 17px; border: 1px solid #0077CC; color: #0077CC">Đặt câu hỏi</button>
                    </div>
                    <div style="text-align: center; font-size: 18px; font-weight: bold; color: #007AD9; margin-top: 20px">
                        ${ks.danhGia} &#9733;<br/>
                        ${strDanhGia[ks.danhGia]}
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div style="margin: 14px 0 5px 12px">
                    <div style="font-size: 24px; font-weight: bold">${ks.ten}</div>
                    <button class="btn-datngay" style="margin-top: -10px; font-size: 14px; width: 90px; height: 30px; float: right" onClick="window.location = '#phongtrong'">Đặt ngay</button>
                </div>
                <div style="font-size: 14px; color: #007AD9; margin: 4px 0 10px 12px">
                    <img style="height: 22px" src="/do_An/Content/Images/Position.png" alt="Img"/>
                    ${ks.diaChi}
                </div>
                <div style="margin-top: 20px; background-color: #E9F0FA; border-radius: 3px">
                    <div style="width: 800px; border-bottom: 1px solid #E0E0E0; padding-bottom: 20px; margin-bottom: 20px">
                        <div style="border-radius: 3px; width: 540px; overflow: hidden; margin: auto">
                            <img style="height: 440px" src="/do_An/Content/Images/KhachSan/${ks.id}.jpg" alt="Img"/>
                        </div>
                    </div>
                </div>
                <div>
                    <div style="margin-left: 20px">
                        <div style="color: #FEBB02; height: 32px; position: relative;">
                            <div style="position: absolute; font-size: 26px; left: 10px; top: -10px">&#10026;</div>
                            <div style="position: absolute; font-size: 16px; font-weight: bold; left: 40px; top: -4px">Một trong những chỗ nghỉ bán chạy nhất ở ${ks.tenThanhPho} của chúng tôi!</div>
                        </div>
                        <div>
                            <div style="font-size: 14px; color: #222 ">Cách trung tâm: ${ks.cachTrungTam} m</div>
                            <div style="font-size: 14px; color: #222">${ks.tenLoaiKhachSan}</div>
                            <div style="font-size: 14px">Giáp biển: ${ks.giapBien ? "Có" : "Không"}</div>
                            <div style="font-size: 14px; color: #222; margin-top: 8px">${ks.moTa}</div>
                        </div>
                    </div>
                </div>
                <div>
                    <h3 id="phongtrong">Phòng trống</h3>
                    <div style="height: 120px; background-color: #FFD257; border: 1px solid #E2AA11; padding: 10px 0 0 20px">
                        <span>Bạn muốn nghỉ tại <b>${ks.ten}</b> vào lúc nào?</span>
                        <form action="${pageContext.request.contextPath}/timPhongTrong" method="post">
                           <div class="row" style="margin-top: 20px;">
    						<div class="col-md-3">
        						<label for="ngayDen" class="form-label">Ngày nhận phòng</label>
        						<input type="date" class="form-control" id="ngayDen" name="ngayDen" required>
    						</div>
    						<div class="col-md-3">
        						<label for="ngayTra" class="form-label">Ngày trả phòng</label>
        						<input type="date" class="form-control" id="ngayTra" name="ngayTra" required>
    						</div>
    						<div class="col-md-6 d-flex align-items-end" style="margin-top: 26px">
        						<button type="submit" class="btn btn-primary w-100">Kiểm tra phòng trống</button>
    						</div>
						</div>
                        </form>
                    </div>
                    <div>
                        <form id="form-dsphong">
                            <table class="table-dsphong">
                                <tr>
                                    <th style="width: 15%">Hình ảnh phòng</th>
                                    <th style="width: 70%">Thông tin phòng</th> 
                                    <th style="width: 15%"></th>
                                </tr>
                                <c:forEach var="phong" items="${listPhong}">
                                    <tr>
                                        <td style="text-align: center">
                                        	<c:if test="${phong.anhPhong.substring(0,5) != 'https' }">
												<c:url value="/image?fname=${phong.anhPhong}" var="imgUrl"></c:url>
											</c:if> 
											<c:if test="${phong.anhPhong.substring(0,5) == 'https' }">
												<c:url value="${phong.anhPhong}" var="imgUrl"></c:url>
											</c:if>
											<img height="150" width="200" src="${imgUrl}" />
                                        </td>
                                        <td>
                                            <div style="color: #0077CC; font-weight: bold">${phong.ten}</div>
                                            <div>Số phòng còn trống: ${phong.soPhongTrong}</div>
                                            <div>Sức chứa tối đa: ${phong.sucChuaToiDa}</div>
                                            <div>Diện tích: ${phong.dienTich} m2</div>
                                            <div>Mô tả: ${phong.moTa}</div>
                                            <div>${phong.giaThue},000 VND</div>
                                        </td>
                                        <td>
                                            <button type="button" onClick="window.location='datphong.jsp'">Đặt Phòng</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>