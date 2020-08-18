/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bean;

public class Sach {
private String maSach;
private String tenSach;
private String maTheLoai;
private String tacGia;
private String nhaXuatBan;
private int NamXuatban;
private String AnhSach;
private String TheLoai="";
private int soHienCon;
private int Soluong;
private int soLanMuon=0;

public Sach(String maSach, String tenSach, String maTheLoai, String tacGia, String nhaXuatBan, int namXuatban,
		String anhSach, String theLoai, int soHienCon, int soluong, int soLanMuon) {
	super();
	this.maSach = maSach;
	this.tenSach = tenSach;
	this.maTheLoai = maTheLoai;
	this.tacGia = tacGia;
	this.nhaXuatBan = nhaXuatBan;
	NamXuatban = namXuatban;
	AnhSach = anhSach;
	TheLoai = theLoai;
	this.soHienCon = soHienCon;
	Soluong = soluong;
	this.soLanMuon = soLanMuon;
}
public int getSoluong() {
	return Soluong;
}
public void setSoluong(int soluong) {
	Soluong = soluong;
}
public int getSoHienCon() {
	return soHienCon;
}
public void setSoHienCon(int soHienCon) {
	this.soHienCon = soHienCon;
}
public int getSoLanMuon() {
	return soLanMuon;
}
public void setSoLanMuon(int soLanMuon) {
	this.soLanMuon = soLanMuon;
}
public String getMaSach() {
	return maSach;
}
public void setMaSach(String maSach) {
	this.maSach = maSach;
}
public String getTenSach() {
	return tenSach;
}
public void setTenSach(String tenSach) {
	this.tenSach = tenSach;
}
public String getMaTheLoai() {
	return maTheLoai;
}
public void setMaTheLoai(String maTheLoai) {
	this.maTheLoai = maTheLoai;
}
public String getTacGia() {
	return tacGia;
}
public void setTacGia(String tacGia) {
	this.tacGia = tacGia;
}
public String getNhaXuatBan() {
	return nhaXuatBan;
}
public void setNhaXuatBan(String nhaXuatBan) {
	this.nhaXuatBan = nhaXuatBan;
}
public int getNamXuatban() {
	return NamXuatban;
}
public void setNamXuatban(int namXuatban) {
	NamXuatban = namXuatban;
}
public String getAnhSach() {
	return AnhSach;
}
public void setAnhSach(String anhSach) {
	AnhSach = anhSach;
}
public String getTheLoai() {
	return TheLoai;
}
public void setTheLoai(String theLoai) {
	TheLoai = theLoai;
}
public Sach() {
	super();
}




}
