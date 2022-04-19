package Lesson3;

import java.util.HashMap;
import java.util.Map;

public class UniqueWord {

    public static void main(String[] args) {
        String[] dublicateArray = {"A", "B", "C", "A", "A", "D", "E", "D", "F", "E", "B", "A", "D"};

        Map<String, Integer> numberOfElements = new HashMap<>();

        for (String element : dublicateArray) {

            int amount = numberOfElements.getOrDefault(element, 0) + 1;
            numberOfElements.put(element, amount);
        }

        for (Map.Entry<String, Integer> result : numberOfElements.entrySet()) {
            System.out.println(result.getKey() + " is found " + result.getValue() + " times.");
        }
    }
}
