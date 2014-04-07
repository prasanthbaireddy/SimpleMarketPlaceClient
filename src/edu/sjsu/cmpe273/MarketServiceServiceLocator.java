/**
 * MarketServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.sjsu.cmpe273;

public class MarketServiceServiceLocator extends org.apache.axis.client.Service implements edu.sjsu.cmpe273.MarketServiceService {

    public MarketServiceServiceLocator() {
    }


    public MarketServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MarketServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MarketService
    private java.lang.String MarketService_address = "http://localhost:8080/SimpleMarketPlace/services/MarketService";

    public java.lang.String getMarketServiceAddress() {
        return MarketService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MarketServiceWSDDServiceName = "MarketService";

    public java.lang.String getMarketServiceWSDDServiceName() {
        return MarketServiceWSDDServiceName;
    }

    public void setMarketServiceWSDDServiceName(java.lang.String name) {
        MarketServiceWSDDServiceName = name;
    }

    public edu.sjsu.cmpe273.MarketService getMarketService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MarketService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMarketService(endpoint);
    }

    public edu.sjsu.cmpe273.MarketService getMarketService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.sjsu.cmpe273.MarketServiceSoapBindingStub _stub = new edu.sjsu.cmpe273.MarketServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMarketServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMarketServiceEndpointAddress(java.lang.String address) {
        MarketService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.sjsu.cmpe273.MarketService.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.sjsu.cmpe273.MarketServiceSoapBindingStub _stub = new edu.sjsu.cmpe273.MarketServiceSoapBindingStub(new java.net.URL(MarketService_address), this);
                _stub.setPortName(getMarketServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("MarketService".equals(inputPortName)) {
            return getMarketService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://cmpe273.sjsu.edu", "MarketServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://cmpe273.sjsu.edu", "MarketService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MarketService".equals(portName)) {
            setMarketServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
