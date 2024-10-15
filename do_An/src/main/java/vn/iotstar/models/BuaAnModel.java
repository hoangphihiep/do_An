package vn.iotstar.models;

import java.io.Serializable;
import java.util.ArrayList;


public class BuaAnModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static ArrayList<BuaAnModel> listBuaAn = new ArrayList<BuaAnModel>() {
        {
            add(new BuaAnModel(0, "Không có"));
            add(new BuaAnModel(1, "Bữa Sáng"));
            add(new BuaAnModel(2, "Bữa Sáng Và Trưa"));
            add(new BuaAnModel(3, "Bữa Sáng Và Tối"));
            add(new BuaAnModel(4, "Cả Ba Bữa"));
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
