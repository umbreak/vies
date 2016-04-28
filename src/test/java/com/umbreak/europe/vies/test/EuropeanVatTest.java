package com.umbreak.europe.vies.test;

import com.umbreak.europe.vies.api.EuropeanVat;
import com.umbreak.europe.vies.api.exception.EuropeanVatApiException;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by didac on 27.04.16.
 */
public class EuropeanVatTest {

    @Test
    public void testVat() throws EuropeanVatApiException {
        EuropeanVat europeanVat=new EuropeanVat();
        Assert.assertTrue(europeanVat.checkVat("270157501", "DE"));
        Assert.assertTrue(europeanVat.checkVat("DE270157501"));

        Assert.assertFalse(europeanVat.checkVat("270157502", "DE"));
        Assert.assertFalse(europeanVat.checkVat("4535454", "DE"));
    }

    @Test(expected=EuropeanVatApiException.class)
    public void testVatException() throws EuropeanVatApiException {
        EuropeanVat europeanVat=new EuropeanVat();
        europeanVat.checkVat("270157501", "A2");
    }
}
