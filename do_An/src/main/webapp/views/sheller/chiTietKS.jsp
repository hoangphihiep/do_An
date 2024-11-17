<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sidebar</title>
<style>
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
</head>
<body style="margin: 0; font-family: Arial, sans-serif; background-color: #333;">

<!-- BEGIN SIDEBAR -->
<div class="sidebar">
    <a href="#" class="sidebar-item">
        <i style="mask: url('icon-home.svg') no-repeat center;"></i>
        <span>Thông tin khách sạn</span>
    </a>
    <a href="#" class="sidebar-item">
        <i style="mask: url('icon-basket.svg') no-repeat center;"></i>
        <span>Tiện nghi khách sạn</span>
    </a>
    <div class="sidebar-item">
        <i style="mask: url('icon-diamond.svg') no-repeat center;"></i>
        <span>Phòng của khách sạn</span>
        <div class="submenu">
            <a href="#" class="submenu-item">Phòng đơn</a>
            <a href="#" class="submenu-item">Phòng đôi</a>
            <a href="#" class="submenu-item">Phòng gia đình</a>
            <a href="#" class="submenu-item">Phòng VIP</a>
        </div>
    </div>
    <a href="#" class="sidebar-item">
        <i style="mask: url('icon-diamond.svg') no-repeat center;"></i>
        <span>Ảnh khách sạn</span>
    </a>
</div>

</body>
</html>
