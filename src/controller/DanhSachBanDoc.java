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

import model.bean.BanDoc;
import model.bo.BanDocBO;

/**
 * Servlet implementation class DanhSachBanDoc
 */
@WebServlet("/DanhSachBanDoc")
public class DanhSachBanDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachBanDoc() {
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
		List<BanDoc> banDocs=new ArrayList<BanDoc>();
		String search = request.getParameter("search");
		if(search==null)
		{
			banDocs= new BanDocBO().getList();
		}
		else
		{
			banDocs=new BanDocBO().getList(search);
		}
		request.setAttribute("listbandoc", banDocs);
		RequestDispatcher rd = request.getRequestDispatcher("resources/admin/BanDoc/danhsachbandoc.jsp");
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
