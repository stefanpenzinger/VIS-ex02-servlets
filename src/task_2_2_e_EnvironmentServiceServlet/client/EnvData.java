
package task_2_2_e_EnvironmentServiceServlet.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for envData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="envData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="temp" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="temp_min" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="humidity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="pressure" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="temp_max" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "envData", propOrder = {
    "temp",
    "tempMin",
    "humidity",
    "pressure",
    "tempMax"
})
public class EnvData {

    protected float temp;
    @XmlElement(name = "temp_min")
    protected float tempMin;
    protected float humidity;
    protected float pressure;
    @XmlElement(name = "temp_max")
    protected float tempMax;

    /**
     * Gets the value of the temp property.
     * 
     */
    public float getTemp() {
        return temp;
    }

    /**
     * Sets the value of the temp property.
     * 
     */
    public void setTemp(float value) {
        this.temp = value;
    }

    /**
     * Gets the value of the tempMin property.
     * 
     */
    public float getTempMin() {
        return tempMin;
    }

    /**
     * Sets the value of the tempMin property.
     * 
     */
    public void setTempMin(float value) {
        this.tempMin = value;
    }

    /**
     * Gets the value of the humidity property.
     * 
     */
    public float getHumidity() {
        return humidity;
    }

    /**
     * Sets the value of the humidity property.
     * 
     */
    public void setHumidity(float value) {
        this.humidity = value;
    }

    /**
     * Gets the value of the pressure property.
     * 
     */
    public float getPressure() {
        return pressure;
    }

    /**
     * Sets the value of the pressure property.
     * 
     */
    public void setPressure(float value) {
        this.pressure = value;
    }

    /**
     * Gets the value of the tempMax property.
     * 
     */
    public float getTempMax() {
        return tempMax;
    }

    /**
     * Sets the value of the tempMax property.
     * 
     */
    public void setTempMax(float value) {
        this.tempMax = value;
    }

    @Override
    public String toString() {
        return "EnvData{" +
                "temp=" + temp +
                ", tempMin=" + tempMin +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", tempMax=" + tempMax +
                '}';
    }
}
