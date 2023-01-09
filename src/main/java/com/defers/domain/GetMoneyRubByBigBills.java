package com.defers.domain;

import com.defers.exceptions.BillsException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetMoneyRubByBigBills implements GetMoneyLogic {

    @Override
    public Money getMoney(int sum, Money<MoneyRub.BillTypeRub> moneyFrom) {

        List<Map.Entry<MoneyRub.BillTypeRub, Integer>> entryList = sortAndGetEntryList(moneyFrom);
        Money<MoneyRub.BillTypeRub> moneyTo = new MoneyRub();

        for (Map.Entry<MoneyRub.BillTypeRub, Integer> entry : entryList) {

            sum = transferMoney(entry, moneyFrom, moneyTo, sum);

        }

        if (sum > 0) {
            throw new BillsException("Нет нужных купюр к выдаче");
        }

        return moneyTo;
    }

    private List<Map.Entry<MoneyRub.BillTypeRub, Integer>> sortAndGetEntryList(Money<MoneyRub.BillTypeRub> money) {
        return money.getMoneyMap()
                .entrySet()//moneyMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getKey().getSum() - o1.getKey().getSum())
                .collect(Collectors.toList());
    }

    private int transferMoney(Map.Entry<MoneyRub.BillTypeRub, Integer> entry,
                          Money<MoneyRub.BillTypeRub> moneyFrom,
                          Money<MoneyRub.BillTypeRub> moneyTo,
                               int sum) {

        var billType = entry.getKey();
        var billQuantity = entry.getValue();
        var billValue = billType.getSum();
        int res = sum / billValue;

        if (res > 0 && sum > 0) {
            int quantity = Math.min(res, billQuantity);
            sum -= (quantity * billValue);

            moneyFrom.decreaseBillQuantity(billType, quantity);
            moneyTo.put(billType, quantity);

            if (sum < 0) {
                throw new BillsException("Выдано больше купюр, чем нужно");
            }
        }
     return sum;
    }
}
