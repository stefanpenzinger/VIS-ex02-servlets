package task_2_2_e_EnvironmentServiceServlet.c;

import java.sql.Timestamp;
import java.util.Vector;

/**
 *  class representing a Sensor
 */
public class EnvData {
    enum EnvDataTypes{ light, noise, air } // available sensor types

    /** represents sensor data */
    Vector<Integer> mData;
    /** type of sensor */
    EnvDataTypes mType;

    /**
     * initializes a new sensor
     *
     * @param _data (sensor data)
     * @param _type (type of sensor)
     */
    EnvData(Vector<Integer> _data, EnvDataTypes _type){
        mData = _data;
        mType = _type;
    }

    public Vector<Integer> getmData() {
        return mData;
    }

    public EnvDataTypes getmType() {
        return mType;
    }

    public long getmTimestamp() {
        return System.currentTimeMillis();
    }



    /**
     * converts the given _value into a EnvData object
     * _value: "type;sensor_value1;sensor_value2;"
     *
     * Example for _value: "air;32;54;30"
     *
     * @param _value (String)
     * @return EnvData
     */
    static EnvData deserialize(String _value){
        Vector<Integer> data = new Vector<>();
        EnvDataTypes type = EnvDataTypes.noise;
        int i = 0;
        for (String s : _value.split("\\;")) {
            if(i == 0){
                type = EnvDataTypes.valueOf(s);
            } else {
                data.add(Integer.decode(s));
            }
            i++;
        }

        return new EnvData(data, type);
    }

    /**
     * overrides toString() method
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder rv = new StringBuilder();
        rv.append("Type: ").append(mType.name()).append(" | ");
        rv.append("Data: ");
        for (int i : mData) {
            rv.append(Integer.toString(i)).append(" ");
        }
        return rv.toString();
    }
}
