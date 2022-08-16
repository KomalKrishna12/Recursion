import java.util.Arrays;
import java.util.HashMap;

public class All_Permutation_of_string_contains_duplicate_char {
    public static void main(String[] args) {
        String str = "abaab";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        
    }

}
