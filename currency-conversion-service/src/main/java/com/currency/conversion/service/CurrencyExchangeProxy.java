/**
 * 
 */
package com.currency.conversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 504703
 *
 */
//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to")String to) ;
}
