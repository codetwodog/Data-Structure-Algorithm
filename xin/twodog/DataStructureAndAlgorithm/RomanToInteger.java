package xin.twodog.DataStructureAndAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * I II III  V VI VII VIII  X     IV, IX, XL, XC, CD, CM
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> integerMap = new HashMap<>();
        Set<String> minusNumber = new HashSet<>(Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM"));
        integerMap.put('I', 1);
        integerMap.put('V', 5);
        integerMap.put('X', 10);
        integerMap.put('L', 50);
        integerMap.put('C', 100);
        integerMap.put('D', 500);
        integerMap.put('M', 1000);
        int result = 0;
        int i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            String combineCharacter = "" + s.charAt(i) + s.charAt(i + 1);
            if (minusNumber.contains(combineCharacter)) {
                result += integerMap.get(s.charAt(i + 1)) - integerMap.get(s.charAt(i));
                i++;
            } else {
                result += integerMap.get(s.charAt(i));
            }

        }
        if (i == s.length() - 1) {
            result += integerMap.get(s.charAt(i));
        }
        return result;
    }
}
