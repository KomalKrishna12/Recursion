import java.util.*;
// in this problem we have given an array in which some duplicate elemenets are also available
// we have to store the unique combbinations whose sum are equal to target
// we can pick one element one time only
// we have to create unique combinations only
// in this ques we will not use take/not take approach
// we use loop becoz we don't want duplicate combinations
// so firslty sort the array
// when we start we firslt check the previos starting point if same then don't start from this otherwise
// it will create duplicates
public class Q2_Combination_sum_II{
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int tar = 8; 

        // find all combinations whose sum is equal to tar
        // all combination must be unique
        // one element can be pick once only

        Arrays.sort(candidates); // sort the array
        ArrayList<Integer> sl = new ArrayList<>(); // small array list to store combination elements
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // ans array list which will store all
        // combinations possible
        combinationSum(0, candidates, tar, sl, ans);
        System.out.println(ans);
    }

    public static void combinationSum(int idx, int[] candidates, int tar, ArrayList<Integer> sl, 
    ArrayList<ArrayList<Integer>> ans){

        // when target become 0 then add small array list into ans array list bcoz we get one combination
        // whose sum is euqal to target
        if(tar == 0){
            ans.add(new ArrayList<>(sl));
            return;
        }

        // start loop from idx till end of array
        // if elememnt value is greater then target then break bcoz array is sorted and current element is
        // greater so no further combinations possible
        // now check dupliacte start point
        // if i is greter than idx means this is not starting index and if cand[i] equals to previous
        // value then continue
        // else add value into smmall array list
        // reduce target and call for next ith index
        for(int i = idx; i < candidates.length; i++){
            if(candidates[i] > tar) break;
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            
            sl.add(candidates[i]);
            tar -= candidates[i];
            combinationSum(i+1, candidates, tar, sl, ans);
            sl.remove(sl.size()-1);
            tar += candidates[i];
        }

    }
}