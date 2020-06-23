package robinhood.dfs;

public class CityStreets {


    public static void main(String[] args) {

        int[][] directions = {
                {0, 2, 1},
                {5, 4, 0},
        };

    }


    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static final int HORIZONTAL = 0;

    private static final int VERTICAL = 1;

    private static final int LEFT_DOWN = 2;

    private static final int RIGHT_DOWN = 3;

    private static final int RIGHT_UP = 4;

    private static final int LEFT_UP = 5;


    public boolean trafficMap(int[][] directions) {
        int m = directions.length;
        int n = directions[0].length;

        dfs(directions, 0, 0, m, n);
        return false;

    }


    private void dfs(int[][] directions, int i, int j, int m, int n) {

        int current = directions[i][j];

        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (i < 0 || j < 0 || i >= m || j >= n) {
                continue;
            }

            int next = directions[x][y];

            

        }


    }

}
