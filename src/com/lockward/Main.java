package com.lockward;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        testMultiplication();
        testFrancMultiplication();
        testEquality();
        System.out.println("Finished testing");
    }

    public static void testMultiplication() {
        Money five = Money.dollar(5);
        assert (Money.dollar(10).equals(five.times(2))) : "amount not equal to 10";
        assert (Money.dollar(15).equals(five.times(3))) : "amount not equal to 15";
    }

    public static void testFrancMultiplication() {
        Franc five = new Franc(5);
        assert (new Franc(10).equals(five.times(2))) : "amount not equal to 10";
        assert (new Franc(15).equals(five.times(3))) : "amount not equal to 15";
    }

    public static void testEquality() {
        assert Money.dollar(5).equals(Money.dollar(5)) : "5 dollars not equal to 5 dollars";
        assert !(Money.dollar(5).equals(Money.dollar(6))) : "5 dollars is not equal to 6 dollars";
        assert new Franc(5).equals(new Franc(5)) : "5 francs not equal to 5 francs";
        assert !(new Franc(5).equals(new Franc(6))) : "5 francs is not equal to 6 francs";
        assert !(new Franc(5).equals(Money.dollar(5))) : "5 francs is not equal to 5 dollars";
    }
}
