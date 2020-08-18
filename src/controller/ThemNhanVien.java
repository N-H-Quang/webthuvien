package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class ThemNhanVien
 */
@WebServlet("/ThemNhanVien")
public class ThemNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if("submit".equals(request.getParameter("submit"))){		//nhan nut Xac nhan o trang Them sinh vien
			
			NhanVien nhanVien=new NhanVien();
			String maNV=request.getParameter("manv");
			String tenNV=request.getParameter("tennv");
			String tuoi=request.getParameter("tuoi");
			String gioiTinh=request.getParameter("gioitinh");
			String sDT=request.getParameter("sdt");
			String luong=request.getParameter("luong");
			String chucVu=request.getParameter("ChucVu");
			String tenDN=request.getParameter("TenDN");
			String matKhau=request.getParameter("MatKhau");
			nhanVien=new NhanVien(maNV, tenNV, Integer.valueOf(tuoi), gioiTinh, sDT, chucVu, luong, tenDN, matKhau);
			if(new NhanVienBO().insert(nhanVien)==true)
			{
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("trangthai", "thêm mới thành công");
				
			}
			else {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("trangthai", "thêm mới thất bại");
			
			}
			RequestDispatcher rd = request.getRequestDispatcher("resources/admin/nv/themnhanvien.jsp");
			rd.forward(request, response);
		} else {													//chuyen sang trang Them sinh vien
			RequestDispatcher rd = request.getRequestDispatcher("resources/admin/nv/themnhanvien.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
