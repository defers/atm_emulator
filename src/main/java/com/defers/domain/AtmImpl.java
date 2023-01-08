package com.defers.domain;

public class AtmImpl implements Atm {

    private Money moneyAtm = new MoneyRub();

    @Override
    public void put(Money money) {
        moneyAtm.put(money);
    }

    @Override
    public Money get(Integer sum) {
        return moneyAtm;
    }

    @Override
    public Integer balance() {
        return moneyAtm.getBalance();
    }
}
