package dp;
import java.util.*;
public class coinchange2 {
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount = 5;
        int dp[][] = new int[coins.length][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int m= rec(amount,coins,coins.length-1,dp);
        System.out.println(m);
    }
    public static int rec(int amount,int[] nums,int n,int dp[][]){
        if(n==0){
            if(amount%nums[n]==0) return 1;
            else return 0;}
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }

        int pick = 0;
        if(amount>=nums[n]){
            pick = rec(amount-nums[n],nums,n,dp);

        }
        int notpick  = rec(amount,nums,n-1,dp);
        return dp[n][amount]=pick+notpick;
    }
}
