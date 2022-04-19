package Lesson3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {

    Map <String, Set<String>> phoneAndName = new TreeMap<>();

    public void add(String Surname, String phoneNumber) {

        Set <String> phone = phoneAndName.get(Surname);

        if (phone != null) {
            phone.add(phoneNumber);
            phoneAndName.put(Surname, phone);
        } else {
            Set<String> somePhone = new HashSet<>();
            somePhone.add(phoneNumber);
            phoneAndName.put(Surname, somePhone);
        }
    }

    public Set<String> get(String Surname) {
        return phoneAndName.get(Surname);
    }

    public void info() {
        Set <String> surnames = phoneAndName.keySet();
        for (String surname : surnames) {
            System.out.println(surname + " has a phone number: " + get(surname));
        }
    }
}
