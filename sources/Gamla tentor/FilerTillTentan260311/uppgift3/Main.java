package uppgift3;

public class Main {

    public static void main(String[] args) {
        IntQueue myQ = new IntQueue(2);
        for (int i = 0; i < 8; i++) {
            myQ.enqueue(i);
        }
        int i=0;
        while (!myQ.isEmpty()&&i<5) {
            i++;
            System.out.println(myQ.dequeue());
        }
        for (i = 8; i < 30; i++) {
            myQ.enqueue(i);
        }
        while (!myQ.isEmpty()) {
            System.out.println(myQ.dequeue());
        }
        myQ.dequeue();
    }

}
