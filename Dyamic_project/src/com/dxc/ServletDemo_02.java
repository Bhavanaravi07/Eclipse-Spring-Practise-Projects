package com.dxc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo_02
 */
public class ServletDemo_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>home</title>");
		out.println("</head>");
		out.println("<h2>Welcome to Servlet World!!!</h2>");
		out.println("<h3>Learning servlet is fun </h3>");
		for(int c=0;c<10;c++) {
			if(c%2==0) {
				out.println("<font color=\"green\">"+c+"</font><br>");
			}
			else {
				out.println("<font color=\"red\">"+c+"</font><br>");
				
			}
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
