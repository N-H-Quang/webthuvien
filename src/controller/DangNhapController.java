package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		NhanVienBO nguoiDungBO = new NhanVienBO();
		if(nguoiDungBO.checkLogin(tenDangNhap, matKhau)){
			String id=new NhanVienBO().findTenDangNhap(tenDangNhap,matKhau);
			HttpSession session = request.getSession();
			session.setAttribute("MaNV", id);
			session.setAttribute("tenDangNhap", tenDangNhap);
			response.sendRedirect("DanhSachNhanVienServlet");
		} else {
			request.setAttribute("thongBao", "Đăng nhập không thành công");
			RequestDispatcher rd = request.getRequestDispatcher("resources/login/login.jsp");
			rd.forward(request, response);
		}
	}


}
