/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bean;

public class PhieuMuon {
private String maPM;
private String tenBD;
private String tenSach;
private String ngayMuon;
private String ngayTra;
private String ngayPhaiTra;
private String trangThai;
public PhieuMuon(String maPM, String tenBD, String tenSach, String ngayMuon, String ngayTra, String ngayPhaiTra,
		String trangThai) {
	super();
	this.maPM = maPM;
	this.tenBD = tenBD;
	this.tenSach = tenSach;
	this.ngayMuon = ngayMuon;
	this.ngayTra = ngayTra;
	this.ngayPhaiTra = ngayPhaiTra;
	this.trangThai = trangThai;
}
public String getMaPM() {
	return maPM;
}
public void setMaPM(String maPM) {
	this.maPM = maPM;
}
public String getTenBD() {
	return tenBD;
}
public void setTenBD(String tenBD) {
	this.tenBD = tenBD;
}
public String getTenSach() {
	return tenSach;
}
public void setTenSach(String tenSach) {
	this.tenSach = tenSach;
}
public String getNgayMuon() {
	return ngayMuon;
}
public void setNgayMuon(String ngayMuon) {
	this.ngayMuon = ngayMuon;
}
public String getNgayTra() {
	return ngayTra;
}
public void setNgayTra(String ngayTra) {
	this.ngayTra = ngayTra;
}
public String getNgayPhaiTra() {
	return ngayPhaiTra;
}
public void setNgayPhaiTra(String ngayPhaiTra) {
	this.ngayPhaiTra = ngayPhaiTra;
}
public String getTrangThai() {
	return trangThai;
}
public void setTrangThai(String trangThai) {
	this.trangThai = trangThai;
}
public PhieuMuon() {
	super();
}


}
