package stack;

import java.util.Arrays;
import java.util.Stack;

public class greatestrightnum {
    public static int[] rightnum(int[] nums){
        int arr[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i = nums.length-1;i>=0;i--){
            while(s.isEmpty()==false&&s.peek()<=nums[i]){
                s.pop();
            }
            if(s.isEmpty()==false){
                arr[i]=s.peek();
            }else{
               arr[i]=-1;
            }
         s.push(nums[i]);

        }
        int n =arr.length-1;
        for(int i =0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i]=arr[n];
            arr[n]=temp;
            n--;
        }
        return arr;
    }

    public static void main(String[] args) {
int arr[] ={1,2,4,7,5,10,6};
        System.out.println(Arrays.toString(rightnum(arr)));
    }
}
