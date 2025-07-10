package dp;

public class minimumdiffrence {
    public static void main(String[] args) {
      int nums[] = {-36,36};
        System.out.println(minimumDifference(nums));
    }

    public static int minimumDifference(int[] nums) {
        int totalsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                totalsum += nums[i];
            }
        }
        //  if(nums.length%2==1){
        //      return 0;
        //  }
        return minimum(nums, totalsum);
    }

    public static int minimum(int[] nums, int k) {
        boolean dp[][] = new boolean[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        if (k >= nums[0]&&nums[0]>=0) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                boolean notpick = dp[i - 1][j];
                boolean pick = false;
                if (nums[i] <= k&&nums[i]>=0) {
                    pick = dp[i - 1][k - nums[i]];
                }
                dp[i][j] = pick || notpick;
            }
        }
        int mini = (int) 1e9;
        for (int i = 0; i <= k / 2; i++) {
            if (dp[nums.length - 1][i] == true) {
                mini = Math.min(mini, Math.abs((k - i) - i));
            }
        }
        return mini;
    }
}
