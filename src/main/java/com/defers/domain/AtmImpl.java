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
    public Integer balance() {
        return moneyAtm.getBalance();
    }

    @Override
    public Money get(int sum, GetMoneyLogic getMoneyLogic) {
        Money resultMoney = getMoneyLogic.getMoney(sum, moneyAtm);
        return resultMoney;
    }

    @Override
    public Money get(int sum) {
        return get(sum, new GetMoneyRubByBigBills());
    }
}
