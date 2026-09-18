package JavaBase;

import java.util.ArrayList;
import java.util.List;

public class Fruits {
    public static void main(String[] args) {
        fruitsList();
    }

    public static void fruitsList() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Груша");
        fruits.add("Апельсин");
        fruits.add("Ананас");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println((i + 1) + ". " + fruits.get(i));
        }
    }
}