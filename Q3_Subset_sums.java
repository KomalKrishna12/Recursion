import java.util.ArrayList;
import java.util.Collections;

public class Q3_Subset_sums {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        // print all the subset sums of arr
        // in arr 2 elements are there so total no of subsets will be 2^2 = 4
        // subset  sum
        // []      0
        // [2]     2
        // [3]     3
        // [2, 3]  5
        // so all sums are {0, 2, 3, 5}
        // we have to print the sums into increasing order

        ArrayList<Integer> ans = new ArrayList<>();

        subsetSums(0, arr, 0, ans);

        Collections.sort(ans);

        System.out.println(ans);
    }

    public static void subsetSums(int idx, int[] arr, int sum, ArrayList<Integer> ans){
        if(idx == arr.length){
            ans.add(sum);
            return;
        }

        // pick
        subsetSums(idx + 1, arr, sum + arr[idx], ans);

        // not pick
        subsetSums(idx + 1, arr, sum, ans);
    }

}
