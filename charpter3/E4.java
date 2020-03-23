package charpter3;

/**
 * 3.4和3.5一起完成了
 * 3.4 Given two sorted lists, L1 and L2, write a procedure to compute L1 ∩ L2
 * using only the basic list operations.
 */

/**
 * 3.5 Given two sorted lists, L1 and L2, write a procedure to compute L1 ∪ L2 using only
 * the basic list operations.
 */
import java.util.List;
import java.util.ListIterator;

public class E4 {
    public static <AnyType extends Comparable<? super AnyType>> List<AnyType> intersection(List<AnyType> L1,
            List<AnyType> L2, List<AnyType> Intersect) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = iterL1.next(), itemL2 = iterL2.next();

        while (iterL1.hasNext() && iterL2.hasNext()) {
            int compareResult = itemL1.compareTo(itemL2);

            if (compareResult == 0) {
                Intersect.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            } else if (compareResult == 1) {
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            } else {
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
            }
        }
        return Intersect;

    }

    public static <AnyType extends Comparable<? super AnyType>> List<AnyType> union(List<AnyType> L1, List<AnyType> L2,
            List<AnyType> Result) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = iterL1.next(), itemL2 = iterL2.next();

        while (iterL1.hasNext()) {
            if (!(Result.contains(itemL1))) {
                Result.add(itemL1);
            }
        }
        while (iterL2.hasNext()) {
            if (!(Result.contains(itemL2))) {
                Result.add(itemL2);
            }

        }
        return Result;

    }

}