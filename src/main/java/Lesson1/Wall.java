package Lesson1;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    public void infoJumping() {
        System.out.println("The height is " + height);
    }

    @Override
    public boolean passObstacle(Participant participant) {
        if (participant.jump() >= height) {
            System.out.println("Successfully jump");
            return true;
        } else {
            System.out.println("Couldn't jump");
            return false;
        }
    }
}
