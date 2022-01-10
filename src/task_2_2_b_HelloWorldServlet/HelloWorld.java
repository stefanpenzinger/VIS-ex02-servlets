package task_2_2_b_HelloWorldServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet(
        name = "Hello World",
        urlPatterns = {"/helloworld"}
)
public class HelloWorld extends HttpServlet {
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
