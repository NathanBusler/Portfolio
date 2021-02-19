import java.util.concurrent.TimeUnit;

public class KnightsTour {
    static int size = 6;
    static int[][] chessBoard = new int[size][size];
    static int move;
    static int noOfBacktrackCalls;

    public boolean tourBackTrackRoutine(int row, int col) {
        boolean flag = false;
        noOfBacktrackCalls++;
        if (!isMoveSafe(row, col)) {
            return false;
        }
        move++;
        chessBoard[row][col] = move;

        if (move == size * size) {
            return true;
        }

        flag = true;


        int counter = 0;

        for (int i[] : possibleMoves) {
            counter++;
            int newX = row + i[0];
            int newY = col + i[1];
            if (flag = tourBackTrackRoutine(newX, newY)) {
                return true;
            } else {
                if (counter == possibleMoves.length) {
                    move--;
                    chessBoard[row][col] = 0;
                    return flag;
                } else {
                    continue;
                }
            }
        }
        return flag;

    }

    public boolean isMoveSafe(int row, int col) {

        if (row < 0 || col < 0 || !(row < size) || !(col < size)) {
            return false;
        }

        if (row == size || col == size) {
            return false;
        }
        if (chessBoard[row][col] > 0) {
            return false;
        } else {
            return true;
        }
    }

    int[][] possibleMoves = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    public static void main(String[] args) {
        System.out.println("Solving...");
        long startTime = System.nanoTime();
        if (new KnightsTour().tourBackTrackRoutine(0, 0)) {
            System.out.println("Solved!!");
        } else {
            System.out.println("Cannot be solved!!");
        }
        long timeTaken = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
        System.out.println("\nCompleted in :" + timeTaken + " milli sec");
        System.out.println("\nTook " + noOfBacktrackCalls + " backtrack calls for completion!");
        for (int[] i : chessBoard) {
            System.out.print("\n{");
            for (int i1 : i) {
                System.out.print(i1 + ",\t");
            }
            System.out.print("}");
        }
    }

}