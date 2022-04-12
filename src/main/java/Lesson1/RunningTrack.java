package Lesson1;

public class RunningTrack implements Obstacle{
    int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    public void infoRunning() {
        System.out.println("The distance is " + distance);
    }

    @Override
    public boolean passObstacle(Participant participant) {
        if (participant.run() >= distance) {
           System.out.println("Successfully ran");
           return true;
        } else {
            System.out.println("Couldn't ran");
            return false;
        }
    }
}
