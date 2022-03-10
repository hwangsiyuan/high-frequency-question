package com.hussein;

/**
 * <p>Title: StrReverse</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/10/14 7:42 PM
 */
public class StrReverse {

    public static void main(String[] args) {
        String str = "0P";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char leftChar = getChar(s.charAt(left));
            if(!(leftChar >= 'a' && leftChar <= 'z') && !(leftChar >= '0' && leftChar <= '9')){
                left ++;
                continue;
            }
            char rightChar = getChar(s.charAt(right));
            if(!(rightChar >= 'a' && rightChar <= 'z') && !(rightChar >= '0' && rightChar <= '9')){
                right --;
                continue;
            }
            if(leftChar == rightChar){
                left ++;
                right --;
            }else{
                return false;
            }
        }
        return true;
    }

    private static char getChar(char c){
        if(c >= 'a' && c <= 'z'){
            return c;
        }
        if(c >= 'A' && c <= 'Z'){
            return (char)(c + 32);
        }
        if(c >='0' && c <= '9'){
            return c;
        }
        return c;
    }
}
