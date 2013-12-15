
/**
 * DiscoveryAPICallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.seatwave.api.v2;

    /**
     *  DiscoveryAPICallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DiscoveryAPICallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DiscoveryAPICallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DiscoveryAPICallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getEventGroupsForCategory method
            * override this method for handling normal response from getEventGroupsForCategory operation
            */
           public void receiveResultgetEventGroupsForCategory(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventGroupsForCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventGroupsForCategory operation
           */
            public void receiveErrorgetEventGroupsForCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGenreByID method
            * override this method for handling normal response from getGenreByID operation
            */
           public void receiveResultgetGenreByID(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetGenreByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGenreByID operation
           */
            public void receiveErrorgetGenreByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventByID method
            * override this method for handling normal response from getEventByID operation
            */
           public void receiveResultgetEventByID(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventByID operation
           */
            public void receiveErrorgetEventByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLayoutByID method
            * override this method for handling normal response from getLayoutByID operation
            */
           public void receiveResultgetLayoutByID(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetLayoutByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLayoutByID operation
           */
            public void receiveErrorgetLayoutByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventsForCategory method
            * override this method for handling normal response from getEventsForCategory operation
            */
           public void receiveResultgetEventsForCategory(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventsForCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventsForCategory operation
           */
            public void receiveErrorgetEventsForCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPopularEventsForGenre method
            * override this method for handling normal response from getPopularEventsForGenre operation
            */
           public void receiveResultgetPopularEventsForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPopularEventsForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPopularEventsForGenre operation
           */
            public void receiveErrorgetPopularEventsForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventsForVenue method
            * override this method for handling normal response from getEventsForVenue operation
            */
           public void receiveResultgetEventsForVenue(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventsForVenueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventsForVenue operation
           */
            public void receiveErrorgetEventsForVenue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVenueByID method
            * override this method for handling normal response from getVenueByID operation
            */
           public void receiveResultgetVenueByID(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetVenueByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVenueByID operation
           */
            public void receiveErrorgetVenueByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPopularEventsForCategory method
            * override this method for handling normal response from getPopularEventsForCategory operation
            */
           public void receiveResultgetPopularEventsForCategory(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPopularEventsForCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPopularEventsForCategory operation
           */
            public void receiveErrorgetPopularEventsForCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFeaturedEventGroupsForCategory method
            * override this method for handling normal response from getFeaturedEventGroupsForCategory operation
            */
           public void receiveResultgetFeaturedEventGroupsForCategory(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetFeaturedEventGroupsForCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFeaturedEventGroupsForCategory operation
           */
            public void receiveErrorgetFeaturedEventGroupsForCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for venuesSearch method
            * override this method for handling normal response from venuesSearch operation
            */
           public void receiveResultvenuesSearch(
                    com.seatwave.api.v2.DiscoveryAPIStub.VenuesSearchResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from venuesSearch operation
           */
            public void receiveErrorvenuesSearch(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTicketGroupsByEvent method
            * override this method for handling normal response from getTicketGroupsByEvent operation
            */
           public void receiveResultgetTicketGroupsByEvent(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetTicketGroupsByEventResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTicketGroupsByEvent operation
           */
            public void receiveErrorgetTicketGroupsByEvent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventsForGenre method
            * override this method for handling normal response from getEventsForGenre operation
            */
           public void receiveResultgetEventsForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventsForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventsForGenre operation
           */
            public void receiveErrorgetEventsForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPopularEventGroupsForGenre method
            * override this method for handling normal response from getPopularEventGroupsForGenre operation
            */
           public void receiveResultgetPopularEventGroupsForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPopularEventGroupsForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPopularEventGroupsForGenre operation
           */
            public void receiveErrorgetPopularEventGroupsForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPopularEventGroups method
            * override this method for handling normal response from getPopularEventGroups operation
            */
           public void receiveResultgetPopularEventGroups(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPopularEventGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPopularEventGroups operation
           */
            public void receiveErrorgetPopularEventGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUpdatedEvents method
            * override this method for handling normal response from getUpdatedEvents operation
            */
           public void receiveResultgetUpdatedEvents(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetUpdatedEventsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUpdatedEvents operation
           */
            public void receiveErrorgetUpdatedEvents(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFeaturedCategoriesForGenre method
            * override this method for handling normal response from getFeaturedCategoriesForGenre operation
            */
           public void receiveResultgetFeaturedCategoriesForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetFeaturedCategoriesForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFeaturedCategoriesForGenre operation
           */
            public void receiveErrorgetFeaturedCategoriesForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventGroupsForVenue method
            * override this method for handling normal response from getEventGroupsForVenue operation
            */
           public void receiveResultgetEventGroupsForVenue(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventGroupsForVenueResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventGroupsForVenue operation
           */
            public void receiveErrorgetEventGroupsForVenue(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCategoryByID method
            * override this method for handling normal response from getCategoryByID operation
            */
           public void receiveResultgetCategoryByID(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetCategoryByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCategoryByID operation
           */
            public void receiveErrorgetCategoryByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventsForEventGroup method
            * override this method for handling normal response from getEventsForEventGroup operation
            */
           public void receiveResultgetEventsForEventGroup(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventsForEventGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventsForEventGroup operation
           */
            public void receiveErrorgetEventsForEventGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPopularEventGroupsForCategory method
            * override this method for handling normal response from getPopularEventGroupsForCategory operation
            */
           public void receiveResultgetPopularEventGroupsForCategory(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPopularEventGroupsForCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPopularEventGroupsForCategory operation
           */
            public void receiveErrorgetPopularEventGroupsForCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUpdatedEventGroups method
            * override this method for handling normal response from getUpdatedEventGroups operation
            */
           public void receiveResultgetUpdatedEventGroups(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetUpdatedEventGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUpdatedEventGroups operation
           */
            public void receiveErrorgetUpdatedEventGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCategoriesForGenre method
            * override this method for handling normal response from getCategoriesForGenre operation
            */
           public void receiveResultgetCategoriesForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetCategoriesForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCategoriesForGenre operation
           */
            public void receiveErrorgetCategoriesForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVenuesForGenre method
            * override this method for handling normal response from getVenuesForGenre operation
            */
           public void receiveResultgetVenuesForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetVenuesForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVenuesForGenre operation
           */
            public void receiveErrorgetVenuesForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventGroupByID method
            * override this method for handling normal response from getEventGroupByID operation
            */
           public void receiveResultgetEventGroupByID(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventGroupByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventGroupByID operation
           */
            public void receiveErrorgetEventGroupByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVenuesForEventGroup method
            * override this method for handling normal response from getVenuesForEventGroup operation
            */
           public void receiveResultgetVenuesForEventGroup(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetVenuesForEventGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVenuesForEventGroup operation
           */
            public void receiveErrorgetVenuesForEventGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getVenuesForCategory method
            * override this method for handling normal response from getVenuesForCategory operation
            */
           public void receiveResultgetVenuesForCategory(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetVenuesForCategoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getVenuesForCategory operation
           */
            public void receiveErrorgetVenuesForCategory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDomains method
            * override this method for handling normal response from getDomains operation
            */
           public void receiveResultgetDomains(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetDomainsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDomains operation
           */
            public void receiveErrorgetDomains(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for eventsSearch method
            * override this method for handling normal response from eventsSearch operation
            */
           public void receiveResulteventsSearch(
                    com.seatwave.api.v2.DiscoveryAPIStub.EventsSearchResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from eventsSearch operation
           */
            public void receiveErroreventsSearch(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for eventGroupsSearch method
            * override this method for handling normal response from eventGroupsSearch operation
            */
           public void receiveResulteventGroupsSearch(
                    com.seatwave.api.v2.DiscoveryAPIStub.EventGroupsSearchResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from eventGroupsSearch operation
           */
            public void receiveErroreventGroupsSearch(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCategories method
            * override this method for handling normal response from getCategories operation
            */
           public void receiveResultgetCategories(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetCategoriesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCategories operation
           */
            public void receiveErrorgetCategories(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPopularEvents method
            * override this method for handling normal response from getPopularEvents operation
            */
           public void receiveResultgetPopularEvents(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPopularEventsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPopularEvents operation
           */
            public void receiveErrorgetPopularEvents(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFeaturedEventGroupsForGenre method
            * override this method for handling normal response from getFeaturedEventGroupsForGenre operation
            */
           public void receiveResultgetFeaturedEventGroupsForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetFeaturedEventGroupsForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFeaturedEventGroupsForGenre operation
           */
            public void receiveErrorgetFeaturedEventGroupsForGenre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getFeaturedEventGroups method
            * override this method for handling normal response from getFeaturedEventGroups operation
            */
           public void receiveResultgetFeaturedEventGroups(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetFeaturedEventGroupsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getFeaturedEventGroups operation
           */
            public void receiveErrorgetFeaturedEventGroups(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getGenres method
            * override this method for handling normal response from getGenres operation
            */
           public void receiveResultgetGenres(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetGenresResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getGenres operation
           */
            public void receiveErrorgetGenres(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPriceBreakdown method
            * override this method for handling normal response from getPriceBreakdown operation
            */
           public void receiveResultgetPriceBreakdown(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetPriceBreakdownResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPriceBreakdown operation
           */
            public void receiveErrorgetPriceBreakdown(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTicketTypesByEvent method
            * override this method for handling normal response from getTicketTypesByEvent operation
            */
           public void receiveResultgetTicketTypesByEvent(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetTicketTypesByEventResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTicketTypesByEvent operation
           */
            public void receiveErrorgetTicketTypesByEvent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEventGroupsForGenre method
            * override this method for handling normal response from getEventGroupsForGenre operation
            */
           public void receiveResultgetEventGroupsForGenre(
                    com.seatwave.api.v2.DiscoveryAPIStub.GetEventGroupsForGenreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEventGroupsForGenre operation
           */
            public void receiveErrorgetEventGroupsForGenre(java.lang.Exception e) {
            }
                


    }
    