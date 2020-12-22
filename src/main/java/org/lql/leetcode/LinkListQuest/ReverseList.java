package org.lql.leetcode.LinkListQuest;

import org.apache.log4j.Logger;

/**
 * @author: lql
 * @date: 2020/12/20 22:16
 * @description: 反转链表-206
 */
public class ReverseList {

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
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        logger.debug("originHead:  " + head.val + " -> " + head.next.val + " -> " + head.next.next.val + " -> " + head.next.next.next.val + " -> " + head.next.next.next.next.val);

        ListNode listNode = iterationReverseList(head);
        logger.debug("iterationReverseList: " + listNode.val + " -> " + listNode.next.val + " -> " + listNode.next.next.val + " -> " + listNode.next.next.next.val + " -> " + listNode.next.next.next.next.val);

        ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        ListNode listNode1 = recursionReverseLists(head5);
        logger.debug("recursionReverseLists: " + listNode1.val + " -> " + listNode1.next.val + " -> " + listNode1.next.next.val + " -> " + listNode1.next.next.next.val + " -> " + listNode1.next.next.next.next.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
