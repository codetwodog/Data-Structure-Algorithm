package xin.twodog.DataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode No.3 无重复字符最长字串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 11:31
 */
public class NoRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录每个字符的索引，重复字符记录最后一个
        Map<Character, Integer> strMap = new HashMap<>(s.length()); //定义当前最长字串中字符表
        int max = 0;
        int count = 0;
        int tempIndex = -1; // 记录当前假定最长字符串的初始位置
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 两种条件要加：1. 字典里为空 或者 字典里的字符小于当前字符索引
            if (strMap.get(ch) == null || (strMap.get(ch) <= tempIndex && strMap.get(ch) != null)) {
                strMap.put(ch, i);
                count++;
            } else if (strMap.get(ch) != null && strMap.get(ch) > tempIndex) {
                if (count > max) {
                    max = count;
                }
                tempIndex = strMap.get(ch); //记录之前的重复位置
                count = i - tempIndex;
                strMap.put(ch, i);


            }

        }

        return max > count ? max : count;
    }
}
