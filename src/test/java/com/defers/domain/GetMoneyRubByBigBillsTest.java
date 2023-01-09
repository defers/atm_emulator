package com.defers.domain;

import com.defers.exceptions.BillsException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetMoneyRubByBigBillsTest {
    GetMoneyLogic getMoneyRubByBigBills;
    Money<MoneyRub.BillTypeRub> moneyFrom;

    @Before
    public void setup() {
        getMoneyRubByBigBills = new GetMoneyRubByBigBills();
        moneyFrom = new MoneyRub();
    }

    @Test
    public void getMoney() {
        moneyFrom.put(MoneyRub.BillTypeRub.Rub1000, 3);
        moneyFrom.put(MoneyRub.BillTypeRub.Rub5000, 1);

        int expected = 7000;

        Money<MoneyRub.BillTypeRub> money = getMoneyRubByBigBills.getMoney(expected, moneyFrom);

        assertEquals(expected, money.getBalance());
    }

    @Test(expected = BillsException.class)
    public void getMoneyBillsException() {
        moneyFrom.put(MoneyRub.BillTypeRub.Rub1000, 3);
        moneyFrom.put(MoneyRub.BillTypeRub.Rub5000, 1);

        int expected = 9000;

        Money<MoneyRub.BillTypeRub> money = getMoneyRubByBigBills.getMoney(expected, moneyFrom);

        assertEquals(expected, money.getBalance());
    }
}