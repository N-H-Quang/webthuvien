/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Sach;

public class SachMapper implements RowMapper<Sach>{

	@Override
	public Sach Maprow(ResultSet rs) {
		Sach sach=new Sach();
		try {
			sach.setMaSach(rs.getString("MaSach"));
			sach.setTenSach(rs.getString("TenSach"));
			sach.setMaTheLoai(rs.getString("MaTheLoai"));
			sach.setTacGia(rs.getString("TacGia"));
			sach.setNhaXuatBan(rs.getString("NhaXuatBan"));
			sach.setNamXuatban(Integer.valueOf(rs.getString("NamXuatBan")));
			sach.setAnhSach(rs.getString("AnhSach"));
			sach.setTheLoai(rs.getString("TenTheLoai"));
			sach.setSoHienCon(Integer.valueOf(rs.getString("SoHienCon")));
			sach.setSoLanMuon(Integer.valueOf(rs.getString("SoLanMuon")));
			return sach;
		} catch (SQLException e) {
			return null;
		}
	}

}
