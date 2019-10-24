package com.hussein;

/**
 * <p>Title: BubbleSort</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/23 5:23 PM
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 数组
     * @param n   数组长度
     */
    public static void bubbleSort(int[] arr, int n) {
        //临时变量
        int temp;
        //是否交换的标志
        boolean flag;
        ////表示趟数，一共 arr.length-1 次
        for (int i = 0; i < arr.length - 1; i++) {
            // 每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
            flag = false;
            //选出该趟排序的最大值往后移动
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //只要有发生了交换，flag就置为true
                    flag = true;
                }
                printArray(arr);
            }
            // 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 20 40 30 10 60 50
     * 20 40 30 10 50 60
     * 20 40 30 10 50 60
     * 20 40 10 30 50 60
     * 20 10 40 30 50 60
     * 10 20 40 30 50 60
     * 10 20 40 30 50 60
     * 10 20 40 30 50 60
     * 10 20 30 40 50 60
     * 10 20 30 40 50 60
     * 10 20 30 40 50 60
     * 10 20 30 40 50 60
     * 10 20 30 40 50 60
     * 10 20 30 40 50 60
     */
    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        printArray(a);
        bubbleSort(a, a.length);
        printArray(a);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\n");
    }
}
