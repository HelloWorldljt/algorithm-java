package main.java.sort;

import java.util.Arrays;

/**
 * 将待排序数组按照步长gap进行分组，然后将每两组的元素利用直接插入排序的方法进行排序；每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
 * 可以看到步长的选择是希尔排序的重要部分。只要最终步长为1任何步长序列都可以工作。一般来说最简单的步长取值是初次取数组长度的一半为增量，之后每次再减半，直到增量为1。
 * 更好的步长序列取值可以参考维基百科。
 *
 * ①. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
 * ②. 按增量序列个数k，对序列进行k 趟排序；
 * ③. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，
 * 整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 *
 * @author lijiangtao
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {12,3,5,1256,23,19,45,90,22,230,345};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        int gap = array.length/2;
        for (;gap > 0;gap = gap/2){//不断缩小gap，直到1为止
            for (int i = 0;(i+gap) < array.length;i++){
                for (int j = 0;(j+gap) < array.length;j+=gap){//使用当前gap进行两组数据插入排序
                    if (array[j] > array[j+gap]) {
                        //交换
                        int temp = array[j];
                        array[j] = array[j+gap];
                        array[j+gap] = temp;
                    }
                }
            }
        }

    }
}
