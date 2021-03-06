package task_2_2_e_EnvironmentServiceServlet.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEnvService extends Remote {
    /**
     * Provides the types of the available environmental sensors
     *
     * @return A String array with the sensor types
     * @throws RemoteException An error occurred during the communication
     * @see String
     * @see RemoteException
     */
    public String[] requestEnvironmentDataTypes() throws RemoteException;
    /**
     * Provides the measurement values of a specific sensor in the form
     * of an environmental data object (EnvData)
     *
     * @param _type the type of the targeted sensor
     * @return EnvData the current measurement value of the sensor
     * null, if the sensor doesn’t exist
     * @throws RemoteException An error occurred during the communication
     * @see EnvData
     * @see String
     * @see RemoteException
     */
    public EnvData requestEnvironmentData(String _type) throws RemoteException;

    /**
     * Provides the measurement values of all available sensors
     *
     * @return EnvData[] all available measurement values
     * @throws RemoteException An error occurred during the communication
     * @see EnvData
     * @see String
     * @see RemoteException
     */
    public EnvData[] requestAll() throws RemoteException;

    /** Method for testing a basic communication between server & client */
    public String saySomething() throws RemoteException;
}
