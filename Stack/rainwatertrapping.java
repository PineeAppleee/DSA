package stack;

public class rainwatertrapping {
    public static void main(String[] args) {
        int nums[] = {1,8,6,2,5,4,8,3,7};
        int left[] = left(nums);
        int right[] = right(nums);

        int sum =0;
        for(int i =0;i<nums.length;i++){
           int min = Math.min(left[i],right[i]);
           sum += min-nums[i];

    }
        System.out.println(sum);
    }
    public static int[] left(int nums[]){
        int left[] = new int[nums.length];
        left[0]=nums[0];
        for(int i =1;i<nums.length;i++){
            if(left[i-1]>nums[i]){
                left[i]=left[i-1];
            }else{
                left[i]=nums[i];
            }

        }
        return left;
    }
    public static int[] right(int nums[]){
        int left[] = new int[nums.length];
        left[nums.length-1]=nums[nums.length-1];
        for(int i =nums.length-2;i>=0;i--){
            if(left[i+1]>nums[i]){
                left[i]=left[i+1];
            }else{
                left[i]=nums[i];
            }

        }
        return left;


    }

}


