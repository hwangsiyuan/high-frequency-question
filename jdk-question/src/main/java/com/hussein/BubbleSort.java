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
        // 标记
        int flag;
        for (i = n - 1; i > 0; i--) {
            // 初始化标记为0
            flag = 0;
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 若发生交换，则设标记为1
                    flag = 1;
                }
            }
            // 若没发生交换，则说明数列已有序。
            if (flag == 0) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
        bubbleSort(a, a.length);
        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}
