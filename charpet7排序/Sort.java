import org.omg.CORBA.Any;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: algorithm
 * @description: 各种排序
 * @author: Sunbuhui7
 * @create: 2020-03-22 10:16
 **/

public class Sort {
    private static final int OFFSET = 10;
    public static void main(String[] args) {
        Integer[] a = {1, 3, 4, 5, 7, 6};
        Integer[] b = new Integer[6];
        Sort.merge(a, b, 0, 3, 5);
        for (Integer c : a) {
            System.out.println(c);
        }
    }

    private static <AnyType extends Object>
    void swapReference(AnyType[] anArray, int a, int b){
        AnyType temp = anArray[a];
        anArray[a] = anArray[b];
        anArray[b] = temp;
    }

    /**
     * 插入排序，适用于非常少量的排序。O(n^2)
     *
     * @param anArray
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void insertSort(AnyType[] anArray) {
        int j;
        for (int i = 1; i < anArray.length; i++) {
            AnyType tmp = anArray[i];
            for (j = i; j >= 1 && tmp.compareTo(anArray[j - 1]) < 0; j--) {
                anArray[j] = anArray[j - 1];
            }
            anArray[j] = tmp;
        }
    }

    /**
     * 希尔排序，O(4/3)
     *
     * @param anArray
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void shellSort(AnyType[] anArray) {
        int j;
        for (int gap = anArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < anArray.length; i++) {
                AnyType temp = anArray[i];
                for (j = i; j >= gap && temp.compareTo(anArray[j - gap]) < 0; j -= gap) {
                    anArray[j] = anArray[j - gap];
                }
                anArray[j] = temp;
            }
        }
    }

    /**
     * 堆排序，待完成
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void heapSort(AnyType[] anArray) {

    }

    /**
     * 归并排序,迭代部分
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] anArray, AnyType[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(anArray, tempArray, left, center);
            mergeSort(anArray, tempArray, center + 1, right);
            merge(anArray, tempArray, left, center + 1, right);
        }
    }

    /**
     * merge汇总，两个部分每个部分都要排好序
     *
     * @param anArray
     * @param tempArray
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     * @param <AnyType>
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType[] anArray, AnyType[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int len = rightEnd - leftPos + 1;
        int tempPos = leftPos;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (anArray[leftPos].compareTo(anArray[rightPos]) < 0) {
                tempArray[tempPos] = anArray[leftPos];
                tempPos++;
                leftPos++;
            } else {
                tempArray[tempPos] = anArray[rightPos];
                tempPos++;
                rightPos++;
            }
        }
        while (leftPos <= leftEnd) {
            tempArray[tempPos] = anArray[leftPos];
            tempPos++;
            leftPos++;
        }
        while (rightPos <= rightEnd) {
            tempArray[tempPos] = anArray[rightPos];
            tempPos++;
            rightPos++;
        }
        //copy Array back
        for (int i = 0; i < len; i++, rightEnd--) {
            anArray[rightEnd] = tempArray[rightEnd];
        }
    }

    /**
     * mergeSort归并排序启动方法
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] anArray) {
        AnyType[] tempArray = (AnyType[]) new Comparable[anArray.length];
        mergeSort(anArray, tempArray, 0, anArray.length - 1);
    }

    /**
     * 简单的递归算法。
     *
     * @param aList
     * @param <Anytype>
     */
    public static <Anytype extends Comparable<? super Anytype>>
    void recursionSort(List<Anytype> aList) {
        if (aList.size() > 1) {
            List<Anytype> smaller = new ArrayList();
            List<Anytype> same = new ArrayList();
            List<Anytype> larger = new ArrayList();
            Integer pivot = aList.size() / 2;
            for (Anytype i : aList) {
                int result = i.compareTo(aList.get(pivot));
                if (result < 0) {
                    smaller.add(i);
                } else if (result > 0) {
                    larger.add(i);
                } else {
                    same.add(i);
                }
            }
            recursionSort(smaller);
            recursionSort(larger);
            aList.clear();
            aList.addAll(smaller);
            aList.addAll(same);
            aList.addAll(larger);
        }
    }

    /**
     * 快排的驱动函数
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void quickSort(AnyType[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void quickSort(AnyType[] aList, int left, int right) {
        if(left + OFFSET <= right){
            AnyType pivot =
        }

    }

    private static <AnyType extends Comparable<? super AnyType>>
    void median3(AnyType[] aList, int left , int right){
        int center = (left+right)/2;
        if(aList[left].compareTo(aList[right])>0){
            swapReference(aList,left,right);
        }
        if (aList[])

    }
}



