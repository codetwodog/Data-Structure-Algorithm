package xin.twodog.DataStructureAndAlgorithm;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String int2String = String.valueOf(x);
        int count = int2String.length();

        for (int i = 0; i < count / 2; i++) {
            if (int2String.charAt(i) != int2String.charAt(count - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
