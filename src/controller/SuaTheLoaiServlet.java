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
 * Servlet implementation class SuaTheLoaiServlet
 */
@WebServlet("/SuaTheLoaiServlet")
public class SuaTheLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaTheLoaiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		if (id == null) {
			response.sendRedirect("DanhSachTheLoai");
		} else {
			if ("submit".equals(request.getParameter("submit"))) {
				System.out.println("vo day");
				
				String maTheLoai = request.getParameter("matl");
				String maLoai = request.getParameter("mal");
				String tenTheLoai = request.getParameter("tentl");
				TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai, maLoai);
				if (new TheLoaiBO().update(theLoai) == true)

				{
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("trangthai", "thêm mới thành công");

				} else {
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("trangthai", "thêm mới thất bại");

				}
				response.sendRedirect("DanhSachTheLoai");

			} else {
				List<Loai> list = new ArrayList<Loai>();
				list = new LoaiBo().getlist();
				TheLoai loai = new TheLoai();
				loai = new TheLoaiBO().findorfail(id);
				request.setAttribute("listloai", list);
				request.setAttribute("theloai", loai);
				RequestDispatcher rd = request.getRequestDispatcher("resources/admin/TheLoai/suatheloai.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
