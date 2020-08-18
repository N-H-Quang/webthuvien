/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.BanDoc;

public class BanDocMapper implements RowMapper<BanDoc>{

	@Override
	public BanDoc Maprow(ResultSet rs) {
		BanDoc banDoc=new BanDoc();
		try {
		banDoc.setMaBD(rs.getString("MaBD"));
		banDoc.setTenBD(rs.getString("TenDN"));
		banDoc.setMatKhau(rs.getString("MatKhau"));
		banDoc.setHoTen(rs.getString("HoTen"));
		banDoc.setEmail(rs.getString("Email"));
		banDoc.setDiaChi(rs.getString("DiaChi"));
		banDoc.setSdt(rs.getString("SDT"));
		return banDoc;
		} catch (SQLException e) {
			return null;
		}
	}

}
