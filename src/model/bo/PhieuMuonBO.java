/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bo;

import java.util.List;

import model.bean.PhieuMuon;
import model.dao.BanDocDao;
import model.dao.PhieuMuonDAO;

public class PhieuMuonBO {

	public List<PhieuMuon> getlist() {
		// TODO Auto-generated method stub
		return new PhieuMuonDAO().getList();
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return new PhieuMuonDAO().delete(id);
	}

	public boolean updateTT(String id, String maNV) {
		return new PhieuMuonDAO().updateTT(id,maNV);
	}

}
