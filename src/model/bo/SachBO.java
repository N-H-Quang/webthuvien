/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bo;

import java.util.List;

import model.bean.Sach;
import model.dao.SachDAO;
import model.dao.TheLoaiDAO;

public class SachBO {

	public List<Sach> getList() {
		// TODO Auto-generated method stub
		return new SachDAO().getList();
	}

	public boolean insert(Sach sach) {
		return new SachDAO().insert(sach);
	}

	public Sach failorfail(String string) {
		// TODO Auto-generated method stub
		return new SachDAO().findorfail(string);
	}

	public boolean update(Sach sach) {
		// TODO Auto-generated method stub
		return new SachDAO().update(sach);
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return new SachDAO().delete(id);
	}


}
