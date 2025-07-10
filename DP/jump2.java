package dp;
import java.util.ArrayList;
import java.util.Arrays;

public class jump2 {
    public static void main(String[] args) {
        int nums[] ={2,3,1,1,4};
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int m= memoization(nums,0,dp);
        System.out.println(m);
    }
    public static int memoization(int nums[],int idx,int dp[]){
        if(idx==nums.length-1){
            return dp[idx]=0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int min = 0;
        for(int i =idx+1;i<=idx+nums[idx]&&i<nums.length;i++){
            min = Math.min(min,memoization(nums,i,dp)+1);
        }
        return dp[idx] = min;
    }
}
