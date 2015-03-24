package StackAndQueue;

/**
 * Created by chen on 15/3/24.
 * Generic stack: array implementation
 */
public class FixedCapacityStack<Item> {
    private Item[] s;
    private int N = 0;

    public FixedCapacityStack(int capacity) {
        //s = new Item[capacity];     //generic array creation not allowed in Java
        s = (Item[])new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }

}
