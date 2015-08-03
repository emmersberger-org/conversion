package org.emmersberger.currency;

import org.emmersberger.currency.converter.CurrencyConversionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConversionContext.class)
public class ConversionContextTest {

  @Autowired
  CurrencyConversionService currencyConversionService;

  @Test
  public void testSuccessfulCurrencyConversionService() {
    Currency currency = currencyConversionService.convert(Locale.GERMANY, Currency.class);
    assertNotNull("Currency must not be null", currency);
    assertTrue("", currency.getCurrencyCode().equals("EUR"));
  }

  @Test
  public void testFailedCurrencyConversionService() {
    try {
      currencyConversionService.convert(Locale.GERMAN, Currency.class);
    } catch (Exception ex) {
      if (ex instanceof ConversionFailedException && ex.getCause() instanceof IllegalArgumentException) {
        assertEquals("Exception cause message does not meet the expectation",
            "Locale for language [de] does not contain a country information",
            ex.getCause().getMessage());
      }
    }
  }
}