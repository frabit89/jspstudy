package pkg02_multiple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiPlication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
  
    response.setContentType("text/html; charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    out.println("<script>");
    out.println("var expectedResult;");
    out.println("function calculate() {");
    out.println("  var userInput = document.getElementById('result').value;");
    out.println("  if (parseInt(userInput) === expectedResult) {");
    out.println("    alert('정답입니다.');");
    out.println("  } else {");
    out.println("    alert('오답입니다.');");
    out.println("  }");
    out.println("}");
    out.println("</script>");
    
    out.flush();
    out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
