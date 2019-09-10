package Simple;
class ListNode {
    int val; // 节点保存的值
    ListNode next; // 下一个节点
    ListNode(int x) {
        val = x;
    }
}
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){return l2;}
        if(l2==null){return l1;}
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
