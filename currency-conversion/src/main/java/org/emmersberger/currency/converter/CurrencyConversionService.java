package org.emmersberger.currency.converter;

import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

/**
 * The CurrencyConversionService extends the {@link GenericConversionService} for Locale to Currency conversions.
 *
 * @author cemmersb
 */
@Service
public class CurrencyConversionService extends GenericConversionService {

  /**
   * Creates a new instance of the {@link GenericConversionService} and adds the {@link LocaleToCurrencyConverter}.
   */
  public CurrencyConversionService() {
    super();
    this.addConverter(new LocaleToCurrencyConverter());
  }
}
