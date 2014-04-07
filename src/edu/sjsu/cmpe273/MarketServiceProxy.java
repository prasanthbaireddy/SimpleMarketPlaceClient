package edu.sjsu.cmpe273;

public class MarketServiceProxy implements edu.sjsu.cmpe273.MarketService {
  private String _endpoint = null;
  private edu.sjsu.cmpe273.MarketService marketService = null;
  
  public MarketServiceProxy() {
    _initMarketServiceProxy();
  }
  
  public MarketServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMarketServiceProxy();
  }
  
  private void _initMarketServiceProxy() {
    try {
      marketService = (new edu.sjsu.cmpe273.MarketServiceServiceLocator()).getMarketService();
      if (marketService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)marketService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)marketService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (marketService != null)
      ((javax.xml.rpc.Stub)marketService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.sjsu.cmpe273.MarketService getMarketService() {
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService;
  }
  
  public boolean signUp(java.lang.String firstName, java.lang.String lastName, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.signUp(firstName, lastName, email, password);
  }
  
  public java.lang.String postAdvertisement(java.lang.String productName, java.lang.String description, java.lang.String sellerInfo, int quantity, double price, java.lang.String owner) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.postAdvertisement(productName, description, sellerInfo, quantity, price, owner);
  }
  
  public java.lang.String getAdvertisements() throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.getAdvertisements();
  }
  
  public boolean updateProductQuantity(int quantity, int id) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.updateProductQuantity(quantity, id);
  }
  
  public java.lang.String loginAuthenticate(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.loginAuthenticate(email, password);
  }
  
  public java.lang.String getProductName(int id) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.getProductName(id);
  }
  
  public boolean updatePurchase(int id, int quantity, java.lang.String email) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.updatePurchase(id, quantity, email);
  }
  
  public java.lang.String getPurchasedItems(java.lang.String email) throws java.rmi.RemoteException{
    if (marketService == null)
      _initMarketServiceProxy();
    return marketService.getPurchasedItems(email);
  }
  
  
}