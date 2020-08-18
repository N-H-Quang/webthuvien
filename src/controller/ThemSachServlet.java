package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Sach;
import model.bean.TheLoai;
import model.bo.SachBO;
import model.bo.TheLoaiBO;

@WebServlet("/ThemSachServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 100)
/**
 * Servlet implementation class ThemLoaiController
 */

public class ThemSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "img";

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if ("submit".equals(request.getParameter("submit"))) {
			String maSach = request.getParameter("masach");
			String tenSach = request.getParameter("tensach");
			String theLoai = request.getParameter("theloai");
			String tacGia = request.getParameter("tacgia");
			String nxb = request.getParameter("nxb");
			String namXB = request.getParameter("namxb");
			String hienCon = request.getParameter("hiencon");
			String sL = request.getParameter("sl");
			String fileName = "";
			fileName = uploadFile(request);
			Sach sach = new Sach(maSach, tenSach, theLoai, tacGia, nxb, Integer.valueOf(namXB), fileName, theLoai,
					Integer.valueOf(hienCon), Integer.valueOf(sL), 0);
			if (new SachBO().insert(sach)) {
				request.setAttribute("message", "Them moi thanh cong");
				response.sendRedirect("DanhSachSachservlet");
			} else {
				request.setAttribute("message", "Them moi that bai");
				response.sendRedirect("DanhSachSachservlet");
			}
		} else {
			List<TheLoai> list = new ArrayList<TheLoai>();
			list = new TheLoaiBO().getList();
			request.setAttribute("listtheloai", list);
			RequestDispatcher rd = request.getRequestDispatcher("resources/admin/Sach/themsach.jsp");
			rd.forward(request, response);
		}

	}

	private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
		String fileName = "";
		try {
			Part filePart = request.getPart("photo");
			fileName = (String) getFileName(filePart);
			String applicationPath = request.getServletContext().getRealPath("");
//	            String basePath = "C:/Users/nguyen quang/eclipse-workspace/Mockjsp/WebContent/resources" + File.separator + UPLOAD_DIR + File.separator;
			String basePath = "C:/Users/nguyen quang/eclipse-workspace/webthuvien/WebContent/resources/" + UPLOAD_DIR+ File.separator;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				File outputFilePath = new File(basePath + fileName);
				inputStream = filePart.getInputStream();
				outputStream = new FileOutputStream(outputFilePath);
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (Exception e) {
				e.printStackTrace();
				fileName = "";
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}

		} catch (Exception e) {
			fileName = "";
		}
		return fileName;
	}

	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("*****partHeader :" + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		return null;
	}
}
