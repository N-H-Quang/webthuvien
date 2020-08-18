/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bean;

public class TheLoai {
	private String MaTheLoai;
	private String TenTheLoai;
	private String Maloai;
	public String getMaTheLoai() {
		return MaTheLoai;
	}
	public void setMaTheLoai(String maTheLoai) {
		MaTheLoai = maTheLoai;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	public String getMaloai() {
		return Maloai;
	}
	public void setMaloai(String maloai) {
		Maloai = maloai;
	}
	public TheLoai(String maTheLoai, String tenTheLoai, String maloai) {
		super();
		MaTheLoai = maTheLoai;
		TenTheLoai = tenTheLoai;
		Maloai = maloai;
	}
	public TheLoai() {
		super();
	}
	

}
