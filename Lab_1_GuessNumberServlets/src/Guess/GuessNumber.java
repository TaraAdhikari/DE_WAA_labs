package Guess;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GuessNumber")
public class GuessNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GuessNumber() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html);charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("check");
		try{
			System.out.println(request.getParameter("number"));
			int number = Integer.parseInt((String) request.getParameter("number"));
			System.out.println(number);
			HttpSession session = request.getSession(true);
			int randomNumber = Integer.parseInt(session.getAttribute("rand").toString());

			if(number==randomNumber){
				out.println(" <font color = 'green'> <b> Correct, congratulations!  </b> </font> ");
			}
			else if(number < randomNumber){
				out.println(" <font color = 'red'> <b> Too low, try again</b> </font> ");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			else{
				out.println(" <font color = 'red'> <b> Too high, try again</b> </font> ");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		}finally{
			out.close();
		}
		
	}
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {
    	PrintWriter out = response.getWriter(); 
    	Random random = new Random();
    	int Low = 1;
    	int High = 10;
    	int Result = random.nextInt(High-Low) + Low;
    	
    	HttpSession session = request.getSession(true);
    	session.setAttribute("rand", Result);
    	System.out.println(Result);
    	
    	
    	out.println("<html>"
    			+ "<head>"
    			+ "<title>Guess NUmber</title>"
    			+ "</head>"
	    			+ "<body>"
	    			+ "<p>Enter Number</p>"
	    			+"<form method='POST' action='GuessNumber'>"
	    			+ "<input type='number' name='number'>"
	    			+ "<br><input type='submit' value='submit'>"
	    			+ "</form>"
	    			+ "</body>"
    			+ "</html>");
    }

}
