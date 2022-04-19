package Lesson3;

public class TestPhoneBook {

    public static void main(String[] args) {
        PhoneBook person = new PhoneBook();

        person.add("Ivanov", "88888888888");
        person.add("Ivanov", "89999999999");
        person.add("Petrov", "81111111111");
        person.add("Ivanov", "82222222222");
        person.add("Sokolov", "83333333333");


        person.info();
    }
}
