package com.defers.domain;

public class MoneyRub extends Money<MoneyRub.BillTypeRub>{

    public MoneyRub() {
        super();
    }

    public enum BillTypeRub {
        Rub100(100),
        Rub500(500),
        Rub1000(1000),
        Rub5000(5000);

        private final Integer sum;

        BillTypeRub(Integer sum) {
            this.sum = sum;
        }

        Integer getSum() {
            return this.sum;
        }
    }

    @Override
    public Integer getBalance() {
        Integer balance = getMoneyMap().entrySet()
                .stream()
                .mapToInt(e -> e.getKey().getSum() * e.getValue())
                .sum();

        return balance;
    }

}

