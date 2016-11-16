package logon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html);charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			String name = request.getParameter("user");
			String password = request.getParameter("pass");
			
			if((password.equals("user"))&&(name.equals("pass"))){
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}
			else{
				out.println(" <font color = 'red'> <b> Wrong username or password!Please try again </b> </font> ");
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
					rd.include(request, response);
			}
		}finally{
			out.close();
		}
		
	}

}
