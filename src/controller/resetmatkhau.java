package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import model.bean.BanDoc;
import model.bo.BanDocBO;

/**
 * Servlet implementation class resetmatkhau
 */
@WebServlet("/resetmatkhau")
public class resetmatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public resetmatkhau() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if ("submit".equals(request.getParameter("submit"))) {
			String id = request.getParameter("id");
			String mk1 = request.getParameter("mk1");
			String mk2 = request.getParameter("mk2");
			System.out.println(mk1);
			if (mk1.compareTo(mk2) == 0) {
				if (new BanDocBO().doiMatKhau(id, mk1) == true) {
					request.setAttribute("message", "sua mat khau thanh cong");
					RequestDispatcher rd = request.getRequestDispatcher("resources/QuenMatKhau/resetmatkhau.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "Sua mat khau that bai");
					RequestDispatcher rd = request.getRequestDispatcher("resources/QuenMatKhau/resetmatkhau.jsp");
					rd.forward(request, response);
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("resources/QuenMatKhau/resetmatkhau.jsp");
				rd.forward(request, response);
			}
		} else {
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("resources/QuenMatKhau/resetmatkhau.jsp");
			rd.forward(request, response);
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
