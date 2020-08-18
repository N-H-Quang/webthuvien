package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BanDoc;
import model.bo.BanDocBO;

/**
 * Servlet implementation class QuenMatKhauServlet
 */
@WebServlet("/QuenMatKhauServlet")
public class QuenMatKhauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuenMatKhauServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("submit".equals(request.getParameter("submit"))){
			String email=request.getParameter("emailInput");
			BanDoc banDoc=new BanDocBO().findorfail(email);
				String host="mail.javatpoint.com";  
			  final String user="ducy357@gmail.com";//change accordingly  
			  final String password="hpfzokjtgumyaiwr";//change accordingly  
			    System.out.println(banDoc.getEmail());
			  String to=banDoc.getEmail();//change accordingly  
			  
			   //Get the session object  
			   Properties prop = new Properties();  
			   prop.put("mail.smtp.host", "smtp.gmail.com");
		        prop.put("mail.smtp.port", "587");
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS  
			     
			   Session session = Session.getDefaultInstance(prop,  
			    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(user,password);  
			      }  
			    });  
			  
			   //Compose the message  
			    try {  
			     MimeMessage message = new MimeMessage(session);  
			     message.setFrom(new InternetAddress(user));  
			     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			     message.setSubject("Mail Quen Mat Khau");  
			     message.setText("Link lay lai may khau : http://localhost:7376/webthuvien/resetmatkhau?id="+banDoc.getMaBD());  
			       
			    //send the message  
			     Transport.send(message);  
			  
			     System.out.println("message sent successfully...");  
			   
			     } catch (MessagingException e) {e.printStackTrace();}  
			 }  
		
		else
		{
		RequestDispatcher rd = request.getRequestDispatcher("resources/QuenMatKhau/quenmatkhau.jsp");
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
