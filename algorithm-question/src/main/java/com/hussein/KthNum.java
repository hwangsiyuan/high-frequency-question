package com.hussein;

/**
 * <p>Title: KthNum</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/9/27 11:54 AM
 */
public class KthNum {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 5, 8, 11};
        int[] nums2 = new int[]{2, 4, 9, 10};
        int kthNum = kthNum(nums1, nums2, 6);
        System.out.println(kthNum);
    }

    private static int kthNum(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int i = 0;
        int len2 = nums2.length;
        int j = 0;
        while (true) {
            if (i == len1) {
                return nums2[j + k - 1];
            }
            if (j == len2) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }
            int half = k / 2;
            int ni = Math.min(i + half, len1) - 1;
            int nj = Math.min(j + half, len1) - 1;
            if (nums1[ni] <= nums2[nj]) {
                k -= (ni - i + 1);
                i = ni + 1;
            } else {
                k -= (nj - j + 1);
                j = nj + 1;
            }
        }
    }

}
