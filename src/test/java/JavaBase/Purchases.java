package JavaBase;

import java.util.ArrayList;
import java.util.List;

public class Purchases {
    public static void main(String[] args) {
        calculatePurchases();
    }

    public static void calculatePurchases() {
        double budget = 2222;
        double sum = 0;
        int bought = 0;
        int i = 0;

        List<Double> prices = new ArrayList<>();
        prices.add(199.99);
        prices.add(1959.99);
        prices.add(111.01);
        prices.add(249.01);
        prices.add(29.01);

        while (i < prices.size() && prices.get(i) <= budget - sum) {
            sum += prices.get(i);
            bought++;
            i++;
        }
        System.out.println("Куплено: " + bought + " товара на сумму " + sum);
        System.out.println("Остаток бюджета: " + (budget - sum));
        System.out.println("Не куплено: " + (prices.size() - bought) + " товара");
    }
}