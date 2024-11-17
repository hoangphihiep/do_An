<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    /* Sidebar container */
    .sidebar {
        width: 250px;
        background-color: #3a4b59;
        height: 100vh;
        color: #c2c7d0;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding-top: 20px;
        box-sizing: border-box;
    }

    /* Sidebar item */
    .sidebar-item {
        width: 100%;
        padding: 15px 20px;
        display: flex;
        align-items: center;
        color: #c2c7d0;
        text-decoration: none;
        font-size: 16px;
        transition: background-color 0.3s;
        position: relative;
        box-sizing: border-box; /* Ensure padding doesn't increase width */
    }

    /* Icon style */
    .sidebar-item i {
        width: 20px;
        height: 20px;
        background-color: #c2c7d0;
        margin-right: 10px;
        transition: background-color 0.3s;
    }

    /* Hover effect */
    .sidebar-item:hover {
        background-color: #2e3b4a;
        color: #ffffff;
    }

    .sidebar-item:hover i {
        background-color: #1abc9c;
    }

    /* Active item (highlighted) */
    .sidebar-item.active {
        background-color: #2e3b4a;
        color: #ffffff;
    }

    .sidebar-item.active i {
        background-color: #1abc9c;
    }

    /* Submenu styling */
    .submenu {
        display: none;
        flex-direction: column;
        position: absolute;
        top: 0;
        left: 100%;
        background-color: #2e3b4a;
        min-width: 200px;
        box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);
    }

    /* Show submenu on hover */
    .sidebar-item:hover .submenu {
        display: flex;
    }

    /* Submenu item */
    .submenu-item {
        padding: 10px 20px;
        color: #c2c7d0;
        text-decoration: none;
        font-size: 14px;
        transition: background-color 0.3s;
        white-space: nowrap;
        box-sizing: border-box;
    }

    /* Submenu hover effect */
    .submenu-item:hover {
        background-color: #1abc9c;
        color: #ffffff;
    }
</style>
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/bootstrap.min.css" />
<!-- // -->
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/style.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/font.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/carousel.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/style2.css" />
<script src="/do_An/Content/js/sweetalert2.min.js"></script>
</head>
<body>
	<div>
		<!-- Begin Header -->
		<%@ include file="/commons/sheller/navbar.jsp"%>
		<!-- End Header -->
        <%@ include file="/commons/sheller/header.jsp"%>
        <!-- Flex container for optionCaNhan.jsp and main body -->
        <div class="container-flex">
            <div style = "flex: 1; margin-left: 120px; margin-top: 50px">
                <%@ include file="/commons/sheller/optionChiTiet.jsp" %>
            </div>
            <div class="main-section">
                <div class="main">
                    <sitemesh:write property="body" />
                </div>
            </div>
        </div>
    </div>
</body>
</html>