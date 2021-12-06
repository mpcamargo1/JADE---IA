
package com.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CPS", targetNamespace = "http://service.com/", wsdlLocation = "http://localhost:8080/WebService/CPS?wsdl")
public class CPS_Service
    extends Service
{

    private final static URL CPS_WSDL_LOCATION;
    private final static WebServiceException CPS_EXCEPTION;
    private final static QName CPS_QNAME = new QName("http://service.com/", "CPS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebService/CPS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CPS_WSDL_LOCATION = url;
        CPS_EXCEPTION = e;
    }

    public CPS_Service() {
        super(__getWsdlLocation(), CPS_QNAME);
    }

    public CPS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CPS_QNAME, features);
    }

    public CPS_Service(URL wsdlLocation) {
        super(wsdlLocation, CPS_QNAME);
    }

    public CPS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CPS_QNAME, features);
    }

    public CPS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CPS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CPS
     */
    @WebEndpoint(name = "CPSPort")
    public CPS getCPSPort() {
        return super.getPort(new QName("http://service.com/", "CPSPort"), CPS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CPS
     */
    @WebEndpoint(name = "CPSPort")
    public CPS getCPSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.com/", "CPSPort"), CPS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CPS_EXCEPTION!= null) {
            throw CPS_EXCEPTION;
        }
        return CPS_WSDL_LOCATION;
    }

}