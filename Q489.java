import java.util.HashSet;
import java.util.Set;

public class Q489 {
    // robot clean
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<int[]> visited = new HashSet<>();
    Robot robot;

    public void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backtrack(int row, int col){
        visited.add(new int[]{row, col});
        robot.clean();
        for (int[] d : directions){
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (!visited.contains(new int[]{newRow, newCol}) && robot.move()){
                backtrack(newRow, newCol);
                goBack();
            }

            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot){
        this.robot = robot;
        backtrack(0, 0);
    }
}
