package com.umbreak.europe.vies.api;

import com.umbreak.europe.vies.api.exception.EuropeanVatApiException;

import javax.xml.ws.Holder;

/**
 * This class provides an API connection to VIES (VAT Information Exchange System)
 * Created by didac on 27.04.16.
 */
public class EuropeanVat {

    /**
     * Check VAT number
     * @param vatNumberWithCountryCode VAT number containing country code prefix. E.g. ESXXXXXX
     * @return true if correct, false otherwise
     * @throws EuropeanVatApiException if the VIES API throws an exception. Might be related with country code invalid or with a connection issue.
     */
    public static boolean isVatValid(String vatNumberWithCountryCode) throws EuropeanVatApiException {
        String countryCode=vatNumberWithCountryCode.substring(0,2);
        String vatNumber=vatNumberWithCountryCode.substring(2);
        return isVatValid(vatNumber, countryCode);
    }

    /**
     * Check VAT number
     * @param vatNumber VAT number
     * @param countryCode country code.
     * @return true if correct, false otherwise
     * @throws EuropeanVatApiException if the VIES API throws an exception. Might be related with country code invalid or with a connection issue.
     */
    public static boolean isVatValid(String vatNumber, String countryCode) throws EuropeanVatApiException {
        Holder<Boolean> responseValidityCallback=generateHolder(false);
        try {
            EuropeanVatService.getAPI().checkVat(
                    generateHolder(countryCode),
                    generateHolder(vatNumber),
                    null,
                    responseValidityCallback,
                    null,
                    null);
            return (responseValidityCallback.value == true);
        }catch(Exception ex){
            throw new EuropeanVatApiException(ex.getMessage());
        }
    }

    //----------------------------- private methods ------------------------//

    private static <T> Holder<T> generateHolder(T value){
        return new Holder<>(value);
    }

}
