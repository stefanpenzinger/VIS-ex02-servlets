package task_2_2_e_EnvironmentServiceServlet.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

/**
 * class representing the client
 */
public class Client implements task_2_2_e_EnvironmentServiceServlet.c.IEnvService {

    Socket mSocket; // socket
    OutputStream mOut; // Output stream for socket
    InputStream mIn; // Input stream for socket

    /**
     * ctor creating the socket
     *
     * @param _port (port for communication)
     * @param _address (ip address of server)
     */
    public Client(int _port, String _address){
        try{
            mSocket = new Socket(_address, _port);
            mOut = mSocket.getOutputStream();
            mIn = mSocket.getInputStream();
        } catch (Exception e){
            System.out.println("Error: creating Socket");
            mSocket = null;
            mOut = null;
            mIn = null;
        }
    }

    /**
     * reads the response from the server and returns the received message
     *
     * @return String (received Message)
     * @throws IOException
     */
    private String readResponse() throws IOException {
        int data = -1;
        StringBuffer line = new StringBuffer();
        while ((data = mIn.read()) != -1) {
            if (((char) data) == '#') {
                break;
            } // if end of line
            line.append((char) data);
        }
        return line.toString();
    }

    /**
     * query the sensor types from the server
     * @return String[]
     */
    @Override
    public String[] requestEnvironmentDataTypes() {
        try {
            String msg = "getSensortypes()#";
            System.out.println("send: getSensortypes()#");
            mOut.write(msg.getBytes());
            mOut.flush();
            String response = readResponse();
            return response.split("\\;");
        } catch (Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }

    /**
     * returns the sensor form the server with the given type
     *
     * @param _type
     * @return EnvData
     */
    @Override
    public EnvData requestEnvironmentData(String _type) {
        try {
            String msg = "getSensor(" +  _type + ")#";
            System.out.println("send: getSensor(" +  _type + ")#");
            mOut.write(msg.getBytes());
            mOut.flush();
            String response = readResponse();
            return EnvData.deserialize(response.split("\\|")[1]); //TODO: split not working!
        } catch (Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }

    /**
     * returns a list of all Sensors from the Server
     * @return EnvData[]
     */
    @Override
    public EnvData[] requestAll() {
        try {
            String msg = "getAllSensors()#";
            System.out.println("send: getAllSensors()#");
            mOut.write(msg.getBytes());
            mOut.flush();
            String response = readResponse();
            String[] values = response.split("\\|");
            int i = 0;
            Vector<EnvData> rv = new Vector<>();
            for (String s : values) {
                if(i != 0){
                    rv.add(EnvData.deserialize(s));
                }
                i++;
            }
            return rv.toArray(new EnvData[0]);
        } catch (Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }
}
