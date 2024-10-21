package vn.iotstar.models;

import java.io.Serializable;
import java.util.ArrayList;


public class BuaAnModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static ArrayList<BuaAnModel> listBuaAn = new ArrayList<BuaAnModel>() {
        {
            add(new BuaAnModel(0, "Không có"));
            add(new BuaAnModel(1, "Phòng tắm vòi sen"));
            add(new BuaAnModel(2, "TV"));
            add(new BuaAnModel(3, "Quầy lễ tân"));
            add(new BuaAnModel(4, "Lễ tân 24h"));
            add(new BuaAnModel(5, "Đưa đón sân bay"));
            add(new BuaAnModel(6, "Bãi đậu xe"));
            add(new BuaAnModel(7, "Cho thuê xe hơi"));
            add(new BuaAnModel(8, "Thang máy"));
            add(new BuaAnModel(9, "Nhà hàng"));
            add(new BuaAnModel(10, "Máy lạnh"));
            add(new BuaAnModel(11, "Bữa sáng"));
            add(new BuaAnModel(12, "Wifi"));
        }
    };

    int id;
    String ten;

    public BuaAnModel() {
    }

    public BuaAnModel(int id, String ten) {
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
