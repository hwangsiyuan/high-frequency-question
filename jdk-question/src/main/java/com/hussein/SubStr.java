package com.hussein;

/**
 * <p>Title: SubStr</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/7/28 7:33 PM
 */
public class SubStr {

    public static void main(String[] args) {
        String str = "ab acb4 nmb";
        int maxSubLen = maxSubLen(str);
        System.out.println(maxSubLen);
    }

    private static int maxSubLen(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int maxSub = 0;
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            if (str.charAt(end) == ' ') {
                start = end + 1;
            }
            maxSub = Math.max(maxSub, end - start + 1);
        }
        return maxSub;
    }
}
