
/**
 * HotelServicesImplServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.ean.wsapi.hotel.v3;

    /**
     *  HotelServicesImplServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HotelServicesImplServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HotelServicesImplServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HotelServicesImplServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getList method
            * override this method for handling normal response from getList operation
            */
           public void receiveResultgetList(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetListResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getList operation
           */
            public void receiveErrorgetList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCancellation method
            * override this method for handling normal response from getCancellation operation
            */
           public void receiveResultgetCancellation(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetCancellationResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCancellation operation
           */
            public void receiveErrorgetCancellation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAvailability method
            * override this method for handling normal response from getAvailability operation
            */
           public void receiveResultgetAvailability(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetAvailabilityResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAvailability operation
           */
            public void receiveErrorgetAvailability(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGeoLocation method
            * override this method for handling normal response from getGeoLocation operation
            */
           public void receiveResultgetGeoLocation(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetGeoLocationResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGeoLocation operation
           */
            public void receiveErrorgetGeoLocation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAlternateProperties method
            * override this method for handling normal response from getAlternateProperties operation
            */
           public void receiveResultgetAlternateProperties(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetAlternatePropertiesResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAlternateProperties operation
           */
            public void receiveErrorgetAlternateProperties(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getReservation method
            * override this method for handling normal response from getReservation operation
            */
           public void receiveResultgetReservation(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetReservationResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getReservation operation
           */
            public void receiveErrorgetReservation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRateRules method
            * override this method for handling normal response from getRateRules operation
            */
           public void receiveResultgetRateRules(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetRateRulesResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRateRules operation
           */
            public void receiveErrorgetRateRules(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getItinerary method
            * override this method for handling normal response from getItinerary operation
            */
           public void receiveResultgetItinerary(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetItineraryResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getItinerary operation
           */
            public void receiveErrorgetItinerary(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPaymentInfo method
            * override this method for handling normal response from getPaymentInfo operation
            */
           public void receiveResultgetPaymentInfo(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetPaymentInfoResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPaymentInfo operation
           */
            public void receiveErrorgetPaymentInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPing method
            * override this method for handling normal response from getPing operation
            */
           public void receiveResultgetPing(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetPingResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPing operation
           */
            public void receiveErrorgetPing(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInformation method
            * override this method for handling normal response from getInformation operation
            */
           public void receiveResultgetInformation(
                    com.ean.wsapi.hotel.v3.HotelServicesImplServiceStub.GetInformationResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInformation operation
           */
            public void receiveErrorgetInformation(java.lang.Exception e) {
            }
                


    }
    