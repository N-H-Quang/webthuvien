/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bean;

public class BanDoc {
private String maBD;
private String tenBD;
private String matKhau;
private String hoTen;
private String email;
private String diaChi;
private String sdt;
public String getMaBD() {
	return maBD;
}
public void setMaBD(String maBD) {
	this.maBD = maBD;
}
public String getTenBD() {
	return tenBD;
}
public void setTenBD(String tenBD) {
	this.tenBD = tenBD;
}
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}
public BanDoc(String maBD, String tenBD, String matKhau, String hoTen, String email, String diaChi, String sdt) {
	super();
	this.maBD = maBD;
	this.tenBD = tenBD;
	this.matKhau = matKhau;
	this.hoTen = hoTen;
	this.email = email;
	this.diaChi = diaChi;
	this.sdt = sdt;
}
public BanDoc() {
	super();
}

}
