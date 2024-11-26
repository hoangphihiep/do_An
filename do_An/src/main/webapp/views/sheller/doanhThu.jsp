<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f0f8ff; margin: 0; padding: 20px;">
	
	<%@ include file="/commons/sheller/headerGiamGia.jsp"%>
    <!-- Header -->
    <div style="padding: 20px; background-color: #e9f5ff; border: 1px solid #d1e7f5; border-radius: 8px;">
        <h2 style="margin: 0; color: #007bff;">Thống kê doanh thu</h2>
    </div>

    <!-- Filters -->
     <form action="${pageContext.request.contextPath}/sheller/doanhThu" method="post">
     	<div style="margin-top: 20px; background-color: #ffffff; padding: 20px; border: 1px solid #ddd; border-radius: 8px;">
	        <div style="display: flex; align-items: center; gap: 20px;">
	            <div>
	                <label for="hotel" style="display: block; margin-bottom: 5px;">Lựa chọn khách sạn</label>
	                <select name="hotel" id="hotel" style="padding: 8px 10px; border: 1px solid #ccc; border-radius: 4px; width: 200px;">
	                    <c:forEach items="${listKS}" var="ks">
			            	<option value="${ks.id}" 
				                <c:if test="${ks.ten == tenks}">selected</c:if>>${ks.ten}
				            </option>
			            </c:forEach>
	                </select>
	            </div>
	            <div>
			        <label for="start-date" style="display: block; margin-bottom: 5px;">Ngày bắt đầu</label>
			        <input id="start-date" name="startDate" type="date" value = "${ngaybatdau}"
			            style="padding: 8px 10px; border: 1px solid #ccc; border-radius: 4px; width: 250px;" required>
			    </div>
			    <div >
			        <label for="end-date" style="display: block; margin-bottom: 5px;">Ngày kết thúc</label>
			        <input id="end-date" name="endDate" type="date" value = "${ngayketthuc}"
			            style="padding: 8px 10px; border: 1px solid #ccc; border-radius: 4px; width: 250px;" required>
			    </div>
	            <button type="submit" style="padding: 8px 15px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; margin-top: 23px;">
	                Thống kê
	            </button>
	        </div>
	    </div>
     </form>
    

    <!-- Statistics -->
    <div style="margin-top: 20px;">
        <div style="padding: 15px; background-color: #ffffff; border: 1px solid #ddd; border-radius: 8px;">
            <p style="margin: 0; font-size: 16px;">Tổng số lượt đặt phòng: <strong>${tongdatphong}</strong></p>
            <p style="margin: 5px 0; font-size: 16px;">Tổng số tiền đặt phòng: <strong>${tongtiendp} VND</strong></p>
        </div>
    </div>

    <!-- Chart (Placeholder for simplicity) -->
    <div style="margin-top: 20px; padding: 20px; display: flex; justify-content: center; background-color: #ffffff; border: 1px solid #ddd; border-radius: 8px;">
        <img src="data:image/png;base64,${chartImage}" alt="Biểu đồ doanh thu" style="max-width: 100%;">
    </div>

</body>
</html>