package com.defers.domain;

@FunctionalInterface
public interface GetMoneyLogic {
    Money getMoney(int sum, Money<MoneyRub.BillTypeRub> money);
}
