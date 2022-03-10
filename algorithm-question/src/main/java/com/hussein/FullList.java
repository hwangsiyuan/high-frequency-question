package com.hussein;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: FullList</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/10/13 7:52 PM
 */
public class FullList {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        dfs(res, nums, new ArrayList());
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, List<Integer> combines) {
        if (combines.size() == nums.length) {
            res.add(new ArrayList<>(combines));
        }
        for (int i = 0; i < nums.length; i++) {
            if (combines.contains(nums[i])) {
                continue;
            }
            combines.add(nums[i]);
            System.out.println(combines + "-1");
            dfs(res, nums, combines);
            combines.remove(combines.size() - 1);
            System.out.println(combines + "-2");
        }
    }
}
