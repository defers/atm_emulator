package com.defers.domain;

public class AtmImpl implements Atm {

    private Money moneyAtm;

    public AtmImpl(Money moneyAtm) {
        this.moneyAtm = moneyAtm;
    }

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
