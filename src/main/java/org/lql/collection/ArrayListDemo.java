package org.lql.collection;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author: LQL
 * @date: 2020/12/23 16:32
 * @description: ArrayList Demo https://www.cnblogs.com/skywang12345/p/3323085.html
 */
public class ArrayListDemo {

    private static Logger logger = Logger.getLogger("ArrayListDemo");

    public static void main(String[] args) {
        arrayListTest();
    }

    /**
     * 迭代器遍历ArrayList
     *
     * @param list 待遍历的集合
     */
    private static void iteratorTraverseArrayList(ArrayList<Object> list) {
        Object object = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            logger.debug("iteratorTraverseArrayList: " + object);
        }
    }

    /**
     * 随机遍历ArrayList
     *
     * @param list 待遍历的List
     */
    private static void randomTraverseArrayList(ArrayList<Object> list) {
        Object object = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            object = list.get(i);
            logger.debug("randomTraverseArrayList: " + object);
        }
    }

    /**
     * 增强循环遍历ArrayList
     *
     * @param list 待遍历的集合
     */
    private static void cycleTraverseArrayList(ArrayList<Object> list) {
        Object object = null;
        for (Object o : list) {
            object = o;
            logger.debug("cycleTraverseArrayList: " + object);
        }
    }

    private static void arrayListTest() {
        //Collection集合
        List<String> col = new ArrayList<String>();
        col.add("1");
        col.add("2");

        //指定容量
        ArrayList<Object> list = new ArrayList<Object>(10);

        //插入到末尾-插入指定位置
        list.add("lql");
        list.add(4);
        list.add(99);
        list.add(new Date());
        list.add(1, "gags");
        logger.debug("list ： " + list);

        //指定位置开始插入Collection元素
        list.addAll(1, col);
        logger.debug("addAll ： " + list);

        //列表Contain
        boolean contain = list.contains("lql");
        logger.debug("contains : " + contain);

        //获取元素索引，无则-1
        int gags = list.indexOf("gags");
        logger.debug("indexOf ：" + gags);

        //用指定的元素替代此列表中指定位置上的元素
        Object set = list.set(1, 0);
        logger.debug("set : " + set);

        //迭代遍历
        iteratorTraverseArrayList(list);

        //随机遍历
        randomTraverseArrayList(list);

        //循环遍历
        cycleTraverseArrayList(list);

        //清空
        logger.debug("isEmpty: "+list.isEmpty());
        list.clear();

        //列表中所有元素的数组
        Object[] objects = list.toArray();
        logger.debug("toArray : " + Arrays.toString(objects));
    }
}
