package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 给定一个由0和1组成的矩阵，找出每个元素到最近的0的距离。
 * @author: Sunbuhui7
 * @create: 2020-04-15 13:08
 **/

public class MatrixUpate {
    public int[][] updateMatrix(int[][] matrix) {
        //首先判空
        if (matrix==null||matrix.length==0){
            return null;
        }
        //定义变量
        int m = matrix.length;
        int n = matrix[0].length;
        //队列，后进先出
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for (int i=0;i<m;i++){
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j]==0){
                    //offer与add类似，但是如果超出大小的话，offer返回null,add返回异常。
                    queue.offer(new int[] {i,j});
                }else {
                    //将未曾访问过的点值定义为-1
                    matrix[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            //我这么写是错的
            //int x = queue.poll()[0];
            //int y = queue.poll()[1];
            //正确写法
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i <4 ; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                if (newX>=0&&newX<m&&newY>=0&&newY<n&&matrix[newX][newY]==-1){
                    matrix[newX][newY] = matrix[x][y]+1;
                    queue.offer(new int[] {newX,newY});
                }
            }
        }
        return matrix;


    }
}
