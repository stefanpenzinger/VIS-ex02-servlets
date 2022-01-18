package task_2_2_e_EnvironmentServiceServlet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Environment Data Container
 */
@XmlRootElement
@XmlType(propOrder = { "mTemp", "mTempMin", "mHumidity", "mPressure", "mTempMax" })
public class EnvData {
    /**
     * Temperature of the location
     * @val float mTemp
     */
    @XmlElement(name = "temp")
    private float mTemp;
    /**
     * Pressure of the location
     * @val float mPressure
     */
    @XmlElement(name = "pressure")
    private float mPressure;
    /**
     * Humidity of the location
     * @val float mHumidity
     */
    @XmlElement(name = "humidity")
    private float mHumidity;
    /**
     * Minimum Temperature of the location
     * @val float mTempMin
     */
    @XmlElement(name = "temp_min")
    private float mTempMin;
    /**
     * Maximum Temperature of the location
     * @val float mTempMax
     */
    @XmlElement(name = "temp_max")
    private float mTempMax;

    /**
     * Needed default constructor
     */
    public EnvData() {
    }

    /**
     * EnvData Constructor
     * @param _temp float
     * @param _pressure float
     * @param _humidity float
     * @param _minTemp float
     * @param _maxTemp float
     */
    public EnvData(float _temp, float _pressure, float _humidity, float _minTemp, float _maxTemp) {
        this.mTemp = _temp;
        this.mPressure = _pressure;
        this.mHumidity = _humidity;
        this.mTempMin = _minTemp;
        this.mTempMax = _maxTemp;
    }

    /**
     * Returns temperature
     * @return float
     */
    public float getmTemp() {
        return mTemp;
    }

    /**
     * Returns pressure
     * @return float
     */
    public float getmPressure() {
        return mPressure;
    }

    /**
     * Returns humidity
     * @return float
     */
    public float getmHumidity() {
        return mHumidity;
    }

    /**
     * Returns minimum temperature
     * @return float
     */
    public float getmTempMin() {
        return mTempMin;
    }

    /**
     * Returns maximum temperature
     * @return float
     */
    public float getmTempMax() {
        return mTempMax;
    }

    /**
     * String representation of EnvData
     * @return String
     */
    @Override
    public String toString() {
        return "EnvData{" +
                "mTemp=" + mTemp +
                ", mPressure=" + mPressure +
                ", mHumidity=" + mHumidity +
                ", mTempMin=" + mTempMin +
                ", mTempMax=" + mTempMax +
                '}';
    }
}
