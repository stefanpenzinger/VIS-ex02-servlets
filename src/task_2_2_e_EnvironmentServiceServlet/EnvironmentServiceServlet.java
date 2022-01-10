package task_2_2_e_EnvironmentServiceServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "EnvironmentServiceServlet Servlet",
        urlPatterns = {"/enviromentserviceservlet"}
)
public class EnvironmentServiceServlet extends HttpServlet {

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        PrintWriter out = _response.getWriter();

        String color = _request.getParameter("color");
        String text = _request.getParameter("text");

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Session Servlet</TITLE></HEAD>");
        out.println("<BODY>");

        out.println("<meta http-equiv=\"refresh\" content=\"5\"/>");

        out.println("</BODY></HEAD></HTML>");

        out.close();
    }
}



