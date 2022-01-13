package task_2_2_c_InfoServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(
        name = "Info Servlet",
        urlPatterns = {"/infoservlet"}
)

/**
 * Servlet which shows different client & server data
 * dispalyed data:
 * Client: IP-Address, Browser Type, MIME-Type, Protocol
 * Server: Port, name
 */
public class InfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        PrintWriter out = _response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Info Servlet</TITLE></HEAD>");
        out.println("<BODY>");


        // Client Info
        out.println("<H1>Client</H1>");
        out.println("<p>IP-Address: " + _request.getRemoteAddr() + "</p>");
        out.println("<p>Browser Type: " + _request.getHeader("User-Agent") + "</p>");
        out.println("<p>MIME-Type: " + _request.getContentType() + "</p>");
        out.println("<p>Protocol: " + _request.getScheme() + "</p>");

        // Server Info
        out.println("<H1>Server</H1>");
        out.println("<p>Port: " + _request.getServerPort() + "</p>");
        out.println("<p>Name: " + _request.getServerName() + "</p>");

        out.println("</BODY></HEAD></HTML>");

        out.close();
    }
}

