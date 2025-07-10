package stack;

import java.util.ArrayList;

public class impusingarray {
   static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
    insert(45);
    insert(23);
    insert(55);
    insert(89);
    pop();
    display();
    }
    public static void insert(int val){
        list.add(val);
    }
    public static int pop(){
        int val = list.get(0);
        list.remove(0);
        return val;
    }
    public static void display(){
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
