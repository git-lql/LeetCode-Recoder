package org.lql.leetcode.collectionframe;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author: lql
 * @date: 2020/12/23 17:28
 * @description: Stack Demo
 */
public class StackDemo {

    private static Logger logger = Logger.getLogger("StackDemo");

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stackTest(stack);
        logger.debug("stack: " + stack.toString());
    }

    /**
     * 迭代器遍历
     *
     * @param stack 栈
     */
    private static void iteratorTraverseStack(Stack<Object> stack) {
        Object val = null;
        for (Iterator iter = stack.iterator(); iter.hasNext(); ) {
            val = (String) iter.next();
            System.out.print(val + " ");
        }
    }

    /**
     * 随机访问遍历
     *
     * @param stack 栈
     */
    private static void randomTraverseStack(Stack<Object> stack) {
        Object object = null;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            object = stack.get(i);
            logger.debug("randomTraverseStack: " + object);
        }
    }

    /**
     * 循环遍历
     *
     * @param stack 栈
     */
    private static void cycleTraverseStack(Stack<Object> stack) {
        Object object = null;
        for (Object o : stack) {
            object = o;
            logger.debug("cycleTraverseStack: " + object);
        }
    }

    private static void stackTest(Stack<Object> stack) {
        int n = 11;
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        logger.debug("stack: " + stack.toString());

        int search = stack.search(11);
        logger.debug("search: " + search);

        Object pop = stack.pop();
        logger.debug("pop: " + pop);

        Object peek = stack.peek();
        logger.debug("peek: " + peek);
    }
}
