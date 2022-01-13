package task_2_2_d_SessionServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Random;

@WebServlet(
        name = "Session Servlet",
        urlPatterns = {"/sessionservlet"}
)

/**
 *  Servlet which uses HTTP Sessions to remember a text from the user
 *  The user can type a text and choose a background color in the index.html file
 *  and with a click on the submit button this servlet is called and the data are passed via
 *  get Parameter.
 */
public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        PrintWriter out = _response.getWriter();
        HttpSession httpSession = _request.getSession();

        String color = _request.getParameter("color");
        String text = _request.getParameter("text");

        String userAgent = _request.getHeader("User-Agent");
        String browser = "unknown";
        if (userAgent.contains("Chrome")) {
            browser = "Google Chrome or Chrome like browser";
        }
        else if (userAgent.contains("Firefox")) {
            browser = "Mozilla Firefox";
        }

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Session Servlet</TITLE></HEAD>");
        out.println("<BODY style=\"background-color: " + color + ";\">");

        out.println("<h2>" + text + "</h2>");

        String lastText = (String) httpSession.getAttribute("text");
        if (lastText != null) {
            out.println("<p>last Text: " + lastText + "</p>");
        }
        else {
            out.println("<p>You have not visited this site before</p>");
        }

        int magicNumber = new Random().nextInt(100 - 1);
        out.println("<p>You are using " + browser + " and your magic number is " + magicNumber + "</p>");
        Integer lastMagicNumber = (Integer) httpSession.getAttribute("magicNumber");

        if (lastMagicNumber != null) {
            out.println("<p>Last time your magic number was " + lastMagicNumber + "</p>");
        }
        else {
            out.println("<p>You have not visited this site before</p>");
        }

        out.println("<p>" + userAgent + "</p>");

        httpSession.setAttribute("text", text);
        httpSession.setAttribute("magicNumber", magicNumber);

        out.println("</BODY></HEAD></HTML>");

        out.close();
    }
}