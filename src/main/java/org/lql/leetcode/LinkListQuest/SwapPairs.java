package org.lql.leetcode.LinkListQuest;

import org.apache.log4j.Logger;

/**
 * @author: lql
 * @date: 2020/12/20 22:37
 * @description: 两两交换链表中结点-24
 */
public class SwapPairs {
    private static Logger logger = Logger.getLogger("SwapPairs");

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        logger.debug("head: " + head.val + " -> " + head.next.val + " -> " + head.next.next.val + " -> " + head.next.next.next.val + " -> " + head.next.next.next.next.val);
        ListNode listNode = recursionSwapPairs(head);
        logger.debug("recursionSwapPairs: " + listNode.val + " -> " + listNode.next.val + " -> " + listNode.next.next.val + " -> " + listNode.next.next.next.val + " -> " + listNode.next.next.next.next.val);

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode listNode1 = iterationSwapPairs(head1);
        logger.debug("recursionReverseLists: " + listNode1.val + " -> " + listNode1.next.val + " -> " + listNode1.next.next.val + " -> " + listNode1.next.next.next.val + " -> " + listNode1.next.next.next.next.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归-两两反转链表结点
     *
     * @param head 原链表
     * @return 反转后的链表
     */
    private static ListNode recursionSwapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = recursionSwapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * 迭代-两两反转链表结点
     *
     * @param head 原链表
     * @return 反转后的链表
     */
    private static ListNode iterationSwapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
