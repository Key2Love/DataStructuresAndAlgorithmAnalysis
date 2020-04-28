package BFS;

/**
 * @program: algorithm
 * @description: 给定一个由0和1组成的矩阵，找出每个元素到最近的0的距离。
 * @author: Sunbuhui7
 * @create: 2020-04-15 13:08
 **/
import java.util.*;

public class MatrixUpate {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix==null||matrix.length==0){
            return null;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //存储结构是队列中的一个有两个元素，下标为0是x，下标为1是y
        Queue<int[]> queue=new LinkedList<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]==0){
                    queue.offer(new int[] {i,j});
                }else {
                    //如果没访问，那么就初始化为-1
                    matrix[i][j] = -1;
                }
            }
        }
        //四个方向
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i <4 ; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                //首先判断边界值
                if (newX>=0&&newX<m&&newY>=0&&newY<n
                &&matrix[newX][newY]==-1){
                    matrix[newX][newY] = matrix[x][y];
                    queue.offer(new int[]{newX,newY});
                }
            }

        }

        return matrix;



    }


}
