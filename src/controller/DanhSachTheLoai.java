package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TheLoai;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class DanhSachTheLoai
 */
@WebServlet("/DanhSachTheLoai")
public class DanhSachTheLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachTheLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tenDangNhap")==null){
			response.sendRedirect("DangNhapController");
			return;
		}
		List<TheLoai> list=new ArrayList<TheLoai>();
		String search = request.getParameter("search");
		if(search==null)
		{
		list=new TheLoaiBO().getList();
		}
		else
		{
			list=new TheLoaiBO().getsearchlist(search);
		}
		request.setAttribute("listtl", list);
		RequestDispatcher rd = request.getRequestDispatcher("resources/admin/TheLoai/danhsachtheloai.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
