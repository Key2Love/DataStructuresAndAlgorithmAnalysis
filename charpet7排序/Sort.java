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
        Integer[] a = {1, 3, 4, 5, 7, 6,2,3,4,1,4,124,124,123,4,24,23,42,124,14,124142,123,2323,424,2144,4214,12414,424,3,2,42,5,12,124,2141,5,124,52,14,521,14,152,14,5251,12,1,5125,21515,};
        Integer[] b = new Integer[6];
        Sort.quickSort(a);
        for (Integer c:a){
            System.out.println(c);
        }

    }

    private static <AnyType extends Object>
    void swapReference(AnyType[] anArray, int a, int b) {
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
    void insertSort(AnyType[] anArray,int left,int right) {
        int j;
        for (int i = left; i <= right; i++) {
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
     *
     * @param a
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void quickSort(AnyType[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 总结快排流程，首先left=0,right=末尾索引。如果left+OFFSET>right则小数组，使用插入排序。
     * 如果不，调用median3方法，将中位数放在right-1，pivot=aList[right-1]。
     * 建立一个死循环，i =left,j=right-1。for(::)死循环，内部 while(++i)比较,while(--j)比较
     * 方法体内如果i<j，交换索引。如果不是退出循环
     * **注意，退出循环后，记得交换i和right-1索引**
     * 最后，递归调用quickSort(aList,left,i-1);
     * quickSort(aList,i+1,right)
     * @param aList
     * @param left
     * @param right
     * @param <AnyType>
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void quickSort(AnyType[] aList, int left, int right) {
        if (left + OFFSET <= right) {
            AnyType pivot = median3(aList, left, right);
            //begin partitioning
            int i = left, j = right - 1;
            // 死循环的写法for ( ; ; )
            for (; ; ) {
                //此处为什么不从left开始，因为median3方法保证了left<pivot<right
                while (aList[++i].compareTo(pivot) < 0) {
                }
                while (aList[--j].compareTo(pivot) > 0) {
                }
                /** 如果是这样的写法，那么a[i]=a[j]=pivot会陷入死循环。
                while (aList[i].compareTo(pivot) < 0) {
                    i++;
                }*/
                if (i < j) {
                    swapReference(aList, i, j);
                } else {
                    break;
                }
            }

            //restore pivot，重新建立pivot。把pivot移到中间
            swapReference(aList, i, right - 1);
            //small elements
            quickSort(aList,left,i-1);
            //large elements
            quickSort(aList,i+1,right);
        }else{
            insertSort(aList,left,right);
        }

    }


    /**
     * 取median
     *
     * @param aList
     * @param left
     * @param right
     * @param <AnyType>
     * @return
     */
    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median3(AnyType[] aList, int left, int right) {
        int center = (left + right) / 2;
        if (aList[left].compareTo(aList[right]) > 0) {
            swapReference(aList, left, right);
        }
        if (aList[left].compareTo(aList[center]) > 0) {
            swapReference(aList, left, right);
        }
        if (aList[center].compareTo(aList[right]) > 0) {
            swapReference(aList, center, right);
        }
        //place pivot at pos right -1
        swapReference(aList, center, right - 1);
        return aList[right - 1];

    }
}



