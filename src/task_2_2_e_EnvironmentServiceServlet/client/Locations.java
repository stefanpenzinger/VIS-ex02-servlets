
package task_2_2_e_EnvironmentServiceServlet.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for locations.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="locations">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Wien"/>
 *     &lt;enumeration value="Graz"/>
 *     &lt;enumeration value="Linz"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "locations")
@XmlEnum
public enum Locations {

    @XmlEnumValue("Wien")
    WIEN("Wien"),
    @XmlEnumValue("Graz")
    GRAZ("Graz"),
    @XmlEnumValue("Linz")
    LINZ("Linz");
    private final String value;

    Locations(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Locations fromValue(String v) {
        for (Locations c: Locations.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
