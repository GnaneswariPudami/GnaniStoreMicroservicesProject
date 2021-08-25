/**
 * 
 */
package com.currency.exchange.service;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 504703
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CurrencyExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@Column(name = "fromCurrency")
	@Getter @Setter private String from;
	
	@Column(name = "toCurrency")
	@Getter @Setter private String to;
	
	@Getter @Setter private BigDecimal conversionMultiple;
	@Getter @Setter private String environment;
}
