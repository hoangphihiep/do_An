package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class DoanhThuModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Date ngayDat;
	int tongTien;
	int tongPhongDat;
	
	public DoanhThuModel() {
		super();
	}

	public DoanhThuModel(Date ngayDat, int tongTien, int tongPhongDat) {
		super();
		this.ngayDat = ngayDat;
		this.tongTien = tongTien;
		this.tongPhongDat = tongPhongDat;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public int getTongPhongDat() {
		return tongPhongDat;
	}

	public void setTongPhongDat(int tongPhongDat) {
		this.tongPhongDat = tongPhongDat;
	}

	@Override
	public String toString() {
		return "DoanhThuModel [ngayDat=" + ngayDat + ", tongTien=" + tongTien + ", tongPhongDat=" + tongPhongDat + "]";
	}
}
