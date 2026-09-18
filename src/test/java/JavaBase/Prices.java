package JavaBase;

import java.util.ArrayList;
import java.util.List;

public class Prices {
    public static void main(String[] args) {
        calculatorPrice();
    }

    public static void calculatorPrice() {
        double budget = 10000;
        double sum = 0;
        List<Double> prices = new ArrayList<>();
        prices.add(199.99);
        prices.add(1959.99);
        prices.add(111.01);
        prices.add(249.01);
        prices.add(29.01);
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
        }
        if (budget >= sum) {
            System.out.println("Бюджета хватает. Остаток: " + (budget - sum));
        } else {
            System.out.println("Бюджета не хватает. Не хватает: " + (sum - budget));
        }
    }
}