package com.hussein;


/**
 * <p>Title: QuickSort2</p>
 * <p>Description: 快速排序2</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/6/29 10:01 AM
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int arr[] = {30, 40, 60, 10, 20, 50};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (arr[++i] < pivot) {
                if (i == high) {
                    break;
                }
            }
            while (arr[--j] > pivot) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, low, j);
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("\n");
    }

}
