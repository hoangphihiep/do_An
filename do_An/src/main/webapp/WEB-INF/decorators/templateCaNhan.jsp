<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
    <title>PrimeFaces</title>
    <link type="text/css" rel="stylesheet" href="/do_An/Content/css/bootstrap.min.css" />
    <!-- // -->
    <link type="text/css" rel="stylesheet" href="/do_An/Content/css/style.css" />
    <link type="text/css" rel="stylesheet" href="/do_An/Content/css/font.css" />
    <link type="text/css" rel="stylesheet" href="/do_An/Content/css/carousel.css" />
    <link type="text/css" rel="stylesheet" href="/do_An/Content/css/style2.css" />

    <!-- Flexbox CSS to make the layout horizontal -->
    <style>
        .container-flex {
            display: flex; /* Use flexbox layout */
        }
        .option-section {
            flex: 1; /* Adjust width of option section */
        }
        .main-section {
            flex: 3; /* Adjust width of main body section */
        }
    </style>
</head>
<body>
    <div class="layout fullPage">
        <script>link_active = 3;</script>
		<!-- Begin Header -->
		<%@ include file="/commons/user/header.jsp"%>
		<!-- End Header -->
        
        <!-- Flex container for optionCaNhan.jsp and main body -->
        <div class="container-flex">
            <div style = "flex: 1; margin-left: 120px; margin-top: 50px">
                <%@ include file="/commons/user/optionCaNhan.jsp" %>
            </div>
            <div class="main-section">
                <div class="main">
                    <sitemesh:write property="body" />
                </div>
            </div>
        </div>

        <!-- Begin Footer -->
		<%@ include file="/commons/user/footer.jsp"%>
		<!-- End Footer -->
    </div>
    <!-- Include scripts -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/do_An/Content/js/bootstrap.min.js"></script>
    <script src="/do_An/Content/js/carousel.js"></script>
    <script src="/do_An/Content/js/range.js"></script>

    <script>
        var link_active = 1;
    </script>
    <script>
        var li = document.getElementById('form-nav:link-' + link_active);
        li.classList.add('active');
    </script>

    <!-- Thêm Bootstrap JS và jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wnumb/1.1.0/wNumb.min.js"></script>
</body>
</html>
