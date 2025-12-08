
package com.smartcity.orchestrator.soapclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.smartcity.orchestrator.soapclient package. 
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

    private final static QName _AirQualityData_QNAME = new QName("http://service.airsoap.smartcity.com/", "AirQualityData");
    private final static QName _GetAirQualityByZone_QNAME = new QName("http://service.airsoap.smartcity.com/", "getAirQualityByZone");
    private final static QName _GetAirQualityByZoneResponse_QNAME = new QName("http://service.airsoap.smartcity.com/", "getAirQualityByZoneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.smartcity.orchestrator.soapclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AirQualityData }
     * 
     */
    public AirQualityData createAirQualityData() {
        return new AirQualityData();
    }

    /**
     * Create an instance of {@link GetAirQualityByZone }
     * 
     */
    public GetAirQualityByZone createGetAirQualityByZone() {
        return new GetAirQualityByZone();
    }

    /**
     * Create an instance of {@link GetAirQualityByZoneResponse }
     * 
     */
    public GetAirQualityByZoneResponse createGetAirQualityByZoneResponse() {
        return new GetAirQualityByZoneResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AirQualityData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AirQualityData }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.airsoap.smartcity.com/", name = "AirQualityData")
    public JAXBElement<AirQualityData> createAirQualityData(AirQualityData value) {
        return new JAXBElement<AirQualityData>(_AirQualityData_QNAME, AirQualityData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAirQualityByZone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAirQualityByZone }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.airsoap.smartcity.com/", name = "getAirQualityByZone")
    public JAXBElement<GetAirQualityByZone> createGetAirQualityByZone(GetAirQualityByZone value) {
        return new JAXBElement<GetAirQualityByZone>(_GetAirQualityByZone_QNAME, GetAirQualityByZone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAirQualityByZoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAirQualityByZoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.airsoap.smartcity.com/", name = "getAirQualityByZoneResponse")
    public JAXBElement<GetAirQualityByZoneResponse> createGetAirQualityByZoneResponse(GetAirQualityByZoneResponse value) {
        return new JAXBElement<GetAirQualityByZoneResponse>(_GetAirQualityByZoneResponse_QNAME, GetAirQualityByZoneResponse.class, null, value);
    }

}
