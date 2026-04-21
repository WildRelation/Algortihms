package uppgift3;

public class IntQueue {

    private int front, rear, size, maxSize;
    private int[] data;

    public IntQueue(int maxSize) {
        size = 0;
        front = 0;
        this.maxSize = maxSize;
        rear = maxSize - 1;
        data = new int[maxSize];
    }

    public boolean enqueue(int element) {
        if (size == maxSize) {
            reallocate();
        }
        rear = (rear + 1) % maxSize;
        data[rear] = element;
        size++;
        return true;
    }

    public int dequeue() {
        if (size == 0) throw new IllegalStateException("Dequeue on empty queue.");
        size--;
        int element = data[front];
        front = (front + 1) % maxSize;
        return element;

    }

    private void reallocate() {
        int newMaxSize = 2 * maxSize;
        int[] newData = new int[newMaxSize];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size - 1;
        maxSize = newMaxSize;
        data = newData;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
