package main.java.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 基本思想：归并排序算法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 *
 * 采用递归法：
 * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
 * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
 * ③. 重复步骤②，直到所有元素排序完毕
 *
 * @author lijiangtao
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {12,3,5,1256,23,19,45,90,22,230,345};
        int[] sort = sort(array);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] array){
        if(array.length <= 1){
            return array;
        }
        int mid = array.length >> 1;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return mergeArray(sort(left),sort(right));
    }

    private static int[] mergeArray(int[] left,int[] right){
        int i = 0,j = 0,k = 0;
        // 申请额外空间保存归并之后数据
        int[] result = new int[left.length+right.length];
        while (i < left.length && j < right.length){
            //选取两个序列中的较小值放入新数组
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            }else {
                result[k++] = right[j++];
            }
        }

        //放入剩余的元素
        while (i < left.length){
            result[k++] = left[i++];
        }
        while (j < right.length){
            result[k++] = right[j++];
        }
        return result;
    }


}
