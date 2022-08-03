import java.util.ArrayList;
// in this ques we use pick / not pick approach
public class Q1_Combination_sum_I {
    public static void main(String[] args) {
        int[] candidate = { 2, 3, 6, 7 };
        int tar = 7;

        // store all combinations whose sum equals to target
        // we can pick one elemnts infinte times
        // all combinations should be unqiue

        ArrayList<Integer> sl = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        combinationSum(0, candidate, tar, sl, ans);
        System.out.println(ans);
    }

    public static void combinationSum(int idx, int[] candidate, int tar, ArrayList<Integer> sl,
            ArrayList<ArrayList<Integer>> ans) {

        if (idx == candidate.length) {
            if (tar == 0) {
                ans.add(new ArrayList<>(sl));
            }
            return;
        }

        // pick
        // if pick then add element candiadet[idx] into small array list and reduce tar
        // by that
        // we can pick a single element multiple times so we call for same index
        if (candidate[idx] <= tar) { // this condition is important otherwise tar become negetive
            sl.add(candidate[idx]);
            tar -= candidate[idx];
            combinationSum(idx, candidate, tar, sl, ans); // calling for same idx bcoz we can pick
            // a single element multiple times 

            // now remove that from list so we call for not pick
            sl.remove(sl.size() - 1);
            tar += candidate[idx];
        }

        // not pick
        combinationSum(idx + 1, candidate, tar, sl, ans);

    }
}
