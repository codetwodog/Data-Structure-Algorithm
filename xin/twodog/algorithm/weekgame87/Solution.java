package xin.twodog.algorithm.weekgame87;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static List<String> collectTimeFrame(LocalDate start, LocalDate end) {
        // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
        return Stream.iterate(start, localDate -> localDate.plusDays(1))
                // 截断无限流，长度为起始时间和结束时间的差+1个
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                // 由于最后要的是字符串，所以map转换一下
                .map(LocalDate::toString)
                // 把流收集为List
                .collect(Collectors.toList());
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int j = 0;
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            for (; j < trainers.length; ) {
                if (players[i] <= trainers[j]) {
                    count++;
                    j++;
                    break;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        int[] b = {10};
        int[] c = {1, 0, 2, 1, 3};
        int i = matchPlayersAndTrainers(a, b);
        for (int j = 0; j < smallestSubarrays(c).length; j++) {
            System.out.println(smallestSubarrays(c)[j]);
        }
    }

    public static int[] smallestSubarrays(int[] nums) {
        int arr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int maxValue = maxValue(nums, i);
            arr[i] = shortestArray(nums, maxValue, i);
        }
        return arr;
    }

    public static int maxValue(int[] nums, int start) {
        int result = nums[start];
        for (int i = start; i < nums.length; i++) {
            result |= nums[i];
        }
        return result;
    }

    public static int shortestArray(int[] nums, int max, int start) {
        int result = nums[start];
        int count = 0;
        for (; start < nums.length; start++) {
            result |= nums[start];
            count++;
            if (result == max) {
                break;
            }
        }
        return count;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate localDate11 = string2Date(arriveAlice);
        LocalDate localDate12 = string2Date(leaveAlice);
        LocalDate localDate21 = string2Date(arriveAlice);
        LocalDate localDate22 = string2Date(leaveAlice);
        List<String> strings = collectTimeFrame(localDate11, localDate12);
        List<String> strings2 = collectTimeFrame(localDate21, localDate22);
        Set<String> set1 = new HashSet<>();
        set1.addAll(strings);
        set1.addAll(strings2);
        return strings.size() + strings2.size() - set1.size();
    }

    public LocalDate string2Date(String arriveAlice) {
        return LocalDate.of(2001, Integer.valueOf(arriveAlice.split("-")[0]), Integer.valueOf(arriveAlice.split("-")[1]));
    }

}
