import java.util.HashSet;
import java.util.Set;

public class Q489 {
    // robot clean
    public static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }

    private void clean(Robot robot, int x, int y, int curDirection, Set<String> cleaned) {
        robot.clean();
        cleaned.add(x + " " + y);

        for (int i = 0; i < 4; i++) {
            int nx = x + DIRS[curDirection][0];
            int ny = y + DIRS[curDirection][1];
            if (!cleaned.contains(nx + " " + ny) && robot.move()) {
                clean(robot, nx, ny, curDirection, cleaned);
                goBack(robot);
            }
            robot.turnRight();
            curDirection = (curDirection + 1) % 4;
        }

    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
