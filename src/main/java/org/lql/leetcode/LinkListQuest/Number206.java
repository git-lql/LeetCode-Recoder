package org.lql.leetcode.LinkListQuest;

import org.apache.log4j.Logger;

/**
 * @author: lql
 * @date: 2020/12/20 22:16
 * @description: 反转链表
 */
public class Number206 {

    private static Logger logger = Logger.getLogger("reverseList");

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        logger.debug("originHead:  " + head.val + " -> " + head.next.val + " -> " + head.next.next.val + " -> " + head.next.next.next.val + " -> " + head.next.next.next.next.val);
        ListNode listNode = iterationReverseList(head);
        logger.debug("iterationReverseList: " + listNode.val + " -> " + listNode.next.val + " -> " + listNode.next.next.val + " -> " + listNode.next.next.next.val + " -> " + listNode.next.next.next.next.val);

        ListNode head5 = new ListNode(1);
        ListNode head6 = new ListNode(2);
        ListNode head7 = new ListNode(3);
        ListNode head8 = new ListNode(4);
        ListNode head9 = new ListNode(5);
        head5.next = head6;
        head6.next = head7;
        head7.next = head8;
        head8.next = head9;
        ListNode listNode1 = recursionReverseLists(head5);
        logger.debug(listNode1.val);
        logger.debug("recursionReverseLists: " + listNode1.val + " -> " + listNode1.next.val + " -> " + listNode1.next.next.val + " -> " + listNode1.next.next.next.val + " -> " + listNode1.next.next.next.next.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代-反转链表
     *
     * @param head 原链表
     * @return 反转后的链表
     */
    private static ListNode iterationReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归-反转链表
     *
     * @param head 原链表
     * @return 反转后的链表
     */
    private static ListNode recursionReverseLists(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = recursionReverseLists(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
