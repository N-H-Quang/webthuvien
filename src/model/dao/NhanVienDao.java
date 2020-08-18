/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.dao;

import java.util.List;

import common.AbstractDAO;
import common.NhanVienMapper;
import model.bean.NhanVien;

public class NhanVienDao {

	public List<NhanVien> getlist() {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		return abstractDAO.query("select MaNV,TenNV,Tuoi,GioiTinh,SDT,ChucVu,Luong,TenDN,MatKhau from NhanVien",
				new NhanVienMapper());
	}

	public boolean insert(NhanVien nhanVien) {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		if (abstractDAO.checkdublicade("select Manv from NhanVien where Manv = ?", nhanVien.getTenNV()) == false) {
			abstractDAO.insert(
					"INSERT INTO NhanVien(MaNV, TenNV, Tuoi,GioiTinh,SDT,Luong,ChucVu,TenDN,MatKhau)VALUES (?,?,?,?,?,?,?,?,?)",
					nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getTuoi(), nhanVien.getGioiTinh(),
					nhanVien.getSDT(), nhanVien.getLuong(), nhanVien.getChucVu(), nhanVien.getTenDN(),
					nhanVien.getMatKhau());
			return true;
		} else {
			return false;

		}
	}

	public NhanVien findorfail(String msNV) {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		List<NhanVien>list=abstractDAO.query("select * from NhanVien where MaNV = '"+msNV+"'",
				new NhanVienMapper());
		if (list!=null) {
			
			return list.get(0);

		}
		else
		{
			return null;
		}

	}

	public boolean update(NhanVien nhanVien) {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		abstractDAO.update("UPDATE NhanVien SET MaNV = ?,TenNV=?,Tuoi=?,GioiTinh=?,SDT=?,Luong=?,ChucVu=?,TenDN=?,MatKhau=? WHERE MaNV=?;",nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.getTuoi(), nhanVien.getGioiTinh(),
				nhanVien.getSDT(), nhanVien.getLuong(), nhanVien.getChucVu(), nhanVien.getTenDN(),
				nhanVien.getMatKhau(),nhanVien.getMaNV() );
		return true;
	}

	public boolean delete(String msNV) {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		abstractDAO.update("delete from NhanVien where MaNV=?", msNV);
		return true;
	}

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		return abstractDAO.checkdublicade("select * from NhanVien where (TenDN =?)and(MatKhau=?)", tenDangNhap,matKhau);
		
	}

	public String findTenDangNhap(String tenDangNhap, String matKhau) {
		AbstractDAO<NhanVien> abstractDAO = new AbstractDAO<NhanVien>();
		List<NhanVien>list=abstractDAO.query("select * from NhanVien where (TenDN=?)and(MatKhau=?)",new NhanVienMapper(),tenDangNhap,matKhau);
		if (list!=null) {
			
			return list.get(0).getMaNV();

		}
		else
		{
			return null;
		}
	}

}
