package stack;


import java.util.Arrays;
import java.util.Stack;

public class areaofhstogram {
    public static void main(String[] args) {
        int arr[]={4,2,1,5,6,3,2,4,2};

        int ns[] = ns(arr);
        int ps[] = ps(arr);
        int j = arr.length-1;
        int greatest=0;
        for(int i =0;i<arr.length;i++){
            int n =(ns[j]-ps[i]-1)*arr[i];

            if(n>greatest){
                greatest = n;
            }
            System.out.print((ns[j]-ps[i]-1)*arr[i]+"->");
            j--;
        }
        System.out.print("End");
        System.out.println();
        System.out.println("Largest area of the histogram according to the area of the largest frequency of a graph "+greatest);
    }
    public static int[] ps (int[] nums){
        Stack<Integer> s = new Stack<>();
        int arr[] = new int[nums.length];

        for(int i =0;i<nums.length;i++){
            while(!s.isEmpty()&&nums[s.peek()]>=nums[i]){
                s.pop();
            }
            if(s.isEmpty()){
                arr[i]=-1;
            }else{
                arr[i]=s.peek();
            }
            s.push(i);

        }
        return arr;
    }
    public static int[] ns(int[] nums){
        int arr[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
    int m =0;
    for(int i =nums.length-1;i>=0;i--){
        while(!s.isEmpty()&&nums[s.peek()]>=nums[i]){
            s.pop();
        }
        if(s.isEmpty()){
           arr[m]=nums.length;
        }else{
            arr[m]=s.peek();
        }
        s.push(i);

        m++;
    }
    return arr;}
}
