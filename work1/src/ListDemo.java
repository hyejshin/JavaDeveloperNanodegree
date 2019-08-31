import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static List<String>[] groupString(List<String> input) {
        List<String> groupA = new ArrayList<String>();
        List<String> groupB = new ArrayList<String>();
        List<String> others = new ArrayList<String>();

        for(String word : input) {
            if(word.charAt(0) == 'a')
                groupA.add(word);
            else if(word.charAt(0) == 'b')
                groupB.add(word);
            else others.add(word);
        }

        List<String>[] retValue = new List[3];
        retValue[0] = groupA;
        retValue[1] = groupB;
        retValue[2] = others;

        return retValue;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("abc", "bcd", "bbb", "ace", "snb", "aaaa", "bbbbb", "eeee");
        for (List<String> lst : groupString(input)) {
            System.out.println(lst);
        }
    }
}
