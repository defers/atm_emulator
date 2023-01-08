package com.defers.domain;

import java.math.BigDecimal;

public interface Atm {
    void put(Money money);
    Money get(Integer sum);
    Integer balance();
}
