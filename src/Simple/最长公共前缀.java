package Simple;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最长公共前缀 {
    @Test
    public void t() {
        System.out.println("预期的结果是："+longestCommonPrefix(new String[]{"ca","a"}));
    }

    /**
     * 自己的解法 执行用时 :1ms  ，内存消耗 :36.2 MB
     * 思路：
     * 1.找出最短的那个字符串的数组下标（就算有多个长度的最短的字符串，任取其一就行）
     * 2.将最短的字符串依次与其他字符串的开头开始对比
     * 3.如果不匹配，则将最短的字符串去掉末尾的字符，再回到2继续判断
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null){
            return "";
        }
        // 获取最短字符串的下标
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            index = strs[index].length() > strs[i].length() ? i : index;
        }
        return compare(index,strs);
    }

    private String compare(int index,String[] strs){
        for (int j = 0; j < strs.length; j++) {
            if (j == index) {
                continue;
            }
            if (!strs[j].substring(0,strs[index].length()).equals(strs[index])) {
                // 如果不匹配的话，去掉最短字符串末尾的字符继续和其他字符串的前缀匹配
                strs[index] = strs[index].substring(0, strs[index].length() > 0 ? strs[index].length() - 1 : 0);
                if (strs[index].length() == 0 || strs[index] == null) {
                    return "";
                }
                compare(index,strs);
            }
        }
        return strs[index];
    }
}
