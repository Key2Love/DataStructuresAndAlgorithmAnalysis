package 剑指Offer;

import java.util.*;

/**
 * @program: algorithm
 * @description: 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * @author: Sunbuhui7
 * @create: 2020-03-18 15:14
 **/
public class MatrixPath {
    public static void main(String[] args) {
        char[][] a = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new MatrixPath().exist(a, "ABCE"));
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean res = dfs(board, words, i, j, 0);
                if (res == true) {
                    return res;
                }
            }
        }
        return false;

    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || index >= word.length || board[i][j] == '/' || board[i][j] != word[index]) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]) {
            return false;
        }
        if(index == word.length-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i, j + 1, index + 1);
        board[i][j] = temp;
        return res;
    }
}