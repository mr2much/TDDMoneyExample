package com.lockward;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        testEquality();
        testMultiplication();
        testCurrency();
        System.out.println("Finished testing");
    }

    public static void testMultiplication() {
        Money five = Money.dollar(5);
        assert (Money.dollar(10).equals(five.times(2))) : "amount not equal to 10 dollars";
        assert (Money.dollar(15).equals(five.times(3))) : "amount not equal to 15 dollars";
    }

    public static void testEquality() {
        assert Money.dollar(5).equals(Money.dollar(5)) : "5 dollars not equal to 5 dollars";
        assert !(Money.dollar(5).equals(Money.dollar(6))) : "5 dollars is not equal to 6 dollars";
        assert !(Money.franc(5).equals(Money.dollar(5))) : "5 francs is not equal to 5 dollars";
    }

    public static void testCurrency() {
        assert "USD".equals(Money.dollar(1).currency()) : "1 dollar equals 1 USD";
        assert "CHF".equals(Money.franc(1).currency()) : "1 franc equals 1 Franc";
    }
}
