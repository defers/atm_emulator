package com.defers.domain;

public class MoneyRub extends Money<MoneyRub.BillTypeRub> {

    @Override
    public int getBalance() {
        int balance = getMoneyMap().entrySet()
                .stream()
                .mapToInt(e -> e.getKey().getSum() * e.getValue())
                .sum();

        return balance;
    }

    public enum BillTypeRub {
        Rub100(100),
        Rub500(500),
        Rub1000(1000),
        Rub5000(5000);

        private final int sum;

        BillTypeRub(int sum) {
            this.sum = sum;
        }

        int getSum() {
            return this.sum;
        }
    }
}

