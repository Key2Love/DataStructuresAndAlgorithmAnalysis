/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-26 09:22
 **/

class ChessProblem {
    public int numRookCaptures(char[][] board) {
        if (board.length != 8 || board[0].length != 8) {
            return 0;
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    for (int k = 0; k < 4; k++) {
                        int m = i;
                        int n = j;
                        for (; ; ) {
                            m += dx[k];
                            n += dy[k];
                            if (m<0||m>=8||n<0||n>=8||board[m][n]=='B'){
                                break;
                            }
                            if (board[m][n] == 'p') {
                                count++;
                                break;
                            }


                        }
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        char[][] a = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(new ChessProblem().numRookCaptures(a));
    }
}
