package Simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有效的括号 {
    @Test
    public void t(){
        System.out.println("result is :"+isValid1("()[]{}"));
    }

    /**
     * 参考了一下解题标准后写的
     * 用时5ms，内存消耗34.6 MB
     */
    public boolean isValid1(String s) {
        Map<Character,Character> entry = new HashMap<>();
        if(s.isEmpty()){return true;}
        entry.put(')','(');
        entry.put('}','{');
        entry.put(']','[');
        int length = s.length();
        if(length ==0|| length %2!=0){return false;}
        Stack<Character> stack = new Stack();
        for(int i = 0;i<length;i++){
            if(entry.get(s.charAt(0))!=null){ // 首次判断
                return false;
            }
            // 判断是不是右括号，如果是的话，则不放入栈，并从栈中pop字符
            if(entry.get(s.charAt(i)) != null){
                if(entry.get(s.charAt(i))==stack.pop()){
                    continue;
                }
                return false;
            }
            // 先将字符逐个放入栈中
            stack.push(s.charAt(i));
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }
}
