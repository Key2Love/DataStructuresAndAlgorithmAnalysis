package BFS;

import java.util.LinkedList;
import java.util.Queue;

class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //记录count计数
        int count = 0;
        //记录方向，上下左右
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        //新建一个队列
        Queue<int[]> queue = new LinkedList<>();
        //用于保存当前节点的下标
        int[] indexs = new int[2];
        //记录是否被访问
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((!visited[i][j]) && grid[i][j] == '1') {
                    indexs[0] = i;
                    indexs[1] = j;
                    count++;
                    //
                    queue.offer(indexs);
                    //只要一被访问就要标记访问
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            indexs = queue.poll();
                            int x = indexs[0];
                            int y = indexs[1];
                            for (int m = 0; m < 4; m++) {
                                int nowX = x + dx[m];
                                int nowY = y + dy[m];
                                if (nowX >= 0 && nowX < grid.length && nowY >= 0 && nowY < grid[0].length
                                        && !visited[nowX][nowY] && grid[nowX][nowY] == '1') {
                                    queue.offer(new int[]{nowX, nowY});
                                    //只要一被访问就要标记访问
                                    visited[nowX][nowY] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        char[][] grid3 = {
                {'1','0'},
                {'0','1'}
        };
        System.out.println(new NumIslands().numIslands(grid1));
        System.out.println(new NumIslands().numIslands(grid2));
        System.out.println(new NumIslands().numIslands(grid3));

    }
}
