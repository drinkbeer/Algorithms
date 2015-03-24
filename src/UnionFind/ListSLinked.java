package UnionFind;

/**
 * Created by chen on 15/1/22.
 * 线性表的单链表实现
 */
public class ListSLinked implements List {
    private Strategy strategy;
    private SLNode head;
    private int size;

    public ListSLinked() {
//        this(new DafaultStrategy());
    }

    public ListSLinked(Strategy strategy) {
        this.strategy = strategy;
        head = new SLNode();
        size = 0;
    }

    //辅助方法：获取数据元素e的前驱结点
    private SLNode getPreNode(Object e) {
        SLNode p = head;
        while (p.getNext() != null)
            if (strategy.equal(p.getNext().getData(), e)) return p;
            else p = p.getNext();
        return null;
    }

    //辅助方法：获取序号为0<=i<size的元素所在节点的前驱结点.head不算在结点内
    private SLNode getPreNode(int i) {
        SLNode p = head;
        for (; i > 0; i--) p = p.getNext();
        return p;
    }

    //获取序号为0<=i<size的元素所在结点
    private SLNode getNode(int i) {
        SLNode p = head.getNext();
        for (; i > 0; i--) p = p.getNext();
        return p;
    }

    //线性表的长度
    @Override
    public int getSize() {
        return size;
    }

    //判断是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //判断是否包含e
    @Override
    public boolean contains(Object e) {
        SLNode p = head.getNext();
        while (p != null)
            if (strategy.equal(p.getData(), e)) return true;
            else p = p.getNext();
        return false;
    }

    //返回e在线性表中的序号
    @Override
    public int indexOf(Object e) {
        SLNode p = head.getNext();
        int index = 0;
        while (p != null)
            if (strategy.equal(p.getData(), e)) return index;
            else {
                index++;
                p = p.getNext();
            }
        return -1;
    }

    //将e插入到i位置
    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {
        if (i < 0 || i > size)
            throw new OutOfBoundaryException("错误，指定的插入序号越界");
        SLNode p = getPreNode(i);
        SLNode q = new SLNode(e, p.getNext());
        p.setNext(q);
        size++;
        return;
    }

    //把e插在obj之前
    @Override
    public boolean insertBefore(Object obj, Object e) {
        SLNode p = getPreNode(obj);
        if (p != null) {
            SLNode q = new SLNode(e, p.getNext());
            p.setNext(q);
            size++;
            return true;
        }
        return false;
    }

    //将e插在obj之后
    @Override
    public boolean insertAfter(Object obj, Object e) {
        SLNode p = getPreNode(obj);
        if (p != null) {
            SLNode q = new SLNode(e, p.getNext().getNext());
            p.getNext().setNext(q);
            size++;
            return true;
        }
        return false;
    }

    //删除序号i的元素，并返回之
    @Override
    public Object remove(int i) throws OutOfBoundaryException {
        if (i < 0 || i >= size)
            throw new OutOfBoundaryException("错误，指定的删除序号越界");
        SLNode p = getPreNode(i);
        Object obj = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        size--;
        return obj;
    }

    //删除线性表中第一个与e相同的元素
    @Override
    public boolean remove(Object e) {
        SLNode p = getPreNode(e);
        if (p != null) {
            p.setNext(p.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    //替换线性表中序号为i的数据元素为e，返回原数据元素
    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryException {
        if (i < 0 || i >= size)
            throw new OutOfBoundaryException("错误，指定的删除序号越界");
        SLNode p = getNode(i);
        Object obj = p.getData();
        p.setData(e);
        return obj;
    }

    //返回序号为i的数据元素
    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if (i < 0 || i >= size)
            throw new OutOfBoundaryException("错误，指定的删除序号越界");
        SLNode p = getNode(i);
        return p.getData();
    }
}
