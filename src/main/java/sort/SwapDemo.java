package main.java.sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author lijiangtao
 * @Description 数字交换的三种方法
 * @date 2020/7/29 13:16
 */
public class SwapDemo {

	public static void main(String[] args) {
		int[] array = {10,20,30};
		swapByTemp(array,0,2);
		System.out.println(Arrays.toString(array));
		swapByArithmetic(array,1,2);
		System.out.println(Arrays.toString(array));
		swapByOperation(array,0,1);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * @Description 通过临时变量交换，暂用额外空间
	 * @author lijiangtao
	 * @date 2020/7/29
	 * @params array 数组
	 * @params i 下标
	 * @params j 下标
	 */
	public static void swapByTemp(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * @Description 通过运算交换，可能溢出
	 * @author lijiangtao
	 * @date 2020/7/29
	 * @params array 数组
	 * @params i 下标
	 * @params j 下标
	 */
	public static void swapByArithmetic(int[] array, int i, int j){
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}

	/**
	 * @Description 通过位运算交换
	 * @author lijiangtao
	 * @date 2020/7/29
	 * @params array 数组
	 * @params i 下标
	 * @params j 下标
	 */
	public static  void swapByOperation(int[] array, int i, int j){
		array[i] = array[i]^array[j];
		//array[i]^array[j]^array[j]=array[i]
		array[j] = array[i]^array[j];
		//array[i]^array[j]^array[i]=array[j]
		array[i] = array[i]^array[j];
	}


}
