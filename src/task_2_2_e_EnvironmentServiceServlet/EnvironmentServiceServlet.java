package task_2_2_e_EnvironmentServiceServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import task_2_2_e_EnvironmentServiceServlet.c.Client;
import task_2_2_e_EnvironmentServiceServlet.c.EnvData;
import task_2_2_e_EnvironmentServiceServlet.client.EnvironmentDataService;
import task_2_2_e_EnvironmentServiceServlet.client.IEnvironmentData;
import task_2_2_e_EnvironmentServiceServlet.client.Locations;
import task_2_2_e_EnvironmentServiceServlet.rmi.IEnvService;


import java.io.IOException;
import java.io.PrintWriter;;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


@WebServlet(
        name = "EnvironmentServiceServlet Servlet",
        urlPatterns = {"/enviromentserviceservlet"}
)

/*/
 * Servlet which displays the sensor data from the C++ Server (EX01)
 * and the RMI Server (EX02.1)
 */
public class EnvironmentServiceServlet extends HttpServlet {

    public void doGet(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        _response.setContentType("text/html");

        //try {
           //String addr = "IEnvService";
            //Registry reg = null;

            //reg = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);

            // start SecurityManager to be on the save side
            //System.setSecurityManager (new RMISecurityManager());

            //IEnvService service = (IEnvService) reg.lookup(addr);
            //task_2_2_e_EnvironmentServiceServlet.rmi.EnvData data = service.requestEnvironmentData("air");

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
            //out.println("<p>"+ data.toString() + "</p>");
            out.println("<p>Not working :(</p>");
            out.println("<iframe src=\"https://giphy.com/embed/xiAqCzbB3eZvG\" width=\"480\" height=\"302\" frameBorder=\"0\" class=\"giphy-embed\" allowFullScreen></iframe><p><a href=\"https://giphy.com/gifs/angry-monday-working-xiAqCzbB3eZvG\">via GIPHY</a></p>");

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

            // Weather Server
            out.println("<h1>Weather Server </h1>");

            try{
                Service service = Service.create(
                                new URL("http://localhost:8081/Environment?wsdl"),
                                new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/",
                                        "EnvironmentDataService"));

                IEnvironmentData mSoap = service.getPort(IEnvironmentData.class);

                out.println("<h4>Wien </h4>");
                out.print("<p> + " + mSoap.requestWeatherData(Locations.WIEN) + "</p>");

                out.println("<h4>Linz </h4>");
                out.print("<p> + " + mSoap.requestWeatherData(Locations.LINZ) + "</p>");

                out.println("<h4>Graz </h4>");
                out.print("<p> + " + mSoap.requestWeatherData(Locations.GRAZ) + "</p>");

            } catch (Exception e){
                out.println("<p>Weather Server not running!</p>");
                //out.println("<p>Exception: " + e.toString() + "</p>");
            }

        // Rest Server

        try {
            URL url = new URL("http://localhost:8080/RestServlet/b/EnvironmentService/ALL");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();


            int length = http.getContentLength();
            int resCode = http.getResponseCode();
            String mime = http.getContentType();

            Scanner s = new Scanner(http.getInputStream(), "UTF-8");
            s.useDelimiter("\\z"); // \z --> till end of input

            String content = s.next();
            s.close();

            out.println("<h2>REST</h2>");
            out.println("<p> + " + content + "</p>");
        } catch(Exception e){
            out.println("<p>Error: " + e.toString() + "</p>");
        }

        out.println("<meta http-equiv=\"refresh\" content=\"5\"/>");
        out.println("</BODY></HEAD></HTML>");

        out.close();

        /*}catch (Exception e){
            PrintWriter out = _response.getWriter();
            out.println("<html><body><h1>Error (" + e.toString() + ")</h1></body></html>");
            e.printStackTrace();
        }*/
    }
}



