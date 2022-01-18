
package task_2_2_e_EnvironmentServiceServlet.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the task_2_2_e_EnvironmentServiceServlet.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnvData_QNAME = new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "envData");
    private final static QName _RequestEnvironmentDataTypesResponse_QNAME = new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "requestEnvironmentDataTypesResponse");
    private final static QName _RequestWeatherData_QNAME = new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "requestWeatherData");
    private final static QName _RequestEnvironmentDataTypes_QNAME = new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "requestEnvironmentDataTypes");
    private final static QName _RequestWeatherDataResponse_QNAME = new QName("http://b.task3_2.vis.mc.hagenberg.fh.at/", "requestWeatherDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: task_2_2_e_EnvironmentServiceServlet.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestWeatherDataResponse }
     * 
     */
    public RequestWeatherDataResponse createRequestWeatherDataResponse() {
        return new RequestWeatherDataResponse();
    }

    /**
     * Create an instance of {@link RequestEnvironmentDataTypes }
     * 
     */
    public RequestEnvironmentDataTypes createRequestEnvironmentDataTypes() {
        return new RequestEnvironmentDataTypes();
    }

    /**
     * Create an instance of {@link RequestWeatherData }
     * 
     */
    public RequestWeatherData createRequestWeatherData() {
        return new RequestWeatherData();
    }

    /**
     * Create an instance of {@link EnvData }
     * 
     */
    public EnvData createEnvData() {
        return new EnvData();
    }

    /**
     * Create an instance of {@link RequestEnvironmentDataTypesResponse }
     * 
     */
    public RequestEnvironmentDataTypesResponse createRequestEnvironmentDataTypesResponse() {
        return new RequestEnvironmentDataTypesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", name = "envData")
    public JAXBElement<EnvData> createEnvData(EnvData value) {
        return new JAXBElement<EnvData>(_EnvData_QNAME, EnvData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestEnvironmentDataTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", name = "requestEnvironmentDataTypesResponse")
    public JAXBElement<RequestEnvironmentDataTypesResponse> createRequestEnvironmentDataTypesResponse(RequestEnvironmentDataTypesResponse value) {
        return new JAXBElement<RequestEnvironmentDataTypesResponse>(_RequestEnvironmentDataTypesResponse_QNAME, RequestEnvironmentDataTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestWeatherData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", name = "requestWeatherData")
    public JAXBElement<RequestWeatherData> createRequestWeatherData(RequestWeatherData value) {
        return new JAXBElement<RequestWeatherData>(_RequestWeatherData_QNAME, RequestWeatherData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestEnvironmentDataTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", name = "requestEnvironmentDataTypes")
    public JAXBElement<RequestEnvironmentDataTypes> createRequestEnvironmentDataTypes(RequestEnvironmentDataTypes value) {
        return new JAXBElement<RequestEnvironmentDataTypes>(_RequestEnvironmentDataTypes_QNAME, RequestEnvironmentDataTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestWeatherDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", name = "requestWeatherDataResponse")
    public JAXBElement<RequestWeatherDataResponse> createRequestWeatherDataResponse(RequestWeatherDataResponse value) {
        return new JAXBElement<RequestWeatherDataResponse>(_RequestWeatherDataResponse_QNAME, RequestWeatherDataResponse.class, null, value);
    }

}
