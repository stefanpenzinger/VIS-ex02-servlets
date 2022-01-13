package task_2_2_e_EnvironmentServiceServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import task_2_2_e_EnvironmentServiceServlet.c.Client;
import task_2_2_e_EnvironmentServiceServlet.c.EnvData;
import task_2_2_e_EnvironmentServiceServlet.rmi.IEnvService;

import java.io.IOException;
import java.io.PrintWriter;;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



@WebServlet(
        name = "EnvironmentServiceServlet Servlet",
        urlPatterns = {"/enviromentserviceservlet"}
)

/**
 * Servlet which displays the sensor data from the C++ Server (EX01)
 * and the RMI Server (EX02.1)
 */
public class EnvironmentServiceServlet extends HttpServlet {

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        try {
            String addr = "IEnvService";
            Registry reg = null;

            reg = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);

            // start SecurityManager to be on the save side
            //System.setSecurityManager (new RMISecurityManager());

            IEnvService service = (IEnvService) reg.lookup(addr);
            task_2_2_e_EnvironmentServiceServlet.rmi.EnvData data = service.requestEnvironmentData("air");

            Client client = new Client(4949, "127.0.0.1");
            EnvData[] sensors = client.requestAll();

            PrintWriter out = _response.getWriter();
            String color = _request.getParameter("color");
            String text = _request.getParameter("text");

            out.println("<HTML>");
            out.println("<HEAD><TITLE>Session Servlet</TITLE></HEAD>");
            out.println("<BODY>");

            // RMI Server
            out.println("<h1>RMI Server</h1>");
            out.println("<p>"+ data.toString() + "</p>");

            // C++ Server
            out.println("<h1>C++ Server </h1>");

            if (sensors != null) {
                out.println("<table border='1'><tr><th>Timestamp</th><th>Sensortype</th><th>Value</th></tr>");
                for (EnvData sensor : sensors) {
                    out.println("<tr>");
                    out.println("<td> " + sensor.getmTimestamp() + "</td>");
                    out.println("<td> " + sensor.getmType() + "</td>");
                    out.println("<td> " + sensor.getmData() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("<p>C++ Server is offline!</p>");
            }


            out.println("<meta http-equiv=\"refresh\" content=\"5\"/>");
            out.println("</BODY></HEAD></HTML>");

            out.close();

        }catch (Exception e){
            PrintWriter out = _response.getWriter();
            out.println("<html><body><h1>Error (" + e.toString() + ")</h1></body></html>");
            e.printStackTrace();
        }
    }
}



