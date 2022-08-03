import java.util.ArrayList;
import java.util.Arrays;
// we have given an array which may contains some duplicates
// we have to print all it's unique subset
// we use same approach which we use in combination sum 2
// but here we store sets level wise bcoz one of the subset is empty subset in which we didn't take
// any elements

public class Q4_Subset_sum_II {
    public static void main(String[] args) {
        int[]  nums = {1, 2, 2};

        // print all it's unique subsets
        // {}, {1}, {2}, {1, 2}, {1, 2, 2}, {2, 2}

        ArrayList<Integer> sl = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // sorting is impoprtant so that we avoid starting set from same elements
        // which can create duplicate subset 

        subsetSum(0, nums, sl, ans);

        System.out.println(ans); 
    }

    // store each level set  
    // start i = idx to end
    // if i is not idx then check the i and i-1 elements to avoid duplicasy
    // first time we can pick same element eg {1, 1}
    public static void subsetSum(int idx, int[] nums, ArrayList<Integer> sl,
    ArrayList<ArrayList<Integer>> ans){
        ans.add(new ArrayList<>(sl));

        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i - 1]) continue;

            sl.add(nums[i]);
            subsetSum(i + 1, nums, sl, ans);
            sl.remove(sl.size() - 1);
        }
    }
}
