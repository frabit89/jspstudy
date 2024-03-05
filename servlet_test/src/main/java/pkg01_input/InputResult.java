package pkg01_input;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class InputResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  String id = request.getParameter("id");
	  String pwd = request.getParameter("pwd");
	  String pwd_chk = request.getParameter("pwd-chk");
	  String name = request.getParameter("name");
	  String[] birth = request.getParameterValues("birth");
	  String[] gender = request.getParameterValues("gender");
	  String email = request.getParameter("email");
	  String[] mobile = request.getParameterValues("mobile");
	  
	  out.println("<!DOCTYPE html>");
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<meta charset=\"UTF-8\">");
	  out.println("<title>회원 정보</title>");
	  out.println("</head>");
	  out.println("<body>");
	  out.println("<ul>");
	  out.println("<li>아이디 : " + id + "</li>");
	  out.println("<li>비밀번호 : " + pwd + "</li>");
	  out.println("<li>이름 : " + name + "</li>");
	  out.println("<li>생년월일 : " + Arrays.toString(birth) + "</li>");
	  out.println("<li>성별 : " + Arrays.toString(gender) + "</li>");
	  out.println("<li>이메일 : " + email + "</li>");
	  out.println("<li>휴대전화 : " + Arrays.toString(mobile) + "</li>");
	  out.println("</ul>");
	  out.println("</body>");
	  out.println("</html>");
	    
	}

}
