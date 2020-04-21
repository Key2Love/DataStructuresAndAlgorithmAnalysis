package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description:问题的本质就是让你在一幅「图」中找到从起点start到终点target的最近距离
 * @author: Sunbuhui7
 * @create: 2020-04-17 17:12
 **/

public class BFS框架 {
    public int bfs(int[][] matrix,int[] start,int [] target) {
        if (matrix==null||matrix.length==0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int sz = 0;
        while (!queue.isEmpty()){
            int[] now =queue.poll();

            for (int i = 0; i <4 ; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x>=0&&x<matrix.length&&y>=0&&y<matrix[0].length&&!visited[x][y]){
                    if (x==target[0]&&y==target[1]){
                        return sz;
                    }
                    queue.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
            sz++;

        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{{1,2},{3,4},{5,6}};
        System.out.println(new BFS框架().bfs(x,new int[]{0,0},new int[]{1,1}));
    }

}

