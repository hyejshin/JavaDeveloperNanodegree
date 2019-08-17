import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchDemoTest {

    @Test
    public void findTargetTest1() {
        int[] arr = new int[]{1, 5, 7, 8, 9, 11, 18, 19, 20, 25};
        int target = 11;
        int expect = 5;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr, target));
    }

    @Test
    public void findTargetTest2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int target = 10;
        int expect = -1;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr, target));
    }

    @Test
    public void findTargetTest3() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int target = 1;
        int expect = 0;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr, target));
    }

    @Test
    public void findTargetTest4() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int target = 5;
        int expect = 4;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr, target));
    }
}