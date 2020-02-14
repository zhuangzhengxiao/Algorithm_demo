package Middle;

import org.junit.Test;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 
 * 逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 两数相加 {
    @Test
    public void tes() {
        //addTwoNumbers(new ListNode(1), new ListNode(1));

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        curr.next = new ListNode(5);
        curr = curr.next;
        curr.next = new ListNode(8);
//        curr.next.next = new ListNode(7);
        curr = curr.next;
        System.out.println(dummyHead);
        System.out.println(curr);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为是直接将result赋值给curr的，所以两个对象一样
        // 在下面将相加的结果给到新的链表时，curr.next改变后，result.next一致，然后用curr = curr.next，用curr来保存当前相加的结果，curr就等于是result.next
        ListNode result = new ListNode(0);
        ListNode curr = result;
        if(l1==null && l2==null){ // 两个都是空就直接返回
            return result;
        }
        // 设定一个数字x，用来接收链表1的值
        // 设定一个数字y，用来接收链表2的值
        // 设定一个数字carry，用来计算溢出的值 如 9+9=18
        int carry = 0;
        int x ,y ,sum;
        while (l1 != null ||l2 !=null) {
            x = l1 != null ? l1.val:0;
            y = l2 != null ? l2.val:0;
            sum = x + y + carry;// 求出两个链表的val相加的值
            curr.next = new ListNode(sum%10);// 留下sum的个位数
            carry = sum/10;// 保留sum的十位数数字
            curr = curr.next;
            // 两个链表长度不一定想等，所以会出现空节点的情况
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        // 如果最高位的两个数字相加超过10 ，则再进一位
        if(carry>0){
           curr.next = new ListNode(carry);
        }
        return result.next;
    }
}
