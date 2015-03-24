package UnionFind;

/**
 * Created by chen on 15/1/23.
 */
public class LinkedListDLNode implements LinkedList {
    private int size;       //规模
    private DLNode head;    //头结点，哑元结点
    private DLNode tail;    //尾结点，哑元结点

    public LinkedListDLNode() {
        size = 0;
        head = new DLNode();
        tail = new DLNode();
        tail.setPre(head);
    }

    //辅助方法：判断结点p是否合法，如合法则转换为DLNode
    protected DLNode checkPosition(Node p) throws InvalidNodeException {
        if (p == null)
            throw new InvalidNodeException("错误：p为空");
        if (p == head)
            throw new InvalidNodeException("错误：p指向头结点，非法");
        if (p == tail)
            throw new InvalidNodeException("错误：p指向尾结点，非法");
        DLNode node = (DLNode) p;
        return node;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Node first() throws OutOfBoundaryException {
        if (isEmpty())
            throw new OutOfBoundaryException("错误：链接表为空");
        return head.getNext();
    }

    @Override
    public Node last() throws OutOfBoundaryException {
        if (isEmpty())
            throw new OutOfBoundaryException("错误：链接表为空");
        return tail.getPre();
    }

    //返回p之后的结点
    @Override
    public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getNext();
        if (node == tail)
            throw new OutOfBoundaryException("错误：已经是链接表尾端");
        return node;
    }

    //返回p之前的结点
    @Override
    public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
        DLNode node = checkPosition(p);
        node = node.getPre();
        if (node == head)
            throw new OutOfBoundaryException("错误：已经是链接表前端");
        return node;
    }

    //将e作为第一个元素插入链接表，并返回e所在结点
    @Override
    public Node insertFirst(Object e) {
        DLNode node = new DLNode(e, head, head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
        size++;
        return node;
    }

    //将e作为最后一个元素插入链接表，并返回e所在结点
    @Override
    public Node insertLast(Object e) {
        DLNode node = new DLNode(e, tail.getPre(), tail);
        tail.getPre().setNext(node);
        tail.setPre(node);
        size++;
        return node;
    }

    //将e插入p之后，并返回e所在结点
    @Override
    public Node insertAfter(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node, node.getNext());
        node.getNext().setPre(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }

    //将e插入p之前，并返回e所在结点
    @Override
    public Node insertBefore(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        DLNode newNode = new DLNode(e, node.getPre(), node);
        node.getPre().setNext(newNode);
        node.setPre(newNode);
        size++;
        return newNode;
    }

    //删除给定位置处的元素，并返回之
    @Override
    public Object remove(Node p) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.getNext().setPre(node.getPre());
        node.getPre().setNext(node.getNext());
        size--;
        return obj;
    }

    //删除首元素，并返回之
    @Override
    public Object removeFirst() throws OutOfBoundaryException {
        return remove(head.getNext());
    }

    //删除末元素，并返回之
    @Override
    public Object removeLast() throws OutOfBoundaryException {
        return remove(tail.getPre());
    }

    //将处于给定位置的元素替换为新元素，并返回被替换的元素
    @Override
    public Object replace(Node p, Object e) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        node.setData(e);
        return obj;
    }

    //元素迭代器
    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }
}
