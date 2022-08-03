import java.util.*;
// given a string 
// we have to print all partioning substring which are pallindrome
public class Q9_Pallindrome_partioning {

    public static void main(String[] args) {

        String s = "aabb";
        // print all subsets of string s

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        ArrayList<String> ds = new ArrayList<>();

        pallindromePartions(s, 0, ds, ans);

        System.out.println(ans);

    }

    public static void pallindromePartions(String s, int idx, ArrayList<String> ds,
    ArrayList<ArrayList<String>> ans){

        if(idx == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(pallindrome(s, idx, i)){
                ds.add(s.substring(idx, i+1));
                pallindromePartions(s, i + 1, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }

    }

    public static boolean pallindrome(String s, int si, int li){
        while(si <= li){
            if(s.charAt(si++) != s.charAt(li--)) return false;
        }
        return true;
    }

}
