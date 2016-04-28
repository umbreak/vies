package com.umbreak.europe.vies.api;

import eu.europa.ec.taxud.vies.services.checkvat.CheckVatPortType;
import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;

import javax.xml.ws.BindingProvider;
import java.util.Map;

/**
 * Created by didac on 27.04.16.
 */
public enum EuropeanVatService {
    INSTANCE;
    private final CheckVatPortType checkVatAPI;

    //30seconds
    private final int requestTimeoutMillis=1000*30;
    private final String REQUEST_TIMEOUT="javax.xml.ws.client.receiveTimeout";

    //60 seconds
    private final int connectionTimeoutMillis=1000*60;
    private final String CONNECTION_TIMEOUT="javax.xml.ws.client.connectionTimeout";




    EuropeanVatService() {
        checkVatAPI=new CheckVatService().getCheckVatPort();
        Map<String, Object> apiRequestContext = ((BindingProvider) checkVatAPI).getRequestContext();
        apiRequestContext.put(REQUEST_TIMEOUT, requestTimeoutMillis);
        apiRequestContext.put(CONNECTION_TIMEOUT, connectionTimeoutMillis);
    }

    static CheckVatPortType getAPI() {
        return INSTANCE.checkVatAPI;
    }
}
