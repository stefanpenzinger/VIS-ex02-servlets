package task_2_2_b_HelloWorldServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(
        name = "Hello World",
        urlPatterns = {"/helloworld"}
)

/**
 * HelloWorld Servlets which shows just a simple text
 * and also shows a counts how often the servlet has been called.
 */
public class HelloWorld extends HttpServlet {
    /** member Variable to count how often the Servlet has been called */
    private int mCounter = 0;

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        PrintWriter out = _response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>Active Sessions: " + ++mCounter + "</H1>");
        out.println("</BODY></HEAD></HTML>");
        out.close();
    }
}
