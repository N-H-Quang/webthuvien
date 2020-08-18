/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bo;

import java.util.List;

import model.bean.Loai;
import model.dao.LoaiDao;


public class LoaiBo {

	public boolean insert(Loai loai) {
		return new  LoaiDao().insert( loai);
	}

	public List<Loai> getlist() {
		return new LoaiDao().getlist();
	}


	public Loai findorfail(String maupdate) {
		// TODO Auto-generated method stub
		return new LoaiDao().findorfail(maupdate);
	}

	public boolean update(Loai loai) {
		// TODO Auto-generated method stub
		return new LoaiDao().update(loai);
	}

	public boolean delete(String maupdate) {
		return new LoaiDao().delete(maupdate);
	}

}
