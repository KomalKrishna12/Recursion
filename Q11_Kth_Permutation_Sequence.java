import java.util.ArrayList;
// we have given a number n and k
// if n is 3 that means we have 123 as a number
// we have to find kth permutation of 123
// this is the permutation of 123 and suppose k is 3 so 3rd permutation will be 213 
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
public class Q11_Kth_Permutation_Sequence {
    public static void main(String[] args) {
        int n = 4, k = 9;

        String str = getPermutation(n, k);
        System.out.println(str);
    }
    public static String getPermutation(int n, int k){
        int fact = 1;
        ArrayList<Integer> num = new ArrayList<>();
        for(int i = 1; i < n; i++){ 
            fact *= i;
            num.add(i);
        }
        num.add(n);
        k = k - 1;
        String ans = "";
        while(true){
            ans += num.get(k/fact);
            num.remove(k/fact);
            if(num.size() == 0) break;
            k = k % fact;
            fact = fact/num.size();
        }
        return ans;
    }
}
