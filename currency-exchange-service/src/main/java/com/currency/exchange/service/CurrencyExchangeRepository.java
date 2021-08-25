/**
 * 
 */
package com.currency.exchange.service;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 504703
 *
 */
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	public CurrencyExchange findByFromAndTo(String from, String to);
}
