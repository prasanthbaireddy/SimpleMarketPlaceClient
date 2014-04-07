/**
 * MarketService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.sjsu.cmpe273;

public interface MarketService extends java.rmi.Remote {
    public java.lang.String getProductName(int id) throws java.rmi.RemoteException;
    public boolean signUp(java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public boolean updatePurchase(int id, int quantity, java.lang.String email) throws java.rmi.RemoteException;
    public java.lang.String postAdvertisement(java.lang.String productName, java.lang.String description, java.lang.String sellerInfo, int quantity, double price, java.lang.String owner) throws java.rmi.RemoteException;
    public java.lang.String getAdvertisements() throws java.rmi.RemoteException;
    public boolean updateProductQuantity(int quantity, int id) throws java.rmi.RemoteException;
    public java.lang.String loginAuthenticate(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getPurchasedItems(java.lang.String email) throws java.rmi.RemoteException;
}
