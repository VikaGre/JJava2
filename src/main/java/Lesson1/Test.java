package Lesson1;

public class Test {
    public static void main(String[] args) {

        RunningTrack runningTrack = new RunningTrack(250);
        runningTrack.infoRunning();
        Wall wall = new Wall(10);
        wall.infoJumping();
        System.out.println();

        Cat cat = new Cat("Myrzic");
        Person people = new Person("Oleg");
        Robot robot = new Robot("Rob321");

        Participant[] participant = {cat, people, robot};
        Obstacle[] obstacles = {runningTrack, wall};

        for (Participant participant1 : participant) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.passObstacle(participant1)) {
                    System.out.println("Participant is out");
                    System.out.println();
                    break;
                }
            }
        }

    }
}
