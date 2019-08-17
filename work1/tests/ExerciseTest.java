import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExerciseTest {

    @Test
    public void findDuplicate1() {
        String str = "abcabc";
        int expect = 3;
        Assert.assertEquals(expect, Exercise.findDuplicate(str));
    }
    @Test
    public void findDuplicate2() {
        String str = "abcd";
        int expect = -1;
        Assert.assertEquals(expect, Exercise.findDuplicate(str));
    }

    @Test
    public void twoSum1() {
        int[] nums = {1, 2, 3, 4};
        boolean expect = true;
        Assert.assertEquals(expect, Exercise.twoSum(nums, 5));
    }
    @Test
    public void twoSum2() {
        int[] nums = {1, 4, 5, 1, 6};
        boolean expect = false;
        Assert.assertEquals(expect, Exercise.twoSum(nums, 12));
    }

    @Test
    public void twoSumSet1() {
        int[] nums = {1, 2, 3, 4};
        boolean expect = true;
        Assert.assertEquals(expect, Exercise.twoSum(nums, 5));
    }
    @Test
    public void twoSumSet2() {
        int[] nums = {1, 4, 5, 1, 6};
        boolean expect = false;
        Assert.assertEquals(expect, Exercise.twoSum(nums, 12));
    }

    @Test
    public void reverseString1() {
        String str = "Hello World!";
        String expect = "!dlroW olleH";
        Assert.assertEquals(expect, Exercise.reverseString(str));
    }
    @Test
    public void reverseString2() {
        String str = "abcde";
        String expect = "edcba";
        Assert.assertEquals(expect, Exercise.reverseString(str));
    }

    @Test
    public void topKLargerNumber1() {
        int[] nums = {-1, 15, 59, 22, 6, 42, 45, 0};
        int k = 4;
        List<Integer> expect = new ArrayList<>();
        expect = Arrays.asList(22, 42, 45, 59);
        Assert.assertEquals(expect, Exercise.topKLargerNumber(nums, k));
    }

    @Test
    public void topKLargerNumber2() {
        int[] nums = {5, 10, 22, 100, 8};
        int k = 2;
        List<Integer> expect = new ArrayList<>();
        expect = Arrays.asList(22, 100);
        Assert.assertEquals(expect, Exercise.topKLargerNumber(nums, k));
    }

    @Test
    public void topKLargerNumberSet1() {
        int[] nums = {-1, 15, 59, 22, 6, 42, 45, 0};
        int k = 4;
        List<Integer> expect = new ArrayList<>();
        expect = Arrays.asList(22, 42, 45, 59);
        Assert.assertEquals(expect, Exercise.topKLargerNumber(nums, k));
    }

    @Test
    public void topKLargerNumberSet2() {
        int[] nums = {5, 10, 22, 100, 8};
        int k = 2;
        List<Integer> expect = new ArrayList<>();
        expect = Arrays.asList(22, 100);
        Assert.assertEquals(expect, Exercise.topKLargerNumber(nums, k));
    }

    @Test
    public void translateNumberToWord1() {
        int num = 125;
        String expect = "one hundred twenty five";
        Assert.assertEquals(expect, Exercise.translateNumberToWord(num));
    }

    @Test
    public void translateNumberToWord2() {
        int num = 10245;
        String expect = "ten thousand two hundred forty five";
        Assert.assertEquals(expect, Exercise.translateNumberToWord(num));
    }

    @Test
    public void translateNumberToWord3() {
        int num = 215;
        String expect = "two hundred fifteen";
        System.out.println(Exercise.translateNumberToWord(num));
        Assert.assertEquals(expect, Exercise.translateNumberToWord(num));
    }
}