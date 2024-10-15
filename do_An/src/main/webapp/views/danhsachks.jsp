<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Danh sách Khách sạn</title>
    </head>
    <body>
        <div class="c80">
            <h3 style="text-align: center; color: #444; margin-bottom: 0px">Các Khách sạn tìm thấy</h3>
            <div class="row">
                <div class="col-md-3">
                    <div style="border: 1px solid #c0c0c0; border-radius: 5px; margin-top: 20px">
                        <form method="post" action="hotelFilterAction">
                            <div style="padding: 10px 0 8px 20px">
                                <span style="font-size: 16px; font-weight: bold">Chọn lọc theo</span>
                            </div>

                            <%-- Xếp hạng --%>
                            <div class="khoi-loc">
                                <div class="head">Xếp hạng</div>
                                <c:forEach var="xephang" items="${listxh}">
                                    <div>
                                        <input type="checkbox" name="ranking" value="${xephang.checked}"/> ${xephang.label}
                                    </div>
                                </c:forEach>
                            </div>

                            <%-- Loại khách sạn --%>
                            <div class="khoi-loc">
                                <div class="head">Loại khách sạn</div>
                                <c:forEach var="loaiks" items="${listloaiks}">
                                    <div>
                                        <input type="checkbox" name="hotelType" value="${loaiks.checked}"/> ${loaiks.label}
                                    </div>
                                </c:forEach>
                            </div>

                            <%-- Bữa ăn --%>
                            <div class="khoi-loc">
                                <div class="head">Bữa ăn</div>
                                <c:forEach var="buaan" items="${listBuaAn}">
                                    <div>
                                        <input type="checkbox" name="mealType" value="${buaan.checked}"/> ${buaan.label}
                                    </div>
                                </c:forEach>
                            </div>

                            <%-- Cách trung tâm --%>
                            <div class="khoi-loc">
                                <div class="head">Cách trung tâm</div>
                                <c:forEach var="cachtrungtam" items="${listCachTrungTam}">
                                    <div>
                                        <input type="checkbox" name="distanceFromCenter" value="${cachtrungtam.checked}"/> ${cachtrungtam.label}
                                    </div>
                                </c:forEach>
                            </div>

                            <%-- Giáp biển --%>
                            <div class="khoi-loc">
                                <div class="head">Giáp biển</div>
                                <c:forEach var="giapbien" items="${listGiapBien}">
                                    <div>
                                        <input type="checkbox" name="nearSea" value="${giapbien.checked}"/> ${giapbien.label}
                                    </div>
                                </c:forEach>
                            </div>

                        </form>
                    </div>
                </div>

                <div class="col-md-9">
                    <form id="form" method="post" action="hotelListAction">
                        <c:forEach var="ks" items="${listks}">
                            <a href="<c:url value='/khachsan?id=${ks.id}'/>" class="link-khachsan">
                                <div class="div-khachsan" style="height: 240px; border: 1px solid #c0c0c0; border-radius: 5px; margin-top: 20px">
                                    <div class="row">
                                        <div class="col-md-4" style="margin: 20px 0 0 20px; width: 240px">
                                            <div style="border-radius: 3px; width: 220px; overflow: hidden">
                                                <img style="height: 200px" src="/do_An_CNTT/Content/Images/KhachSan/${ks.id}.jpg" alt="Img"/>
                                            </div>
                                        </div>
                                        <div class="col-md-8" style="margin: 20px 0 0 20px; width: 480px">
                                            <div style="font-size: 18px; font-weight: bold; color: #0077CC">${ks.ten}</div>
                                            <div style="font-size: 14px; color: #666666 "><span style="font-weight: bold; color: #077812">${ks.tenThanhPho}</span> - Cách trung tâm: ${ks.cachTrungTam} m</div>
                                            <div style="font-size: 14px; color: #777777">${ks.tenLoaiKhachSan}</div>
                                            <div style="font-size: 14px">Giáp biển: ${ks.giapBien ? "Có" : "Không"}</div>
                                            <div class="danh-gia-star">${ks.danhGia} &#9733;</div>
                                            <div class="danh-gia-label">${strDanhGia[ks.danhGia]}</div>
                                            <div style="font-size: 13px; color: #666666">${ks.moTa}</div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>