package main.java.sort;

/**
 * 冒泡排序算法的算法过程如下：
 * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * ③. 针对所有的元素重复以上的步骤，除了最后一个。
 * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
 * 平均时间复杂度O(n^2) 最好情况O(n) 最坏情况O(n^2) 空间复杂度O(1) 排序方式 In—place 稳定性：稳定
 * @author lijiangtao
 */
public class BubbleSort {


    public static void sort(int[] array){
        if(array == null || array.length == 0){
            return ;
        }
        //外层循环：需要 array.length - 1 次比较
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环：每次循环需要两两比较，每次内层循环完成都会将本次循环最大的数放到最后，内层循环次数每次减一（i每次加一）
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    //交换位置
                    int temp = array[j];
                    array[i] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }
}
