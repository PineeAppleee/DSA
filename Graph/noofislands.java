import java.util.ArrayList;

public class noofislands {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
     for(int i =0;i<5;i++){
        list.add(new ArrayList<>());
      }
    list.get(0).add(2);
    list.get(2).add(0);

    list.get(1).add(3);
    list.get(3).add(1);

    list.get(2).add(3);
    list.get(3).add(2);

    list.get(0).add(3);
    list.get(3).add(0);
    }

}
