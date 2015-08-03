package org.emmersberger.currency;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This ConversionContext provides all services and converters that are required to convert a {@link java.util.Locale}
 * object into a {@link java.util.Currency} object. The required services are pulled via component scan.
 *
 * @author cemmersb
 */
@Configuration
@ComponentScan(basePackages = {"org.emmersberger.currency.converter"})
public class ConversionContext {

  @Value(value = "ConversionContext")
  String applicationName;

}