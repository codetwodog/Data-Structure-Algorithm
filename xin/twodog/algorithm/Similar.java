package xin.twodog.algorithm;

import java.util.Set;
import java.util.TreeSet;

public class Similar {
    public static void main(String[] args) {
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        Similar similar = new Similar();
        System.out.println(similar.similarPairs(words));
    }
    public int similarPairs(String[] words) {
        int count = 0;
        for(int i = 0; i< words.length; i++){
            for(int j = i+1; j< words.length; j++){
                if (isSimilar(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
    }
    boolean isSimilar(String s1, String s2){
        // 一个单词有哪些字母， 这些字母一样吗， 全部放在tree set 里面， 数量是否一致，就比较每一个字母
        Set<Character> chars1= String2CharList(s1);
        Set<Character> chars2 =String2CharList(s2);
        if(chars1.size()!= chars2.size()){
            return false;
        }
        if (!chars1.equals(chars2))
            return false;
        return true;

    }

    Set<Character> String2CharList(String word){
        Set set = new TreeSet();
        for (int i = 0; i < word.length(); i++){
            set.add(word.charAt(i));
        }
        return set;
    }
}
