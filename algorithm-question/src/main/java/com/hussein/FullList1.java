package com.hussein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: FullList</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/10/13 7:52 PM
 */
public class FullList1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }


    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        boolean[] used = new boolean[nums.length];
        dfs(res, nums, used, new ArrayList());
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> combines) {
        if (combines.size() == nums.length) {
            res.add(new ArrayList<>(combines));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])) {
                continue;
            }
            combines.add(nums[i]);
            used[i] = true;
            dfs(res, nums, used, combines);
            used[i] = false;
            combines.remove(combines.size() - 1);
        }
    }
}
