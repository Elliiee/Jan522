import java.util.List;

public class NodeNary {
    public int val;
    public List<NodeNary> children;

    public NodeNary(){}

    public NodeNary(int _val, List<NodeNary> _children){
        val = _val;
        children = _children;
    }
}
