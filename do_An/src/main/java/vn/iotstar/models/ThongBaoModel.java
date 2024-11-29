package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class ThongBaoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idUser;
	private Timestamp ngayGui;
	private String noiDung;

	public ThongBaoModel() {
		super();
	}
	public ThongBaoModel(int id, int idUser, Timestamp ngayGui, String noiDung) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.ngayGui = ngayGui;
		this.noiDung = noiDung;
	}
	
	public ThongBaoModel(int idUser, Timestamp ngayGui, String noiDung) {
		super();
		this.idUser = idUser;
		this.ngayGui = ngayGui;
		this.noiDung = noiDung;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Timestamp getNgayGui() {
		return ngayGui;
	}
	public void setNgayGui(Timestamp ngayGui) {
		this.ngayGui = ngayGui;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getThoiGianCachDay() {
        long currentTimeMillis = System.currentTimeMillis(); // Thời gian hiện tại
        long timeDifference = currentTimeMillis - ngayGui.getTime(); // Sự khác biệt thời gian (ms)

        // Chuyển đổi sang đơn vị phù hợp
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeDifference);
        if (minutes < 60) {
            return "cách đây " + minutes + " phút";
        }

        long hours = TimeUnit.MILLISECONDS.toHours(timeDifference);
        if (hours < 24) {
            return "cách đây " + hours + " giờ";
        }

        long days = TimeUnit.MILLISECONDS.toDays(timeDifference);
        return "cách đây " + days + " ngày";
    }
}
