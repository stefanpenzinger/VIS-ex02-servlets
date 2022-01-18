package task_2_2_e_EnvironmentServiceServlet;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IEnvironmentData {
    enum Locations { Wien, Graz, Linz }

    /**
     * Returns the available Locations
     *
     * @return Locations
     */
    @WebMethod
    Locations[] requestEnvironmentDataTypes();

    /**
     * Returns the weather data in form of EnvData Container
     *
     * @param _location Location to get the weather data from
     * @return EnvData Object or null in case of error
     */
    @WebMethod
    EnvData requestWeatherData(Locations _location);
}
