
/**
 * GardeServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package dao;

    /**
     *  GardeServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GardeServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GardeServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GardeServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getEtudiantParNom method
            * override this method for handling normal response from getEtudiantParNom operation
            */
           public void receiveResultgetEtudiantParNom(
                    dao.GardeServiceStub.GetEtudiantParNomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantParNom operation
           */
            public void receiveErrorgetEtudiantParNom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantParNomEtPrenom method
            * override this method for handling normal response from getEtudiantParNomEtPrenom operation
            */
           public void receiveResultgetEtudiantParNomEtPrenom(
                    dao.GardeServiceStub.GetEtudiantParNomEtPrenomResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantParNomEtPrenom operation
           */
            public void receiveErrorgetEtudiantParNomEtPrenom(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEtudiantParMatricule method
            * override this method for handling normal response from getEtudiantParMatricule operation
            */
           public void receiveResultgetEtudiantParMatricule(
                    dao.GardeServiceStub.GetEtudiantParMatriculeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEtudiantParMatricule operation
           */
            public void receiveErrorgetEtudiantParMatricule(java.lang.Exception e) {
            }
                


    }
    