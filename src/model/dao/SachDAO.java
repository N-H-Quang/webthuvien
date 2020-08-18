/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package model.dao;

import java.util.List;

import common.AbstractDAO;
import common.SachMapper;
import common.TheLoaiMapper;
import model.bean.Loai;
import model.bean.Sach;
import model.bean.TheLoai;

public class SachDAO {

	public List<Sach> getList() {
		AbstractDAO<Sach> abstractDAO = new AbstractDAO<Sach>();
		return abstractDAO.query(
				"select Sach.*,TheLoai.TenTheLoai,ThuVien.SoHienCon,ThuVien.SoLanMuon from Sach join TheLoai on TheLoai.MaTheLoai=Sach.MaTheLoai join ThuVien on ThuVien.MaSach=Sach.MaSach",
				new SachMapper());
	}

	public boolean insert(Sach sach) {
		AbstractDAO<Sach> abstractDAO = new AbstractDAO<Sach>();
		if (abstractDAO.checkdublicade("select MaSach from Sach where MaSach=", sach.getMaSach()) == false) {
			abstractDAO.insert(
					"INSERT INTO Sach(MaSach,TenSach,MaTheLoai,NamXuatBan,NhaXuatBan,TacGia,AnhSach) VALUES(?,?,?,?,?,?,?)",
					sach.getMaSach(), sach.getTenSach(), sach.getMaTheLoai(), sach.getNamXuatban(),
					sach.getNhaXuatBan(), sach.getTacGia(), sach.getAnhSach());
			abstractDAO.insert("INSERT INTO ThuVien(MaSach,SoHienCon,SoLanMuon,SoLuong) VALUES(?,?,?,?)", sach.getMaSach(),sach.getSoHienCon(),sach.getSoLanMuon(),sach.getSoluong());
			return true;
		}
		else
		{
			return false;
		}
	}

	public Sach findorfail(String string) {
		AbstractDAO<Sach> abstractDAO = new AbstractDAO<Sach>();
		List<Sach> list=abstractDAO.query("select Sach.*,TheLoai.TenTheLoai,ThuVien.SoHienCon,ThuVien.SoLanMuon from Sach join TheLoai on TheLoai.MaTheLoai=Sach.MaTheLoai join ThuVien on ThuVien.MaSach=Sach.MaSach where Sach.MaSach= '"+string+"'",new SachMapper());
		if(list.size()!=0)
		{
		return list.get(0);	
		}
		else
		{
			return null;
		}
	}

	public boolean update(Sach sach) {
		AbstractDAO<Sach> abstractDAO=new AbstractDAO<Sach>();
		abstractDAO.update("update Sach set MaTheLoai=?,NamXuatBan=?,NhaXuatBan=?,TacGia=?,TenSach=?,AnhSach=? where MaSach= ?",sach.getMaTheLoai(),sach.getNamXuatban(),sach.getNhaXuatBan(),sach.getTacGia(),sach.getTenSach(),sach.getAnhSach(),sach.getMaSach());
		abstractDAO.update("update ThuVien set SoHienCon=?,SoLanMuon=?,SoLuong=? where MaSach= ?", sach.getSoHienCon(),sach.getSoLanMuon(),sach.getSoluong(),sach.getMaSach());
		return true;
	}

	public boolean delete(String id) {
		AbstractDAO<Sach> abstractDAO=new AbstractDAO<Sach>();
		abstractDAO.update("delete from ThuVien where MaSach=?", id);
		abstractDAO.update("delete from Sach where MaSach=?", id);
		return true;
	}

}
