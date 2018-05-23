package main.java.api.pojo.epspaymentsearch.request;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortDirectionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SortDirectionEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="ASC"/>
 *     &lt;enumeration value="DESC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SortDirectionEnum")
@XmlEnum
public enum SortDirectionEnum {

    ASC,
    DESC;

    public String value() {
        return name();
    }

    public static SortDirectionEnum fromValue(String v) {
        return valueOf(v);
    }

}
