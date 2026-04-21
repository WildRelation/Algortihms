package uppgift4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i <= 5; i++)
        {
            list.add("e" + i);
        }
        System.out.println(list);
        //uppgift 1a
        for(String d:list)//O(n)
        {
            System.out.println(d);
        }
        //uppgift 1b
        Iterator<String> iter = list.evenIterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }

}
