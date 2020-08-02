package main.java.sort;

import java.util.Arrays;

/**
 * 快速排序（Quicksort）是对冒泡排序的一种改进，借用了分治的思想，由C. A. R. Hoare在1962年提出。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序使用分治策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为：
 * ①. 从数列中挑出一个元素，称为”基准”（pivot）。
 * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 *
 *
 * @author lijiangtao
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {12,3,5,1256,23,19,45,90,22,230,345};
        sort2(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    /**
     * ①. 挖坑法
     * 用伪代码描述如下：
     * （1）low = L; high = R; 将基准数挖出形成第一个坑a[low]。
     * （2）high--，由后向前找比它小的数，找到后挖出此数填前一个坑a[low]中。
     * （3）low++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[high]中。
     * （4）再重复执行②，③二步，直到low==high，将基准数填入a[low]中。
     * 举例说明：
     * 一个无序数组：[4, 3, 7, 5, 10, 9, 1, 6, 8, 2]
     * （1）随便先挖个坑，就在第一个元素（基准元素）挖坑，挖出来的“萝卜”（第一个元素4）在“篮子”（临时变量）里备用。
     * 挖完之后的数组是这样：[ 坑, 3, 7, 5, 10, 9, 1, 6, 8,2]
     * （2）挖右坑填左坑：从右边开始，找个比“萝卜”（元素4）小的元素，挖出来，填到前一个坑里面。
     * 填坑之后：[ 2, 3, 7, 5, 10, 9, 1, 6, 8,坑]
     * （3）挖左坑填右坑：从左边开始，找个比“萝卜”（元素4）大的元素，挖出来，填到右边的坑里面。
     * 填坑之后：[ 2, 3,坑, 5, 10, 9, 1, 6, 8, 7]
     * （4）挖右坑填左坑：从右边开始，找个比“萝卜”（元素4）小的元素，挖出来，填到前一个坑里面。
     * 填坑之后：[ 2, 3, 1, 5, 10, 9,坑, 6, 8, 7]
     * （5）挖左坑填右坑：从左边开始，找个比“萝卜”（元素4）大的元素，挖出来，填到右边的坑里面。
     * 填坑之后：[ 2, 3, 1,坑, 10, 9, 5, 6, 8, 7]
     * （6）挖右坑填左坑：从右边开始，找个比“萝卜”（元素4）小的元素，挖出来，填到前一个坑里面，这一次找坑的过程中，
     * 找到了上一次挖的坑了，说明可以停了，用篮子里的的萝卜，把这个坑填了就行了，并且返回这个坑的位置，作为分而治之的中轴线。
     * 填坑之后：[ 2, 3, 1, 4, 10, 9, 5, 6, 8, 7]
     *
     * @param array 数组
     * @param low 左边界
     * @param high 又边界
     */
    public static void sort(int[] array,int low,int high){
        if (array == null) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low,right = high;
        int temp = array[left];//挖坑1：保存基准的值

        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];//坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (left < right && array[left] <= temp){
                left++;
            }
            array[right] = array[left];//坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
        }
        array[left] = temp;//基准值填补到坑3中，准备分治递归快排
        sort(array,low,left - 1);//分治左边
        sort(array,left + 1,high);//分治右边
    }

    /**
     * ②.左右指针法
     * 描述如下：
     * （1）low = L; high = R; 选取a[low]作为关键字记录为key。
     * （2）high--，由后向前找比它小的数
     * （3）low++，由前向后找比它大的数
     * （4）交换第（2）、（3）步找到的数
     * （5）重复（2）、（3），一直往后找，直到left和right相遇，这时将key和a[low]交换位置。
     *
     * @param array
     * @param low
     * @param high
     */
    public static void sort2(int[] array,int low,int high){
        if (array == null) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low,right = high;
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            while (left < right && array[left] <= temp){
                left++;
            }
            if(left < right){
                swap(array, left, right);
            }
        }
        swap(array, low, left);
        sort2(array, low, left - 1);
        sort2(array, left + 1, high);
    }

    public static void swap(int arr[], int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }

}
