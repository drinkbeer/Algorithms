package UnionFind;

/**
 * Created by chen on 15/1/22.
 * 序号越界异常
 */
public class OutOfBoundaryException extends RuntimeException {
    public OutOfBoundaryException(String err){
        super(err);
    }
}
