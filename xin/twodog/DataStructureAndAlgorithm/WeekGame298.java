package xin.twodog.DataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeekGame298 {
    public static String greatestLetter(String s) {
        List<Character> ss = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++) {
            //char c = s.charAt(i);
            for (int j = i+1; j< s.length(); j++){
                if (verify(s.charAt(i), s. charAt(j))){
                    ss.add(s.charAt(i));
                }
            }
        }
        char[] ccc= new char[ss.size()];
        for (int i = 0; i < ss.size(); i++) {
            ccc[i] = ss.get(i);
        }
        Arrays.sort(ccc);
        if (ss.size() == 0)
        return "";
        else return String.valueOf(Character.toUpperCase(ccc[ccc.length-1]) );
    }
    public static boolean verify(char c, char d){
        if (Character.isUpperCase(c)){
            if (Character.isLowerCase(d) && Character.toUpperCase(d) == c)
                return true;
        }
        if (Character.isLowerCase(c)){
            if (Character.isUpperCase(d) && Character.toLowerCase(d) == c)
                return true;
        }
        return false;
    }



    //problem 2
    public int minimumNumbers(int num, int k) {
        // num 个位数相同的数字，有非常多，典型的贪心算法
        if (num == 0) return 0;
        int count = 0;
        int temp = 0;
        temp = num - k;
        if ( geweishu( temp) == k){
            return 2;
        }

        return num;
    }

    public static int geweishu(int m ) {
        while(m>9){
            m=m%10; //所报数的个位数
        }
        return m;
    }
    public static boolean verifyGeweishu(int ta, int cu){
        return geweishu(cu) == ta;
    }
    public static void main(String[] args) {
//        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(geweishu(34239));

    }
}
