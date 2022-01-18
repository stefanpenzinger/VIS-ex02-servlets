package task_2_2_e_EnvironmentServiceServlet;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.json.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@WebService(endpointInterface = "task_2_2_e_EnvironmentServiceServlet.IEnvironmentData")
public class EnvironmentData implements IEnvironmentData {
    /**
     * Api key to get weather data
     * @val String
     */
    private String mApiKey;

    /**
     * Constructor of EnvironmentData
     */
    public EnvironmentData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/at/fh/hagenberg/mc/vis/task3_2/b/api.txt"));

            this.mApiKey = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the available Locations
     *
     * @return Locations
     */
    @Override
    @WebMethod
    public Locations[] requestEnvironmentDataTypes() {
        return Locations.values();
    }

    /**
     * Returns the weather data in form of EnvData Container
     *
     * @param _location Location to get the weather data from
     * @return EnvData Object or null in case of error
     */
    @Override
    @WebMethod
    public EnvData requestWeatherData(Locations _location) {
        try {
            System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

            String content = getContent(_location);
            //String content = "{\"coord\":{\"lon\":16.3721,\"lat\":48.2085},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"base\":\"stations\",\"main\":{\"temp\":4.88,\"feels_like\":4.88,\"temp_min\":3.21,\"temp_max\":6.56,\"pressure\":1035,\"humidity\":61},\"visibility\":10000,\"wind\":{\"speed\":0.45,\"deg\":350,\"gust\":3.58},\"clouds\":{\"all\":20},\"dt\":1642508532,\"sys\":{\"type\":2,\"id\":2037452,\"country\":\"AT\",\"sunrise\":1642487884,\"sunset\":1642519875},\"timezone\":3600,\"id\":2761369,\"name\":\"Vienna\",\"cod\":200}\n";


            JSONObject jsonObject = new JSONObject(content);
            jsonObject = jsonObject.getJSONObject("main");

            //EnvData envDataTest = new EnvData(jsonObject.getFloat("temp"), jsonObject.getFloat("pressure"),jsonObject.getFloat("humidity"),jsonObject.getFloat("temp_min"),jsonObject.getFloat("temp_max"));

            JAXBContext jc = JAXBContext.newInstance(new Class[] { EnvData.class });

            Unmarshaller um = jc.createUnmarshaller();

            um.setProperty(UnmarshallerProperties.MEDIA_TYPE,
                    MediaType.APPLICATION_JSON);
            um.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT,
                    Boolean.FALSE);

            StreamSource stream = new StreamSource(new StringReader(jsonObject.toString()));
            JAXBElement<EnvData> envDataContainer = um.unmarshal(stream, EnvData.class);
            EnvData envData = envDataContainer.getValue();

            return envData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns the json data from the api call
     *
     * @param _location Location to get the weather data from
     * @return JSON String
     * @throws IOException if something fails
     */
    private String getContent(Locations _location) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + _location + ",at&units=metric&APPID=" + mApiKey);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();

        int length = http.getContentLength();
        int resCode = http.getResponseCode();
        String mime = http.getContentType();

        Scanner s = new Scanner(http.getInputStream(), "UTF-8");
        s.useDelimiter("\\z"); // \z --> till end of input

        String content = s.next();
        s.close();

        return content;
    }
}
