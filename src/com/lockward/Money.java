package com.lockward;

public abstract class Money {
    protected String currency;
    protected int amount;

    public String currency() { return currency; }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }
    public static Money franc(int amount) { return new Franc(amount, "CHF"); }

    public abstract Money times(int multiplier);

    @Override
    public boolean equals(Object o){
        Money money = (Money) o;
        return amount == money.amount && getClass().equals(money.getClass());
    }
}
