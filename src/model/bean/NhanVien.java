/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bean;

public class NhanVien {
private String maNV;
private String tenNV;
private int tuoi;
private String gioiTinh;
private String SDT;
private String chucVu;
private String luong;
private String tenDN;
private String matKhau;
public String getMaNV() {
	return maNV;
}
public void setMaNV(String maNV) {
	this.maNV = maNV;
}
public String getTenNV() {
	return tenNV;
}
public void setTenNV(String tenNV) {
	this.tenNV = tenNV;
}
public int getTuoi() {
	return tuoi;
}
public void setTuoi(int tuoi) {
	this.tuoi = tuoi;
}
public String getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getSDT() {
	return SDT;
}
public void setSDT(String sDT) {
	SDT = sDT;
}
public String getChucVu() {
	return chucVu;
}
public void setChucVu(String chucVu) {
	this.chucVu = chucVu;
}
public String getLuong() {
	return luong;
}
public void setLuong(String luong) {
	this.luong = luong;
}
public String getTenDN() {
	return tenDN;
}
public void setTenDN(String tenDN) {
	this.tenDN = tenDN;
}
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public NhanVien(String maNV, String tenNV, int tuoi, String gioiTinh, String sDT, String chucVu, String luong,
		String tenDN, String matKhau) {
	super();
	this.maNV = maNV;
	this.tenNV = tenNV;
	this.tuoi = tuoi;
	this.gioiTinh = gioiTinh;
	SDT = sDT;
	this.chucVu = chucVu;
	this.luong = luong;
	this.tenDN = tenDN;
	this.matKhau = matKhau;
}
public NhanVien() {
	super();
}

}
