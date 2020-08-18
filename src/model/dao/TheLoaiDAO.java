/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.dao;

import java.util.List;

import common.AbstractDAO;
import common.TheLoaiMapper;
import model.bean.Loai;
import model.bean.NhanVien;
import model.bean.TheLoai;

public class TheLoaiDAO {

	public List<TheLoai> getList() {
		AbstractDAO<TheLoai> abstractDAO=new AbstractDAO<TheLoai>();
		return abstractDAO.query("select *from TheLoai", new TheLoaiMapper());
	}

	public List<TheLoai> getsearchlist(String search) {
		AbstractDAO<TheLoai> abstractDAO=new AbstractDAO<TheLoai>();
		return abstractDAO.query("select *from TheLoai where (TenTheLoai like N'%"+search+"%')", new TheLoaiMapper());
	}

	public boolean insert(TheLoai loai) {
		AbstractDAO<TheLoai> abstractDAO = new AbstractDAO<TheLoai>();
		if(abstractDAO.checkdublicade("select MaTheLoai from TheLoai where MaTheLoai=",loai.getMaTheLoai())==false)
		{
			abstractDAO.insert("INSERT INTO TheLoai(MaTheLoai, MaLoai, TenTheLoai)VALUES (?,?,?)", loai.getMaTheLoai(),loai.getMaloai(),loai.getTenTheLoai());
		return true;
		}
		else
		{
			return false;
		}
	}

	public TheLoai findorfail(String id) {
		AbstractDAO<TheLoai> abstractDAO = new AbstractDAO<TheLoai>();
		List<TheLoai> list=abstractDAO.query("select * from TheLoai where MaTheLoai= '"+id+"'",new TheLoaiMapper());
		if(list.size()!=0)
		{
		return list.get(0);	
		}
		else
		{
			return null;
		}
		
	}

	public boolean update(TheLoai theLoai) {
		AbstractDAO<TheLoai> abstractDAO=new AbstractDAO<TheLoai>();
		abstractDAO.update("UPDATE TheLoai SET MaLoai = ?,MaTheLoai=?,TenTheLoai=? WHERE MaTheLoai='"+theLoai.getMaTheLoai()+"'", theLoai.getMaloai(),theLoai.getMaTheLoai(),theLoai.getTenTheLoai());
		return true;
	}

	public boolean delete(String id) {
		AbstractDAO<TheLoai> abstractDAO=new AbstractDAO<TheLoai>();
		abstractDAO.update("delete from TheLoai where MaTheLoai='"+id+"'");
		return true;
	}

}
