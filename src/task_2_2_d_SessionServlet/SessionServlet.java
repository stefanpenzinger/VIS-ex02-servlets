package task_2_2_d_SessionServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Session Servlet",
        urlPatterns = {"/sessionservlet"}
)
public class SessionServlet extends HttpServlet {

    String mLastText = null;

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        PrintWriter out = _response.getWriter();

        String color = _request.getParameter("color");
        String text = _request.getParameter("text");

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Session Servlet</TITLE></HEAD>");
        out.println("<BODY style=\"background-color: " + color + ";\">");

        out.println("<h2>" + text + "</h2>");

        out.println("<p>last Text:<br/>" + mLastText + "</p>");
        mLastText = text;
        out.println("</BODY></HEAD></HTML>");

        out.close();
    }
}


