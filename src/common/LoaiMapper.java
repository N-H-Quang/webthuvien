/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Loai;

public class LoaiMapper implements RowMapper<Loai>{

	@Override
	public Loai Maprow(ResultSet rs) {
		Loai loai=new Loai();
		try {
			loai.setMaLoai(rs.getString("MaLoai"));
			loai.setTenloai(rs.getString("TenLoai"));
			loai.setAnh(rs.getString("AnhLoai"));
			return loai;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
