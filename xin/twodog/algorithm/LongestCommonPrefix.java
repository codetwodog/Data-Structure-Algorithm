package xin.twodog.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        List<Integer> lenList = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < strs.length; i++) {
            lenList.add(strs[i].length());
        }
        List<Integer> collect = lenList.stream().sorted().collect(Collectors.toList());
        int min = collect.get(0);
        for (int i = 0; i < min; i++) {
            Character c;
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < lenList.size(); j++) {
                set.add(strs[j].charAt(i));
            }
            if (set.size() == 1) {
                c = set.stream().findFirst().get();
                result += c;
            }else {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }
}
