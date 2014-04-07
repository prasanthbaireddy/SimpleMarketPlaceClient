/**
 * MarketServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.sjsu.cmpe273;

public interface MarketServiceService extends javax.xml.rpc.Service {
    public java.lang.String getMarketServiceAddress();

    public edu.sjsu.cmpe273.MarketService getMarketService() throws javax.xml.rpc.ServiceException;

    public edu.sjsu.cmpe273.MarketService getMarketService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
