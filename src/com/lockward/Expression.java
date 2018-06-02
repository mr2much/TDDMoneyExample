package com.lockward;

public interface Expression {
    Money reduce(Bank bank, String to);
}
