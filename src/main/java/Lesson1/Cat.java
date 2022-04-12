package Lesson1;

public class Cat implements Participant{

    String name;

    public Cat(String name) {
        this.name = name;
    }

    public int run() {
        int catRun = 100;
        System.out.println("Cat " + name + " can run " + catRun);
        return 100;
    }

    public int jump() {
        int catJump = 1;
        System.out.println("Cat " + name + " can jump " + catJump);
        return 1;
    }
}
