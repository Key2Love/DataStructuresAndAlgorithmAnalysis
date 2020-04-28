/**
 * @program: algorithm
 * @description: 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * @author: Sunbuhui7
 * @create: 2020-04-02 22:44
 **/

public class LifeGame {
    public static void main(String[] args) {
        int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new LifeGame().gameOfLife(a);
        System.out.println(a);
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        //此处为判断是否为空数组
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        //这里是坐标系移位的好表示方法
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //cnt用于计数该点周围的1的个数和，活细胞的个数
                int cnt = 0;
                for (int k = 0; k <8 ; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    //边界值判断
                    if(x<0||x>=m||y<0||y>=n){
                        continue;
                    }
                    //board[x][y]用int来储存两个状态，0b11是旧活新活，0b10是旧死新活，0b00是旧死新死，0b01是旧活新死
                    //&1是为了和最后一位做并运算。
                    cnt += board[x][y]&1;
                }
                if((board[i][j]&1)==1){
                    //为什么这里没有修改新的位变成0的情况，因为如果不改变的话，反正board[i][j]还是ob01
                    // 周围活细胞过多或过少都会死，因为原数据是0b01，所以这里不用额外赋值。
                    if(cnt==2||cnt==3){
                        //表示二进制
                        board[i][j] = 0b11;
                    }
                }else if (cnt==3){
                    board[i][j] = 0b10;
                }
            }
        }
        //右移一位，倒数第二位变成倒数第一位。
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
