import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-18 20:27
 **/
import java.util.*;

public class HuaWei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = Integer.parseInt(in.nextLine());
        if (row == 1) {
            System.out.println(0);
        } else {
            String firstLine = in.nextLine();
            int col = firstLine.length();
            int[][] matrix = new int[row][col];
            for (int i = 0; i < col; i++) {
                matrix[0][i] = Integer.parseInt(String.valueOf(firstLine.charAt(i)));
            }
            for (int i = 1; i < row; i++) {
                String line = in.nextLine();
                char[] lineChar = line.toCharArray();
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = Integer.parseInt(String.valueOf(lineChar[j]));
                }
            }
            int temp = row;
            if (row > col) {
                temp = col;
            }
            int s = 1;
            for (int i = 0; i < temp; i++) {
            }
        }


    }
}
