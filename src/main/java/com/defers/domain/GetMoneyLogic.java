package com.defers.domain;

import java.util.Map;

@FunctionalInterface
public interface GetMoneyLogic {
    Money getMoney(int sum, Money<MoneyRub.BillTypeRub> money);
}
