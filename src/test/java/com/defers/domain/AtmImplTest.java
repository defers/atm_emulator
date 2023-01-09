package com.defers.domain;

import com.defers.exceptions.BillsException;
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
        money.put(MoneyRub.BillTypeRub.Rub5000, 2);
        money.put(MoneyRub.BillTypeRub.Rub1000, 2);
        money.put(MoneyRub.BillTypeRub.Rub500, 3);
        atm.put(money);

        int expected = 13500;

        assertEquals(expected, atm.get(expected).getBalance());
    }

    @Test(expected = BillsException.class)
    public void getBillsException() {
        money.put(MoneyRub.BillTypeRub.Rub5000, 2);
        money.put(MoneyRub.BillTypeRub.Rub1000, 2);
        atm.put(money);

        int expected = 20000;

        assertEquals(expected, atm.get(expected).getBalance());
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