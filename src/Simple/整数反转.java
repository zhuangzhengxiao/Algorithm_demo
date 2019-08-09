package Simple;

import org.junit.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 整数反转 {
    @Test
    public void reversal() {
        Solution s = new Solution();
        System.out.println(s.reverse2(-120));
    }

    class Solution {
        // 个人解法使用字符串 （最好用数学的方法去解决，执行时间7ms，比官方解法多1ms，使用内存多1.5mb左右）
        public int reverse1(int x) {
            if (x == 0){
                return 0;
            }
            boolean flag = false; // 判断是否是负数
            if (x < 0) {
                flag = true;
            }
            StringBuilder sb = new StringBuilder();
            String result = sb.append(x).reverse().toString();// 反转后获得的字符串
            // 先将反转后的数字前面的0全部去掉
            while (result.charAt(0)=='0'){
                result = result.substring(1,result.length());
            }
            if(flag){
                // 如果是负数则将反转过的负号放到前面来
                result = String.valueOf(result.charAt(result.length()-1)) + result.substring(0, result.length()-1);
            }
            try {
                return Integer.valueOf(result);
            }catch (Exception e){
                return 0;
            }
        }
        /**
         * 官方解法
         */
        public int reverse2(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10; // 等于0后就退出了
                if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }
}
