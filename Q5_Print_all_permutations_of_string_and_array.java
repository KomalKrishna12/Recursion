import java.util.ArrayList;

public class Q5_Print_all_permutations_of_string_and_array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        // Approach 1
        // if array contains n numbers then it have total n! permutations
        // use a boolean array to check which element is used
        // when small array list size equal to array size add that into ans means we got
        // one of the
        // permutation

        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // ArrayList<Integer> sl = new ArrayList<>();
        // boolean[] map = new boolean[nums.length];

        // permutations(nums, sl, ans, map);

        // System.out.println(ans);

        // Approah 2
        // in this approach we will not used any extra space for map array
        // we use swap function
        // start taking index and start swaping it with index till end
        // after every swap call function for next index + 1
        // base case will be when index reach at end
        // create a small array list and add all array elements into that list and then
        // add that list into final ans array list and return

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        permuattions2(0, nums, ans);
        System.out.println(ans);
        
    }
   

    public static void permuattions2(int idx, int[] nums, ArrayList<ArrayList<Integer>> ans) {
        if (idx == nums.length) {
            ArrayList<Integer> ds = new ArrayList<>();
            for (int item : nums)
                ds.add(item);
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            permuattions2(idx + 1, nums, ans);
            swap(i, idx, nums);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void permutations(int[] nums, ArrayList<Integer> sl, ArrayList<ArrayList<Integer>> ans,
            boolean[] map) {

        if (sl.size() == nums.length) {
            ans.add(new ArrayList<>(sl));
            return;
        }

        // check all the index from 0 to end
        // if that is false then we can add it into sl and mark it true and call for
        // next
        for (int i = 0; i < map.length; i++) {
            if (map[i] == false) {
                map[i] = true;
                sl.add(nums[i]);
                permutations(nums, sl, ans, map);
                map[i] = false;
                sl.remove(sl.size() - 1);
            }
        }
    }

    
}
