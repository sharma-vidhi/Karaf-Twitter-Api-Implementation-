package twitter;
/*
 @VidhiSharma
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Karaf Servlet Implemantation class
@WebServlet("/karaf")
public class karaf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //HttpServlet
    public karaf() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	 // HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at the path: ").append(request.getContextPath());
	}

	
	 // HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
