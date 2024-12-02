<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
	<div class="layout fullPage">
		<!-- Begin Header -->
		<%@ include file="/commons/sheller/navbar.jsp"%>
		<!-- End Header -->

		<div class="main">
			<!-- Begin content -->
			<sitemesh:write property="body" />
			<!-- End content -->
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
</html>