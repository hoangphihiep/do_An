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
        <h2 style="margin-bottom: 20px;">Tài khoản</h2>
        <table id="reservationTable" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr style="background-color: #f8f9fa; border-bottom: 1px solid #ddd;">
                    <th style="padding: 10px; text-align: left;">STT</th>
                    <th style="padding: 10px; text-align: left;">Họ và tên</th>
                    <th style="padding: 10px; text-align: left;">Email</th>
                    <th style="padding: 10px; text-align: left;">Điện thoại</th>
                    <th style="padding: 10px; text-align: left;">Trạng thái</th>
                    <th style="padding: 10px; text-align: left;">Vai trò</th>
                    <th style="padding: 10px; text-align: left;">Thao tác</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listuser}" var="user" varStatus="STT">
            		<tr style="border-bottom: 1px solid #ddd;">
	                    <td style="padding: 10px;">${STT.index+1}</td>
	                    <td style="padding: 10px;">${user.fullname}</td>
	                    <td style="padding: 10px;">${user.email}</td>
	                    <td style="padding: 10px;">${user.phone}</td>
	                    <c:if test="${user.acitve == true}">
	                    	<td style="padding: 10px; color: green;">Hoạt động</td>
	                    </c:if>
	                    <c:if test="${user.acitve == false}">
	                    	<td style="padding: 10px; color: red;">Đã khóa</td>
	                    </c:if>
	                    <td style="padding: 10px;">
	                    	<c:if test="${user.idRole == 1}">
	                    		<span style="background-color: #17a2b8; color: white; padding: 5px 10px; border-radius: 4px;">ROLE_CUSTOMER</span>
	                    	</c:if>
	                    	<c:if test="${user.idRole == 2}">
	                    		<span style="background-color: #007bff; color: white; padding: 5px 10px; border-radius: 4px;">ROLE_BUSINESS</span>
	                    	</c:if>
	                    	<c:if test="${user.idRole == 3}">
	                    		<span style="background-color: #28a745; color: white; padding: 5px 10px; border-radius: 4px;">ROLE_ADMIN</span>
	                    	</c:if>
	                        
	                    </td>
	                    <td style="padding: 10px;">
	                    	<c:if test="${user.acitve == true}">
	                    		<a href="<c:url value='/admin/listTaiKhoan?id=${user.id}'/>" style="background-color: #dc3545; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">🔒 Khóa</a>
	                    	</c:if>
	                        <c:if test="${user.acitve == false}">
	                    		<a href="<c:url value='/admin/listTaiKhoan?id=${user.id}'/>" style="background-color: #007bff; color: white; border: none; padding: 5px 10px; border-radius: 4px; cursor: pointer; display: inline-block; text-decoration: none;">🔓 Mở khóa</a>
	                    	</c:if>
	                    </td>
	                </tr>
	                
            	</c:forEach>
                
            </tbody>
        </table>
    </div>

</body>
</html>