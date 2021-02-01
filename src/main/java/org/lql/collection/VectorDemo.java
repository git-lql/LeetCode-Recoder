package org.lql.collection;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author: lql
 * @date: 2020/12/23 17:07
 * @description: Vector Demo
 */
public class VectorDemo {

    private static Logger logger = Logger.getLogger("VectorDemo");

    public static void main(String[] args) {
        Vector<Object> vector = new Vector<Object>();
        vectorTest(vector);
        logger.debug("trimToSize: " + vector.toString());
    }

    /**
     * 迭代器遍历
     *
     * @param vector 待遍历的vector
     */
    private static void iteratorTraverseVector(Vector<Object> vector) {
        Iterator<Object> iterator = vector.iterator();
        while (iterator.hasNext()) {
            logger.debug("iteratorTraverseVector: " + iterator.next());
        }
    }

    /**
     * 随机访问遍历
     *
     * @param vector 待遍历的vector
     */
    private static void randomTraverseVector(Vector<Object> vector) {
        Object object = null;
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            object = vector.get(i);
            logger.debug("randomTraverseVector: " + object);
        }
    }

    /**
     * 循环遍历
     *
     * @param vector 待遍历的vector
     */
    private static void cycleTraverseVector(Vector<Object> vector) {
        Object object = null;
        for (Object o : vector) {
            object = o;
            logger.debug("cycleTraverseVector: " + object);
        }
    }

    /**
     * enumeration遍历
     *
     * @param vector 待遍历的vector
     */
    private static void enumerationTraverseVector(Vector<Object> vector) {
        Enumeration<Object> elements = vector.elements();
        while (elements.hasMoreElements()) {
            logger.debug("enumerationTraverseVector: " + elements.nextElement());
        }
    }

    private static void vectorTest(Vector<Object> vector) {
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(4, 5);
        vector.addElement(99);
        vector.addElement("lql");
        logger.debug("vector: " + vector.toString());

        int capacity = vector.capacity();
        logger.debug("capacity: " + capacity);

        boolean contains = vector.contains("lql");
        logger.debug("contains: " + contains);

        Object[] arr = new Object[10];
        vector.copyInto(arr);
        logger.debug("copyInto: " + Arrays.toString(arr));

        Object elementAt = vector.elementAt(5);
        logger.debug("elementAt: " + elementAt);

        Object firstElement = vector.firstElement();
        logger.debug("firstElement: " + firstElement);

        Object lastElement = vector.lastElement();
        logger.debug("lastElement: " + lastElement);

        int indexOf = vector.indexOf("lql");
        logger.debug("indexOf: " + indexOf);

        int indexOf1 = vector.indexOf("lql", 3);
        logger.debug("indexOf: " + indexOf1);

        vector.insertElementAt(88, 3);
        logger.debug("insertElementAt: " + vector.toString());

        int lastIndexOf = vector.lastIndexOf("lql", 3);
        logger.debug("lastIndexOf: " + lastElement);

        vector.trimToSize();
        logger.debug("trimToSize: " + vector.toString());
    }
}
