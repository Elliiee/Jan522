import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q588 {
    class Dir{
        HashMap<String, Dir> dirs = new HashMap<>();
        HashMap<String, String> files = new HashMap<>();
    }

    Dir root;

    public Q588(){
        root = new Dir();
    }


}
