package com.defers.domain;

import java.math.BigDecimal;

public interface Atm {
    void put(Money money);
    Money get(int sum);
    Money get(int sum, GetMoneyLogic getMoneyLogic);
    Integer balance();
}
