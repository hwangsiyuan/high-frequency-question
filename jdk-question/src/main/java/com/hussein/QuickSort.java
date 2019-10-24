package com.hussein;

/**
 * <p>Title: QuickSort</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/23 5:08 PM
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr  待排序的数组
     * @param low  数组的左边界(例如，从起始位置开始排序，则l=0)
     * @param high 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (high <= low) return;
        int i = low;
        int j = high + 1;
        int key = arr[low];
        while (true) {
            /*从左向右找比key大的值*/
            while (arr[++i] < key) {
                if (i == high) {
                    break;
                }
            }
            /*从右向左找比key小的值*/
            while (arr[--j] > key) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            /*交换i,j对应的值*/
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            printArray(arr);
        }
        /*中枢值与j对应值交换*/
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        printArray(arr);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    /**
     * 30 40 60 10 20 50
     * 30 20 60 10 40 50
     * 30 20 10 60 40 50
     * 10 20 30 60 40 50
     * 10 20 30 60 40 50
     * 10 20 30 50 40 60
     * 10 20 30 40 50 60
     * 10 20 30 40 50 60
     */
    public static void main(String[] args) {
        int a[] = {30, 40, 60, 10, 20, 50};
        printArray(a);
        quickSort(a, 0, a.length - 1);
        printArray(a);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\n");
    }
}
