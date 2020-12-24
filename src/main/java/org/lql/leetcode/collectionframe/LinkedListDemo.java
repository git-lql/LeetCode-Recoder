package org.lql.leetcode.collectionframe;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: lql
 * @date: 2020/12/23 16:54
 * @description: LinkedList Demo
 */
public class LinkedListDemo {

    private static Logger logger = Logger.getLogger("LinkedListDemo");

    public static void main(String[] args) {

        LinkedList<Object> list = new LinkedList<Object>();
        list.add(1);
        list.add(2);
        list.addLast(6);
        list.add(3);
        list.add(4);
        list.addFirst(Math.E);
        list.add(5);
        list.add("lql");
        list.add("lll");
        list.add("lql");
        linkedListTest(list);
    }

    /**
     * 迭代器遍历LinkedList
     *
     * @param list 待遍历的List
     */
    private static void iteratorTraverseLinkedList(LinkedList<Object> list) {
        Object object = null;
        Iterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            logger.debug("iteratorTraverseLinkedList: " + object);
        }
    }

    /**
     * 随机访问遍历LinkedList
     *
     * @param list 待遍历的List
     */
    private static void randomTraverseLinkedList(LinkedList<Object> list) {
        Object object = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            object = list.get(i);
            logger.debug("randomTraverseLinkedList: " + object);
        }
    }

    /**
     * 循环遍历LinkedList
     *
     * @param list 待遍历的LIst
     */
    private static void cycleTraverseLinkedList(LinkedList<Object> list) {
        Object object = null;
        for (Object o : list) {
            object = o;
            logger.debug("cycleTraverseLinkedList: " + object);
        }
    }

    private static void linkedListTest(LinkedList<Object> list) {
        logger.debug("Traverse: " + list.toString());

        //包含元素的索引
        //--------------------------------------------
        boolean contains = list.contains("lql");
        logger.debug("contains: " + contains);

        int indexOf = list.indexOf("lql");
        logger.debug("indexOf: " + indexOf);

        int lastIndexOf = list.lastIndexOf("lql");
        logger.debug("LastIndexOf: " + lastIndexOf);
        //--------------------------------------------

        //获取列表首个元素//返回列表首元素//返回列表最后元素
        //--------------------------------------------
        Object element = list.element();
        logger.debug("element: " + element);

        Object first = list.getFirst();
        logger.debug("first: " + first);

        Object last = list.getLast();
        logger.debug("getLast: " + last);
        //--------------------------------------------

        //--------------------------------------------
        boolean offer = list.offer(66);
        boolean offerFirst = list.offerFirst(22);
        boolean offerLast = list.offerLast(99);
        //--------------------------------------------
        logger.debug("offerTraverse: " + list.toString());

        //--------------------------------------------
        Object peek = list.peek();
        logger.debug("peek: " + peek);

        Object peekFirst = list.peekFirst();
        logger.debug("peekFirst: " + peekFirst);

        Object peekLast = list.peekLast();
        logger.debug("peekLast: " + peekLast);
        //-------------------------------------------
        logger.debug("peekTraverse: " + list.toString());

        //获取列表首个元素并移除
        //--------------------------------------------
        Object poll = list.poll();
        logger.debug("poll: " + poll);

        Object pollFirst = list.pollFirst();
        logger.debug("pollFirst: " + pollFirst);

        Object pollLast = list.pollLast();
        logger.debug("pollLast: " + pollLast);
        //--------------------------------------------
        logger.debug("pollTraverse: " + list.toString());

        //--------------------------------------------
        Object pop = list.pop();
        logger.debug("pop: " + pop);

        list.push(88);
        //--------------------------------------------
        logger.debug("pushTraverse: " + list.toString());

        //--------------------------------------------
        Object remove = list.remove();
        logger.debug("remove: " + remove);

        Object removeIndex = list.remove(5);
        logger.debug("removeIndex-5: " + removeIndex);

        Object removeFirst = list.removeFirst();
        logger.debug("removeFirst: " + removeFirst);

        Object removeLast = list.removeLast();
        logger.debug("removeLast: " + removeLast);

        boolean removeFirstOccurrence = list.removeFirstOccurrence("lql");
        logger.debug("removeFirstOccurrence: " + removeFirstOccurrence);

        boolean removeLastOccurrence = list.removeLastOccurrence("lql");
        logger.debug("removeLastOccurrence: " + removeLastOccurrence);
        //--------------------------------------------
        logger.debug("removeTraverse: " + list.toString());

        //逆向元素迭代器
        Iterator<Object> objectIterator = list.descendingIterator();
        logger.debug("descendingIterator：-逆向元素迭代器");
        while (objectIterator.hasNext()) {
            logger.debug("descendingIterator: " + objectIterator.next());
        }
    }

}
