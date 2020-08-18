/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.PhieuMuon;

public class PhieuMuonMapper implements RowMapper<PhieuMuon> {

	@Override
	public PhieuMuon Maprow(ResultSet rs) {
		PhieuMuon muon=new PhieuMuon();
		try {
			muon.setMaPM(rs.getString("MaPM"));
			muon.setTenBD(rs.getString("HoTen"));
			muon.setTenSach(rs.getString("TenSach"));
			muon.setNgayMuon(rs.getString("NgayMuon"));
			muon.setNgayTra(rs.getString("NgayTra"));
			muon.setNgayPhaiTra(rs.getString("NgayPhaiTra"));
			muon.setTrangThai(rs.getString("TinhTrang"));
			return muon;
		} catch (SQLException e) {
			return null;
		}
	}

}
