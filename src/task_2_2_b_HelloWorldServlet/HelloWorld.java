package task_2_2_b_HelloWorldServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "Hello World",
        description = "a small hello world test servlet …",
        urlPatterns = {"/helloworld"}
)
public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");
        PrintWriter out = _response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>HELLO WORLD!</H1>");
        out.println("</BODY></HEAD></HTML>");
        out.close();
    }
}
