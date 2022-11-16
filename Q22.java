import java.util.ArrayList;
import java.util.List;

public class Q22 {
    /*
    Generate Parentheses
    Given n paris of parentheses, write a function to generate all combinations of
    well-formed parentheses.
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    //Brute Force
    public List<String> generateParentheses(int n){
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    private void generateAll(char[] current, int pos, List<String> result){
        if (pos == current.length){
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean valid(char[] current){
        int balance = 0;
        for (char c : current){
            if (c == '(')
                balance++;
            else
                balance--;
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    public void backtrack(List<String> result, StringBuilder sb, int open, int end, int max){
        if (sb.length() == 2 * max){
            result.add(sb.toString());
            return;
        }

        if (open < max){
            sb.append("(");
            backtrack(result, sb, open + 1, end, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (end < open){
            sb.append(")");
            backtrack(result, sb, open, end + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
