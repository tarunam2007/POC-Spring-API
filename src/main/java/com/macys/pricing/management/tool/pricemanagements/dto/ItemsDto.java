package com.macys.pricing.management.tool.pricemanagements.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ItemsDto {
	@NotNull
	private Integer itemNum;
	@NotNull
	private String itemName;
	@NotNull
	private BigDecimal itemPrice;
	private Integer location;
	private String analyticsInfo;
	private String merchantDecision;
}
