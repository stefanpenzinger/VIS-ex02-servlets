
package task_2_2_e_EnvironmentServiceServlet.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IEnvironmentData", targetNamespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IEnvironmentData {


    /**
     * 
     * @return
     *     returns java.util.List<task_2_2_e_EnvironmentServiceServlet.client.Locations>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestEnvironmentDataTypes", targetNamespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", className = "task_2_2_e_EnvironmentServiceServlet.client.RequestEnvironmentDataTypes")
    @ResponseWrapper(localName = "requestEnvironmentDataTypesResponse", targetNamespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", className = "task_2_2_e_EnvironmentServiceServlet.client.RequestEnvironmentDataTypesResponse")
    @Action(input = "http://b.task3_2.vis.mc.hagenberg.fh.at/IEnvironmentData/requestEnvironmentDataTypesRequest", output = "http://b.task3_2.vis.mc.hagenberg.fh.at/IEnvironmentData/requestEnvironmentDataTypesResponse")
    public List<Locations> requestEnvironmentDataTypes();

    /**
     * 
     * @param arg0
     * @return
     *     returns task_2_2_e_EnvironmentServiceServlet.client.EnvData
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestWeatherData", targetNamespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", className = "task_2_2_e_EnvironmentServiceServlet.client.RequestWeatherData")
    @ResponseWrapper(localName = "requestWeatherDataResponse", targetNamespace = "http://b.task3_2.vis.mc.hagenberg.fh.at/", className = "task_2_2_e_EnvironmentServiceServlet.client.RequestWeatherDataResponse")
    @Action(input = "http://b.task3_2.vis.mc.hagenberg.fh.at/IEnvironmentData/requestWeatherDataRequest", output = "http://b.task3_2.vis.mc.hagenberg.fh.at/IEnvironmentData/requestWeatherDataResponse")
    public EnvData requestWeatherData(
        @WebParam(name = "arg0", targetNamespace = "")
        Locations arg0);

}