package main.java.sort;

/**
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
 * 基数排序按照优先从高位或低位来排序有两种实现方案：
 * MSD（Most significant digital）  从最左侧高位开始进行排序。先按k1排序分组, 同一组中记录, 关键码k1相等, 再对各组按k2排序分成子组, 之后, 对后面的关键码继续这样的排序分组, 直到按最次位关键码kd对各子组排序后. 再将各组连接起来, 便得到一个有序序列。MSD方式适用于位数多的序列。
 * LSD（Least significant digital） 从最右侧低位开始进行排序。先从kd开始排序，再对kd-1进行排序，依次重复，直到对k1排序后便得到一个有序序列。LSD方式适用于位数少的序列。
 *
 * 以LSD为例，从最低位开始，具体算法描述如下：
 *
 * 第一趟桶排序将数字的个位数分配到桶子里面去，然后回收起来，此时数组元素的所有个位数都已经排好顺序了
 * 第二趟桶排序将数字的十位数分别分配到桶子里面去，然后回收起来，此时数组元素的所有个位数和十位数都已经排好顺序了(如果没有十位数、则补0)
 * 第三趟桶排序将数字的百位数分别分配到桶子里面去，然后回收起来，此时数组元素的所有个位数和十位数和百位数都已经排好顺序了(如果没有百位数、则补0)
 *
 * @author lijiangtao
 */
public class RadixSort {

    public static int[] sort(int[] array){
        if (array == null || array.length <= 1) {
            return array;
        }
        int max = array[0];
        for (int ele : array) {
            if(ele > max){
                max = ele;
            }
        }
        System.out.println("max:" + max);

        //最高位计算
        int maxDigit = 0;
        while (max != 0){
            max = max / 10;
            maxDigit++;
        }

        int[][] buckets = new int[10][array.length];
        int base = 10;

        for (int i = 0; i < maxDigit; i++) {
            //放入桶中

            //回收

        }

        return array;

    }
}
