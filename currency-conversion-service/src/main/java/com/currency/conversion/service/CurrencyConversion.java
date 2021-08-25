/**
 * 
 */
package com.currency.conversion.service;

import java.math.BigDecimal;

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
public class CurrencyConversion {
	@Getter @Setter private Long id;
	@Getter @Setter private String from;
	@Getter @Setter private String to;
	@Getter @Setter private BigDecimal conversionMultiple;
	@Getter @Setter private BigDecimal quantity;
	@Getter @Setter private BigDecimal totalValue;
	@Getter @Setter private String environment;
}
