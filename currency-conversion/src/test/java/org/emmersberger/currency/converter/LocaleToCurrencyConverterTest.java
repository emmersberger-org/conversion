package org.emmersberger.currency.converter;

import org.junit.Before;
import org.junit.Test;

import java.util.Currency;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LocaleToCurrencyConverterTest {

  private LocaleToCurrencyConverter localeToCurrencyConverter;

  @Before
  public void setUp() {
    localeToCurrencyConverter = new LocaleToCurrencyConverter();
  }

  @Test
  public void testLocaleUStoCurrency() {
    Currency result = localeToCurrencyConverter.convert(Locale.US);

    assertNotNull("Result may not be null", result);
    assertEquals("CurrencyCode did not meet the expectation", "USD", result.getCurrencyCode());
  }

  @Test
  public void testLocaleUKtoCurrency() {
    Currency result = localeToCurrencyConverter.convert(Locale.UK);

    assertNotNull("Result may not be null", result);
    assertEquals("CurrencyCode did not meet the expectation", "GBP", result.getCurrencyCode());
  }

  @Test
  public void testLocaleENGLISHtoCurrency() {
    Currency result = null;
    try {
      result = localeToCurrencyConverter.convert(Locale.ENGLISH);
    } catch (Exception ex) {
      assertTrue("Exception is not an instance of IllegalArgumentException", ex instanceof IllegalArgumentException);
    }

    assertNull("Result must be null", result);
  }

  @Test
  public void testLocaleFRtoCurrency() {
    Currency result = localeToCurrencyConverter.convert(Locale.FRANCE);

    assertNotNull("Result may not be null", result);
    assertEquals("CurrencyCode did not meet the expectation", "EUR", result.getCurrencyCode());
  }

  @Test
  public void testLocaleCANADA_FRENCHtoCurrency() {
    Currency result = localeToCurrencyConverter.convert(Locale.CANADA_FRENCH);

    assertNotNull("Result may not be null", result);
    assertEquals("CurrencyCode did not meet the expectation", "CAD", result.getCurrencyCode());
  }

  @Test
  public void testLocaleFRENCHtoCurrency() {
    Currency result = null;
    try {
      result = localeToCurrencyConverter.convert(Locale.FRENCH);
    } catch (Exception ex) {
      assertTrue("Exception is not an instance of IllegalArgumentException", ex instanceof IllegalArgumentException);
    }

    assertNull("Result must be null", result);
  }

  @Test
  public void testLocaleGERMANtoCurrency() {
    Currency result = null;
    try {
      result = localeToCurrencyConverter.convert(Locale.GERMAN);
    } catch (Exception ex) {
      assertTrue("Exception is not an instance of IllegalArgumentException", ex instanceof IllegalArgumentException);
    }

    assertNull("Result must be null", result);
  }

  @Test
  public void testLocaleGERMANYToCurrency() {
    Currency result = localeToCurrencyConverter.convert(Locale.GERMANY);

    assertNotNull("Result may not be null", result);
    assertEquals("CurrencyCode did not meet the expectation", "EUR", result.getCurrencyCode());
  }
}