//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.multimedia_v1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.optum.enterprise.schema.cim.common.multimedia_v1_0 package. 
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

    private final static QName _TextFileContents_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "TextFileContents");
    private final static QName _Multimedias_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "Multimedias");
    private final static QName _BinaryFileContent_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "BinaryFileContent");
    private final static QName _ImageContent_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "ImageContent");
    private final static QName _ImageContents_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "ImageContents");
    private final static QName _BinaryFileContents_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "BinaryFileContents");
    private final static QName _Multimedia_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "Multimedia");
    private final static QName _TextFileContent_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", "TextFileContent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.common.multimedia_v1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Multimedia }
     * 
     */
    public Multimedia createMultimedia() {
        return new Multimedia();
    }

    /**
     * Create an instance of {@link BinaryFileContent }
     * 
     */
    public BinaryFileContent createBinaryFileContent() {
        return new BinaryFileContent();
    }

    /**
     * Create an instance of {@link TextFileContent }
     * 
     */
    public TextFileContent createTextFileContent() {
        return new TextFileContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextFileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "TextFileContents")
    public JAXBElement<TextFileContent> createTextFileContents(TextFileContent value) {
        return new JAXBElement<TextFileContent>(_TextFileContents_QNAME, TextFileContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multimedia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "Multimedias")
    public JAXBElement<Multimedia> createMultimedias(Multimedia value) {
        return new JAXBElement<Multimedia>(_Multimedias_QNAME, Multimedia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryFileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "BinaryFileContent")
    public JAXBElement<BinaryFileContent> createBinaryFileContent(BinaryFileContent value) {
        return new JAXBElement<BinaryFileContent>(_BinaryFileContent_QNAME, BinaryFileContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryFileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "ImageContent")
    public JAXBElement<BinaryFileContent> createImageContent(BinaryFileContent value) {
        return new JAXBElement<BinaryFileContent>(_ImageContent_QNAME, BinaryFileContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryFileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "ImageContents")
    public JAXBElement<BinaryFileContent> createImageContents(BinaryFileContent value) {
        return new JAXBElement<BinaryFileContent>(_ImageContents_QNAME, BinaryFileContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryFileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "BinaryFileContents")
    public JAXBElement<BinaryFileContent> createBinaryFileContents(BinaryFileContent value) {
        return new JAXBElement<BinaryFileContent>(_BinaryFileContents_QNAME, BinaryFileContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multimedia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "Multimedia")
    public JAXBElement<Multimedia> createMultimedia(Multimedia value) {
        return new JAXBElement<Multimedia>(_Multimedia_QNAME, Multimedia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextFileContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Multimedia_v1_0", name = "TextFileContent")
    public JAXBElement<TextFileContent> createTextFileContent(TextFileContent value) {
        return new JAXBElement<TextFileContent>(_TextFileContent_QNAME, TextFileContent.class, null, value);
    }

}