package script_example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet(
        name = "Example",
        urlPatterns = {"/example"}
)

/**
 * Servlet Example from the script (used for testing)
 * gets 2 numbers as get Parameter and adds them together
 */
public class Example extends HttpServlet {
    protected void doGet(HttpServletRequest _request,
                         HttpServletResponse _response)
            throws ServletException, IOException
    {
        int x = Integer.parseInt(_request.getParameter("x"));
        int y = Integer.parseInt(_request.getParameter("y"));

        _response.setContentType("text/html");
        PrintWriter out = _response.getWriter();
        out.println("<html>");
        out.println(" <head><title>Addition</title></head>");
        out.println(" <body>");
        out.println("Berechne: " + x + " + " + y + " = " + (x + y));
        out.println(" </body>");
        out.println("</html>");
    }
}
