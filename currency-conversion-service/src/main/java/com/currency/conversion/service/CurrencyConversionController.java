/**
 * 
 */
package com.currency.conversion.service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 504703
 *
 */
@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping(path="/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveCurrencyConvert(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		//CurrencyConversion currencyConv = new CurrencyConversion(10001L, from, to, BigDecimal.valueOf(100.0),quantity, port);
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = 
							new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
									CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversionResponse = responseEntity.getBody();
		
		return new CurrencyConversion(currencyConversionResponse.getId(),
				from, to, quantity, currencyConversionResponse.getConversionMultiple(),
				quantity.multiply(currencyConversionResponse.getConversionMultiple()),
				currencyConversionResponse.getEnvironment());
	}
	
	@GetMapping(path="/currency-conversion-openfeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveCurrencyConvertUsingOpenFeign(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		CurrencyConversion currencyConversionResponse = currencyExchangeProxy.retrieveExchangeValue(from, to);
		return new CurrencyConversion(currencyConversionResponse.getId(),
				from, to, quantity, currencyConversionResponse.getConversionMultiple(),
				quantity.multiply(currencyConversionResponse.getConversionMultiple()),
				currencyConversionResponse.getEnvironment());
	}
}
