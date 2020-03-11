package com.org;

//Immutabile class
public final class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
    
    public void setAmount(int num) {
    	//amount=num; cannot re-assign final values
    }
    
    public void setCurrency(Currency obj) {
           ///currency = obj; //cannot re-assign final values
    }
}
