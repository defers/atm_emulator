package com.defers.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetMoneyRubByBigBills implements GetMoneyLogic {

    @Override
    public Money getMoney(int sum,
                          Money<MoneyRub.BillTypeRub> money) {

        List<Map.Entry<MoneyRub.BillTypeRub, Integer>> entryList = sortAndGetEntryList(money);

        for (Map.Entry<MoneyRub.BillTypeRub, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " " + entry.getValue());

            var billType = entry.getKey();
            var billQuantity = entry.getValue();
            var billValue = billType.getSum();
            int res = sum / billValue;

            if (res > 0 && sum > 0) {
                int quantity = Math.min(res, billQuantity);
                sum -= (quantity * billValue);

                money.decreaseBillQuantity(billType, quantity);

                if (sum < 0) {
                    throw new RuntimeException("Выдано больше купюр, чем нужно");
                }
            }
            System.out.println(billType + " " + sum);
            System.out.println(billType + " " + money.getMoneyMap().get(billType));

        }

        if (sum > 0) {
            throw new RuntimeException("Нет нужных купюр к выдаче");
        }

        return new MoneyRub();
    }

    private List<Map.Entry<MoneyRub.BillTypeRub, Integer>> sortAndGetEntryList(Money<MoneyRub.BillTypeRub> money) {
        return money.getMoneyMap()
                .entrySet()//moneyMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getKey().getSum() - o1.getKey().getSum())
                .collect(Collectors.toList());
    }
}
