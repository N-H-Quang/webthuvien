/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.dao;

import java.util.List;

import common.AbstractDAO;
import common.PhieuMuonMapper;
import model.bean.PhieuMuon;

public class PhieuMuonDAO {

	public List<PhieuMuon> getList() {
		AbstractDAO<PhieuMuon> abstractDAO=new AbstractDAO<PhieuMuon>();
		return abstractDAO.query("select PhieuMuon.*,BanDoc.HoTen,Sach.TenSach from PhieuMuon join Sach on Sach.MaSach=PhieuMuon.MaSach join BanDoc on BanDoc.MaBD=PhieuMuon.MaBD", new PhieuMuonMapper());
	}

	public boolean delete(String id) {
		AbstractDAO<PhieuMuon> abstractDAO=new AbstractDAO<PhieuMuon>();
		abstractDAO.update("delete from PhieuMuon where MaPM = ? ", id);
		return true;
	}

	public boolean updateTT(String id, String maNV) {
		AbstractDAO<PhieuMuon> abstractDAO=new AbstractDAO<PhieuMuon>();
		if(abstractDAO.checkdublicade("select * from PhieuMuon where (MaPM=?)and(TinhTrang=N'chưa xử lý')", id)==false)
		{
			return false;
		}else
		{
			
			abstractDAO.update("update PhieuMuon set TinhTrang=N'đã xử lý',MaNV=? where MaPM=?",maNV ,id);
			return true;
		}
	}

}
