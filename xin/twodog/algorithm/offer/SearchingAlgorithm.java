package xin.twodog.algorithm.offer;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SearchingAlgorithm {
    /**
     * ### 解题思路
     * 1. 往右🫱递增 ，往下⬇️递增
     * 2. 从左下角开始判断是最快的，为啥呢？
     * 3. 往下没有了，只能往右或者往上，比目标小就往右🫱，反之向上，向上之后，又是一个新的左下角。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * <p>
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
     * <p>
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int i;
        for (i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> countCharMap = new LinkedHashMap<>();
        char space = ' ';
        for (int i = 0; i < s.length(); i++) {
            countCharMap.put(s.charAt(i), countCharMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Character c : countCharMap.keySet()) {
            if (countCharMap.get(c) == 1) {
                return c;
            }
        }
        return space;
    }
}
