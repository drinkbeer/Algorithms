package UnionFind;

/**
 * Created by chen on 15/1/22.
 */
public class DLNode implements Node {
    private Object element;
    private DLNode pre;
    private DLNode next;

    public DLNode() {
        this(null,null,null);
    }

    public DLNode(Object element, DLNode pre, DLNode next) {
        this.element = element;
        this.pre = pre;
        this.next = next;
    }

    public DLNode getNext(){
        return next;
    }

    public void setNext(DLNode next){
        this.next = next;
    }

    public DLNode getPre(){
        return pre;
    }

    public void setPre(DLNode pre){
        this.pre = pre;
    }

    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        element = obj;
    }
}
