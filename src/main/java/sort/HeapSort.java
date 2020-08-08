package main.java.sort;

import java.util.Arrays;

/**
 *
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 *
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 *
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 *
 * 由于堆排序中初始化堆的过程比较次数较多, 因此它不太适用于小序列。同时由于多次任意下标相互交换位置, 相同元素之间原本相对的顺序被破坏了, 因此, 它是不稳定的排序
 *
 * 参考文章：https://www.cnblogs.com/chengxiao/p/6129630.html
 *
 * 时间复杂度：O(nlogn)  空间复杂度：O(1)
 *
 * @author lijiangtao
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {12,3,5,1256,23,19,45,90,22,230,345};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void sort(int[] array){
        //构建最大堆
        for (int i = array.length/2 - 1;i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array,i,array.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = array.length - 1; i > 0 ; i--) {
            //将堆顶元素与末尾元素进行互换
            swap(array,0,i);
            //重新对堆进行调整
            adjustHeap(array,0,i);
        }

    }

    /**
     * 调整大顶堆
     * @param array
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] array, int i, int length) {
        //取出当前元素
        int temp = array[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for (int j = 2 * i + 1; j < length; j = j*2 + 1) {
            //如果左子结点小于右子结点，j指向右子结点
            if(j + 1 < length && array[j] < array[j+1]){
                j++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (array[j] > temp) {
                array[i] = array[j];
                i = j;
            }else {
                break;
            }
        }
        //将temp值放到最终的位置
        array[i] = temp;
    }

    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
