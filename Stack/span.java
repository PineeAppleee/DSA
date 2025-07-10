package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class span {
    public static void main(String[] args) {
        int arr[] = {10,4,5,90,120,80};
        System.out.println(spanprobleam(arr));
    }
    public static ArrayList<Integer> spanprobleam(int[] nums){
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int i =0;
        for(int j =0;j<nums.length;j++){
            while(s.isEmpty()==false&&nums[s.peek()]<nums[j]){
                s.pop();
            }
            if(s.isEmpty()){
                list.add(i+1);
            }else{
                list.add(j-s.peek());
            }
            s.push(i);
            i++;
        }
        return list;
    }
}
