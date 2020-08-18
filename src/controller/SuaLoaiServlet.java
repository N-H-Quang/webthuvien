package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Loai;
import model.bo.LoaiBo;

/**
 * Servlet implementation class SuaLoaiServlet
 */
@WebServlet("/SuaLoaiServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

public class SuaLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String  UPLOAD_DIR = "img";

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
		if("submit".equals(request.getParameter("submit"))){
		String maHD = request.getParameter("maloai");
		String tenloai = request.getParameter("tenloai");
		String fileName = "";
		fileName= uploadFile(request);
		Loai loai = new Loai(maHD, tenloai, fileName);
		if (new LoaiBo().update(loai) == true) {
			request.setAttribute("message", "Sửa thành công");
			request.getRequestDispatcher("resources/admin/Loai/TheLoai.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Sửa thất bại");
			request.getRequestDispatcher("resources/admin/Loai/TheLoai.jsp").forward(request, response);
		}
		}
		else
		{
			String maupdate=request.getParameter("maupdate");
			Loai loai=new LoaiBo().findorfail(maupdate);
			request.setAttribute("Loai", loai);
			request.getRequestDispatcher("resources/admin/Loai/sualoai.jsp").forward(request, response);
		}

	}
	 private String uploadFile(HttpServletRequest request) throws IOException, ServletException{
	        String fileName="";
	        try{
	            Part filePart = request.getPart("photo");
	            fileName = (String) getFileName(filePart);
	            String applicationPath = request.getServletContext().getRealPath("");
//	            String basePath = "C:/Users/nguyen quang/eclipse-workspace/Mockjsp/WebContent/resources" + File.separator + UPLOAD_DIR + File.separator;
	            String basePath="C:/Users/nguyen quang/eclipse-workspace/webthuvien/WebContent/resources/"+UPLOAD_DIR+File.separator;
	            InputStream inputStream = null;
	            OutputStream outputStream = null;
	            try {
	                File outputFilePath = new  File(basePath + fileName);
	                inputStream = filePart.getInputStream();
	                outputStream = new FileOutputStream(outputFilePath);
	                int read = 0;
	                final byte[] bytes =  new  byte[1024];
	                while((read = inputStream.read(bytes)) != -1){
	                    outputStream.write(bytes, 0, read);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                fileName = "";
	            }finally{
	                if(inputStream != null){
	                    inputStream.close();
	                }
	                if(outputStream != null){
	                    outputStream.close();
	                }
	            }
	            
	        }catch(Exception e){
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
