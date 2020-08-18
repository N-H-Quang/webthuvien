/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.TheLoai;

public class TheLoaiMapper implements RowMapper<TheLoai>{

	@Override
	public TheLoai Maprow(ResultSet rs) {
		TheLoai theLoai=new TheLoai();
		try {
			theLoai.setMaTheLoai(rs.getString("MaTheLoai"));
			theLoai.setTenTheLoai(rs.getString("TenTheLoai"));
			theLoai.setMaloai(rs.getString("MaLoai"));
			return theLoai;
		} catch (SQLException e) {
			return null;
		}
				
	}

}
