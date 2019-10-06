package usr.cesare.leetcode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(new Object());
        objects.add(null);
        objects.add(new Object());
        objects.add(null);
        objects.add(null);
        objects.add(new Object());
        while (objects.size() > 0){
            System.out.println(objects.pollFirst());
        }
    }
}
