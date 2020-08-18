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

import model.bean.Loai;
import model.bean.TheLoai;
import model.bo.LoaiBo;
import model.bo.TheLoaiBO;

/**
 * Servlet implementation class ThemTheLoai
 */
@WebServlet("/ThemTheLoai")
public class ThemTheLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemTheLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Loai>list=new ArrayList<Loai>();
		if("submit".equals(request.getParameter("submit"))){
			request.setCharacterEncoding("UTF-8");
			String maTheLoai=request.getParameter("matl");
			String maLoai=request.getParameter("mal");
			String tenTheLoai=request.getParameter("tentl");
			TheLoai loai=new TheLoai(maTheLoai, tenTheLoai, maLoai);
			if(new TheLoaiBO().insert(loai))
			{
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("trangthai", "thêm mới thành công");
				
			}
			else {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("trangthai", "thêm mới thất bại");
			
			}
			response.sendRedirect("DanhSachTheLoai");
		}
		else
		{
		list=new LoaiBo().getlist();
		request.setAttribute("listloai", list);
		RequestDispatcher rd = request.getRequestDispatcher("resources/admin/TheLoai/themtheloai.jsp");
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
