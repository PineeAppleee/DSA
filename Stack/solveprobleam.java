package stack;

import java.util.ArrayList;
import java.util.Stack;

public class solveprobleam {
    public static void main(String[] args) {
        String str = postfix("-1+(8-(3+4-3))");
        System.out.println(perform(str));
    }
    public static int perform(String s){
        Stack<Integer> st = new Stack<>();
        int sum =0;
        int flag =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
//            if(i==s.length()-1&&(ch=='-')){
//                sum=sum*-1;
//
//            }
             if(ch=='+'){
                 if(st.size()>1){
               int a = st.pop();
               int b = st.pop();
               sum =  (b+a);
               st.push(sum);}else {
                     sum = sum*1;
                 }
            }
            else if(ch=='-'){
                if(st.size()>1){
                int a = st.pop();
                int b = st.pop();
                sum =  (b-a);
                st.push(sum);}else{
                    sum = sum*-1;
                }
            }
            else {
                st.push(ch-'0');
            }
        }
        return sum;
    }
    public static String postfix(String s){
        Stack<Character> st = new Stack<>();
       StringBuilder str = new StringBuilder();
       for(int i =0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch>=48&&ch<=57){
               str.append(ch-'0');
           }else{
               if(ch==')'){
                   while(st.peek()!='('){
                       str.append(st.peek());
                       st.pop();
                   }st.pop();
               }else{
                   if(!st.isEmpty()&&st.peek()==ch){
                       st.pop();
                   }
                   st.push(ch);
               }}
           }
       while(!st.isEmpty()){
           str.append(st.peek());
           st.pop();
       }

       return str.toString();

    }

}
