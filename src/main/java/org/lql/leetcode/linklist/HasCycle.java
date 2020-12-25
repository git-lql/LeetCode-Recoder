package org.lql.leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lql
 * @date: 2020/12/24 15:31
 * @description: 141. 环形链表
 */
public class HasCycle {

    public static void main(String[] args) {

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
     * 我的快慢指针
     *
     * @param head 链表
     * @return 检测结果
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    /**
     * 官方快慢指针
     *
     * @param head 链表
     * @return 检测结果
     */
    public boolean fastSlowHasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * Hash表
     *
     * @param head 链表
     * @return 检测结果
     */
    public boolean hashHasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
