import java.util.*;
import java.util.stream.Collectors;

public class Exercise {
    public static int findDuplicate(String input) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);
        for(int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'a';
            if(alpha[idx] > 0) return i;
            else alpha[idx]++;
        }
        return -1;
    }

    public static boolean twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(nums[i] + nums[j] == target)
                    return true;
            }
        }
        return false;
    }

    public static boolean twoSumSet(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num))
                return true;
            else set.add(target - num);
        }
        return false;
    }

    public static String reverseString(String s) {
        /*String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;*/
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static List<Integer> topKLargerNumber(int[] nums, int k) {
        List<Integer> largeNums = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = nums.length - k; i < nums.length; i++)
            largeNums.add(nums[i]);
        return largeNums;
    }

    public static List<Integer> topKLargerNumberSet(int[] nums, int k) {
        TreeSet<Integer> numSet = new TreeSet<>();
        for(int num : nums) {
            numSet.add(num);
            if(numSet.size() > k)
                numSet.pollFirst();
        }
        return numSet.stream().collect(Collectors.toList());
    }

    public static String translateNumberToWord(int number) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] onetens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] zeros = {"", "ten", "hundred", "thousand"};
        String numberWords = "";
        int idxTen = 0;
        while(number > 0) {
            int idxDigit = number % 10;
            if(idxTen % 4 > 1)
                numberWords = zeros[idxTen] + " " + numberWords;
            if(idxTen % 3 == 0 && idxDigit > 0 && (number / 10) % 10 == 1) {
                numberWords = onetens[idxDigit] + " " + numberWords;
                idxTen++; number /= 10;
            }
            else if(idxTen % 3 == 1)
                numberWords = tens[idxDigit] + " " + numberWords;
            else if(idxDigit > 0)
                numberWords = digits[idxDigit] + " " + numberWords;
            idxTen++;
            number /= 10;
        }
        return numberWords.trim();
    }

    public static void main(String args[]) {

    }

}
