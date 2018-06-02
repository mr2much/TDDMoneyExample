package com.lockward;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        testEquality();
        testMultiplication();
        testSimpleAddition();
        testMixedAddition();
        testPlusReturnsSum();
        testReduceSum();
        testReduceMoney();
        testReduceMoneyDifferentCurrency();
        testCurrency();
        testIdentityRate();
        System.out.println("Finished testing");
    }

    public static void testMultiplication() {
        Money five = Money.dollar(5);
        assert (Money.dollar(10).equals(five.times(2))) : "amount not equal to 10 dollars";
        assert (Money.dollar(15).equals(five.times(3))) : "amount not equal to 15 dollars";
    }

    public static void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assert Money.dollar(10).equals(reduced) : "10 USD equals to 10 USD";
    }

    public static void testMixedAddition() {
        Money fiveBucks = Money.dollar(5);
        Money tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assert Money.dollar(10).equals(result) : "5 Dollars plus 10 Francs should equal 10 Dollars, got: " +
                result.toString();
    }

    public static void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assert five.equals(sum.augend);
        assert five.equals(sum.addend);
    }

    public static void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assert Money.dollar(7).equals(result) : "7 USD equals 7 USD";
    }

    public static void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assert Money.dollar(1).equals(result);
    }

    public static void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assert Money.dollar(1).equals(result);
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

    public static void testIdentityRate() {
        assert 1 == new Bank().rate("USD", "USD") : "1 Dollar equals 1 Dollar";
    }
}
