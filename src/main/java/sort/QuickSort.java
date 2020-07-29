package main.java.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {12,3,5,1256,23,19,45,90,22,230,345};
        sort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public static void sort(int[] array,int low,int high){
        if (array == null) {
            return;
        }
        if (low > high) {
            return;
        }

        int left = low,right = high;
        int temp = array[left];//挖坑

        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];//右边小于temp的值填入坑
            while (left < right && array[left] <= temp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        sort(array,low,left - 1);//分治左边
        sort(array,left + 1,high);//分治右边
    }

}
