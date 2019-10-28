package com.hussein;

/**
 * <p>Title: SelectSort</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/28 7:45 PM
 */
public class SelectSort {

    /**
     * 选择排序
     *
     * @param arr 数组
     * @param n   数组长度
     */
    public static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        printArray(a);
        selectSort(a, a.length);
        printArray(a);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\n");
    }
}
