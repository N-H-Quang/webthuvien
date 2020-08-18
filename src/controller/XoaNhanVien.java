package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class XoaNhanVien
 */
@WebServlet("/XoaNhanVien")
public class XoaNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String msNV = request.getParameter("msv");
		if(new NhanVienBO().delete(msNV))
		{
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("trangthai", "Xóa thành công");
			response.sendRedirect("DanhSachNhanVienServlet");
			
		}
		else {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("trangthai", "Xóa thất bại");
			response.sendRedirect("DanhSachNhanVienServlet");
		
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
