package com.osm.finance_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentMethod {
    CASH, CHEQUE, TRANSFER;

    @JsonCreator
    public static PaymentMethod fromString(String value) {
        if (value == null) return null;
        return PaymentMethod.valueOf(value.trim().toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
} 