//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.common.entity_v1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.optum.enterprise.schema.cim.common.entity_v1_0 package. 
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

    private final static QName _EntityThumbnail_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "EntityThumbnail");
    private final static QName _EntitySummary_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "EntitySummary");
    private final static QName _OriginationSystems_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "OriginationSystems");
    private final static QName _OriginationSystem_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "OriginationSystem");
    private final static QName _SourceSystem_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "SourceSystem");
    private final static QName _EntityThumbnails_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "EntityThumbnails");
    private final static QName _EntitySummaries_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "EntitySummaries");
    private final static QName _SourceSystems_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "SourceSystems");
    private final static QName _Sender_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "Sender");
    private final static QName _Entities_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "Entities");
    private final static QName _Receivers_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "Receivers");
    private final static QName _Senders_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "Senders");
    private final static QName _Receiver_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "Receiver");
    private final static QName _EntitySystem_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "EntitySystem");
    private final static QName _Entity_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "Entity");
    private final static QName _EntitySystems_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "EntitySystems");
    private final static QName _UniqueEntityIdentifiers_QNAME = new QName("http://enterprise.optum.com/schema/cim/common/Entity_v1_0", "UniqueEntityIdentifiers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.common.entity_v1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UniqueEntityIdentifier }
     * 
     */
    public UniqueEntityIdentifier createUniqueEntityIdentifier() {
        return new UniqueEntityIdentifier();
    }

    /**
     * Create an instance of {@link EntityThumbnail }
     * 
     */
    public EntityThumbnail createEntityThumbnail() {
        return new EntityThumbnail();
    }

    /**
     * Create an instance of {@link EntitySummary }
     * 
     */
    public EntitySummary createEntitySummary() {
        return new EntitySummary();
    }

    /**
     * Create an instance of {@link EntitySystem }
     * 
     */
    public EntitySystem createEntitySystem() {
        return new EntitySystem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityThumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "EntityThumbnail")
    public JAXBElement<EntityThumbnail> createEntityThumbnail(EntityThumbnail value) {
        return new JAXBElement<EntityThumbnail>(_EntityThumbnail_QNAME, EntityThumbnail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "EntitySummary")
    public JAXBElement<EntitySummary> createEntitySummary(EntitySummary value) {
        return new JAXBElement<EntitySummary>(_EntitySummary_QNAME, EntitySummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "OriginationSystems")
    public JAXBElement<EntitySystem> createOriginationSystems(EntitySystem value) {
        return new JAXBElement<EntitySystem>(_OriginationSystems_QNAME, EntitySystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "OriginationSystem")
    public JAXBElement<EntitySystem> createOriginationSystem(EntitySystem value) {
        return new JAXBElement<EntitySystem>(_OriginationSystem_QNAME, EntitySystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "SourceSystem")
    public JAXBElement<EntitySystem> createSourceSystem(EntitySystem value) {
        return new JAXBElement<EntitySystem>(_SourceSystem_QNAME, EntitySystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityThumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "EntityThumbnails")
    public JAXBElement<EntityThumbnail> createEntityThumbnails(EntityThumbnail value) {
        return new JAXBElement<EntityThumbnail>(_EntityThumbnails_QNAME, EntityThumbnail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "EntitySummaries")
    public JAXBElement<EntitySummary> createEntitySummaries(EntitySummary value) {
        return new JAXBElement<EntitySummary>(_EntitySummaries_QNAME, EntitySummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "SourceSystems")
    public JAXBElement<EntitySystem> createSourceSystems(EntitySystem value) {
        return new JAXBElement<EntitySystem>(_SourceSystems_QNAME, EntitySystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "Sender")
    public JAXBElement<Entity> createSender(Entity value) {
        return new JAXBElement<Entity>(_Sender_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "Entities")
    public JAXBElement<Entity> createEntities(Entity value) {
        return new JAXBElement<Entity>(_Entities_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "Receivers")
    public JAXBElement<Entity> createReceivers(Entity value) {
        return new JAXBElement<Entity>(_Receivers_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "Senders")
    public JAXBElement<Entity> createSenders(Entity value) {
        return new JAXBElement<Entity>(_Senders_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "Receiver")
    public JAXBElement<Entity> createReceiver(Entity value) {
        return new JAXBElement<Entity>(_Receiver_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "EntitySystem")
    public JAXBElement<EntitySystem> createEntitySystem(EntitySystem value) {
        return new JAXBElement<EntitySystem>(_EntitySystem_QNAME, EntitySystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "Entity")
    public JAXBElement<Entity> createEntity(Entity value) {
        return new JAXBElement<Entity>(_Entity_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntitySystem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "EntitySystems")
    public JAXBElement<EntitySystem> createEntitySystems(EntitySystem value) {
        return new JAXBElement<EntitySystem>(_EntitySystems_QNAME, EntitySystem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueEntityIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/common/Entity_v1_0", name = "UniqueEntityIdentifiers")
    public JAXBElement<UniqueEntityIdentifier> createUniqueEntityIdentifiers(UniqueEntityIdentifier value) {
        return new JAXBElement<UniqueEntityIdentifier>(_UniqueEntityIdentifiers_QNAME, UniqueEntityIdentifier.class, null, value);
    }

}
