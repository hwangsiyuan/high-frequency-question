package com.hussein;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: UniqueCharacterTest</p>
 * <p>Description: 不重复最长字符子串</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/6/28 3:48 PM
 */
public class UniqueCharacterTest {

    public static void main(String[] args) {
        String str = "abcababcd";
        int result = getLongestUniqueStrLength(str);
        System.out.println(result);
    }

    private static int getLongestUniqueStrLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        Set<Character> uniqueChars = new HashSet<>();
        int start = 0;
        int end = 0;
        int result = 1;
        while (start < len && end < len) {
            if (uniqueChars.contains(str.charAt(end))) {
                uniqueChars.remove(str.charAt(start++));
            } else {
                uniqueChars.add(str.charAt(end++));
                result = Math.max(result, end - start);
            }
        }
        return result;
    }
}
