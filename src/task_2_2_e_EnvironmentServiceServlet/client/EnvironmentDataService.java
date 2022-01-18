
package task_2_2_e_EnvironmentServiceServlet.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EnvironmentDataService", targetNamespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", wsdlLocation = "http://localhost:8081/Environment?wsdl")
public class EnvironmentDataService
    extends Service
{

    private final static URL ENVIRONMENTDATASERVICE_WSDL_LOCATION;
    private final static WebServiceException ENVIRONMENTDATASERVICE_EXCEPTION;
    private final static QName ENVIRONMENTDATASERVICE_QNAME = new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "EnvironmentDataService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/Environment?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ENVIRONMENTDATASERVICE_WSDL_LOCATION = url;
        ENVIRONMENTDATASERVICE_EXCEPTION = e;
    }

    public EnvironmentDataService() {
        super(__getWsdlLocation(), ENVIRONMENTDATASERVICE_QNAME);
    }

    public EnvironmentDataService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ENVIRONMENTDATASERVICE_QNAME, features);
    }

    public EnvironmentDataService(URL wsdlLocation) {
        super(wsdlLocation, ENVIRONMENTDATASERVICE_QNAME);
    }

    public EnvironmentDataService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ENVIRONMENTDATASERVICE_QNAME, features);
    }

    public EnvironmentDataService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EnvironmentDataService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IEnvironmentData
     */
    @WebEndpoint(name = "EnvironmentDataPort")
    public IEnvironmentData getEnvironmentDataPort() {
        return super.getPort(new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "EnvironmentDataPort"), IEnvironmentData.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEnvironmentData
     */
    @WebEndpoint(name = "EnvironmentDataPort")
    public IEnvironmentData getEnvironmentDataPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "EnvironmentDataPort"), IEnvironmentData.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ENVIRONMENTDATASERVICE_EXCEPTION!= null) {
            throw ENVIRONMENTDATASERVICE_EXCEPTION;
        }
        return ENVIRONMENTDATASERVICE_WSDL_LOCATION;
    }

}
