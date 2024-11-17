<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<div style="background-color: #003580; height: 50px; display: flex; align-items: center; padding: 0 20px; justify-content: space-between;">   
        <!-- Booking.com Text -->
        <div style="color: white; font-size: 18px; font-weight: bold;">
            Booking.com
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