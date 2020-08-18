/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.bo;

import java.util.List;

import model.bean.BanDoc;
import model.dao.BanDocDao;

public class BanDocBO {

	public List<BanDoc> getList() {
		return new  BanDocDao().getList();
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return new BanDocDao().delete(id);
	}

	public List<BanDoc> getList(String search) {
		// TODO Auto-generated method stub
		return new  BanDocDao().getList(search);
	}

	public BanDoc findorfail(String email) {
		// TODO Auto-generated method stub
		return new  BanDocDao().findorfail(email);
	}

	public boolean doiMatKhau(String id, String mk1) {
		return new BanDocDao().doiMatKhau(id,mk1);
	}

}
