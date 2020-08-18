/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bean;

public class Loai {
private String maLoai;
private String tenloai;
private String anh;


public String getTenloai() {
	return tenloai;
}
public void setTenloai(String tenloai) {
	this.tenloai = tenloai;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}

public Loai(String maLoai, String tenloai, String anh) {
	super();
	this.maLoai = maLoai;
	this.tenloai = tenloai;
	this.anh = anh;
}
public String getMaLoai() {
	return maLoai;
}
public void setMaLoai(String maLoai) {
	this.maLoai = maLoai;
}
public Loai() {
	super();
}

}
