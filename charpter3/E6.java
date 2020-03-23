package charpter3;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 * 3.6 The Josephus problem is the following game: N people, numbered 1 to N,
 * are sitting in a circle. Starting at person 1, a hot potato is passed. After
 * M passes, the person holding the hot potato is eliminated, the circle closes
 * ranks, and the game continues with the person who was sitting after the
 * eliminated person picking up the hot potato. The last remaining person wins.
 * Thus, if M = 0 and N = 5, players are eliminated in order, and player 5 wins.
 * If M = 1 and N = 5, the order of elimination is 2, 4, 1, 5. a. Write a
 * program to solve the Josephus problem for general values of M and N. Try to
 * make your program as efficient as possible. Make sure you dispose of cells.
 * b. Wha7u.erd t is the running time of your program?
 */

public class E6 {
    public static ArrayList<Integer> josephus(int m,int n){
        ArrayList<Integer> mList = new ArrayList<Integer>(m);
        for(int i=1;i<=m;i++){
            mList.add(i);
        } 
        while(mList.size() >= n){
                
        }

    }
}