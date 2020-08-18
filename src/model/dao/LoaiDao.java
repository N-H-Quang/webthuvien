/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.dao;

import java.util.ArrayList;
import java.util.List;

import common.AbstractDAO;
import common.LoaiMapper;
import model.bean.Loai;
import model.bean.NhanVien;

public class LoaiDao {

	public boolean insert(Loai loai) {
		AbstractDAO<Loai> abstractDAO=new AbstractDAO<Loai>();
		if(abstractDAO.checkdublicade("select MaLoai from Loai where MaLoai = '"+loai.getMaLoai()+"'")==false)
		{
			abstractDAO.insert("INSERT INTO Loai(MaLoai,TenLoai,AnhLoai) VALUES(?,?,?)",loai.getMaLoai(),loai.getTenloai(),loai.getAnh());
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<Loai> getlist() {
		AbstractDAO<Loai> abstractDAO=new AbstractDAO<Loai>();
		return abstractDAO.query("select * from Loai", new LoaiMapper());
	}
	public Loai findorfail(String maupdate) {
		AbstractDAO<Loai> abstractDAO=new AbstractDAO<Loai>();
		List<Loai> list=new ArrayList<Loai>();
		list=abstractDAO.query("select * from Loai where MaLoai='"+maupdate+"'", new  LoaiMapper());
		return list.get(0);
	}

	public boolean update(Loai loai) {
		AbstractDAO<Loai> abstractDAO = new AbstractDAO<Loai>();
		abstractDAO.update("UPDATE Loai SET MaLoai = ?,TenLoai=?,AnhLoai=? WHERE MaLoai=?;",loai.getMaLoai(),loai.getTenloai(),loai.getAnh(),loai.getMaLoai());
		return true;
	}

	public boolean delete(String maupdate) {
		AbstractDAO<Loai> abstractDAO=new AbstractDAO<Loai>();
		abstractDAO.update("delete from Loai where MaLoai='"+maupdate+"'");
		return true;
		
	}

}
