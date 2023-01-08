package com.defers.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmImplTest {

    Atm atm;
    Money money;

    @Before
    public void setup() {
        atm = new AtmImpl(new MoneyRub());
        money = new MoneyRub();
    }

    @Test
    public void put() {
        money.put(MoneyRub.BillTypeRub.Rub100, 7);
        atm.put(money);

        Integer expected = 100 * 7;

        assertEquals(expected, atm.balance());

    }

    @Test
    public void get() {
//        money.put(MoneyRub.BillTypeRub.Rub5000, 5);
//        money.put(MoneyRub.BillTypeRub.Rub1000, 2);
//        atm.put(money);
//
//        Integer expected = 5000; // TODO
//
//        assertEquals(expected, atm.get(5000));
    }

    @Test
    public void balance() {
        money.put(MoneyRub.BillTypeRub.Rub5000, 5);
        money.put(MoneyRub.BillTypeRub.Rub1000, 2);
        atm.put(money);

        Integer expected = (5000 * 5) + (1000 * 2);

        assertEquals(expected, atm.balance());
    }
}