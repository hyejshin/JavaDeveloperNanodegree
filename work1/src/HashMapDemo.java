import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemo {
    public static void calculateWordFrequency() {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = Arrays.asList("abd", "bcd", "abd");

        /*for(String s : list) {
            if(map.get(s) == null)
                map.put(s, 1);
            else
                map.compute(s, (key, val) -> val + 1);
        }*/
        for(String word : list) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(String word : map.keySet())
            System.out.println(word + "|" + map.get(word));
    }

    public static void main(String[] args) {
        HashMapDemo.calculateWordFrequency();
    }
}
