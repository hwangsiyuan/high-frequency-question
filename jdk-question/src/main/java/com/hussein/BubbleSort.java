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
     * @param a 数组
     * @param n 数组长度
     */
    public static void bubbleSort(int[] a, int n) {
        int i, j;
        for (i = n - 1; i > 0; i--) {
            // 初始化标记为0
            int flag = 0;
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 若发生交换，则设标记为1
                    flag = 1;
                    printArray(a);
                }
            }
            // 若没发生交换，则说明数列已有序。
            if (flag == 0) {
                break;
            }
        }
    }

    /**
     * 20 40 30 10 60 50
     * 20 30 40 10 60 50
     * 20 30 10 40 60 50
     * 20 30 10 40 50 60
     * 20 10 30 40 50 60
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
