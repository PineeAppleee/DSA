package stack;

public class implementationofstack {
    static class Node{
        int data;
        Node next;
         Node(int data){
           this.data=data;
           next=null;
        }
    }
    static class stack{
        public static boolean isempty(){
            return head==null;
        }
    public static Node head;
    public static void push(int data){
        Node temp = new Node(data);
        if(isempty()){
            head = temp;
            return;
        }
        temp.next=head;
        head = temp;
    }
    public static int pop(){
        if(isempty()){
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }
    public static int peek(){
        if(isempty()){
            return -1;
        }
        return head.data;
    }
     public static void display(){
        if(head==null){
            System.out.println("nothing to show..");
            return;
        }
        while(head!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
         System.out.print("End");
     }
    }

    public static void main(String[] args) {
        stack ss = new stack();
        ss.push(23);
        ss.push(26);
        ss.push(22);
        while(!ss.isempty()){
             System.out.println(ss.peek());
            System.out.println(ss.pop());
        }
        ss.display();

    }

}

