package xin.twodog.algorithm.offer;

public class StringProblem {
    public static void main(String[] args) {
        StringProblem stringProblem = new StringProblem();
        String s = stringProblem.replaceSpace("We are happy.");
        System.out.println(s);

        System.out.println(stringProblem.reverseLeftWords("lrloseumgh", 6));
    }

    public String replaceSpace(String s) {
        String s1 = s.replace(" ", "%20");
        return s1;
    }

    public String reverseLeftWords(String s, int n) {
        if (n == 0) return s;
        if (s == null) return null;
        if (n > s.length()) n = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        String b = s.substring(0, n);
        stringBuilder.delete(0, n);

        return stringBuilder.append(b).toString();
    }
}
