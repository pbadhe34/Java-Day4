package com.org;

public final class Currency {

    private final String value;
    
    private Currency(String currencyValue) {
        value = currencyValue;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String newval) {
         // value= newval;//Cannot re-assign 
    }
    
    //public way of creating new instance
    public static Currency of(String value) {
        return new Currency(value);
    }
}
