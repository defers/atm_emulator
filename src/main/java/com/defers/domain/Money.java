package com.defers.domain;

import java.util.HashMap;
import java.util.Map;

public abstract class Money<T extends Enum> {
    private Map<T, Integer> moneyMap = new HashMap<>();

    public void put(T billType, int sum) {
        moneyMap.merge(billType, sum, Integer::sum);
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

    protected void decreaseBillQuantity(T billType, int quantity) {
        int value = moneyMap.get(billType);

        if (quantity > value) {
            throw new RuntimeException("Количество банкнот больше, чем есть в наличии");
        }

        moneyMap.put(billType, value - quantity);
        if (value == 0) {
            getMoneyMap().remove(billType);
        }
    }

    public abstract int getBalance();

}
