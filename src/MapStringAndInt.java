import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapStringAndInt {
    static Map<String,Integer> countsWords =new HashMap<>();
    public static void init(String words){
        countsWords.put(words,countsWords.getOrDefault(words,0)+1);
    }

    public static int getCount(String slovo) {
        return countsWords.get(slovo);
    }
    public static String getWords(int counts) {
        return String.valueOf(countsWords.get(counts));
    }
    public static Map<String, Integer> getCountsWords() {
        return Collections.unmodifiableMap(countsWords);
    }
}
