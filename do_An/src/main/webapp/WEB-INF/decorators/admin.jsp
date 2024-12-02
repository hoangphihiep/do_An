<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 150px;
        box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
        z-index: 1;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #ddd;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/bootstrap.min.css" />
<!-- // -->
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/style.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/font.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/carousel.css" />
<link type="text/css" rel="stylesheet" href="/do_An/Content/css/style2.css" />
<!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script src="/do_An/Content/js/sweetalert2.min.js"></script>
</head>
<body>
<body>
	
	<div>
		<!-- Begin Header -->
		<%@ include file="/commons/admin/navbar.jsp"%>
        <!-- Flex container for optionCaNhan.jsp and main body -->
        <div class="container-flex">
            <div style = "flex: 1; margin-left: 0px; margin-top: 0px">
                <%@ include file="/commons/admin/sidebar.jsp" %>
            </div>
            <div class="main-section">
                <div class="main">
                    <sitemesh:write property="body" />
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $('#reservationTable').DataTable({
                "paging": true,        // Bật phân trang
                "searching": true,    // Bật tìm kiếm
                "ordering": true,     // Bật sắp xếp cột
                "info": true,         // Hiển thị thông tin bảng
                "lengthMenu": [5, 10, 25, 50], // Số hàng mỗi trang
                "language": {
                    "lengthMenu": "Hiển thị _MENU_ dòng mỗi trang",
                    "zeroRecords": "Không tìm thấy dữ liệu",
                    "info": "Hiển thị trang _PAGE_ của _PAGES_",
                    "infoEmpty": "Không có dữ liệu",
                    "infoFiltered": "(lọc từ _MAX_ dòng)",
                    "search": "Tìm kiếm:",
                    "paginate": {
                        "first": "Đầu",
                        "last": "Cuối",
                        "next": "Tiếp",
                        "previous": "Trước"
                    }
                }
            });
        });
    </script>
    <script>
	    function toggleDropdown(event) {
	        event.preventDefault();
	        const dropdown = document.getElementById('notificationDropdown');
	        // Toggle visibility
	        if (dropdown.style.display === 'none' || dropdown.style.display === '') {
	            dropdown.style.display = 'block';
	        } else {
	            dropdown.style.display = 'none';
	        }
	    }
	
	    // Đóng dropdown nếu click ra ngoài
	    document.addEventListener('click', function(event) {
	        const dropdown = document.getElementById('notificationDropdown');
	        if (!event.target.closest('.dropdown')) {
	            dropdown.style.display = 'none';
	        }
	    });
	</script>
	<script src="/do_An/Content/js/bootstrap.min.js"></script>
 

    
</body>
</body>
</html>