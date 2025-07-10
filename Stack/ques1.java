package stack;
import java.util.Stack;

public class ques1 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(12);
        s.push(13);
        s.push(14);
        reverse(s);
        while(!s.empty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
    public static void reverse(Stack <Integer> s) {
        if(s.isEmpty()){
            return;
        }
       int top= s.pop();
        reverse(s);
        addele(top,s);
    }
    public static void addele(int data,Stack <Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
       int top= s.pop();
        addele(data,s);
        s.push(top);
    }
}
