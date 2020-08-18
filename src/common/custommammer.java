/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class custommammer  implements RowMapper<Map<String, String>>{

	@Override
	public Map<String, String> Maprow(ResultSet rs) {
		Map<String,String> result=new  HashMap();
		try {
			result.put("MaKH",rs.getString("MaKH"));
			result.put("TenKH",rs.getString("TenKH"));
			result.put("DiaChi", "DiaChi");
			result.put("SoDIenThoai", rs.getString("SoDienThoai"));
			result.put("DiaChiEmail", rs.getString("DiaChiEmail"));
			result.put("MaDV", rs.getString("MaDV"));
			result.put("NgaySudung", rs.getString("NgaySudung"));
			result.put("GioSuDung", rs.getString("GioSuDung"));
			result.put("soluong", rs.getString("soluong"));
			result.put("MaMay", rs.getString("MaMay"));
			result.put("GioBatDau", rs.getString("GioBatDau"));
			result.put("ThoiGianSuDung", rs.getString("ThoiGianSuDung"));
			result.put("DonGia", rs.getString("DonGia"));
		}
		catch(Exception e)
		{
			return null;
		}
		return result;
	}

}
