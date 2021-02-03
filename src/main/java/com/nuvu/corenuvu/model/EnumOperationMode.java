package com.nuvu.corenuvu.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumOperationMode {
	PRODUCTION("Production"), DEMO("Demo");
	
	private String mode;
	
	private EnumOperationMode(final String mode) {
		this.mode = mode;
	}
	
	@JsonValue
	public String getMode() {
		return mode;
	}


}
