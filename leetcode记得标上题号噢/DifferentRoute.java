import com.sun.org.apache.xpath.internal.operations.String;

class Route {
    public static void main(String[] args) {
        int[][] a = {{1}, {0}};
        System.out.println(new Route().uniquePathsWithObstacles(a));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for (int z = 0; z < col; z++) {
            if (obstacleGrid[0][z] == 1) {
                for (int t = z; t < col; t++) {
                    dp[0][t] = 0;
                }
                break;
            } else {
                dp[0][z] = 1;
            }
        }
        for (int g = 0; g < row; g++) {
            if (obstacleGrid[g][0] == 1) {
                for (int p = g; p < row; p++) {
                    dp[p][0] = 0;
                }
                break;
            } else {
                dp[g][0] = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] += obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];
                    dp[i][j] += obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];
                }else {
                    dp[i][j] = 0;
                }

            }
        }
        return dp[row - 1][col - 1];
    }
}