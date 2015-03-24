package UnionFind;

import UnionFind.Iterator;
import UnionFind.LinkedList;
import UnionFind.Node;
import UnionFind.OutOfBoundaryException;

/**
 * Created by chen on 15/1/23.
 */
public class LinkedListIterator implements Iterator {
    private LinkedList list;    //链接表
    private Node current;               //当前结点

    public LinkedListIterator(LinkedList list) {
        this.list = list;
        if (list.isEmpty())
            current = null;
        else
            current = list.first();
    }


    @Override
    public void first() {
        if (list.isEmpty())
            current = null;
        else
            current = list.first();
    }

    @Override
    public void next() throws OutOfBoundaryException {
        if (isDone())
            throw new OutOfBoundaryException("错误：已经没有元素");
        if (current == list.last()) current = null;
        else current = list.getNext(current);
    }

    @Override
    public boolean isDone() {
        return current == null;
    }

    @Override
    public Object currentItem() {
        if (isDone())
            throw new OutOfBoundaryException("错误：已经没有元素");
        return current.getData();
    }
}
