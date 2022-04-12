package Lesson1;

public class Robot implements Participant{

    String name;

    public Robot(String name) {
        this.name = name;
    }

    public int run() {
        int robotRun = 10000;
        System.out.println("Robot " + name + " can run " + robotRun);
        return 10000;
    }

    public int jump() {
        int robotJump = 10;
        System.out.println("Robot " + name + " can jump " + robotJump);
        return 10;
    }
}
