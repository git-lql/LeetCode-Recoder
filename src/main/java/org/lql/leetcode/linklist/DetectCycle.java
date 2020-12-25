package org.lql.leetcode.linklist;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lql
 * @date: 2020/12/24 16:00
 * @description: 142. 环形链表 II-查找环口结点
 */
public class DetectCycle {

    private static Logger logger = Logger.getLogger("DetectCycle");

    public static void main(String[] args) {
        ListNode q = new ListNode(2);
        ListNode w = new ListNode(3, q);
        ListNode e = new ListNode(4, w);
        ListNode r = new ListNode(5, e);
        ListNode t = new ListNode(6, r);
        ListNode y = new ListNode(7, t);
        ListNode head = new ListNode(1, y);
        q.setNext(e);
        ListNode listNode = fastSlowDetectCycle(head);
        logger.debug(listNode.val);

        ListNode hashDetectCycle = hashDetectCycle(head);
        logger.debug(hashDetectCycle != null ? hashDetectCycle.val : null);
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

        void setNext(ListNode next) {
            this.next = next;
        }
    }

    /**
     * 快慢指针寻找循环链表环结点
     *
     * @param head 循环链表
     * @return 链表头结点
     */
    private static ListNode fastSlowDetectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * Hash表
     *
     * @param head 循环链表
     * @return 循环链表结点
     */
    public static ListNode hashDetectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
