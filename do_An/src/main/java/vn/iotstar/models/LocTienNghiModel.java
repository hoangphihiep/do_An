package vn.iotstar.models;

import java.io.Serializable;
import java.util.ArrayList;


public class LocTienNghiModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static ArrayList<LocTienNghiModel> listTienNghi = new ArrayList<LocTienNghiModel>() {
        {
            add(new LocTienNghiModel(0, "Phòng tắm vòi sen"));
            add(new LocTienNghiModel(1, "TV"));
            add(new LocTienNghiModel(2, "Quầy lễ tân"));
            add(new LocTienNghiModel(3, "Lễ tân 24h"));
            add(new LocTienNghiModel(4, "Đưa đón sân bay"));
            add(new LocTienNghiModel(5, "Bãi đậu xe"));
            add(new LocTienNghiModel(6, "Cho thuê xe hơi"));
            add(new LocTienNghiModel(7, "Thang máy"));
            add(new LocTienNghiModel(8, "Nhà hàng"));
            add(new LocTienNghiModel(9, "Máy lạnh"));
            add(new LocTienNghiModel(10, "Bữa sáng"));
            add(new LocTienNghiModel(11, "Wifi"));
        }
    };

    int id;
    String ten;

    public LocTienNghiModel() {
    }

    public LocTienNghiModel(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
