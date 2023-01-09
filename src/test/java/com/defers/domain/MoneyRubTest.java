package com.defers.domain;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class MoneyRubTest {

    Money money;

    @Before
    public void setUp() {
        money = new MoneyRub();
    }

    @Test
    public void putMoney500Quantity3() {
        money.put(MoneyRub.BillTypeRub.Rub500, 3);

        int expected = 500 * 3;

        assertEquals(expected, money.getBalance());
    }

    @Test
    public void putMoney500Quantity3AndMoney1000Quantity2() {
        money.put(MoneyRub.BillTypeRub.Rub500, 3);
        money.put(MoneyRub.BillTypeRub.Rub1000, 2);

        int expected = (500 * 3) + (1000 * 2);

        assertEquals(expected, money.getBalance());
    }

    @Test
    public void putMoney500Quantity3AndMoney1000Quantity2AndMoney500Quantity1() {
        money.put(MoneyRub.BillTypeRub.Rub500, 3);
        money.put(MoneyRub.BillTypeRub.Rub1000, 2);
        money.put(MoneyRub.BillTypeRub.Rub500, 1);

        int expected = (500 * 3) + (1000 * 2) + (500 * 1);

        assertEquals(expected, money.getBalance());
    }

    @Test
    public void getMoneyMap() {
        money.put(MoneyRub.BillTypeRub.Rub500, 3);
        money.put(MoneyRub.BillTypeRub.Rub1000, 2);

        var moneyMap = money.getMoneyMap();

        List<String> result = (List) moneyMap
                .keySet()
                .stream()
                .map(e -> e.toString())
                .collect(Collectors.toList());

        assertThat(result, hasSize(2));

    }

}