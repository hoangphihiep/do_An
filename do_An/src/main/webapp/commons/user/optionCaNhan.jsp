<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div >
            <script>link_active = 3;</script>
 			
            <div >
                
                <div style ="display: flex;gap: 20px; margin-top: 20px;">
                    <div >
                        <div style="margin-top: 20px">
                            <div style="border-radius: 3px; border: 1px solid #c0c0c0; margin-bottom: 20px; overflow: hidden">
                                <div style="background-color: #F7F7F7; font-size: 18px; font-weight: bold; padding: 8px 0 8px 30px">Danh Mục</div>
                                <hr style="border: none; height: 1px; background-color: #c0c0c0; margin: 0"/>
                                <div style = "margin: 0;padding: 0;width: 100%;height: 100%;background-color: #FDFDFD;">
                                    <form action="/do_An/myAccount/trangCaNhan" method="GET">
								        <button type="submit" class="btn-link" style="display: block;">
								            <i style="margin-right: 15px" class="fa fa-id-card"></i>Trang Cá Nhân
								        </button>
								    </form>
								    <form action="/do_An/myAccount/lichSuDatPhong" method="GET">
								        <button type="submit" class="btn-link" style="display: block;">
								            <i style="margin-right: 15px" class="fa fa-history"></i>Lịch Sử
								        </button>
								    </form>
								    <form action="/do_An/myAccount/danhsachksyeuthich" method="GET">
								        <button type="submit" class="btn-link" style="display: block;">
								            <i style="margin-right: 15px" class="fa fa-history"></i>Yêu thích
								        </button>
								    </form>
								    <button class="btn-link" style="display: block;">
								        <i style="margin-right: 15px" class="fa fa-share-alt"></i>Chia Sẻ
								    </button>
                                </div>
                            </div>
                            <div style="border-radius: 3px; background-color: #E9F0FA; border: 1px solid #CCE1FF; text-align: center; padding: 12px 8px 16px 8px; margin-bottom: 20px">
                                Bạn thấy dịch vụ của chúng tôi rất tốt?<br/>
                                <button class="btn btn-kstuongtu">Chia sẻ ngay</button>
                            </div>
                            <div style="border-radius: 3px; border: 1px solid #c0c0c0; text-align: center; padding: 12px 8px 16px 8px">
                                Có thể bạn thắc mắc<br/>
                                Đang vướng mắc một điều gì đó?<br/>
                                <button class="btn btn-default" style="width: 90%; margin-top: 17px; border: 1px solid #0077CC; color: #0077CC">Đặt câu hỏi</button>
                            </div>
                        </div>
                    </div>               
                </div>
            </div>
        </div>