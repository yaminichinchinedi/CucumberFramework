//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.address_v1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.optum.enterprise.schema.cim.common.address_v1_0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PostalUSCode_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "PostalUSCode");
    private final static QName _PostalUSCodeAddOn_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "PostalUSCodeAddOn");
    private final static QName _Locations_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "Locations");
    private final static QName _Location_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "Location");
    private final static QName _CountyUSName_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "CountyUSName");
    private final static QName _CountyUSFipsCode_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "CountyUSFipsCode");
    private final static QName _GeographicScopes_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "GeographicScopes");
    private final static QName _City_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "City");
    private final static QName _USAddresses_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "USAddresses");
    private final static QName _Address_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "Address");
    private final static QName _USAddress_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "USAddress");
    private final static QName _InternationalAddresses_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "InternationalAddresses");
    private final static QName _PostalCode_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "PostalCode");
    private final static QName _GeographicScope_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "GeographicScope");
    private final static QName _InternationalAddress_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "InternationalAddress");
    private final static QName _StateAbbreviation_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "StateAbbreviation");
    private final static QName _State_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "State");
    private final static QName _Addresses_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Address_v1_0", "Addresses");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.common.address_v1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GeographicScope }
     * 
     */
    public GeographicScope createGeographicScope() {
        return new GeographicScope();
    }

    /**
     * Create an instance of {@link InternationalAddress }
     * 
     */
    public InternationalAddress createInternationalAddress() {
        return new InternationalAddress();
    }

    /**
     * Create an instance of {@link USAddress }
     * 
     */
    public USAddress createUSAddress() {
        return new USAddress();
    }

    /**
     * Create an instance of {@link USAddressList }
     * 
     */
    public USAddressList createUSAddressList() {
        return new USAddressList();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "PostalUSCode")
    public JAXBElement<String> createPostalUSCode(String value) {
        return new JAXBElement<String>(_PostalUSCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "PostalUSCodeAddOn")
    public JAXBElement<String> createPostalUSCodeAddOn(String value) {
        return new JAXBElement<String>(_PostalUSCodeAddOn_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "Locations")
    public JAXBElement<Location> createLocations(Location value) {
        return new JAXBElement<Location>(_Locations_QNAME, Location.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Location }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "Location")
    public JAXBElement<Location> createLocation(Location value) {
        return new JAXBElement<Location>(_Location_QNAME, Location.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "CountyUSName")
    public JAXBElement<String> createCountyUSName(String value) {
        return new JAXBElement<String>(_CountyUSName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "CountyUSFipsCode")
    public JAXBElement<String> createCountyUSFipsCode(String value) {
        return new JAXBElement<String>(_CountyUSFipsCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicScope }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "GeographicScopes")
    public JAXBElement<GeographicScope> createGeographicScopes(GeographicScope value) {
        return new JAXBElement<GeographicScope>(_GeographicScopes_QNAME, GeographicScope.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "City")
    public JAXBElement<String> createCity(String value) {
        return new JAXBElement<String>(_City_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "USAddresses")
    public JAXBElement<USAddress> createUSAddresses(USAddress value) {
        return new JAXBElement<USAddress>(_USAddresses_QNAME, USAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "Address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "USAddress")
    public JAXBElement<USAddress> createUSAddress(USAddress value) {
        return new JAXBElement<USAddress>(_USAddress_QNAME, USAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternationalAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "InternationalAddresses")
    public JAXBElement<InternationalAddress> createInternationalAddresses(InternationalAddress value) {
        return new JAXBElement<InternationalAddress>(_InternationalAddresses_QNAME, InternationalAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "PostalCode")
    public JAXBElement<String> createPostalCode(String value) {
        return new JAXBElement<String>(_PostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicScope }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "GeographicScope")
    public JAXBElement<GeographicScope> createGeographicScope(GeographicScope value) {
        return new JAXBElement<GeographicScope>(_GeographicScope_QNAME, GeographicScope.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternationalAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "InternationalAddress")
    public JAXBElement<InternationalAddress> createInternationalAddress(InternationalAddress value) {
        return new JAXBElement<InternationalAddress>(_InternationalAddress_QNAME, InternationalAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "StateAbbreviation")
    public JAXBElement<String> createStateAbbreviation(String value) {
        return new JAXBElement<String>(_StateAbbreviation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "State")
    public JAXBElement<String> createState(String value) {
        return new JAXBElement<String>(_State_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Address_v1_0", name = "Addresses")
    public JAXBElement<Address> createAddresses(Address value) {
        return new JAXBElement<Address>(_Addresses_QNAME, Address.class, null, value);
    }

}
