<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/commons/admin/headerAnhKS.jsp"%>
	<div
		style="max-width: 900px; padding: 20px; background-color: #fff; border: 1px solid #ddd; border-radius: 8px; margin-left: 80px;">
		<!-- Phần chính tải ảnh -->
		<div style="text-align: center;">
			<!-- Sử dụng CSS Grid để sắp xếp ảnh -->
			<div
				style="display: grid; grid-template-columns: repeat(3, 1fr); gap: 20px; justify-items: center;">
				<!-- Hàng đầu tiên chứa 1 ảnh -->
				<div style="grid-column: span 3;">
					<div
						style="width: 400px; height: 200px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
						<div id="previewContainer1"
							style="width: 100%; height: 200px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
							<span id="placeholderText1" style="color: #aaa; font-size: 14px;"></span>
							<c:if test="${image1.substring(0,5) != 'https' }">
								<c:url value="/image?fname=${image1}" var="imgUrl"></c:url>
							</c:if>
							<c:if test="${image1.substring(0,5) == 'https' }">
								<c:url value="${image1}" var="imgUrl"></c:url>
							</c:if>
							<img id="previewImage1" src="${imgUrl}"
								style="width: 100%; height: 100%; object-fit: cover;">
						</div>
						<input type="file" id="imageUpload1" name="image1"
							value="${imgUrl}" style="display: none;" accept="image/*"
							onchange="previewImage(event, 'previewImage1', 'placeholderText1')">
						<input type="hidden" name="image1Url" value="${imgUrl}">
						<button type="button"
							onclick="document.getElementById('imageUpload1').click()"
							style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
					</div>
				</div>

				<!-- Hàng thứ hai chứa 3 ảnh -->
				<div
					style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					<div id="previewContainer2"
						style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
						<span id="placeholderText2" style="color: #aaa; font-size: 14px;"></span>
						<c:if test="${image2.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${image2}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${image2.substring(0,5) == 'https' }">
							<c:url value="${image2}" var="imgUrl"></c:url>
						</c:if>
						<img id="previewImage2" src="${imgUrl}"
							style="width: 100%; height: 100%; object-fit: cover;">
					</div>
					<input type="file" id="imageUpload2" name="image2"
						value="${imgUrl}" style="display: none;" accept="image/*"
						onchange="previewImage(event, 'previewImage2', 'placeholderText2')">
					<input type="hidden" name="image2Url" value="${imgUrl}">
					<button type="button"
						onclick="document.getElementById('imageUpload2').click()"
						style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
				</div>

				<div
					style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					<div id="previewContainer3"
						style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
						<span id="placeholderText3" style="color: #aaa; font-size: 14px;"></span>
						<c:if test="${image3.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${image3}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${image3.substring(0,5) == 'https' }">
							<c:url value="${image3}" var="imgUrl"></c:url>
						</c:if>
						<img id="previewImage3" src="${imgUrl}"
							style="width: 100%; height: 100%; object-fit: cover;">
					</div>
					<input type="file" id="imageUpload3" name="image3"
						value="${imgUrl}" style="display: none;" accept="image/*"
						onchange="previewImage(event, 'previewImage3', 'placeholderText3')">
					<input type="hidden" name="image3Url" value="${imgUrl}">
					<button type="button"
						onclick="document.getElementById('imageUpload3').click()"
						style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
				</div>

				<div
					style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					<div id="previewContainer4"
						style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
						<span id="placeholderText4" style="color: #aaa; font-size: 14px;"></span>
						<c:if test="${image4.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${image4}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${image4.substring(0,5) == 'https' }">
							<c:url value="${image4}" var="imgUrl"></c:url>
						</c:if>
						<img id="previewImage4" src="${imgUrl}"
							style="width: 100%; height: 100%; object-fit: cover;">
					</div>
					<input type="file" id="imageUpload4" name="image4"
						value="${imgUrl}" style="display: none;" accept="image/*"
						onchange="previewImage(event, 'previewImage4', 'placeholderText4')">
					<input type="hidden" name="image4Url" value="${imgUrl}">
					<button type="button"
						onclick="document.getElementById('imageUpload4').click()"
						style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
				</div>

				<!-- Ảnh 5 -->
				<div
					style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					<div id="previewContainer5"
						style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
						<span id="placeholderText5" style="color: #aaa; font-size: 14px;"></span>
						<c:if test="${image5.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${image5}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${image5.substring(0,5) == 'https' }">
							<c:url value="${image5}" var="imgUrl"></c:url>
						</c:if>
						<img id="previewImage5" src="${imgUrl}"
							style="width: 100%; height: 100%; object-fit: cover;">
					</div>
					<input type="file" id="imageUpload5" name="image5"
						value="${imgUrl}" style="display: none;" accept="image/*"
						onchange="previewImage(event, 'previewImage5', 'placeholderText5')">
					<input type="hidden" name="image5Url" value="${imgUrl}">
					<button type="button"
						onclick="document.getElementById('imageUpload5').click()"
						style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
				</div>

				<!-- Ảnh 6 -->
				<div
					style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					<div id="previewContainer6"
						style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
						<span id="placeholderText6" style="color: #aaa; font-size: 14px;"></span>
						<c:if test="${image6.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${image6}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${image6.substring(0,5) == 'https' }">
							<c:url value="${image6}" var="imgUrl"></c:url>
						</c:if>
						<img id="previewImage6" src="${imgUrl}"
							style="width: 100%; height: 100%; object-fit: cover;">
					</div>
					<input type="file" id="imageUpload6" name="image6"
						value="${imgUrl}" style="display: none;" accept="image/*"
						onchange="previewImage(event, 'previewImage6', 'placeholderText6')">
					<input type="hidden" name="image6Url" value="${imgUrl}">
					<button type="button"
						onclick="document.getElementById('imageUpload6').click()"
						style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
				</div>

				<!-- Ảnh 7 -->
				<div
					style="width: 270px; height: 300px; background-color: white; border-radius: 10px; box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1); display: flex; flex-direction: column; justify-content: space-between; align-items: center;">
					<div id="previewContainer7"
						style="width: 100%; height: 300px; background-color: #eee; display: flex; align-items: center; justify-content: center; border: 1px dashed #ccc; overflow: hidden;">
						<span id="placeholderText7" style="color: #aaa; font-size: 14px;"></span>
						<c:if test="${image7.substring(0,5) != 'https' }">
							<c:url value="/image?fname=${image7}" var="imgUrl"></c:url>
						</c:if>
						<c:if test="${image7.substring(0,5) == 'https' }">
							<c:url value="${image7}" var="imgUrl"></c:url>
						</c:if>
						<img id="previewImage7" src="${imgUrl}"
							style="width: 100%; height: 100%; object-fit: cover;">
					</div>
					<input type="file" id="imageUpload7" name="image7"
						value="${imgUrl}" style="display: none;" accept="image/*"
						onchange="previewImage(event, 'previewImage7', 'placeholderText7')">
					<input type="hidden" name="image7Url" value="${imgUrl}">
					<button type="button"
						onclick="document.getElementById('imageUpload7').click()"
						style="width: 100%; background-color: #4e9a9b; color: white; font-size: 24px; text-align: center; padding: 5px 0; border-radius: 0 0 10px 10px; cursor: pointer;">Upload</button>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>