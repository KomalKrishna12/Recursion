import java.util.*;
public class Print_all_permutation_with_all_pallindrome_partion{
    public static void main(String[] args)
    {
        String input = "nitin";
 
        System.out.println("All possible palindrome" +
                            "partitions for " + input
                            + " are :");
 
        allPalPartitions(input);
    }

    public static void allPalPartitions(String str){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        f(str, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    public static void f(String str, ArrayList<String> ds, ArrayList<ArrayList<String>> ans){
        if(str.length() == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < str.length(); i++){
            String subStr = str.substring(0, i+1);
            if(isPallindrome(subStr)){
                ds.add(subStr);
                f(str.substring(i+1), ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public static boolean isPallindrome(String str){
        if(str.length() == 1) return true;
        int si = 0;
        int ei = str.length() - 1;
        while(si <= ei){
            if(str.charAt(si) != str.charAt(ei)) return false;
            si++;
            ei--;
        }
        return true;
    }
 
}