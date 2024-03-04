package pkg09_bind;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataBind3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	   // ServletContext에 데이터 저장하기
     request.setAttribute("c", "일반데이터");
     
	  
    // 데이터 확인 페이지로 이동하기
    //response.sendRedirect("/servlet/dataConfirm");  // 하나의 요청만 있어서 보내고 사라짐.
    // redirect는 응답형 - 클라이언트에게 응답할 장소를 알려주고 다시 돌아옴. 두 번의 요청이 있음. 
    request.getRequestDispatcher("/dataConfirm").forward(request, response);
    // 저장장소는 request, 이동장소는 response
    // request와 session 위주로 공부
    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
