<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<div style="background-color: #003580; height: 50px; display: flex; align-items: center; padding: 0 20px; justify-content: space-between;">   
        <!-- Booking.com Text -->
        <div style="color: white; font-size: 18px; font-weight: bold;">
            UTEBooking
        </div>
        <!-- Icons Section -->
        <div style="display: flex; align-items: center; gap: 15px;">     
            <!-- Flag Icon -->
            <div style="width: 25px; height: 25px; background-color: red; border-radius: 50%; display: flex; justify-content: center; align-items: center;">
                <span style="color: yellow; font-size: 16px;">★</span>
            </div>
            <c:choose>
	            <c:when test="${!empty username}">
	            	<div>
	            		<div class="dropdown" style="position: relative; display: inline-block;">
						    <!-- Hình ảnh thông báo -->
						    <c:if test="${!empty slthongbao}">
						    	<a href="#" onclick="toggleDropdown(event)" class="nav-link" style="color: white; margin: 0 10px; text-decoration: none; padding: 8px; border-radius: 4px; position: relative;">
							        <img src="/do_An/Content/Images/notification.png" alt="Notification" valign="middle" width="20" height="20" />
							        <span class="notification-count" style="position: absolute; top: 0; right: -5px; background: red; color: white; font-size: 10px; padding: 2px 5px; border-radius: 50%;">${slthongbao}</span>
						    	</a>
						    </c:if>
						    
						    <!-- Nội dung dropdown -->
						    <div class="dropdown-content" id="notificationDropdown" style="display: none; position: absolute; background-color: white; padding: 15px; box-shadow: 0 2px 8px rgba(0,0,0,0.2); border-radius: 8px; width: 300px; right: 0; z-index: 1000; max-height: 400px; overflow-y: auto;">
						        <p style="font-weight: bold; margin: 0 0 10px; color: #333;">Các thông báo</p>
						        <c:forEach items="${listthongbao}" var="thongbao">
						            <div class="notification-item" style="border-bottom: 1px solid #ddd; padding: 10px 0;">
						                <div style="display: flex; justify-content: space-between; align-items: center;">
							                <p style="margin: 0; color: black; flex: 1;">${thongbao.noiDung}</p>
							                <!-- Nút xóa -->
							                <a href="deleteNotification?id=${thongbao.id}" style="color: red; text-decoration: none; font-size: 12px; margin-left: 10px;">Xóa</a>
							            </div>
						                <p style="margin: 5px 0; color: gray; font-size: 12px;">${thongbao.thoiGianCachDay}</p>
						                <a href="#" style="color: #007BFF; text-decoration: none; font-size: 12px;">View full notification</a>
						            </div>
						        </c:forEach>
						        <a href="#" style="display: block; text-align: center; color: #007BFF; text-decoration: none; margin-top: 10px; font-weight: bold;">See all</a>
						    </div>
						</div>          
	                </div>
	                <div>
	                    <span style="margin-right: 20px; color: white; font-weight: bold">Xin chào đối tác, <strong>${username}</strong></span>
	                    <a href="<c:url value='/logout'/>" style="color: #00BBFF; font-weight: bold">Đăng Xuất</a>
	                </div>
	            </c:when>
	        </c:choose>
            
            <!-- Help Icon -->
            <div style="width: 25px; height: 25px; border: 1px solid white; border-radius: 50%; display: flex; justify-content: center; align-items: center; color: white; font-size: 16px;">
                ?
            </div>
        </div>      
    </div>