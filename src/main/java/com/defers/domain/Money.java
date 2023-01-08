package com.defers.domain;

import java.util.HashMap;
import java.util.Map;

public abstract class Money<T> {
    private Map<T, Integer> moneyMap = new HashMap();

    public void put(T billType, Integer sum) {
        Integer value = moneyMap.get(billType);
        if (value == null) {
            moneyMap.put(billType, sum);
        }
        else {
            moneyMap.put(billType, value + sum);
        }
    }

    public void put(Money anotherMoney) {
        Map<T, Integer> anotherMoneyMap = anotherMoney.getMoneyMap();

        anotherMoneyMap.entrySet()
                .stream()
                .forEach(e -> put(e.getKey(), e.getValue()));
    }

    Map<T, Integer> getMoneyMap() {
        return moneyMap;
    }

    public abstract Integer getBalance();

}
