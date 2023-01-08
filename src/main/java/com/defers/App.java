package com.defers;

import com.defers.domain.Atm;
import com.defers.domain.AtmImpl;
import com.defers.domain.Money;
import com.defers.domain.MoneyRub;

public class App
{
    public static void main( String... args )
    {
        Atm rubAtm = new AtmImpl(new MoneyRub());
        Money money = new MoneyRub();
        money.put(MoneyRub.BillTypeRub.Rub1000, 3);

        rubAtm.put(money);

        var balance = rubAtm.balance();
        System.out.println(balance);

        Money money2 = new MoneyRub();
        money2.put(MoneyRub.BillTypeRub.Rub500, 3);
        rubAtm.put(money2);

        System.out.println(rubAtm.balance());

    }
}
