//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.03 at 12:32:33 PM CDT 
//


package com.optum.enterprise.schema.cim.member.member_v1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.optum.enterprise.schema.cim.common.entity_v1_0.Entity;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.optum.enterprise.schema.cim.member.member_v1_0 package. 
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

    private final static QName _Card_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "Card");
    private final static QName _Member_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "Member");
    private final static QName _MemberSummary_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberSummary");
    private final static QName _ResponsibleParty_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "ResponsibleParty");
    private final static QName _Subscriber_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "Subscriber");
    private final static QName _CardBackMetadata_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "CardBackMetadata");
    private final static QName _MemberPayments_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberPayments");
    private final static QName _Subscribers_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "Subscribers");
    private final static QName _UniqueMemberSystemIdentifiers_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "UniqueMemberSystemIdentifiers");
    private final static QName _SubscriberSummary_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "SubscriberSummary");
    private final static QName _CardFrontMetadata_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "CardFrontMetadata");
    private final static QName _MemberEnrollmentEffectiveDate_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberEnrollmentEffectiveDate");
    private final static QName _Cards_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "Cards");
    private final static QName _Members_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "Members");
    private final static QName _SubscriberThumbnail_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "SubscriberThumbnail");
    private final static QName _MemberThumbnail_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberThumbnail");
    private final static QName _SubscriberThumbnails_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "SubscriberThumbnails");
    private final static QName _SubscriberSummaries_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "SubscriberSummaries");
    private final static QName _MemberSummaries_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberSummaries");
    private final static QName _MemberThumbnails_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberThumbnails");
    private final static QName _MemberPayment_QNAME = new QName("http://enterprise.optum.com/schema/cim/member/Member_v1_0", "MemberPayment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.optum.enterprise.schema.cim.member.member_v1_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UniqueMemberSystemIdentifier }
     * 
     */
    public UniqueMemberSystemIdentifier createUniqueMemberSystemIdentifier() {
        return new UniqueMemberSystemIdentifier();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link MemberThumbnail }
     * 
     */
    public MemberThumbnail createMemberThumbnail() {
        return new MemberThumbnail();
    }

    /**
     * Create an instance of {@link Card.Front }
     * 
     */
    public Card.Front createCardFront() {
        return new Card.Front();
    }

    /**
     * Create an instance of {@link SubscriberSummary }
     * 
     */
    public SubscriberSummary createSubscriberSummary() {
        return new SubscriberSummary();
    }

    /**
     * Create an instance of {@link SubscriberThumbnail }
     * 
     */
    public SubscriberThumbnail createSubscriberThumbnail() {
        return new SubscriberThumbnail();
    }

    /**
     * Create an instance of {@link Membership }
     * 
     */
    public Membership createMembership() {
        return new Membership();
    }

    /**
     * Create an instance of {@link Card.Back }
     * 
     */
    public Card.Back createCardBack() {
        return new Card.Back();
    }

    /**
     * Create an instance of {@link Member }
     * 
     */
    public Member createMember() {
        return new Member();
    }

    /**
     * Create an instance of {@link CardFrontMetadata }
     * 
     */
    public CardFrontMetadata createCardFrontMetadata() {
        return new CardFrontMetadata();
    }

    /**
     * Create an instance of {@link MemberSummary }
     * 
     */
    public MemberSummary createMemberSummary() {
        return new MemberSummary();
    }

    /**
     * Create an instance of {@link CardBackMetadata }
     * 
     */
    public CardBackMetadata createCardBackMetadata() {
        return new CardBackMetadata();
    }

    /**
     * Create an instance of {@link MemberPayment }
     * 
     */
    public MemberPayment createMemberPayment() {
        return new MemberPayment();
    }

    /**
     * Create an instance of {@link Subscriber }
     * 
     */
    public Subscriber createSubscriber() {
        return new Subscriber();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "Card")
    public JAXBElement<Card> createCard(Card value) {
        return new JAXBElement<Card>(_Card_QNAME, Card.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Member }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "Member")
    public JAXBElement<Member> createMember(Member value) {
        return new JAXBElement<Member>(_Member_QNAME, Member.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberSummary")
    public JAXBElement<MemberSummary> createMemberSummary(MemberSummary value) {
        return new JAXBElement<MemberSummary>(_MemberSummary_QNAME, MemberSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "ResponsibleParty")
    public JAXBElement<Entity> createResponsibleParty(Entity value) {
        return new JAXBElement<Entity>(_ResponsibleParty_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "Subscriber")
    public JAXBElement<Subscriber> createSubscriber(Subscriber value) {
        return new JAXBElement<Subscriber>(_Subscriber_QNAME, Subscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardBackMetadata }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "CardBackMetadata")
    public JAXBElement<CardBackMetadata> createCardBackMetadata(CardBackMetadata value) {
        return new JAXBElement<CardBackMetadata>(_CardBackMetadata_QNAME, CardBackMetadata.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberPayments")
    public JAXBElement<MemberPayment> createMemberPayments(MemberPayment value) {
        return new JAXBElement<MemberPayment>(_MemberPayments_QNAME, MemberPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subscriber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "Subscribers")
    public JAXBElement<Subscriber> createSubscribers(Subscriber value) {
        return new JAXBElement<Subscriber>(_Subscribers_QNAME, Subscriber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UniqueMemberSystemIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "UniqueMemberSystemIdentifiers")
    public JAXBElement<UniqueMemberSystemIdentifier> createUniqueMemberSystemIdentifiers(UniqueMemberSystemIdentifier value) {
        return new JAXBElement<UniqueMemberSystemIdentifier>(_UniqueMemberSystemIdentifiers_QNAME, UniqueMemberSystemIdentifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "SubscriberSummary")
    public JAXBElement<SubscriberSummary> createSubscriberSummary(SubscriberSummary value) {
        return new JAXBElement<SubscriberSummary>(_SubscriberSummary_QNAME, SubscriberSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardFrontMetadata }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "CardFrontMetadata")
    public JAXBElement<CardFrontMetadata> createCardFrontMetadata(CardFrontMetadata value) {
        return new JAXBElement<CardFrontMetadata>(_CardFrontMetadata_QNAME, CardFrontMetadata.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberEnrollmentEffectiveDate")
    public JAXBElement<XMLGregorianCalendar> createMemberEnrollmentEffectiveDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MemberEnrollmentEffectiveDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "Cards")
    public JAXBElement<Card> createCards(Card value) {
        return new JAXBElement<Card>(_Cards_QNAME, Card.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Member }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "Members")
    public JAXBElement<Member> createMembers(Member value) {
        return new JAXBElement<Member>(_Members_QNAME, Member.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberThumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "SubscriberThumbnail")
    public JAXBElement<SubscriberThumbnail> createSubscriberThumbnail(SubscriberThumbnail value) {
        return new JAXBElement<SubscriberThumbnail>(_SubscriberThumbnail_QNAME, SubscriberThumbnail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberThumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberThumbnail")
    public JAXBElement<MemberThumbnail> createMemberThumbnail(MemberThumbnail value) {
        return new JAXBElement<MemberThumbnail>(_MemberThumbnail_QNAME, MemberThumbnail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberThumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "SubscriberThumbnails")
    public JAXBElement<SubscriberThumbnail> createSubscriberThumbnails(SubscriberThumbnail value) {
        return new JAXBElement<SubscriberThumbnail>(_SubscriberThumbnails_QNAME, SubscriberThumbnail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubscriberSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "SubscriberSummaries")
    public JAXBElement<SubscriberSummary> createSubscriberSummaries(SubscriberSummary value) {
        return new JAXBElement<SubscriberSummary>(_SubscriberSummaries_QNAME, SubscriberSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberSummaries")
    public JAXBElement<MemberSummary> createMemberSummaries(MemberSummary value) {
        return new JAXBElement<MemberSummary>(_MemberSummaries_QNAME, MemberSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberThumbnail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberThumbnails")
    public JAXBElement<MemberThumbnail> createMemberThumbnails(MemberThumbnail value) {
        return new JAXBElement<MemberThumbnail>(_MemberThumbnails_QNAME, MemberThumbnail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MemberPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.optum.com/schema/cim/member/Member_v1_0", name = "MemberPayment")
    public JAXBElement<MemberPayment> createMemberPayment(MemberPayment value) {
        return new JAXBElement<MemberPayment>(_MemberPayment_QNAME, MemberPayment.class, null, value);
    }

}
