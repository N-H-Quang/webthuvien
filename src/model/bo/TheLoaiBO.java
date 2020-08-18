/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bo;

import java.util.List;

import model.bean.TheLoai;
import model.dao.TheLoaiDAO;

public class TheLoaiBO {

	public List<TheLoai> getList() {
		return new TheLoaiDAO().getList();
	}

	public List<TheLoai> getsearchlist(String search) {
		// TODO Auto-generated method stub
		return new TheLoaiDAO().getsearchlist(search);
	}

	public boolean insert(TheLoai loai) {
		return new TheLoaiDAO().insert(loai);
	}

	public TheLoai findorfail(String id) {
		return new TheLoaiDAO().findorfail(id);
	}

	public boolean update(TheLoai theLoai) {
		// TODO Auto-generated method stub
		return new TheLoaiDAO().update(theLoai);
	}

	public boolean delete(String id) {
		return new TheLoaiDAO().delete(id);
	}


	

}
