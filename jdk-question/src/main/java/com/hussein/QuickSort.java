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
     * @param a 待排序的数组
     * @param l 数组的左边界(例如，从起始位置开始排序，则l=0)
     * @param r 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
     */
    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && a[j] > x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                // 从左向右找第一个大于x的数
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            /* 递归调用 */
            quickSort(a, l, i - 1);
            /* 递归调用 */
            quickSort(a, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {30, 40, 60, 10, 20, 50};
        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
        quickSort(a, 0, a.length - 1);
        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}
