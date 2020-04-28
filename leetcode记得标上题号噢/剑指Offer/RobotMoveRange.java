package 剑指Offer;

/**
 * @program: algorithm
 * @description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @author: Sunbuhui7
 * @create: 2020-03-21 20:41
 **/

public class RobotMoveRange {
    private int m, n, k;
    private boolean[][] visited;

    /**
     * m 长，n 宽，k 数位和要小于等于该数
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return this.dfs(0, 0, 0, 0);


    }

    /**
     * x 行 y 列 si 行数位和 sj 列数位和
     *
     * @param x
     * @param y
     * @param si
     * @param sj
     * @return
     */
    public int dfs(int x, int y, int si, int sj) {
        if (x < 0 || x >= this.m || y < 0 || y >= this.n || this.k < si + sj || this.visited[x][y]) {
            return 0;
        }
        this.visited[x][y] = true;
        return 1 + dfs(x + 1, y, (x + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(x, y + 1, si, (y + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public int dfs1(int i, int j, int si, int sj) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public static void main(String[] args) {
        System.out.println(new RobotMoveRange().movingCount(11, 8, 16));
    }

}
