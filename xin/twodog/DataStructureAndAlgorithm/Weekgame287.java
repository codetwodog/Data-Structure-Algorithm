package xin.twodog.DataStructureAndAlgorithm;

public class Weekgame287 {
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "03:35"));
    }

    public static int convertTime(String current, String correct) {
        //分解字符串
        if (current.equals(correct))
            return 0;
        String[] currentArray = current.split(":");
        String[] correctArray = correct.split(":");
        int currentHour = s2i(currentArray[0]);
        int currentMin = s2i(currentArray[1]);
        int correctHour = s2i(correctArray[0]);
        int correctMin = s2i(correctArray[1]);
        int count = 0;
        int result = 0;
        int minCount =0;
        if (currentHour <= correctHour) {
             result = correctHour - currentHour;
             minCount = (correctHour - currentHour) * 60 + (60 - currentMin) + correctMin;
        }
        else {
            result = -(correctHour - currentHour);
            minCount = (24-(correctHour - currentHour)) * 60 + (60 - currentMin) + correctMin ;
        }
            while (minCount >= 1) {
                while (minCount >= 5) {
                    while (minCount >= 15) {
                        while (minCount >= 60 && minCount >= 60) {
                            if (minCount >= 60 && minCount % 60 > 0) {
                                minCount = minCount - 60;

                                count++;
                            }
                        }
                        if (minCount >= 15 && minCount % 15 >= 0) {
                            int asss = minCount % 15;
                            minCount = minCount - 15;
                            count++;
                        }
                    }
                    if (minCount >= 5 && minCount % 5 >= 0) {
                        minCount = minCount - 5;

                        count++;
                    }

                }
                if (minCount >= 1 && minCount % 1 >= 0) {
                    minCount = minCount - 1;

                    count++;
                }

            }


        return count;
    }

    private static int s2i(String s) {
        if (s.startsWith("0")) {
            int i = Integer.parseInt(s.substring(1));
            return i;
        }
        return Integer.parseInt(s);
    }

}


