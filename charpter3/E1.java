package charpter3;

import java.util.*;
import java.util.stream.Stream;

/**
 * You are given a list, L, and another list, P, containing integers sorted in
 * ascending order. The operation printLots(L,P) will print the elements in L
 * that are in positions specified by P. For instance, if P = 1, 3, 4, 6, the
 * elements in positions 1, 3, 4, and 6 in L are printed. Write the procedure
 * printLots(L,P). You may use only the public Collections API container
 * operations. What is the running time of your procedure?
 */

public class E1 {
    public static <AnyType> void printLots(List<AnyType> L, List<Integer> P) {
        Iterator<AnyType> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();
        Integer start = 0;
        Integer indexP;
        AnyType itemL = null;
        while (iterL.hasNext() && iterP.hasNext()) {
            indexP = iterP.next();
            while (start < indexP && iterL.hasNext()) {
                itemL = iterL.next();
                start++;
            }
            System.out.println(itemL.toString());
        }
    }

    public static void main(String[] args) {
        List<Integer> L = new ArrayList<Integer>();
        L.add(1);
        L.add(2);
        L.add(3);
        List<Integer> P = new ArrayList<Integer>();
        P.add(1);
        P.add(2);
        printLots(L, P);
    }

}