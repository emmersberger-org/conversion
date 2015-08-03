package org.emmersberger.currency.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Currency;
import java.util.Locale;

/**
 * {@link LocaleToCurrencyConverter} converts a {@link Locale} object into a {@link Currency}.
 *
 * @author cemmersb
 */
final class LocaleToCurrencyConverter implements Converter<Locale, Currency> {

  /**
   * Logger instance.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LocaleToCurrencyConverter.class);

  /**
   * Converts a {@link Locale} object into a {@link Currency} object and provides  details about the successful
   * object instantiation.
   *
   * @param locale {@link Locale} must contain language and country information
   * @return {@link Currency} object that matches the locale information
   * @throws IllegalArgumentException to notify any upstream processes about the failed conversion
   */
  public Currency convert(Locale locale) throws IllegalArgumentException {
    LOGGER.debug("Converting locale [{}] to currency", locale);
    if (null != locale.getCountry() && !locale.getCountry().isEmpty()) {
      Currency currency = Currency.getInstance(locale);
      LOGGER.trace("Successfully converted locale [{}] to currency [{}]", locale, currency);
      return currency;
    }
    LOGGER.warn("Unable to assign a valid currency to locale [{}]", locale);
    throw new IllegalArgumentException(createExceptionMessage(locale));
  }

  /**
   * Generates the exception message based of a locale.
   *
   * @param locale {@link Locale} that did not meet the requirements for the conversion
   * @return exception message as {@link String} object
   */
  private String createExceptionMessage(Locale locale) {
    return "Locale for language [" + locale.getLanguage() + "] does not contain a country information";
  }
}