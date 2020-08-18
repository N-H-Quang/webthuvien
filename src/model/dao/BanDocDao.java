/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.dao;

import java.util.List;

import common.AbstractDAO;
import common.BanDocMapper;
import common.NhanVienMapper;
import model.bean.BanDoc;
import model.bean.NhanVien;

public class BanDocDao {

	public List<BanDoc> getList() {
		AbstractDAO<BanDoc> abstractDAO=new AbstractDAO<BanDoc>();
		return abstractDAO.query("select * from BanDoc", new BanDocMapper());
	}

	public boolean delete(String id) {
		AbstractDAO<BanDoc> abstractDAO=new AbstractDAO<BanDoc>();
		abstractDAO.update("delete  from BanDoc where MaBD= ?",id);
		return true;
	}

	public List<BanDoc> getList(String search) {
		// TODO Auto-generated method stub
		AbstractDAO<BanDoc> abstractDAO=new AbstractDAO<BanDoc>();
		return abstractDAO.query("select *  from BanDoc where HoTen like '%"+search+"%'", new BanDocMapper());
	}

	public BanDoc findorfail(String email) {
		AbstractDAO<BanDoc> abstractDAO = new AbstractDAO<BanDoc>();
		List<BanDoc>list=abstractDAO.query("select * from BanDoc where Email = ?",
				new BanDocMapper(),email);
		if (list!=null) {
			
			return list.get(0);

		}
		else
		{
			return null;
		}
	}

	public boolean doiMatKhau(String id, String mk1) {
		AbstractDAO<BanDoc> abstractDAO = new AbstractDAO<BanDoc>();
		abstractDAO.update("UPDATE BanDoc SET MatKhau = '"+mk1+"' WHERE MaBD= '"+id+"'");
		return true;
	}

}
