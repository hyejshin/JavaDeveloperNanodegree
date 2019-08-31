import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorStackDemoTest {

    @Test
    public void calculate1() {
        String str = "1+2";
        int expect = 3;
        Assert.assertEquals(expect, CalculatorStackDemo.calculate(str));
    }

    @Test
    public void calculate2() {
        String str = "1+2*5";
        int expect = 11;
        Assert.assertEquals(expect, CalculatorStackDemo.calculate(str));
    }

    @Test
    public void calculate3() {
        String str = "5*2+10";
        int expect = 20;
        Assert.assertEquals(expect, CalculatorStackDemo.calculate(str));
    }

    @Test
    public void calculate4() {
        String str = "5*2+10-5*2+20";
        int expect = 30;
        Assert.assertEquals(expect, CalculatorStackDemo.calculate(str));
    }
}