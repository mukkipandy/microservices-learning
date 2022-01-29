package com.learning.mukesh.currencyexchangeservice;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CurrencyExchange {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;

}
