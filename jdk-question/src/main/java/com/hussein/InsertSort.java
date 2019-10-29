package com.hussein;

/**
 * <p>Title: InsertSort</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/29 7:38 PM
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param arr 数组
     * @param n   数组长度
     */
    public static void insertSort(int[] arr, int n) {
        int j, key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {40, 20, 30, 10, 60, 50};
        printArray(a);
        insertSort(a, a.length);
        printArray(a);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\n");
    }
}
