package com.hussein;

/**
 * <p>Title: QuickSort</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2022/3/10 3:32 PM
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 4, 8, 7, 9};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i, j, temp;
        i = low;
        j = high + 1;
        int base = arr[low];
        while (true) {
            while (arr[--j] > base) {
                if (j == low) {
                    break;
                }
            }
            while (arr[++i] < base) {
                if (i == high) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            temp = arr[i];
            arr[j] = arr[i];
            arr[i] = temp;
            printArray(arr);
        }
        temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        printArray(arr);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\n");
    }
}
