package Simple;

import org.junit.Test;

import java.util.HashMap;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做II ，即为两个并列的 1。
 * 12 写做XII ，即为 X + II 。
 * 27 写做XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 罗马数字转整数 {
    @Test
    public void t() {
        // 1.小的数字在大的数字右边，大->小
        // 2.有6种特例，小的可以在大的数字左边
        // 3.输出的数字只能在 1~3999
        romanToInt1("XIII");
    }

    /**
     * 个人写法 一开始不知道怎么下手，后来看了一下别人解题使用了Map
     * 就直接尝试写了一下  耗时 33ms （运行相对其他解法较慢）内存消耗44.7MB（内存消耗还行）
     * 优化了一下代码，变成 耗时 27ms（相对其他人耗时时间排在中间位置） 内存消耗43.7MB
     */
    public int romanToInt1(String s) {
        HashMap map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int result = 0;
        String one = null;
        String two = null;
        for (int i = 0; i < s.length(); i++) {
            one = s.substring(i, i + 1);// 获取当前罗马数字
            two = s.substring(i, i + 2 > s.length() ? s.length() : i + 2);
            if (map.get(two) == null) {
                result += (int) map.get(one);
            } else {
                // 如果是特殊情况，那么下一次循环就会从这个特殊情况后面的一个罗马数字开始算
                result += (int) map.get(two);
                ++i;
            }
        }
        return result;
    }

    /**
     * 最高赞的 C++ 解法
     */
//        int romanToInt(string s) {
//            unordered_map<string, int> m = {{"I", 1}, {"IV", 3}, {"IX", 8}, {"V", 5}, {"X", 10}, {"XL", 30}, {"XC", 80}, {"L", 50}, {"C", 100}, {"CD", 300}, {"CM", 800}, {"D", 500}, {"M", 1000}};
//            int r = m[s.substr(0, 1)];
//            for(int i=1; i<s.size(); ++i){
//                string two = s.substr(i-1, 2);
//                string one = s.substr(i, 1);
//                r += m[two] ? m[two] : m[one];
//            }
//            return r;
//        }

}
