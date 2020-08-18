package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.LoaiBo;

/**
 * Servlet implementation class XoaLoaiServlet
 */
@WebServlet("/XoaLoaiServlet")
public class XoaLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaLoaiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maupdate=request.getParameter("maupdate");
		if(new LoaiBo().delete(maupdate))
		{
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("trangthai", "Xóa thành công");
		}
		else
		{
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("trangthai", "Xóa thất bại");
		}
		response.sendRedirect("DanhSachLoaiController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
