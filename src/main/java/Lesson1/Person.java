package Lesson1;

public class Person implements Participant {

    String name;

    public Person (String name) {
        this.name = name;
    }

    public int run() {
        int manRun = 200;
        System.out.println("Man " + name + " can run " + manRun);
        return 200;
    }

    public int jump() {
        int manJump = 2;
        System.out.println("Man " + name + " can jump " + manJump);
        return 2;
    }

}
