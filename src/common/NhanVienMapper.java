/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import model.bean.NhanVien;

public class NhanVienMapper implements common.RowMapper<NhanVien> {

	@Override
	public NhanVien Maprow(ResultSet rs) {
		NhanVien nhanVien=new NhanVien();
		try {
			nhanVien.setMaNV(rs.getString("MaNV"));
			nhanVien.setTenNV(rs.getString("TenNV"));
			nhanVien.setTuoi(Integer.valueOf(rs.getString("Tuoi")));
			nhanVien.setGioiTinh(rs.getString("GioiTinh"));
			nhanVien.setSDT(rs.getString("SDT"));
			nhanVien.setChucVu(rs.getString("ChucVu"));
			nhanVien.setLuong(rs.getString("Luong"));
			nhanVien.setTenDN(rs.getString("TenDN"));
			nhanVien.setMatKhau(rs.getString("MatKhau"));
			return nhanVien;
		} catch (SQLException e) {
			return null;
		}
	}

}
