/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bo;

import java.util.List;

import model.bean.NhanVien;
import model.dao.NhanVienDao;

public class NhanVienBO {

	public List<NhanVien> getList() {
		return new  NhanVienDao().getlist();
	}

	public boolean insert(NhanVien nhanVien) {
		return new NhanVienDao().insert(nhanVien);
	}

	public NhanVien findorfail(String msNV) {
		return new NhanVienDao().findorfail(msNV);
	}

	public boolean update(NhanVien nhanVien) {
		return new NhanVienDao().update(nhanVien);
	}

	public boolean delete(String msNV) {
		// TODO Auto-generated method stub
		return new NhanVienDao().delete(msNV);
	}

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return new NhanVienDao().checkLogin(tenDangNhap, matKhau);
	}

	public String findTenDangNhap(String tenDangNhap, String matKhau) {
		// TODO Auto-generated method stub
		return new NhanVienDao().findTenDangNhap(tenDangNhap, matKhau);
	}

}
