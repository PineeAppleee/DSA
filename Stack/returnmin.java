package stack;

import java.util.Stack;

public class returnmin {
     static Stack<Integer> s = new Stack<>();
    static int min;

    public static void main(String[] args) {
        push(12);
        push(14);
        push(17);
        push(10);
        push(9);
        pop();

        System.out.println(getmin());
    }
    public static void push(int val){
        if(s.isEmpty()){
            s.push(val);
            min=val;
        }else{
            if(min<val){
                s.push(val);
            }else if(min>val){
                s.push(2*val-min);
                min=val;
            }
        }
    }
    public static void pop(){
        if(s.isEmpty()){
            System.out.println(-1);
        }else{
            if(s.peek()<min){
                min = 2*min-s.peek();
                s.pop();
            }else if(s.peek()>min){
                s.pop();
            }
        }
    }
    public static int peek(){
        if(s.isEmpty()){
            return -1;
        }
        else{
            if(s.peek()<min){
                return min;
            }
            else if(s.peek()>min){
                return s.peek();
            }
        }
        return -1;
    }
    public static int getmin(){
        if(s.isEmpty()){
            return -1;
        }
       return min;
    }
}
