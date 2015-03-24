package UnionFind;

/**
 * Created by chen on 15/1/22.
 * Singly Linked UnionFind.Node
 */
public class SLNode implements Node {
    private Object element;
    private SLNode next;

    public SLNode() {
        this(null,null);
    }

    public SLNode(Object element, SLNode next) {
        this.element = element;
        this.next = next;
    }

    public SLNode getNext(){
        return next;
    }

    public void setNext(SLNode next){
        this.next = next;
    }

    /****Methods of UnionFind.Node Interface****/
    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        element = obj;
    }
}
